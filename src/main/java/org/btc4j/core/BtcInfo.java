/*
 The MIT License (MIT)
 
 Copyright (c) 2013, 2014 by ggbusto

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

package org.btc4j.core;

import java.math.BigDecimal;

public class BtcInfo extends BtcInfoBase {
	private static final long serialVersionUID = -5800958166892028401L;
	private long version = 0;
	private long protocolVersion = 0;
	private long walletVersion = 0;
	private BigDecimal balance = BigDecimal.ZERO;
	private long timeOffset = 0;
	private long connections = 0;
	private String proxy = "";
	private long keyPoolOldest = 0;
	private long keyPoolSize = 0;
	private BigDecimal transactionFee = BigDecimal.ZERO;;

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public long getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(long protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public long getWalletVersion() {
		return walletVersion;
	}

	public void setWalletVersion(long walletVersion) {
		this.walletVersion = walletVersion;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = BtcUtil.notNull(balance);
	}

	public long getTimeOffset() {
		return timeOffset;
	}

	public void setTimeOffset(long timeOffset) {
		this.timeOffset = timeOffset;
	}

	public long getConnections() {
		return connections;
	}

	public void setConnections(long connections) {
		this.connections = connections;
	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = BtcUtil.notNull(proxy);
	}

	public long getKeyPoolOldest() {
		return keyPoolOldest;
	}

	public void setKeyPoolOldest(long keyPoolOldest) {
		this.keyPoolOldest = keyPoolOldest;
	}

	public long getKeyPoolSize() {
		return keyPoolSize;
	}

	public void setKeyPoolSize(long keyPoolSize) {
		this.keyPoolSize = keyPoolSize;
	}

	public BigDecimal getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(BigDecimal transactionFee) {
		this.transactionFee = BtcUtil.notNull(transactionFee);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcInfo [version=");
		builder.append(version);
		builder.append(", protocolVersion=");
		builder.append(protocolVersion);
		builder.append(", walletVersion=");
		builder.append(walletVersion);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", timeOffset=");
		builder.append(timeOffset);
		builder.append(", connections=");
		builder.append(connections);
		builder.append(", proxy=");
		builder.append(proxy);
		builder.append(", keyPoolOldest=");
		builder.append(keyPoolOldest);
		builder.append(", keyPoolSize=");
		builder.append(keyPoolSize);
		builder.append(", transactionFee=");
		builder.append(transactionFee);
		builder.append(", getBlocks()=");
		builder.append(getBlocks());
		builder.append(", getDifficulty()=");
		builder.append(getDifficulty());
		builder.append(", isTestnet()=");
		builder.append(isTestnet());
		builder.append(", getErrors()=");
		builder.append(getErrors());
		builder.append("]");
		return builder.toString();
	}
}
