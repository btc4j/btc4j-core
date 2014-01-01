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

package org.btc4j.btc.model;

import java.io.Serializable;

import javax.json.JsonNumber;
import javax.json.JsonObject;

import org.btc4j.btc.BitcoinConstant;

public class BitcoinInfo implements Serializable {
	private static final long serialVersionUID = 6626334171356500177L;
	private int version;
	private int protocolVersion;
	private int walletVersion;
	private double balance;
	private int blocks;
	private int timeOffset;
	private int connections;
	private String proxy;
	private double difficulty;
	private boolean testnet;
	private int keyPoolOldest;
	private int keyPoolSize;
	private double payTxFee;
	private String errors;

	public static BitcoinInfo fromJson(JsonObject value) {
		BitcoinInfo info = new BitcoinInfo();
		info.setVersion(value.getInt(BitcoinConstant.BTCOBJ_INFO_VERSION, 0));
		info.setProtocolVersion(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_PROTO_VERSION, 0));
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
		JsonNumber txFee = value
				.getJsonNumber(BitcoinConstant.BTCOBJ_INFO_TX_FEE);
		if (txFee != null) {
			info.setPayTxFee(txFee.doubleValue());
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

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
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

	public double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}

	public boolean isTestnet() {
		return testnet;
	}

	public void setTestnet(boolean testnet) {
		this.testnet = testnet;
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

	public double getPayTxFee() {
		return payTxFee;
	}

	public void setPayTxFee(double payTxFee) {
		this.payTxFee = payTxFee;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitcoinInfo [version=");
		builder.append(version);
		builder.append(", protocolVersion=");
		builder.append(protocolVersion);
		builder.append(", walletVersion=");
		builder.append(walletVersion);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", blocks=");
		builder.append(blocks);
		builder.append(", timeOffset=");
		builder.append(timeOffset);
		builder.append(", connections=");
		builder.append(connections);
		builder.append(", proxy=");
		builder.append(proxy);
		builder.append(", difficulty=");
		builder.append(difficulty);
		builder.append(", testnet=");
		builder.append(testnet);
		builder.append(", keyPoolOldest=");
		builder.append(keyPoolOldest);
		builder.append(", keyPoolSize=");
		builder.append(keyPoolSize);
		builder.append(", payTxFee=");
		builder.append(payTxFee);
		builder.append(", errors=");
		builder.append(errors);
		builder.append("]");
		return builder.toString();
	}
}
