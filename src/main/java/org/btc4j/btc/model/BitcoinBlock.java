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

package org.btc4j.btc.model;

import java.io.Serializable;

import javax.json.JsonNumber;
import javax.json.JsonObject;

import org.btc4j.btc.BitcoinConstant;

public class BitcoinBlock implements Serializable {
	private static final long serialVersionUID = -5115242454053420689L;
	private String hash;
	private int confirmations;
	private int size;
	private int height;
	private int version;
	private String merkleRoot;
	private String tx;
	private int time;
	private int nonce;
	private String bits;
	private double difficulty;
	private String nextBlockHash;

	public static BitcoinBlock fromJson(JsonObject value) {
		BitcoinBlock block = new BitcoinBlock();
		block.setHash(value.getString(BitcoinConstant.BTCOBJ_BLOCK_HASH, ""));
		block.setConfirmations(value.getInt(
				BitcoinConstant.BTCOBJ_BLOCK_CONFIRMATIONS, 0));
		block.setSize(value.getInt(BitcoinConstant.BTCOBJ_BLOCK_SIZE, 0));
		block.setHeight(value.getInt(BitcoinConstant.BTCOBJ_BLOCK_HEIGHT, 0));
		block.setVersion(value.getInt(BitcoinConstant.BTCOBJ_BLOCK_VERSION, 0));
		block.setMerkleRoot(value.getString(
				BitcoinConstant.BTCOBJ_BLOCK_MERKLE_ROOT, ""));
		block.setTx(value.getString(BitcoinConstant.BTCOBJ_BLOCK_TX, ""));
		block.setTime(value.getInt(BitcoinConstant.BTCOBJ_BLOCK_TIME, 0));
		block.setNonce(value.getInt(BitcoinConstant.BTCOBJ_BLOCK_NONCE, 0));
		block.setBits(value.getString(BitcoinConstant.BTCOBJ_BLOCK_BITS, ""));
		JsonNumber difficulty = value
				.getJsonNumber(BitcoinConstant.BTCOBJ_BLOCK_DIFFICULTY);
		if (difficulty != null) {
			block.setDifficulty(difficulty.doubleValue());
		}
		block.setNextBlockHash(value.getString(
				BitcoinConstant.BTCOBJ_BLOCK_NEXT_HASH, ""));
		return block;
	}

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

	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
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

	public double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}

	public String getNextBlockHash() {
		return nextBlockHash;
	}

	public void setNextBlockHash(String nextBlockHash) {
		this.nextBlockHash = nextBlockHash;
	}
}
