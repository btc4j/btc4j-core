/*
 The MIT License (MIT)
 
 Copyright (c) 2013, 2014 by Guillermo Gonzalez, btc4j.org

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

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.btc4j.btc.api.BitcoinInfoService;
import org.btc4j.btc.api.BitcoinMiscService;
import org.btc4j.btc.api.BitcoinNodeService;
import org.btc4j.btc.api.BitcoinRawTransactionService;
import org.btc4j.btc.api.BitcoinStatusService;
import org.btc4j.btc.api.BitcoinWalletService;
import org.btc4j.btc.model.BitcoinAccount;
import org.btc4j.btc.model.BitcoinBlock;
import org.btc4j.btc.model.BitcoinClientInfo;
import org.btc4j.btc.model.BitcoinMiningInfo;
import org.btc4j.btc.model.BitcoinNodeOperationEnum;
import org.btc4j.btc.model.BitcoinPeer;
import org.btc4j.btc.model.BitcoinTxOutputSet;

public class BitcoinDaemonBridge implements BitcoinAccountService,
		BitcoinBlockService, BitcoinInfoService, BitcoinMiscService,
		BitcoinNodeService, BitcoinRawTransactionService, BitcoinStatusService,
		BitcoinWalletService {

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

	public String[] getSupportedVersions() {
		return BitcoinConstant.BTC4J_VERSIONS;
	}

	protected JsonValue invoke(String method) throws BitcoinException {
		return invoke(method, null);
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
		if (address == null) {
			address = "";
		}
		JsonArray parameters = Json.createArrayBuilder().add(address).build();
		JsonString resultss = (JsonString) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT, parameters);
		return resultss.getString();
	}

	@Override
	public String getAccountAddress(String account) throws BitcoinException {
		if (account == null) {
			account = "";
		}
		JsonArray parameters = Json.createArrayBuilder().add(account).build();
		JsonString results = (JsonString) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT_ADDRESS, parameters);
		return results.getString();
	}

	@Override
	public List<String> getAddressesByAccount(String account)
			throws BitcoinException {
		if (account == null) {
			account = "";
		}
		JsonArray parameters = Json.createArrayBuilder().add(account).build();
		JsonArray results = (JsonArray) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT_ADDRESSES, parameters);

		List<String> addresses = new ArrayList<String>();
		for (JsonString result : results.getValuesAs(JsonString.class)) {
			addresses.add(result.getString());
		}
		return addresses;
	}

	@Override
	public double getBalance(String account, int minConf)
			throws BitcoinException {
		if (account == null) {
			account = "";
		}
		if (minConf < 1) {
			minConf = 1;
		}
		JsonArray parameters = Json.createArrayBuilder().add(account)
				.add(minConf).build();
		JsonNumber results = (JsonNumber) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT_BALANCE, parameters);
		return results.doubleValue();
	}

	public double getBalance(String account) throws BitcoinException {
		return getBalance(account, 1);
	}

	public double getBalance(int minConf) throws BitcoinException {
		return getBalance("", minConf);
	}

	public double getBalance() throws BitcoinException {
		return getBalance("", 1);
	}

	@Override
	public String getNewAddress(String account) throws BitcoinException {
		JsonArray parameters = null;
		if ((account != null) && (account.length() > 0)) {
			parameters = Json.createArrayBuilder().add(account).build();
		}
		JsonString results = (JsonString) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT_NEW_ADDRESS, parameters);
		return results.getString();
	}

	public String getNewAddress() throws BitcoinException {
		return getNewAddress(null);
	}

	@Override
	public double getReceivedByAccount(String account, int minConf)
			throws BitcoinException {
		if (account == null) {
			account = "";
		}
		if (minConf < 1) {
			minConf = 1;
		}
		JsonArray parameters = Json.createArrayBuilder().add(account)
				.add(minConf).build();
		JsonNumber results = (JsonNumber) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT_RECEIVED, parameters);
		return results.doubleValue();
	}

	public double getReceivedByAccount(String account) throws BitcoinException {
		return getReceivedByAccount(account, 1);
	}

	@Override
	public double getReceivedByAddress(String address, int minConf)
			throws BitcoinException {
		if (address == null) {
			address = "";
		}
		if (minConf < 1) {
			minConf = 1;
		}
		JsonArray parameters = Json.createArrayBuilder().add(address)
				.add(minConf).build();
		JsonNumber results = (JsonNumber) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT_RECEIVED_ADDRESS, parameters);
		return results.doubleValue();
	}

	public double getReceivedByAddress(String address) throws BitcoinException {
		return getReceivedByAddress(address, 1);
	}

	@Override
	public Map<String, BitcoinAccount> listAccounts(int minConf)
			throws BitcoinException {
		if (minConf < 1) {
			minConf = 1;
		}
		JsonArray parameters = Json.createArrayBuilder().add(minConf).build();
		JsonObject results = (JsonObject) invoke(
				BitcoinConstant.BTCAPI_ACCOUNT_LIST, parameters);
		Map<String, BitcoinAccount> accounts = new HashMap<String, BitcoinAccount>();
		for (String account : results.keySet()) {
			JsonNumber balance = results.getJsonNumber(account);
			accounts.put(account,
					new BitcoinAccount(account, balance.doubleValue()));
		}
		return accounts;
	}

	public Map<String, BitcoinAccount> listAccounts() throws BitcoinException {
		return listAccounts(1);
	}

	@Override
	public List<String> listReceivedByAccount(int minConf, boolean includeEmpty)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> listReceivedByAddress(int minConf, boolean includeEmpty)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	// BitcoinBlockService
	@Override
	public BitcoinBlock getBlock(String hash) throws BitcoinException {
		if (hash == null) {
			hash = "";
		}
		JsonArray parameters = Json.createArrayBuilder().add(hash).build();
		JsonObject results = (JsonObject) invoke(BitcoinConstant.BTCAPI_BLOCK,
				parameters);
		return BitcoinBlock.fromJson(results);
	}

	@Override
	public int getBlockCount() throws BitcoinException {
		JsonNumber results = (JsonNumber) invoke(BitcoinConstant.BTCAPI_BLOCK_COUNT);
		return results.intValue();
	}

	@Override
	public String getBlockHash(int index) throws BitcoinException {
		if (index < 0) {
			index = 0;
		}
		JsonArray parameters = Json.createArrayBuilder().add(index).build();
		JsonString results = (JsonString) invoke(
				BitcoinConstant.BTCAPI_BLOCK_HASH, parameters);
		return results.getString();
	}

	@Override
	public String getBlockTemplate(String params) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getWork(String data) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}
	
	@Override
	public List<String> listSinceBlock(String blockHash, int targetConfirmations)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	// BitcoinInfoService
	@Override
	public double getDifficulty() throws BitcoinException {
		JsonNumber results = (JsonNumber) invoke(BitcoinConstant.BTCAPI_INFO_DIFFICULTY);
		return results.doubleValue();
	}

	@Override
	public boolean getGenerate() throws BitcoinException {
		JsonValue results = invoke(BitcoinConstant.BTCAPI_INFO_GENERATE);
		return Boolean.valueOf(String.valueOf(results));
	}

	@Override
	public int getHashesPerSec() throws BitcoinException {
		JsonNumber results = (JsonNumber) invoke(BitcoinConstant.BTCAPI_INFO_HASHESPERSEC);
		return results.intValue();
	}

	@Override
	public BitcoinClientInfo getInfo() throws BitcoinException {
		JsonObject results = (JsonObject) invoke(BitcoinConstant.BTCAPI_INFO);
		return BitcoinClientInfo.fromJson(results);
	}

	@Override
	public BitcoinMiningInfo getMiningInfo() throws BitcoinException {
		JsonObject results = (JsonObject) invoke(BitcoinConstant.BTCAPI_INFO_MINING);
		return BitcoinMiningInfo.fromJson(results);
	}

	@Override
	public List<BitcoinPeer> getPeerInfo() throws BitcoinException {
		JsonArray results = (JsonArray) invoke(BitcoinConstant.BTCAPI_INFO_PEER);
		List<BitcoinPeer> peers = new ArrayList<BitcoinPeer>();
		for (JsonObject result : results.getValuesAs(JsonObject.class)) {
			peers.add(BitcoinPeer.fromJson(result));
		}
		return peers;
	}

	@Override
	public List<String> getRawMemPool() throws BitcoinException {
		JsonArray results = (JsonArray) invoke(BitcoinConstant.BTCAPI_INFO_RAW_MEM_POOL);
		List<String> rawMemPool = new ArrayList<String>();
		for (JsonString result : results.getValuesAs(JsonString.class)) {
			rawMemPool.add(result.getString());
		}
		return rawMemPool;
	}

	@Override
	public BitcoinTxOutputSet getTxOutputSetInfo() throws BitcoinException {
		JsonObject results = (JsonObject) invoke(BitcoinConstant.BTCAPI_INFO_TX_OUTPUT_SET);
		return BitcoinTxOutputSet.fromJson(results);
	}

	// BitcoinMiscService

	// BitcoinNodeService
	@Override
	public void addNode(String node, BitcoinNodeOperationEnum operation)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getAddedNodeInfo(boolean dns, String node)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public int getConnectionCount() throws BitcoinException {
		JsonNumber results = (JsonNumber) invoke(BitcoinConstant.BTCAPI_NODE_CONNECTION_COUNT);
		return results.intValue();
	}

	// BitcoinRawTransactionService
	@Override
	public String createRawTransaction(List<Object> txIds,
			List<Object> addresses) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String decodeRawTransaction(String txId) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getRawTransaction(String txId, boolean verbose)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	// BitcoinStatusService
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

	public String help() throws BitcoinException {
		return help("");
	}

	@Override
	public String stop() throws BitcoinException {
		JsonString results = (JsonString) invoke(BitcoinConstant.BTCAPI_STATUS_STOP);
		return results.getString();
	}

	// BitcoinWalletService
	@Override
	public void addMultiSignatureAddress(int required, List<String> keys,
			String account) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	public void addMultiSignatureAddress(int required, List<String> keys)
			throws BitcoinException {
		addMultiSignatureAddress(required, keys, "");
	}

	@Override
	public void backupWallet(File destination) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String createMultiSignatureAddress(int required, List<String> keys)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String dumpPivateKey(String address) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void encryptWallet(String passPhrase) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getTransaction(String txId) throws BitcoinException {
		if (txId == null) {
			txId = "";
		}
		JsonArray parameters = Json.createArrayBuilder().add(txId).build();
		JsonValue results = invoke(BitcoinConstant.BTCAPI_WALLET_TX, parameters);
		return String.valueOf(results);
	}

	@Override
	public String getTxOutput(String txId, int n, boolean includeMemPool)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String importPrivateKey(String privateKey, String label,
			boolean reScan) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void keyPoolRefill() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> listAddressGroupings() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}
}