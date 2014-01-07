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

package org.btc4j.btc;

import javax.json.JsonNumber;
import javax.json.JsonObject;

public class BitcoinClientInfo extends BitcoinInfo {
	private static final long serialVersionUID = -5800958166892028401L;
	private int version;
	private int protocolVersion;
	private int walletVersion;
	private double balance;
	private int timeOffset;
	private int connections;
	private String proxy;
	private int keyPoolOldest;
	private int keyPoolSize;
	private double transactionFee;

	public static BitcoinClientInfo fromJson(JsonObject value) throws BitcoinException {
		BitcoinClientInfo info = new BitcoinClientInfo();
		info.setVersion(value.getInt(BitcoinConstant.BTCOBJ_INFO_VERSION, 0));
		info.setProtocolVersion(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_PROTOCOL_VERSION, 0));
		info.setWalletVersion(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_WALLET_VERSION, 0));
		JsonNumber balance = value
				.getJsonNumber(BitcoinConstant.BTCOBJ_INFO_BALANCE);
		if (balance != null) {
			info.setBalance(balance.doubleValue());
		}
		info.setBlocks(value.getInt(BitcoinConstant.BTCOBJ_INFO_BLOCKS, 0));
		info.setTimeOffset(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_TIME_OFFSET, 0));
		info.setConnections(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_CONNECTIONS, 0));
		info.setProxy(value.getString(BitcoinConstant.BTCOBJ_INFO_PROXY, ""));
		JsonNumber difficulty = value
				.getJsonNumber(BitcoinConstant.BTCOBJ_INFO_DIFFICULTY);
		if (difficulty != null) {
			info.setDifficulty(difficulty.doubleValue());
		}
		info.setTestnet(value.getBoolean(BitcoinConstant.BTCOBJ_INFO_TESTNET,
				false));
		info.setKeyPoolOldest(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_KEYPOOL_OLDEST, 0));
		info.setKeyPoolSize(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_KEYPOOL_SIZE, 0));
		JsonNumber transactionFee = value
				.getJsonNumber(BitcoinConstant.BTCOBJ_INFO_TRANSACTION_FEE);
		if (transactionFee != null) {
			info.setTransactionFee(transactionFee.doubleValue());
		}
		info.setErrors(value.getString(BitcoinConstant.BTCOBJ_INFO_ERRORS, ""));
		return info;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(int protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public int getWalletVersion() {
		return walletVersion;
	}

	public void setWalletVersion(int walletVersion) {
		this.walletVersion = walletVersion;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getTimeOffset() {
		return timeOffset;
	}

	public void setTimeOffset(int timeOffset) {
		this.timeOffset = timeOffset;
	}

	public int getConnections() {
		return connections;
	}

	public void setConnections(int connections) {
		this.connections = connections;
	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	public int getKeyPoolOldest() {
		return keyPoolOldest;
	}

	public void setKeyPoolOldest(int keyPoolOldest) {
		this.keyPoolOldest = keyPoolOldest;
	}

	public int getKeyPoolSize() {
		return keyPoolSize;
	}

	public void setKeyPoolSize(int keyPoolSize) {
		this.keyPoolSize = keyPoolSize;
	}

	public double getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(double transactionFee) {
		this.transactionFee = transactionFee;
	}
}
