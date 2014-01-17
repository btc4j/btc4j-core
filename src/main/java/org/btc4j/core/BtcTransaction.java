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

import java.math.BigDecimal;
import java.util.List;

public class BtcTransaction extends BtcTransactionBase {
	private static final long serialVersionUID = -5995582642392441320L;
	private BigDecimal amount;
	private List<BtcTransactionDetail> details;
	private int timeReceived;
	private int blockIndex;
	
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public List<BtcTransactionDetail> getDetails() {
		return details;
	}

	public void setDetails(List<BtcTransactionDetail> details) {
		this.details = details;
	}

	public int getTimeReceived() {
		return timeReceived;
	}

	public void setTimeReceived(int timeReceived) {
		this.timeReceived = timeReceived;
	}

	public int getBlockIndex() {
		return blockIndex;
	}

	public void setBlockIndex(int blockIndex) {
		this.blockIndex = blockIndex;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcTransaction [transaction=");
		builder.append(getTransaction());
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", confirmations=");
		builder.append(getConfirmations());
		builder.append(", details=");
		builder.append(details);
		builder.append(", time=");
		builder.append(getTime());
		builder.append(", timeReceived=");
		builder.append(timeReceived);
		builder.append(", blockHash=");
		builder.append(getBlockHash());
		builder.append(", blockIndex=");
		builder.append(blockIndex);
		builder.append(", blockTime=");
		builder.append(getBlockTime());
		builder.append("]");
		return builder.toString();
	}
}
