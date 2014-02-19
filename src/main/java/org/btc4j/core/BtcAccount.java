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

import java.io.Serializable;
import java.math.BigDecimal;

public class BtcAccount implements Serializable {
	private static final long serialVersionUID = -9141351425810937383L;
	private String account = "";
	private BigDecimal amount = BigDecimal.ZERO;
	private long confirmations = 0;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = BtcUtil.notNull(account);
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = BtcUtil.notNull(amount);
	}

	public long getConfirmations() {
		return confirmations;
	}

	public void setConfirmations(long confirmations) {
		this.confirmations = confirmations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcAccount [account=");
		builder.append(account);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", confirmations=");
		builder.append(confirmations);
		builder.append("]");
		return builder.toString();
	}
}
