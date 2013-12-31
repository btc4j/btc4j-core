/*
 Copyright (c) 2013 btc4j.org

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

package org.btc4j.btc.api;

import org.btc4j.btc.BitcoinException;

public interface BitcoinStatusService {
	public double getDifficulty() throws BitcoinException;
	public boolean getGenerate() throws BitcoinException;
	//result: {"version":80600,"protocolversion":70001,"walletversion":60000,"balance":0E-8,"blocks":26000,"timeoffset":1,"connections":7,"proxy":"","difficulty":5.98565110,"testnet":true,"keypoololdest":1388494604,"keypoolsize":101,"paytxfee":0E-8,"errors":""}
	public String getInfo() throws BitcoinException;
	public String help(String command) throws BitcoinException;
	public String stop() throws BitcoinException;

	// gethashespersec Returns a recent hashes per second performance
	// measurement while generating. N

	// getmemorypool [data] Replaced in v0.7.0 with getblocktemplate,
	// submitblock, getrawmempool``` N

	// getrawmempool version 0.7 Returns all transaction ids in memory pool N
}
