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

public class BtcAddress extends BtcAddressBase {
	private static final long serialVersionUID = -3639666223461020070L;
	private boolean valid;
	private boolean mine;
	private boolean script;
	private String publicKey;
	private boolean compressed;
	private BtcAccount account;
	private BigDecimal amount;
	private int confirmations;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public boolean isScript() {
		return script;
	}

	public void setScript(boolean script) {
		this.script = script;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public boolean isCompressed() {
		return compressed;
	}

	public void setCompressed(boolean compressed) {
		this.compressed = compressed;
	}

	public BtcAccount getAccount() {
		return account;
	}

	public void setAccount(BtcAccount account) {
		this.account = account;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcAddress [valid=");
		builder.append(valid);
		builder.append(", mine=");
		builder.append(mine);
		builder.append(", script=");
		builder.append(script);
		builder.append(", publicKey=");
		builder.append(publicKey);
		builder.append(", compressed=");
		builder.append(compressed);
		builder.append(", account=");
		builder.append(account);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", confirmations=");
		builder.append(confirmations);
		builder.append(", getAddress()=");
		builder.append(getAddress());
		builder.append("]");
		return builder.toString();
	}
}