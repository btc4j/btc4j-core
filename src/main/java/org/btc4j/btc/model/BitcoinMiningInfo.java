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

import javax.json.JsonNumber;
import javax.json.JsonObject;

import org.btc4j.btc.BitcoinConstant;

public class BitcoinMiningInfo extends BitcoinInfo {
	private static final long serialVersionUID = -1675343423503889069L;
	private int currentBlockSize;
	private int currentBlockTx;
	private boolean generate;
	private int genProcLimit;
	private int hashesPerSec;
	private int pooledTx;

	public static BitcoinMiningInfo fromJson(JsonObject value) {
		BitcoinMiningInfo info = new BitcoinMiningInfo();
		info.setBlocks(value.getInt(BitcoinConstant.BTCOBJ_INFO_BLOCKS, 0));
		info.setCurrentBlockSize(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_CURRENT_BLOCK_SIZE, 0));
		info.setCurrentBlockTx(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_CURRENT_BLOCK_TX, 0));
		JsonNumber difficulty = value
				.getJsonNumber(BitcoinConstant.BTCOBJ_INFO_DIFFICULTY);
		if (difficulty != null) {
			info.setDifficulty(difficulty.doubleValue());
		}
		info.setErrors(value.getString(BitcoinConstant.BTCOBJ_INFO_ERRORS, ""));
		info.setGenerate(value.getBoolean(BitcoinConstant.BTCOBJ_INFO_GENERATE,
				false));
		info.setGenProcLimit(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_PROC_LIMIT, -1));
		info.setHashesPerSec(value.getInt(
				BitcoinConstant.BTCOBJ_INFO_HASHESPERSEC, 0));
		info.setPooledTx(value.getInt(BitcoinConstant.BTCOBJ_INFO_POOLED_TX, 0));
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

	public int getCurrentBlockTx() {
		return currentBlockTx;
	}

	public void setCurrentBlockTx(int currentBlockTx) {
		this.currentBlockTx = currentBlockTx;
	}

	public boolean isGenerate() {
		return generate;
	}

	public void setGenerate(boolean generate) {
		this.generate = generate;
	}

	public int getGenProcLimit() {
		return genProcLimit;
	}

	public void setGenProcLimit(int genProcLimit) {
		this.genProcLimit = genProcLimit;
	}

	public int getHashesPerSec() {
		return hashesPerSec;
	}

	public void setHashesPerSec(int hashesPerSec) {
		this.hashesPerSec = hashesPerSec;
	}

	public int getPooledTx() {
		return pooledTx;
	}

	public void setPooledTx(int pooledTx) {
		this.pooledTx = pooledTx;
	}
}
