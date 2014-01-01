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

import java.io.File;
import java.net.URL;

import org.btc4j.btc.BitcoinException;
import org.btc4j.btc.model.BitcoinInfo;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BitcoinDaemonBridgeTest {
	private static final String BITCOIND_DIR = "E:/bitcoind-0.8.6";
	private static final String BITCOIND_CMD = "bitcoind.exe";
	private static final String BITCOIND_TEST_ARG = "-testnet=1";
	private static final String BITCOIND_USER = "user";
	private static final String BITCOIND_USER_ARG = "-rpcuser=" + BITCOIND_USER;
	private static final String BITCOIND_PASSWD = "password";
	private static final String BITCOIND_PASSWD_ARG = "-rpcpassword="
			+ BITCOIND_PASSWD;
	private static final String BITCOIND_URL = "http://127.0.0.1:18332";
	private static long BITCOIND_DELAY_SECONDS = 3;
	private static BitcoinDaemonBridge BITCOIND;

	@BeforeClass
	public static void testSetup() throws Exception {
		ProcessBuilder pb = new ProcessBuilder(BITCOIND_DIR + "/"
				+ BITCOIND_CMD, BITCOIND_TEST_ARG, BITCOIND_USER_ARG,
				BITCOIND_PASSWD_ARG);
		pb.directory(new File(BITCOIND_DIR));
		pb.start();
		Thread.sleep(BITCOIND_DELAY_SECONDS * 1000);
		BITCOIND = new BitcoinDaemonBridge(new URL(BITCOIND_URL),
				BITCOIND_USER, BITCOIND_PASSWD);
	}

	@AfterClass
	public static void testCleanup() throws Exception {
		String stop = BITCOIND.stop();
		assertNotNull(stop);
		assertTrue(stop.length() >= 0);
	}

	// BitcoinAccountService

	// BitcoinBlockService
	@Test
	public void getBlockCount() throws BitcoinException {
		int blocks = BITCOIND.getBlockCount();
		assertTrue(blocks >= 0);
	}

	// BitcoinMiscService

	// BitcoinNodeService
	@Test
	public void getConnectionCount() throws BitcoinException {
		int connections = BITCOIND.getConnectionCount();
		assertTrue(connections >= 0);
	}

	// BitcoinStatusService
	@Test
	public void getDifficulty() throws BitcoinException {
		double difficulty = BITCOIND.getDifficulty();
		assertTrue(difficulty >= 0);
	}

	@Test
	public void getGenerate() throws BitcoinException {
		boolean generate = BITCOIND.getGenerate();
		assertTrue(generate || true);
	}

	@Test
	public void getInfo() throws BitcoinException {
		BitcoinInfo info = BITCOIND.getInfo();
		assertNotNull(info);
		assertTrue(info.isTestnet());
		assertEquals(80600, info.getVersion());
	}

	@Test
	public void help() throws BitcoinException {
		String help = BITCOIND.help(null);
		assertNotNull(help);
		assertTrue(help.length() >= 0);
		help = BITCOIND.help("");
		assertNotNull(help);
		assertTrue(help.length() >= 0);
		help = BITCOIND.help("fakecommand");
		assertNotNull(help);
		assertTrue(help.length() >= 0);
		help = BITCOIND.help("help");
		assertNotNull(help);
		assertTrue(help.length() >= 0);
	}

	// BitcoinWalletService
}
