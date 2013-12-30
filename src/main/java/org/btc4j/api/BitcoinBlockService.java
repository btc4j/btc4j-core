package org.btc4j.api;

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

public interface BitcoinBlockService {
	// getbestblockhash
	//
	// recent git checkouts only Returns the hash of the best (tip) block in the
	// longest block chain.
	// N
	// public void getBestBlockHash() throws BitcoinException;

	// getblock
	// <hash>
	// Returns information about the block with the given hash.
	// N
	// public void getBlock() throws BitcoinException;

	// getblockcount
	//
	// Returns the number of blocks in the longest block chain.
	// N
	// public void getBlockCount() throws BitcoinException;

	// getblockhash
	// <index>
	// Returns hash of block in best-block-chain at <index>; index 0 is the
	// genesis block
	// N
	// public void getBlockHash() throws BitcoinException;

	// getblocknumber
	//
	// Deprecated. Removed in version 0.7. Use getblockcount.
	// N
	// public void getBlockNumber() throws BitcoinException;

	// getblocktemplate
	// [params]
	// Returns data needed to construct a block to work on. See BIP_0022 for
	// more info on params.
	// N
	// public void getblocktemplate() throws BitcoinException;
}
