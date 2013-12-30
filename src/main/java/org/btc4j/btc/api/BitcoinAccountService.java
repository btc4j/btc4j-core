package org.btc4j.btc.api;

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

public interface BitcoinAccountService {
	// getaccount
	// <bitcoinaddress>
	// Returns the account associated with the given address.
	// N
	// public void getAccount() throws BitcoinException;

	// getaccountaddress
	// <account>
	// Returns the current bitcoin address for receiving payments to this
	// account.
	// N
	// public void getAccountAddress() throws BitcoinException;

	// getaddressesbyaccount
	// <account>
	// Returns the list of addresses for the given account.
	// N
	// public void getAddressesByAccount() throws BitcoinException;

	// getbalance
	// [account] [minconf=1]
	// If [account] is not specified, returns the server's total available
	// balance. If [account] is specified, returns the balance in the account.
	// N
	// public void getBalance() throws BitcoinException;

	// getnewaddress [account] Returns a new bitcoin address for receiving
	// payments. If [account] is specified (recommended), it is added to the
	// address book so payments received with the address will be credited to
	// [account]. N
}
