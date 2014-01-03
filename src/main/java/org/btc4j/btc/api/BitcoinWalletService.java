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

package org.btc4j.btc.api;

import org.btc4j.btc.BitcoinException;

public interface BitcoinWalletService {
	//help: gettransaction <txid> Get detailed information about in-wallet transaction <txid>
	public String getTransaction(String txId) throws BitcoinException;
	
	//help: getrawtransaction <txid> [verbose=0] If verbose=0, returns a string that is serialized, hex-encoded data for <txid>.
	//If verbose is non-zero, returns an Object with information about <txid>.
	
	// backupwallet
	// <destination>
	// Safely copies wallet.dat to destination, which can be a directory or a
	// path with filename.
	// N
	// public void backupWallet() throws BitcoinException;

	// encryptwallet
	// <passphrase>
	// Encrypts the wallet with <passphrase>.
	// N
	// public void encryptWallet() throws BitcoinException;

	// dumpprivkey
	// <bitcoinaddress>
	// Reveals the private key corresponding to <bitcoinaddress>
	// Y
	// public void dumpPrivateKey() throws BitcoinException;

	// walletlock Removes the wallet encryption key from memory, locking the
	// wallet. After calling this method, you will need to call walletpassphrase
	// again before being able to call any methods which require the wallet to
	// be unlocked. N

	// walletpassphrase <passphrase> <timeout> Stores the wallet decryption key
	// in memory for <timeout> seconds. N

	// walletpassphrasechange <oldpassphrase> <newpassphrase> Changes the wallet
	// passphrase from <oldpassphrase> to <newpassphrase>. N
}
