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

package org.btc4j.btc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.btc4j.btc.BitcoinAccount;
import org.btc4j.btc.BitcoinBlock;
import org.btc4j.btc.BitcoinClientInfo;
import org.btc4j.btc.BitcoinDaemonBridge;
import org.btc4j.btc.BitcoinException;
import org.btc4j.btc.BitcoinMiningInfo;
import org.btc4j.btc.BitcoinNodeOperationEnum;
import org.btc4j.btc.BitcoinPeer;
import org.btc4j.btc.BitcoinTxOutputSet;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BitcoinDaemonBridgeTest {
	private static final String BITCOIND_DIR = "E:/bitcoin/bitcoind-0.8.6";
	private static final String BITCOIND_CMD = "bitcoind.exe";
	private static final String BITCOIND_TEST_ARG = "-testnet=1";
	private static final String BITCOIND_ACCOUNT = "user";
	private static final String BITCOIND_USER_ARG = "-rpcuser="
			+ BITCOIND_ACCOUNT;
	private static final String BITCOIND_PASSWD = "password";
	private static final String BITCOIND_PASSWD_ARG = "-rpcpassword="
			+ BITCOIND_PASSWD;
	private static final String BITCOIND_URL = "http://127.0.0.1:18332";
	// battlestar.xeno-genesis.com:18333
	// https://en.bitcoin.it/wiki/Testnet
	// 54.243.211.176:18333
	// YVmHAJ94qhsVMNvdjzw4Jt
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
				BITCOIND_ACCOUNT, BITCOIND_PASSWD);
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
		assertEquals(BITCOIND_ACCOUNT, account);
	}

	@Test
	public void getAccountAddress() throws BitcoinException {
		String address = BITCOIND.getAccountAddress(BITCOIND_ACCOUNT);
		assertNotNull(address);
		assertEquals("mteUu5qrZJAjybLJwVQpxxmpnyGFUhPYQD", address);
	}

	@Test
	public void getAddressesByAccount() throws BitcoinException {
		List<String> addresses = BITCOIND
				.getAddressesByAccount(BITCOIND_ACCOUNT);
		assertNotNull(addresses);
		assertTrue(addresses.size() >= 0);
		assertTrue(addresses.contains("mteUu5qrZJAjybLJwVQpxxmpnyGFUhPYQD"));
	}

	@Test
	public void getBalance() throws BitcoinException {
		double balance = BITCOIND.getBalance("", -1);
		assertTrue(balance >= 0);
		balance = BITCOIND.getBalance(BITCOIND_ACCOUNT, 2);
		assertTrue(balance >= 0);
	}

	@Test
	public void getNewAddress() throws BitcoinException {
		String address = BITCOIND.getNewAddress(BITCOIND_ACCOUNT);
		assertNotNull(address);
		address = BITCOIND.getNewAddress();
		assertNotNull(address);
	}

	@Test
	public void getReceivedByAccount() throws BitcoinException {
		double balance = BITCOIND.getReceivedByAccount("");
		assertTrue(balance >= 0);
		balance = BITCOIND.getReceivedByAccount(BITCOIND_ACCOUNT, 2);
		assertTrue(balance >= 0);
	}

	@Test
	public void getReceivedByAddress() throws BitcoinException {
		double balance = BITCOIND
				.getReceivedByAccount("mteUu5qrZJAjybLJwVQpxxmpnyGFUhPYQD");
		assertTrue(balance >= 0);
	}

	@Test
	public void listAccounts() throws BitcoinException {
		Map<String, BitcoinAccount> accounts = BITCOIND.listAccounts();
		assertNotNull(accounts);
		assertTrue(accounts.containsKey(BITCOIND_ACCOUNT));
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
		block = BITCOIND
				.getBlock("00000000b873e79784647a6c82962c70d228557d24a747ea4d1b8bbe878e1206");
		assertNotNull(block);
		assertEquals(
				"00000000b873e79784647a6c82962c70d228557d24a747ea4d1b8bbe878e1206",
				block.getHash());
		assertTrue(block.getTx().size() > 0);
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
	
	@Test(expected = BitcoinException.class)
	public void getBlockTemplate() throws BitcoinException {
		BITCOIND.getBlockTemplate("");
	}
	
	@Test(expected = BitcoinException.class)
	public void getWork() throws BitcoinException {
		BITCOIND.getWork("");
	}

	// BitcoinInfoService
	@Test
	public void getConnectionCount() throws BitcoinException {
		int connections = BITCOIND.getConnectionCount();
		assertTrue(connections >= 0);
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
	public void getInfo() throws BitcoinException {
		BitcoinClientInfo info = BITCOIND.getInfo();
		assertNotNull(info);
		assertTrue(info.isTestnet());
		assertEquals(80600, info.getVersion());
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
	@Test(expected = BitcoinException.class)
	public void addNode() throws BitcoinException {
		BITCOIND.addNode("", BitcoinNodeOperationEnum.ADD);
	}
	
	@Test(expected = BitcoinException.class)
	public void getAddedNodeInfo() throws BitcoinException {
		BITCOIND.getAddedNodeInfo(false, "");
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
		help = BITCOIND.help("listaddressgroupings");
		assertNotNull(help);
		assertTrue(help.length() >= 0);
		System.out.println("help: " + help);
	}

	// BitcoinRawTransactionService
	@Test(expected = BitcoinException.class)
	public void createRawTransaction() throws BitcoinException {
		BITCOIND.createRawTransaction(new ArrayList<Object>(),
				new ArrayList<Object>());
	}

	@Test(expected = BitcoinException.class)
	public void decodeRawTransaction() throws BitcoinException {
		BITCOIND.decodeRawTransaction("");
	}
	
	@Test(expected = BitcoinException.class)
	public void getRawTransaction() throws BitcoinException {
		BITCOIND.getRawTransaction("", false);
	}

	// BitcoinWalletService
	@Test(expected = BitcoinException.class)
	public void addMultiSignatureAddress() throws BitcoinException {
		BITCOIND.addMultiSignatureAddress(0, new ArrayList<String>(), "");
	}

	@Test(expected = BitcoinException.class)
	public void backupWallet() throws BitcoinException {
		BITCOIND.backupWallet(new File(""));
	}

	@Test(expected = BitcoinException.class)
	public void createMultiSignatureAddress() throws BitcoinException {
		BITCOIND.createMultiSignatureAddress(0, new ArrayList<String>());
	}
	
	@Test(expected = BitcoinException.class)
	public void dumpPivateKey() throws BitcoinException {
		BITCOIND.dumpPivateKey("");
	}
	
	@Test(expected = BitcoinException.class)
	public void encryptWallet() throws BitcoinException {
		BITCOIND.encryptWallet("");
	}

	@Ignore("Need valid txid")
	@Test(expected = BitcoinException.class)
	public void getTransaction() throws BitcoinException {
		String tx = BITCOIND
				.getTransaction("f0315ffc38709d70ad5647e22048358dd3745f3ce3874223c80a7c92fab0c8ba");
		assertNotNull(tx);
		tx = BITCOIND
				.getTransaction("4a5e1e4baab89f3a32518a88c31bc87f618f76673e2cc77ab2127b7afdeda33b");
		assertNotNull(tx);
	}
	
	@Test(expected = BitcoinException.class)
	public void getTxOutput() throws BitcoinException {
		BITCOIND.getTxOutput("", 0, false);
	}
	
	@Test(expected = BitcoinException.class)
	public void importPrivateKey() throws BitcoinException {
		BITCOIND.importPrivateKey("", "", false);
	}
	
	@Test(expected = BitcoinException.class)
	public void keyPoolRefill() throws BitcoinException {
		BITCOIND.keyPoolRefill();
	}
}
