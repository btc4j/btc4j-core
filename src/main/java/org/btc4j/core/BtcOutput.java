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

public class BtcOutput extends BtcOutputPart {
	private static final long serialVersionUID = 2201035711897764084L;
	private String bestBlock = "";
	private long confirmations = 0;
	private long index = 0;
	private long version = 0;
	private boolean coinbase = false;
	private BtcTransactionDetail detail = new BtcTransactionDetail();
	private BigDecimal value = BigDecimal.ZERO;

	public String getBestBlock() {
		return bestBlock;
	}

	public void setBestBlock(String bestBlock) {
		this.bestBlock = BtcUtil.notNull(bestBlock);
	}

	public long getConfirmations() {
		return confirmations;
	}

	public void setConfirmations(long confirmations) {
		this.confirmations = confirmations;
	}

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public boolean isCoinbase() {
		return coinbase;
	}

	public void setCoinbase(boolean coinbase) {
		this.coinbase = coinbase;
	}

	public BtcTransactionDetail getDetail() {
		return detail;
	}

	public void setDetail(BtcTransactionDetail detail) {
		this.detail = BtcUtil.notNull(detail);
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = BtcUtil.notNull(value);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcOutput [transaction=");
		builder.append(getTransaction());
		builder.append(", bestBlock=");
		builder.append(bestBlock);
		builder.append(", confirmations=");
		builder.append(confirmations);
		builder.append(", index=");
		builder.append(index);
		builder.append(", output=");
		builder.append(getOutput());
		builder.append(", script=");
		builder.append(getScript());
		builder.append(", version=");
		builder.append(version);
		builder.append(", coinbase=");
		builder.append(coinbase);
		builder.append(", detail=");
		builder.append(detail);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
}
