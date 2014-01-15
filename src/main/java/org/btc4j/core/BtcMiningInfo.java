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

public class BtcMiningInfo extends BtcInfoBase {
	private static final long serialVersionUID = -1675343423503889069L;
	private int currentBlockSize;
	private int currentBlockTransactions;
	private boolean generate;
	private int generateProcessorLimit;
	private int hashesPerSecond;
	private int pooledTransactions;

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
