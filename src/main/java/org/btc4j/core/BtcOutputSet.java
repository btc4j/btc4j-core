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

public class BtcOutputSet implements Serializable {
	private static final long serialVersionUID = -4608335658192669893L;
	private long height = 0;
	private String bestBlock = "";
	private long transactions = 0;
	private long outputs = 0;
	private long bytesSerialized = 0;
	private String hashSerialized = "";
	private BigDecimal totalAmount = BigDecimal.ZERO;

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public String getBestBlock() {
		return bestBlock;
	}

	public void setBestBlock(String bestBlock) {
		this.bestBlock = BtcUtil.notNull(bestBlock);
	}

	public long getTransactions() {
		return transactions;
	}

	public void setTransactions(long transactions) {
		this.transactions = transactions;
	}

	public long getOutputs() {
		return outputs;
	}

	public void setOutputs(long outputs) {
		this.outputs = outputs;
	}

	public long getBytesSerialized() {
		return bytesSerialized;
	}

	public void setBytesSerialized(long bytesSerialized) {
		this.bytesSerialized = bytesSerialized;
	}

	public String getHashSerialized() {
		return hashSerialized;
	}

	public void setHashSerialized(String hashSerialized) {
		this.hashSerialized = BtcUtil.notNull(hashSerialized);
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = BtcUtil.notNull(totalAmount);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcOutputSet [height=");
		builder.append(height);
		builder.append(", bestBlock=");
		builder.append(bestBlock);
		builder.append(", transactions=");
		builder.append(transactions);
		builder.append(", outputs=");
		builder.append(outputs);
		builder.append(", bytesSerialized=");
		builder.append(bytesSerialized);
		builder.append(", hashSerialized=");
		builder.append(hashSerialized);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append("]");
		return builder.toString();
	}
}
