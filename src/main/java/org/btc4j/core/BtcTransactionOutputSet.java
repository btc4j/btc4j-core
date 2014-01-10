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

public class BtcTransactionOutputSet implements Serializable {
	private static final long serialVersionUID = -4608335658192669893L;
	private int height;
	private String bestBlock;
	private int transactions;
	private int outputTransactions;
	private int bytesSerialized;
	private String hashSerialized;
	private double totalAmount;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getBestBlock() {
		return bestBlock;
	}

	public void setBestBlock(String bestBlock) {
		this.bestBlock = bestBlock;
	}

	public int getTransactions() {
		return transactions;
	}

	public void setTransactions(int transactions) {
		this.transactions = transactions;
	}

	public int getOutputTransactions() {
		return outputTransactions;
	}

	public void setOutputTransactions(int outputTransactions) {
		this.outputTransactions = outputTransactions;
	}

	public int getBytesSerialized() {
		return bytesSerialized;
	}

	public void setBytesSerialized(int bytesSerialized) {
		this.bytesSerialized = bytesSerialized;
	}

	public String getHashSerialized() {
		return hashSerialized;
	}

	public void setHashSerialized(String hashSerialized) {
		this.hashSerialized = hashSerialized;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
