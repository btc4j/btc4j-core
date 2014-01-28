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

public class BtcBlockTemplate extends BtcBlockBase {
	private static final long serialVersionUID = -9170963731584665470L;
	private long signatureOperations = 0;
	private List<BtcTransactionTemplate> transactions = new ArrayList<BtcTransactionTemplate>();
	private BtcCoinBase coinBase = new BtcCoinBase();
	private String workId = "";

	public enum Mode {
		TEMPLATE, NULL;

		public static Mode getValue(String value) {
			try {
				return Mode.valueOf(value.toUpperCase());
			} catch (Throwable t) {
				return NULL;
			}
		}
	}
	
	public long getSignatureOperations() {
		return signatureOperations;
	}
	
	public void setSignatureOperations(long signatureOperations) {
		this.signatureOperations = signatureOperations;
	}
	
	public List<BtcTransactionTemplate> getTransactions() {
		return transactions;
	}
	
	public void setTransactions(List<BtcTransactionTemplate> transactions) {
		this.transactions = BtcUtil.notNull(transactions);
	}
	
	public BtcCoinBase getCoinBase() {
		return coinBase;
	}
	
	public void setCoinBase(BtcCoinBase coinBase) {
		this.coinBase = BtcUtil.notNull(coinBase);
	}
	
	public String getWorkId() {
		return workId;
	}
	
	public void setWorkId(String workId) {
		this.workId = BtcUtil.notNull(workId);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcBlockTemplate [signatureOperations=");
		builder.append(signatureOperations);
		builder.append(", transactions=");
		builder.append(transactions);
		builder.append(", coinBase=");
		builder.append(coinBase);
		builder.append(", workId=");
		builder.append(workId);
		builder.append(", getBits()=");
		builder.append(getBits());
		builder.append(", getTime()=");
		builder.append(getTime());
		builder.append(", getHeight()=");
		builder.append(getHeight());
		builder.append(", getPreviousBlockHash()=");
		builder.append(getPreviousBlockHash());
		builder.append(", getSize()=");
		builder.append(getSize());
		builder.append(", getVersion()=");
		builder.append(getVersion());
		builder.append("]");
		return builder.toString();
	}
}
