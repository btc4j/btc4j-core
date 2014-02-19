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

public class BtcTransactionDetail implements Serializable {
	private static final long serialVersionUID = -3144377866580782063L;
	private String account = "";
	private String address = "";
	private BtcTransaction.Category category = BtcTransaction.Category.NULL;
	private BigDecimal amount = BigDecimal.ZERO;
	private BigDecimal fee = BigDecimal.ZERO;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = BtcUtil.notNull(account);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = BtcUtil.notNull(address);
	}

	public BtcTransaction.Category getCategory() {
		return category;
	}

	public void setCategory(BtcTransaction.Category category) {
		this.category = BtcUtil.notNull(category);
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = BtcUtil.notNull(amount);
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = BtcUtil.notNull(fee);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcTransactionDetail [account=");
		builder.append(account);
		builder.append(", address=");
		builder.append(address);
		builder.append(", category=");
		builder.append(category);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", fee=");
		builder.append(fee);
		builder.append("]");
		return builder.toString();
	}
}
