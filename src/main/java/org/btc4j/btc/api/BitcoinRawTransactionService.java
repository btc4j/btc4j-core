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

import java.util.List;

import org.btc4j.btc.BitcoinException;

// https://en.bitcoin.it/wiki/Raw_Transactions
public interface BitcoinRawTransactionService {

	// createrawtransaction [{"txid":txid,"vout":n},...] {address:amount,...}
	// Create a transaction spending given inputs (array of objects containing
	// transaction outputs to spend), sending to given address(es). Returns the
	// hex-encoded transaction in a string. Note that the transaction's inputs
	// are not signed, and it is not stored in the wallet or transmitted to the
	// network.
	// Also note that NO transaction validity checks are done; it is easy to
	// create invalid transactions or transactions that will not be
	// relayed/mined by the network because they contain insufficient fees.
	// createrawtransaction
	// [{"txid":txid,"vout":n},...] {address:amount,...}
	// version 0.7 Creates a raw transaction spending given inputs.
	// N
	public String createRawTransaction(List<Object> txIds,
			List<Object> addresses) throws BitcoinException;

	// decoderawtransaction <hex string>
	// Returns JSON object with information about a serialized, hex-encoded
	// transaction.
	// decoderawtransaction
	// <hex string>
	// version 0.7 Produces a human-readable JSON object for a raw transaction.
	// N
	public String decodeRawTransaction(String txId) throws BitcoinException;

	// getrawtransaction <txid> [verbose=0]
	// If verbose=0, returns serialized, hex-encoded data for transaction txid.
	// If verbose is non-zero, returns a JSON Object containing information
	// about the transaction. Returns an error if <txid> is unknown.
	// getrawtransaction <txid> [verbose=0] If verbose=0, returns a string
	// that is serialized, hex-encoded data for <txid>.
	// If verbose is non-zero, returns an Object with information about <txid>.
	public String getRawTransaction(String txId, boolean verbose)
			throws BitcoinException;

	// listunspent [minconf=1] [maxconf=999999]
	// Returns an array of unspent transaction outputs in the wallet that have
	// between minconf and maxconf (inclusive) confirmations. Each output is a
	// 5-element object with keys: txid, output, scriptPubKey, amount,
	// confirmations. txid is the hexadecimal transaction id, output is which
	// output of that transaction, scriptPubKey is the hexadecimal-encoded
	// CScript for that output, amount is the value of that output and
	// confirmations is the transaction's depth in the chain.

	// lockunspent unlock? [{"txid":txid,"vout":n},...]
	// Temporarily lock (true) or unlock (false) specified transaction outputs.
	// A locked transaction output will not be chosen by automatic coin
	// selection, when spending bitcoins. Locks are stored in memory only. Nodes
	// start with zero locked outputs, and the locked output list is always
	// cleared (by virtue of process exit) when a node stops or fails.

	// listlockunspent
	// List all temporarily locked transaction outputs.

	// signrawtransaction <hex string>
	// [{"txid":txid,"vout":n,"scriptPubKey":hex},...] [<privatekey1>,...]
	// [sighash="ALL"]
	// Sign as many inputs as possible for raw transaction (serialized,
	// hex-encoded). The first argument may be several variations of the same
	// transaction concatenated together; signatures from all of them will be
	// combined together, along with signatures for keys in the local wallet.
	// The optional second argument is an array of parent transaction outputs,
	// so you can create a chain of raw transactions that depend on each other
	// before sending them to the network. Third optional argument is an array
	// of base58-encoded private keys that, if given, will be the only keys used
	// to sign the transaction. The fourth optional argument is a string that
	// specifies how the signature hash is computed, and can be "ALL", "NONE",
	// "SINGLE", "ALL|ANYONECANPAY", "NONE|ANYONECANPAY", or
	// "SINGLE|ANYONECANPAY". Returns json object with keys:
	// hex : raw transaction with signature(s) (hex-encoded string)
	// complete : 1 if rawtx is completely signed, 0 if signatures are missing.
	// If no private keys are given and the wallet is locked, requires that the
	// wallet be unlocked with walletpassphrase first.

	// sendrawtransaction <hex string>
	// Submits raw transaction (serialized, hex-encoded) to local node and
	// network. Returns transaction id, or an error if the transaction is
	// invalid for any reason.
}
