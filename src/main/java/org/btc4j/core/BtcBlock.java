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

public class BtcBlock implements Serializable {
	private static final long serialVersionUID = -5115242454053420689L;
	private String hash;
	private int confirmations;
	private int size;
	private int height;
	private int version;
	private String merkleRoot;
	private List<BtcTransaction> transactions;
	private int time;
	private int nonce;
	private String bits;
	private BigDecimal difficulty;
	private String previousBlockHash;
	private String nextBlockHash;

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public int getConfirmations() {
		return confirmations;
	}

	public void setConfirmations(int confirmations) {
		this.confirmations = confirmations;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getMerkleRoot() {
		return merkleRoot;
	}

	public void setMerkleRoot(String merkleRoot) {
		this.merkleRoot = merkleRoot;
	}

	public List<BtcTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<BtcTransaction> transactions) {
		this.transactions = transactions;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getNonce() {
		return nonce;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	public String getBits() {
		return bits;
	}

	public void setBits(String bits) {
		this.bits = bits;
	}

	public BigDecimal getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(BigDecimal difficulty) {
		this.difficulty = difficulty;
	}

	public String getPreviousBlockHash() {
		return previousBlockHash;
	}

	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}

	public String getNextBlockHash() {
		return nextBlockHash;
	}

	public void setNextBlockHash(String nextBlockHash) {
		this.nextBlockHash = nextBlockHash;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcBlock [hash=");
		builder.append(hash);
		builder.append(", confirmations=");
		builder.append(confirmations);
		builder.append(", size=");
		builder.append(size);
		builder.append(", height=");
		builder.append(height);
		builder.append(", version=");
		builder.append(version);
		builder.append(", merkleRoot=");
		builder.append(merkleRoot);
		builder.append(", transactions=");
		builder.append(transactions);
		builder.append(", time=");
		builder.append(time);
		builder.append(", nonce=");
		builder.append(nonce);
		builder.append(", bits=");
		builder.append(bits);
		builder.append(", difficulty=");
		builder.append(difficulty);
		builder.append(", previousBlockHash=");
		builder.append(previousBlockHash);
		builder.append(", nextBlockHash=");
		builder.append(nextBlockHash);
		builder.append("]");
		return builder.toString();
	}
}
