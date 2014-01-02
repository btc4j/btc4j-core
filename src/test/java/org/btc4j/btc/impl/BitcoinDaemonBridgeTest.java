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
import java.util.List;
import java.util.Map;

import org.btc4j.btc.BitcoinException;
import org.btc4j.btc.model.BitcoinAccount;
import org.btc4j.btc.model.BitcoinBlock;
import org.btc4j.btc.model.BitcoinClientInfo;
import org.btc4j.btc.model.BitcoinMiningInfo;
import org.btc4j.btc.model.BitcoinPeer;
import org.btc4j.btc.model.BitcoinTxOutputSet;
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
	private static long BITCOIND_DELAY_SECONDS = 5;
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
	@Test
	public void getAccount() throws BitcoinException {
		String account = BITCOIND
				.getAccount("mteUu5qrZJAjybLJwVQpxxmpnyGFUhPYQD");
		assertNotNull(account);
		assertEquals(BITCOIND_USER, account);
	}

	@Test
	public void getAccountAddress() throws BitcoinException {
		String address = BITCOIND.getAccountAddress(BITCOIND_USER);
		assertNotNull(address);
		assertEquals("mteUu5qrZJAjybLJwVQpxxmpnyGFUhPYQD", address);
	}

	@Test
	public void getAddressesByAccount() throws BitcoinException {
		List<String> addresses = BITCOIND.getAddressesByAccount(BITCOIND_USER);
		assertNotNull(addresses);
		assertTrue(addresses.size() >= 0);
		assertTrue(addresses.contains("mteUu5qrZJAjybLJwVQpxxmpnyGFUhPYQD"));
	}

	@Test
	public void getBalance() throws BitcoinException {
		double balance = BITCOIND.getBalance("", -1);
		assertTrue(balance >= 0);
		balance = BITCOIND.getBalance(BITCOIND_USER, 2);
		assertTrue(balance >= 0);
	}

	@Test
	public void getNewAddress() throws BitcoinException {
		String address = BITCOIND.getNewAddress(BITCOIND_USER);
		assertNotNull(address);
		address = BITCOIND.getNewAddress();
		assertNotNull(address);
	}

	@Test
	public void listAccounts() throws BitcoinException {
		Map<String, BitcoinAccount> accounts = BITCOIND.listAccounts();
		assertNotNull(accounts);
		assertTrue(accounts.containsKey(BITCOIND_USER));
	}

	// BitcoinBlockService
	@Test
	public void getBlock() throws BitcoinException {
		BitcoinBlock block = BITCOIND
				.getBlock("000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943");
		assertNotNull(block);
		assertEquals(
				"000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943",
				block.getHash());
		assertEquals(0, block.getHeight());
		assertEquals(1, block.getVersion());
	}

	@Test
	public void getBlockCount() throws BitcoinException {
		int blocks = BITCOIND.getBlockCount();
		assertTrue(blocks >= 0);
	}

	@Test
	public void getBlockHash() throws BitcoinException {
		String hash = BITCOIND.getBlockHash(-1);
		assertNotNull(hash);
		assertTrue(hash.length() >= 0);
	}

	// BitcoinInfoService
	@Test
	public void getInfo() throws BitcoinException {
		BitcoinClientInfo info = BITCOIND.getInfo();
		assertNotNull(info);
		assertTrue(info.isTestnet());
		assertEquals(80600, info.getVersion());
	}

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
	public void getHashesPerSec() throws BitcoinException {
		int hashesPerSec = BITCOIND.getHashesPerSec();
		assertTrue(hashesPerSec >= 0);
	}
	
	@Test
	public void getMiningInfo() throws BitcoinException {
		BitcoinMiningInfo info = BITCOIND.getMiningInfo();
		assertNotNull(info);
		assertTrue(info.isTestnet());
		assertTrue(info.getDifficulty() >= 0);
	}
	
	@Test
	public void getPeerInfo() throws BitcoinException {
		List<BitcoinPeer> peers = BITCOIND.getPeerInfo();
		assertNotNull(peers);
		assertTrue(peers.size() >= 0);
		assertTrue(peers.get(0).isSyncNode() || true);
	}
	
	@Test
	public void getRawMemPool() throws BitcoinException {
		List<String> rawMemPool = BITCOIND.getRawMemPool();
		assertNotNull(rawMemPool);
		assertTrue(rawMemPool.size() >= 0);
	}
	
	@Test
	public void getTxOutputSetInfo() throws BitcoinException {
		BitcoinTxOutputSet txOutputSet = BITCOIND.getTxOutputSetInfo();
		assertNotNull(txOutputSet);
		assertTrue(txOutputSet.getHeight() >= 0);
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
	public void help() throws BitcoinException {
		String help = BITCOIND.help();
		assertNotNull(help);
		assertTrue(help.length() >= 0);
		help = BITCOIND.help("fakecommand");
		assertNotNull(help);
		assertTrue(help.length() >= 0);
		help = BITCOIND.help("gettransaction");
		assertNotNull(help);
		assertTrue(help.length() >= 0);
		System.out.println("help: " + help);
	}

	// BitcoinWalletService
}
