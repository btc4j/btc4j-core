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

import javax.json.JsonNumber;
import javax.json.JsonObject;

public class BitcoinMining extends BitcoinInfo {
	private static final long serialVersionUID = -1675343423503889069L;
	private int currentBlockSize;
	private int currentBlockTransactions;
	private boolean generate;
	private int generateProcessorLimit;
	private int hashesPerSecond;
	private int pooledTransactions;

	public static BitcoinMining fromJson(JsonObject value)
			throws BitcoinException {
		BitcoinMining info = new BitcoinMining();
		info.setBlocks(value.getInt(BitcoinConstant.BTCOBJ_INFO_BLOCKS, 0));
		info.setCurrentBlockSize(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_CURRENT_BLOCK_SIZE, 0));
		info.setCurrentBlockTransactions(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_CURRENT_BLOCK_TRANSACTIONS, 0));
		JsonNumber difficulty = value
				.getJsonNumber(BitcoinConstant.BTCOBJ_INFO_DIFFICULTY);
		if (difficulty != null) {
			info.setDifficulty(difficulty.doubleValue());
		}
		info.setErrors(value.getString(BitcoinConstant.BTCOBJ_INFO_ERRORS, ""));
		info.setGenerate(value.getBoolean(BitcoinConstant.BTCOBJ_INFO_GENERATE,
				false));
		info.setGenProcessorLimit(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_PROCESSOR_LIMIT, -1));
		info.setHashesPerSecond(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_HASHES_PER_SECOND, 0));
		info.setPooledTransactions(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_POOLED_TRANSACTIONS, 0));
		info.setTestnet(value.getBoolean(BitcoinConstant.BTCOBJ_INFO_TESTNET,
				false));
		return info;
	}

	public int getCurrentBlockSize() {
		return currentBlockSize;
	}

	public void setCurrentBlockSize(int currentBlockSize) {
		this.currentBlockSize = currentBlockSize;
	}

	public int getCurrentBlockTransactions() {
		return currentBlockTransactions;
	}

	public void setCurrentBlockTransactions(int currentBlockTransactions) {
		this.currentBlockTransactions = currentBlockTransactions;
	}

	public boolean isGenerate() {
		return generate;
	}

	public void setGenerate(boolean generate) {
		this.generate = generate;
	}

	public int getGenProcessorLimit() {
		return generateProcessorLimit;
	}

	public void setGenProcessorLimit(int generateProcessorLimit) {
		this.generateProcessorLimit = generateProcessorLimit;
	}

	public int getHashesPerSecond() {
		return hashesPerSecond;
	}

	public void setHashesPerSecond(int hashesPerSecond) {
		this.hashesPerSecond = hashesPerSecond;
	}

	public int getPooledTransactions() {
		return pooledTransactions;
	}

	public void setPooledTransactions(int pooledTransactions) {
		this.pooledTransactions = pooledTransactions;
	}
}
