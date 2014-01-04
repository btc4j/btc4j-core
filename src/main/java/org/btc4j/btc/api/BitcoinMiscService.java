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

public interface BitcoinMiscService {
	// createrawtransaction
	// [{"txid":txid,"vout":n},...] {address:amount,...}
	// version 0.7 Creates a raw transaction spending given inputs.
	// N
	// public void createRawTransaction() throws BitcoinException;

	// decoderawtransaction
	// <hex string>
	// version 0.7 Produces a human-readable JSON object for a raw transaction.
	// N
	// public void decodeRawTransaction() throws BitcoinException;

	// getrawtransaction <txid> [verbose=0] version 0.7 Returns raw transaction
	// representation for given transaction id. N

	// getrawchangeaddress [account] recent git checkouts only Returns a new
	// Bitcoin address, for receiving change. This is for use with raw
	// transactions, NOT normal use. Y

	// getreceivedbyaccount [account] [minconf=1] Returns the total amount
	// received by addresses with [account] in transactions with at least
	// [minconf] confirmations. If [account] not provided return will include
	// all transactions to all accounts. (version 0.3.24) N

	// getreceivedbyaddress <bitcoinaddress> [minconf=1] Returns the amount
	// received by <bitcoinaddress> in transactions with at least [minconf]
	// confirmations. It correctly handles the case where someone has sent to
	// the address in multiple transactions. Keep in mind that addresses are
	// only ever used for receiving transactions. Works only for addresses in
	// the local wallet, external addresses will always show 0. N

	// gettransaction <txid> Returns an object about the given transaction
	// containing: "amount" : total amount of the transaction "confirmations" :
	// number of confirmations of the transaction "txid" : the transaction ID
	// "time" : time associated with the transaction[1]. "details" - An array of
	// objects containing: "account" "address" "category" "amount" "fee" N

	// gettxout <txid> <n> [includemempool=true] Returns details about an
	// unspent transaction output (UTXO) N

	// gettxoutsetinfo Returns statistics about the unspent transaction output
	// (UTXO) set N

	// getwork [data] If [data] is not specified, returns formatted hash data to
	// work on: "midstate" : precomputed hash state after hashing the first half
	// of the data "data" : block data "hash1" : formatted hash buffer for
	// second hash "target" : little endian hash target If [data] is specified,
	// tries to solve the block and returns true if it was successful. N

	// importprivkey <bitcoinprivkey> [label] [rescan=true] Adds a private key
	// (as returned by dumpprivkey) to your wallet. This may take a while, as a
	// rescan is done, looking for existing transactions. Optional [rescan]
	// parameter added in 0.8.0. Y

	// keypoolrefill Fills the keypool, requires wallet passphrase to be set. Y

	// listaddressgroupings version 0.7 Returns all addresses in the wallet and
	// info used for coincontrol. N

	// listreceivedbyaccount [minconf=1] [includeempty=false] Returns an array
	// of objects containing: "account" : the account of the receiving addresses
	// "amount" : total amount received by addresses with this account
	// "confirmations" : number of confirmations of the most recent transaction
	// included N listreceivedbyaddress [minconf=1] [includeempty=false] Returns
	// an array of objects containing: "address" : receiving address "account" :
	// the account of the receiving address "amount" : total amount received by
	// the address "confirmations" : number of confirmations of the most recent
	// transaction included To get a list of accounts on the system, execute
	// bitcoind listreceivedbyaddress 0 true N

	// listsinceblock [blockhash] [target-confirmations] Get all transactions in
	// blocks since block [blockhash], or all transactions if omitted. N

	// listtransactions [account] [count=10] [from=0] Returns up to [count] most
	// recent transactions skipping the first [from] transactions for account
	// [account]. If [account] not provided will return recent transaction from
	// all accounts. N

	// listunspent [minconf=1] [maxconf=999999] version 0.7 Returns array of
	// unspent transaction inputs in the wallet. N

	// listlockunspent version 0.8 Returns list of temporarily unspendable
	// outputs

	// lockunspent <unlock?> [array-of-objects] version 0.8 Updates list of
	// temporarily unspendable outputs

	// move <fromaccount> <toaccount> <amount> [minconf=1] [comment] Move from
	// one account in your wallet to another N

	// sendfrom <fromaccount> <tobitcoinaddress> <amount> [minconf=1] [comment]
	// [comment-to] <amount> is a real and is rounded to 8 decimal places. Will
	// send the given amount to the given address, ensuring the account has a
	// valid balance using [minconf] confirmations. Returns the transaction ID
	// if successful (not in JSON object). Y

	// sendmany <fromaccount> {address:amount,...} [minconf=1] [comment] amounts
	// are double-precision floating point numbers Y

	// sendrawtransaction <hexstring> version 0.7 Submits raw transaction
	// (serialized, hex-encoded) to local node and network. N

	// sendtoaddress <bitcoinaddress> <amount> [comment] [comment-to] <amount>
	// is a real and is rounded to 8 decimal places. Returns the transaction ID
	// <txid> if successful. Y

	// setaccount <bitcoinaddress> <account> Sets the account associated with
	// the given address. Assigning address that is already assigned to the same
	// account will create a new address associated with that account. N

	// setgenerate <generate> [genproclimit] <generate> is true or false to turn
	// generation on or off. Generation is limited to [genproclimit] processors,
	// -1 is unlimited. N

	// settxfee <amount> <amount> is a real and is rounded to the nearest
	// 0.00000001 N

	// signmessage <bitcoinaddress> <message> Sign a message with the private
	// key of an address. Y

	// signrawtransaction <hexstring>
	// [{"txid":txid,"vout":n,"scriptPubKey":hex},...] [<privatekey1>,...]
	// version 0.7 Adds signatures to a raw transaction and returns the
	// resulting raw transaction. Y/N

	// submitblock <hex data> [optional-params-obj] Attempts to submit new block
	// to network. N

	// validateaddress <bitcoinaddress> Return information about
	// <bitcoinaddress>. N

	// verifymessage <bitcoinaddress> <signature> <message> Verify a signed
	// message. N
}
