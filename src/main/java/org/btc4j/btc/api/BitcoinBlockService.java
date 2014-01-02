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
import org.btc4j.btc.model.BitcoinBlock;

public interface BitcoinBlockService {
	// getbestblockhash
	//
	// recent git checkouts only Returns the hash of the best (tip) block in the
	// longest block chain.
	// N
	public String getBestBlockHash() throws BitcoinException;

	// getblock
	// <hash>
	// Returns information about the block with the given hash.
	// N
	public BitcoinBlock getBlock(String hash) throws BitcoinException;

	public int getBlockCount() throws BitcoinException;

	// getblockhash
	// <index>
	// Returns hash of block in best-block-chain at <index>; index 0 is the
	// genesis block
	// N
	public String getBlockHash(int index) throws BitcoinException;

	// getblocktemplate
	// [params]
	// Returns data needed to construct a block to work on. See BIP_0022 for
	// more info on params.
	// N
	// public void getblocktemplate() throws BitcoinException;
}
