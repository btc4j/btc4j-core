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

import java.io.File;
import java.util.List;

import org.btc4j.btc.BitcoinException;

public interface BitcoinWalletService {
	// addmultisigaddress
	// <nrequired> <'["key","key"]'> [account]
	// Add a nrequired-to-sign multisignature address to the wallet. Each key is
	// a bitcoin address or hex-encoded public key. If [account] is specified,
	// assign address to [account].
	// N
	public void addMultiSignatureAddress(int required, List<String> keys,
			String account) throws BitcoinException;

	// backupwallet
	// <destination>
	// Safely copies wallet.dat to destination, which can be a directory or a
	// path with filename.
	// N
	public void backupWallet(File destination) throws BitcoinException;

	// createmultisig
	// <nrequired> <'["key,"key"]'>
	// Creates a multi-signature address and returns a json object.
	//
	public String createMultiSignatureAddress(int required, List<String> keys)
			throws BitcoinException;

	// help: gettransaction <txid> Get detailed information about in-wallet
	// transaction <txid>
	public String getTransaction(String txId) throws BitcoinException;

	// help: getrawtransaction <txid> [verbose=0] If verbose=0, returns a string
	// that is serialized, hex-encoded data for <txid>.
	// If verbose is non-zero, returns an Object with information about <txid>.

	// encryptwallet
	// <passphrase>
	// Encrypts the wallet with <passphrase>.
	// N
	// public void encryptWallet() throws BitcoinException;

	// dumpprivkey
	// <bitcoinaddress>
	// Reveals the private key corresponding to <bitcoinaddress>
	// Y
	// public void dumpPivateKey() throws BitcoinException;

	// walletlock Removes the wallet encryption key from memory, locking the
	// wallet. After calling this method, you will need to call walletpassphrase
	// again before being able to call any methods which require the wallet to
	// be unlocked. N

	// walletpassphrase <passphrase> <timeout> Stores the wallet decryption key
	// in memory for <timeout> seconds. N

	// walletpassphrasechange <oldpassphrase> <newpassphrase> Changes the wallet
	// passphrase from <oldpassphrase> to <newpassphrase>. N
}
