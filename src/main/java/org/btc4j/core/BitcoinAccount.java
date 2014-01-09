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

import javax.json.JsonNumber;
import javax.json.JsonObject;

public class BitcoinAccount implements Serializable {
	private static final long serialVersionUID = -9141351425810937383L;
	private String account;
	private double amount;
	private int confirmations;
	
	public BitcoinAccount() {
	}

	public BitcoinAccount(String account, double amount, int confirmations) {
		this.account = account;
		this.amount = amount;
		this.confirmations = confirmations;
	}
	
	public static BitcoinAccount fromJson(JsonObject value) {
		BitcoinAccount account = new BitcoinAccount();
		account.setAccount(value.getString(
				BitcoinConstant.BTCOBJ_ACCOUNT_ACCOUNT, ""));
		JsonNumber amount = value
				.getJsonNumber(BitcoinConstant.BTCOBJ_ACCOUNT_AMOUNT);
		if (amount != null) {
			account.setAmount(amount.doubleValue());
		}
		account.setConfirmations(value.getInt(
				BitcoinConstant.BTCOBJ_ACCOUNT_CONFIRMATIONS, 0));
		return account;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getConfirmations() {
		return confirmations;
	}

	public void setConfirmations(int confirmations) {
		this.confirmations = confirmations;
	}
}
