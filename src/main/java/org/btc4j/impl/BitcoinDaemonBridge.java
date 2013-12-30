package org.btc4j.impl;

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

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.UUID;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.btc4j.BitcoinException;
import org.btc4j.api.BitcoinAccountService;
import org.btc4j.api.BitcoinBlockService;
import org.btc4j.api.BitcoinMiscService;
import org.btc4j.api.BitcoinNodeService;
import org.btc4j.api.BitcoinStatusService;
import org.btc4j.api.BitcoinWalletService;

public class BitcoinDaemonBridge implements BitcoinAccountService,
		BitcoinBlockService, BitcoinMiscService, BitcoinNodeService,
		BitcoinStatusService, BitcoinWalletService {

	private final static Logger LOGGER = Logger
			.getLogger(BitcoinDaemonBridge.class.getName());
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
	private static final int RPC_ERROR_CODE = -32077;
	private static final String RPC_ERROR_MESSAGE = "Server error";
	private static final String RPC_ERROR_DATA_NULL_URL = "Server URL is null";
	private static final String RPC_ERROR_DATA_NULL_RESPONSE = "Response is empty";
	private static final String BTCAPI_HELP = "help";
	private URL url;
	private HttpState state;

	public BitcoinDaemonBridge(URL url, String username, String password) {
		this.url = url;
		state = new HttpState();
		state.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(
				username, password));
	}

	public String help(String command) throws BitcoinException {
		JsonArray parameters = null;
		if ((command != null) && (command.length() > 0)) {
			parameters = Json.createArrayBuilder().add(command).build();
		}
		JsonObject result = invoke(BTCAPI_HELP, parameters);
		LOGGER.info("result: " + result);
		return "" + result;
	}

	private JsonObject invoke(String method, JsonArray parameters)
			throws BitcoinException {
		if (url == null) {
			throw new BitcoinException(RPC_ERROR_CODE, RPC_ERROR_MESSAGE + ": "
					+ RPC_ERROR_DATA_NULL_URL);
		}
		PostMethod post = new PostMethod(url.toString());
		try {
			post.setRequestHeader(RPC_HTTP_HEADER, RPC_CONTENT_TYPE);
			String guid = UUID.randomUUID().toString();
			JsonObject request = Json.createObjectBuilder()
					.add(RPC_JSONRPC, RPC_VERSION).add(RPC_METHOD, method)
					.add(RPC_PARAMS, parameters).add(RPC_ID, guid).build();
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
						error.getString(RPC_MESSAGE) + ": "
								+ error.getJsonObject(RPC_DATA));
			}
			return response.getJsonObject(RPC_RESULT);
		} catch (NullPointerException e) {
			throw new BitcoinException(RPC_ERROR_CODE, RPC_ERROR_MESSAGE + ": "
					+ e.getMessage(), e);
		} catch (ClassCastException e) {
			throw new BitcoinException(RPC_ERROR_CODE, RPC_ERROR_MESSAGE + ": "
					+ e.getMessage(), e);
		} catch (IOException e) {
			throw new BitcoinException(RPC_ERROR_CODE, RPC_ERROR_MESSAGE + ": "
					+ e.getMessage(), e);
		} finally {
			post.releaseConnection();
		}
	}
}
