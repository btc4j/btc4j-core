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
import org.btc4j.btc.BitcoinException;
import org.btc4j.btc.api.BitcoinAccountService;
import org.btc4j.btc.api.BitcoinBlockService;
import org.btc4j.btc.api.BitcoinMiscService;
import org.btc4j.btc.api.BitcoinNodeService;
import org.btc4j.btc.api.BitcoinStatusService;
import org.btc4j.btc.api.BitcoinWalletService;

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

	//TODO BitcoinAccountService
	
	//BitcoinBlockService
	private static final String BTCAPI_BLOCK_COUNT = "getblockcount";
	
	@Override
	public int getBlockCount() throws BitcoinException {
		JsonValue result = invoke(BTCAPI_BLOCK_COUNT, null);
		LOGGER.info("result: " + result);
		return Integer.valueOf(result.toString());
	}
	
	//TODO BitcoinMiscService
	
	//BitcoinNodeService
	private static final String BTCAPI_NODE_CONNECTION_COUNT = "getconnectioncount";

	@Override
	public int getConnectionCount() throws BitcoinException {
		JsonValue result = invoke(BTCAPI_NODE_CONNECTION_COUNT, null);
		LOGGER.info("result: " + result);
		return Integer.valueOf(result.toString());
	}
	
	//BitcoinStatusService
	private static final String BTCAPI_STATUS_INFO = "getinfo";
	private static final String BTCAPI_STATUS_HELP = "help";
	private static final String BTCAPI_STATUS_STOP = "stop";
	
	@Override
	public String getInfo() throws BitcoinException {
		JsonValue result = invoke(BTCAPI_STATUS_INFO, null);
		LOGGER.info("result: " + result);
		return String.valueOf(result);
	}

	@Override
	public String help(String command) throws BitcoinException {
		JsonArray parameters = null;
		if ((command != null) && (command.length() > 0)) {
			parameters = Json.createArrayBuilder().add(command).build();
		}
		JsonValue result = invoke(BTCAPI_STATUS_HELP, parameters);
		LOGGER.info("result: " + result);
		return String.valueOf(result);
	}
	
	@Override
	public String stop() throws BitcoinException {
		JsonValue result = invoke(BTCAPI_STATUS_STOP, null);
		LOGGER.info("result: " + result);
		return String.valueOf(result);
	}
	
	//TODO BitcoinWalletService

	//JSON-RPC over HTTP w/ basic authentication
	private static final String RPC_JSONRPC = "jsonrpc";
	private static final String RPC_VERSION = "2.0";
	private static final String RPC_ID = "id";
	private static final String RPC_METHOD = "method";
	private static final String RPC_PARAMS = "params";
	private static final String RPC_RESULT = "result";
	private static final String RPC_ERROR = "error";
	private static final String RPC_CODE = "code";
	private static final String RPC_MESSAGE = "message";
	private static final String RPC_DATA = "data";
	private static final String RPC_HTTP_HEADER = "Content-Type";
	private static final String RPC_CONTENT_TYPE = "application/json-rpc";
	private static final String JSON_CONTENT_TYPE = "application/json";
	private static final String RPC_ERROR_MESSAGE = "Server error";
	private static final String RPC_ERROR_DATA_NULL_URL = "Server URL is null";
	private static final String RPC_ERROR_DATA_NULL_RESPONSE = "Response is empty";
	private static final int RPC_ERROR_CODE = -32077;
	private JsonValue invoke(String method, JsonValue parameters)
			throws BitcoinException {
		if (url == null) {
			throw new BitcoinException(RPC_ERROR_CODE, RPC_ERROR_MESSAGE + ": "
					+ RPC_ERROR_DATA_NULL_URL);
		}
		PostMethod post = new PostMethod(url.toString());
		try {
			post.setRequestHeader(RPC_HTTP_HEADER, RPC_CONTENT_TYPE);
			String guid = UUID.randomUUID().toString();
			JsonObjectBuilder builder = Json.createObjectBuilder();
			builder.add(RPC_JSONRPC, RPC_VERSION).add(RPC_METHOD, method);
			if (parameters != null) {
				builder.add(RPC_PARAMS, parameters);
			} else {
				builder.addNull(RPC_PARAMS);
			}
			builder.add(RPC_ID, guid);
			JsonObject request = builder.build();
			LOGGER.info("request: " + request);
			post.setRequestEntity(new StringRequestEntity(request.toString(),
					JSON_CONTENT_TYPE, null));
			HttpClient client = new HttpClient();
			client.setState(state);
			int status = client.executeMethod(post);
			if (status != HttpStatus.SC_OK) {
				throw new BitcoinException(RPC_ERROR_CODE, RPC_ERROR_MESSAGE
						+ ": " + status + " "
						+ HttpStatus.getStatusText(status));
			}
			JsonObject response = (JsonObject) Json.createReader(
					new StringReader(post.getResponseBodyAsString())).read();
			if (response == null) {
				throw new BitcoinException(RPC_ERROR_CODE, RPC_ERROR_MESSAGE
						+ ": " + RPC_ERROR_DATA_NULL_RESPONSE);
			}
			JsonString id = response.getJsonString(RPC_ID);
			if (id == null) {
				JsonObject error = response.getJsonObject(RPC_ERROR);
				throw new BitcoinException(error.getInt(RPC_CODE),
						error.get(RPC_MESSAGE) + ": "
								+ error.getJsonObject(RPC_DATA));
			}
			return response.get(RPC_RESULT);
		} catch (NullPointerException | ClassCastException | IOException e) {
			throw new BitcoinException(RPC_ERROR_CODE, RPC_ERROR_MESSAGE + ": "
					+ e.getMessage(), e);
		} finally {
			post.releaseConnection();
		}
	}
}