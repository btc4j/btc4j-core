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

package org.btc4j.btc.impl;

import static org.junit.Assert.*;

import java.net.URL;

import org.btc4j.btc.BitcoinException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BitcoinDaemonBridgeTest {
	private static BitcoinDaemonBridge BITCOIND;

	@BeforeClass
	public static void testSetup() throws Exception {
		//TODO start bitcoind
		BITCOIND = new BitcoinDaemonBridge(new URL("http://127.0.0.1:18332"), "testnetuser", "testnetpassword");
	}
	
	@AfterClass
	public static void testCleanup() throws Exception {
		assertTrue(BITCOIND.stop().length() >= 0);
	}

	//TODO BitcoinAccountService
	
	//BitcoinBlockService
	@Test
	public void getBlockCount() throws BitcoinException {
		assertTrue(BITCOIND.getBlockCount() >= 0);
	}
	
	//TODO BitcoinMiscService
	
	//BitcoinNodeService
	@Test
	public void getConnectionCount() throws BitcoinException {
		assertTrue(BITCOIND.getConnectionCount() >= 0);
	}
	
	//BitcoinStatusService
	@Test
	public void getInfo() throws BitcoinException {
		assertTrue(BITCOIND.getInfo().length() >= 0);
	}
	
	@Test
	public void help() throws BitcoinException {
		assertTrue(BITCOIND.help("help").length() >= 0);
	}
	
	//TODO BitcoinWalletService
}
