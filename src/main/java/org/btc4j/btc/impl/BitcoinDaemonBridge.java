/*
 Copyright (c) 2013 btc4j.org

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */

package org.btc4j.btc.impl;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.UUID;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import javax.json.JsonValue;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.btc4j.btc.BitcoinConstant;
import org.btc4j.btc.BitcoinException;
import org.btc4j.btc.api.BitcoinAccountService;
import org.btc4j.btc.api.BitcoinBlockService;
import org.btc4j.btc.api.BitcoinMiscService;
import org.btc4j.btc.api.BitcoinNodeService;
import org.btc4j.btc.api.BitcoinStatusService;
import org.btc4j.btc.api.BitcoinWalletService;
import org.btc4j.btc.model.BitcoinInfo;

public class BitcoinDaemonBridge implements BitcoinAccountService,
		BitcoinBlockService, BitcoinMiscService, BitcoinNodeService,
		BitcoinStatusService, BitcoinWalletService {

	private final static Logger LOGGER = Logger
			.getLogger(BitcoinDaemonBridge.class.getName());
	private URL url;
	private HttpState state;

	public BitcoinDaemonBridge(URL url) {
		this.url = url;
		state = new HttpState();
	}

	public BitcoinDaemonBridge(URL url, String username, String password) {
		this(url);
		state.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(
				username, password));
	}

	protected JsonValue invoke(String method, JsonValue parameters)
			throws BitcoinException {
		if (url == null) {
			throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
					BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
							+ BitcoinConstant.BTC4J_ERROR_DATA_NULL_URL);
		}
		PostMethod post = new PostMethod(url.toString());
		try {
			post.setRequestHeader(BitcoinConstant.BTC4J_HTTP_HEADER,
					BitcoinConstant.BTC4J_JSONRPC_CONTENT_TYPE);
			String guid = UUID.randomUUID().toString();
			JsonObjectBuilder builder = Json.createObjectBuilder();
			builder.add(BitcoinConstant.JSONRPC,
					BitcoinConstant.JSONRPC_VERSION).add(
					BitcoinConstant.JSONRPC_METHOD, method);
			if (parameters != null) {
				builder.add(BitcoinConstant.JSONRPC_PARAMS, parameters);
			} else {
				builder.addNull(BitcoinConstant.JSONRPC_PARAMS);
			}
			builder.add(BitcoinConstant.JSONRPC_ID, guid);
			JsonObject request = builder.build();
			LOGGER.info("request: " + request);
			post.setRequestEntity(new StringRequestEntity(request.toString(),
					BitcoinConstant.BTC4J_JSON_CONTENT_TYPE, null));
			HttpClient client = new HttpClient();
			client.setState(state);
			int status = client.executeMethod(post);
			if (status != HttpStatus.SC_OK) {
				throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
						BitcoinConstant.BTC4J_ERROR_MESSAGE + ": " + status
								+ " " + HttpStatus.getStatusText(status));
			}
			JsonObject response = (JsonObject) Json.createReader(
					new StringReader(post.getResponseBodyAsString())).read();
			if (response == null) {
				throw new BitcoinException(
						BitcoinConstant.BTC4J_ERROR_CODE,
						BitcoinConstant.BTC4J_ERROR_MESSAGE
								+ ": "
								+ BitcoinConstant.BTC4J_ERROR_DATA_NULL_RESPONSE);
			}
			LOGGER.info("response: " + response);
			JsonString id = response.getJsonString(BitcoinConstant.JSONRPC_ID);
			if (id == null) {
				JsonObject error = response
						.getJsonObject(BitcoinConstant.JSONRPC_ERROR);
				throw new BitcoinException(
						error.getInt(BitcoinConstant.JSONRPC_CODE),
						error.get(BitcoinConstant.JSONRPC_MESSAGE)
								+ ": "
								+ error.getJsonObject(BitcoinConstant.JSONRPC_DATA));
			}
			if (!guid.equals(id.getString())) {
				throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
						BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
								+ BitcoinConstant.BTC4J_ERROR_DATA_INVALID_ID);
			}
			return response.get(BitcoinConstant.JSONRPC_RESULT);
		} catch (NullPointerException | ClassCastException | IOException e) {
			throw new BitcoinException(
					BitcoinConstant.BTC4J_ERROR_CODE,
					BitcoinConstant.BTC4J_ERROR_MESSAGE + ": " + e.getMessage(),
					e);
		} finally {
			post.releaseConnection();
		}
	}

	// BitcoinAccountService
	@Override
	public String getAccount(String address) throws BitcoinException {
		JsonArray parameters = Json.createArrayBuilder().add(address).build();
		JsonString resultss = (JsonString) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT, parameters);
		return resultss.getString();
	}

	@Override
	public String getAccountAddress(String account) throws BitcoinException {
		JsonArray parameters = Json.createArrayBuilder().add(account).build();
		JsonString results = (JsonString) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT_ADDRESS, parameters);
		return results.getString();
	}

	@Override
	public String[] getAddressesByAccount(String account)
			throws BitcoinException {
		JsonArray parameters = Json.createArrayBuilder().add(account).build();
		JsonArray results = (JsonArray) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT_ADDRESSES, parameters);
		String[] addresses = new String[results.size()];
		for (int i = 0; i < results.size(); i++) {
			JsonString result = results.getJsonString(i);
			addresses[i] = result.getString();
		}
		return addresses;
	}

	// BitcoinBlockService
	@Override
	public int getBlockCount() throws BitcoinException {
		JsonNumber results = (JsonNumber) invoke(
				BitcoinConstant.BTCAPI_BLOCK_COUNT, null);
		return results.intValue();
	}

	// BitcoinMiscService

	// BitcoinNodeService
	@Override
	public int getConnectionCount() throws BitcoinException {
		JsonNumber results = (JsonNumber) invoke(
				BitcoinConstant.BTCAPI_NODE_CONNECTION_COUNT, null);
		return results.intValue();
	}

	// BitcoinStatusService
	@Override
	public double getDifficulty() throws BitcoinException {
		JsonNumber results = (JsonNumber) invoke(
				BitcoinConstant.BTCAPI_STATUS_DIFFICULTY, null);
		return results.doubleValue();
	}

	@Override
	public boolean getGenerate() throws BitcoinException {
		JsonValue results = invoke(BitcoinConstant.BTCAPI_STATUS_GENERATE, null);
		return Boolean.valueOf(String.valueOf(results));
	}

	@Override
	public BitcoinInfo getInfo() throws BitcoinException {
		JsonObject results = (JsonObject) invoke(
				BitcoinConstant.BTCAPI_STATUS_INFO, null);
		return BitcoinInfo.fromJson(results);
	}

	@Override
	public String help(String command) throws BitcoinException {
		JsonArray parameters = null;
		if ((command != null) && (command.length() > 0)) {
			parameters = Json.createArrayBuilder().add(command).build();
		}
		JsonString results = (JsonString) invoke(
				BitcoinConstant.BTCAPI_STATUS_HELP, parameters);
		return results.getString();
	}

	@Override
	public String stop() throws BitcoinException {
		JsonString results = (JsonString) invoke(
				BitcoinConstant.BTCAPI_STATUS_STOP, null);
		return results.getString();
	}

	// BitcoinWalletService
}