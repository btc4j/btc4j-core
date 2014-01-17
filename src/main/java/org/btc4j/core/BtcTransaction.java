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

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class BtcTransaction implements Serializable {
	private static final long serialVersionUID = -5995582642392441320L;
	private String transaction;
	private BigDecimal amount;
	private int confirmations;
	private List<BtcTransactionDetail> details;
	private int time;
	private int timeReceived;
	private String blockHash;
	private int blockIndex;
	private int blockTime;
	
	public enum Category {
		RECEIVE, SEND;

		public static Category getValue(String value) {
			try {
				return Category.valueOf(value.toUpperCase());
			} catch (Throwable t) {
				return null;
			}
		}
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getConfirmations() {
		return confirmations;
	}

	public void setConfirmations(int confirmations) {
		this.confirmations = confirmations;
	}

	public List<BtcTransactionDetail> getDetails() {
		return details;
	}

	public void setDetails(List<BtcTransactionDetail> details) {
		this.details = details;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTimeReceived() {
		return timeReceived;
	}

	public void setTimeReceived(int timeReceived) {
		this.timeReceived = timeReceived;
	}

	public String getBlockHash() {
		return blockHash;
	}

	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}

	public int getBlockIndex() {
		return blockIndex;
	}

	public void setBlockIndex(int blockIndex) {
		this.blockIndex = blockIndex;
	}

	public int getBlockTime() {
		return blockTime;
	}

	public void setBlockTime(int blockTime) {
		this.blockTime = blockTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcTransaction [transaction=");
		builder.append(transaction);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", confirmations=");
		builder.append(confirmations);
		builder.append(", details=");
		builder.append(details);
		builder.append(", time=");
		builder.append(time);
		builder.append(", timeReceived=");
		builder.append(timeReceived);
		builder.append(", blockHash=");
		builder.append(blockHash);
		builder.append(", blockIndex=");
		builder.append(blockIndex);
		builder.append(", blockTime=");
		builder.append(blockTime);
		builder.append("]");
		return builder.toString();
	}
}
