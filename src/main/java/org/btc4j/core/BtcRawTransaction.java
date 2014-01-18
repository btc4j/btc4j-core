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

package org.btc4j.core;

import java.util.ArrayList;
import java.util.List;

public class BtcRawTransaction extends BtcTransactionBase {
	private static final long serialVersionUID = 6599053559390310432L;
	private String hex = "";
	private long version = 0;
	private long lockTime = 0;
	private List<BtcTransactionInput> inputTransactions = new ArrayList<BtcTransactionInput>();
	private List<BtcTransactionOutput> outputTransactions = new ArrayList<BtcTransactionOutput>();

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = BtcUtil.notNull(hex);
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public long getLockTime() {
		return lockTime;
	}

	public void setLockTime(long lockTime) {
		this.lockTime = lockTime;
	}

	public List<BtcTransactionInput> getInputTransactions() {
		return inputTransactions;
	}

	public void setInputTransactions(List<BtcTransactionInput> inputTransactions) {
		this.inputTransactions = BtcUtil.notNull(inputTransactions);
	}

	public List<BtcTransactionOutput> getOutputTransactions() {
		return outputTransactions;
	}

	public void setOutputTransactions(
			List<BtcTransactionOutput> outputTransactions) {
		this.outputTransactions = BtcUtil.notNull(outputTransactions);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcRawTransaction [hex=");
		builder.append(hex);
		builder.append(", version=");
		builder.append(version);
		builder.append(", lockTime=");
		builder.append(lockTime);
		builder.append(", inputTransactions=");
		builder.append(inputTransactions);
		builder.append(", outputTransactions=");
		builder.append(outputTransactions);
		builder.append(", getTransaction()=");
		builder.append(getTransaction());
		builder.append(", getConfirmations()=");
		builder.append(getConfirmations());
		builder.append(", getTime()=");
		builder.append(getTime());
		builder.append(", getBlockHash()=");
		builder.append(getBlockHash());
		builder.append(", getBlockTime()=");
		builder.append(getBlockTime());
		builder.append("]");
		return builder.toString();
	}
}