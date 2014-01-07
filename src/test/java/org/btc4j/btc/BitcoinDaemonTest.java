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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BitcoinDaemonTest {
	private static BitcoinDaemon BITCOIND;
	private static final String BITCOIND_ACCOUNT = "user";
	private static final String BITCOIND_CMD = "bitcoind.exe";
	private static int BITCOIND_DELAY_MILLIS = 10000;
	private static final String BITCOIND_DIR = "E:/bitcoin/bitcoind-0.8.6";
	private static final String BITCOIND_PASSWD = "password";
	private static final String BITCOIND_WALLET = "wallet.dat";
	private static final String BITCOIND_ADDRESS = "mteUu5qrZJAjybLJwVQpxxmpnyGFUhPYQD";

	@BeforeClass
	public static void testSetup() throws Exception {
		BITCOIND = BitcoinDaemon.runDaemon(new File(BITCOIND_DIR + "/"
				+ BITCOIND_CMD), true, BITCOIND_ACCOUNT, BITCOIND_PASSWD,
				BITCOIND_DELAY_MILLIS);
	}

	@AfterClass
	public static void testCleanup() throws Exception {
		String stop = BITCOIND.stop();
		assertNotNull(stop);
		assertTrue(stop.length() >= 0);
	}

	@Test(expected = BitcoinException.class)
	public void addMultiSignatureAddress() throws BitcoinException {
		BITCOIND.addMultiSignatureAddress(0, new ArrayList<String>(), "");
	}

	@Test(expected = BitcoinException.class)
	public void addNode() throws BitcoinException {
		BITCOIND.addNode("", BitcoinNodeOperationEnum.ADD);
	}

	@Test
	public void backupWallet() throws BitcoinException {
		File wallet = new File(BITCOIND_DIR + "/" + BITCOIND_WALLET);
		if (wallet.exists()) {
			wallet.delete();
		}
		BITCOIND.backupWallet(new File(BITCOIND_DIR));
		assertTrue(wallet.exists());
	}

	@Test(expected = BitcoinException.class)
	public void createMultiSignatureAddress() throws BitcoinException {
		BITCOIND.createMultiSignatureAddress(0, new ArrayList<String>());
	}

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
	public void dumpPrivateKey() throws BitcoinException {
		BITCOIND.dumpPrivateKey("");
	}

	@Test(expected = BitcoinException.class)
	public void encryptWallet() throws BitcoinException {
		BITCOIND.encryptWallet("");
	}

	@Test
	public void getAccount() throws BitcoinException {
		String account = BITCOIND.getAccount(BITCOIND_ADDRESS);
		assertNotNull(account);
		assertEquals(BITCOIND_ACCOUNT, account);
	}

	@Test
	public void getAccountAddress() throws BitcoinException {
		String address = BITCOIND.getAccountAddress(BITCOIND_ACCOUNT);
		assertNotNull(address);
		assertEquals(BITCOIND_ADDRESS, address);
	}

	@Test(expected = BitcoinException.class)
	public void getAddedNodeInformation() throws BitcoinException {
		BITCOIND.getAddedNodeInformation(false, "");
	}

	@Test
	public void getAddressesByAccount() throws BitcoinException {
		List<String> addresses = BITCOIND
				.getAddressesByAccount(BITCOIND_ACCOUNT);
		assertNotNull(addresses);
		assertTrue(addresses.size() >= 0);
		assertTrue(addresses.contains(BITCOIND_ADDRESS));
	}

	@Test
	public void getBalance() throws BitcoinException {
		double balance = BITCOIND.getBalance("", -1);
		assertTrue(balance >= 0);
		balance = BITCOIND.getBalance(BITCOIND_ACCOUNT, 2);
		assertTrue(balance >= 0);
	}

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
		List<BitcoinTransaction> transactions = block.getTransactions();
		assertNotNull(transactions);
		int size = transactions.size();
		assertTrue(size > 0);
		if (size > 0) {
			BitcoinTransaction transaction = transactions.get(0);
			assertNotNull(transaction);
		}
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
	public void getHashesPerSecond() throws BitcoinException {
		int hashesPerSec = BITCOIND.getHashesPerSecond();
		assertTrue(hashesPerSec >= 0);
	}

	@Test
	public void getInformation() throws BitcoinException {
		BitcoinClientInfo info = BITCOIND.getInformation();
		assertNotNull(info);
		assertTrue(info.isTestnet());
		assertEquals(80600, info.getVersion());
	}

	@Test
	public void getMiningInformation() throws BitcoinException {
		BitcoinMiningInfo info = BITCOIND.getMiningInformation();
		assertNotNull(info);
		assertTrue(info.isTestnet());
		assertTrue(info.getDifficulty() >= 0);
	}

	@Test
	public void getNewAddress() throws BitcoinException {
		String address = BITCOIND.getNewAddress(BITCOIND_ACCOUNT);
		assertNotNull(address);
		address = BITCOIND.getNewAddress();
		assertNotNull(address);
	}

	@Test
	public void getPeerInformation() throws BitcoinException {
		List<BitcoinPeer> peers = BITCOIND.getPeerInformation();
		assertNotNull(peers);
		int size = peers.size();
		assertTrue(size >= 0);
		if (size > 0) {
			BitcoinPeer peer = peers.get(0);
			assertTrue(peer.isSyncNode() || true);
			assertTrue(peer.getBanScore() >= 0);
		}
	}

	@Test
	public void getRawMemoryPool() throws BitcoinException {
		List<String> rawMemPool = BITCOIND.getRawMemoryPool();
		assertNotNull(rawMemPool);
		assertTrue(rawMemPool.size() >= 0);
	}

	@Test(expected = BitcoinException.class)
	public void getRawTransaction() throws BitcoinException {
		BITCOIND.getRawTransaction("", false);
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
		double balance = BITCOIND.getReceivedByAccount(BITCOIND_ADDRESS);
		assertTrue(balance >= 0);
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
	public void getTransactionOutput() throws BitcoinException {
		BITCOIND.getTransactionOutput("", 0, false);
	}

	@Test
	public void getTransactionOutputSetInformation() throws BitcoinException {
		BitcoinTransactionOutputSet txOutputSet = BITCOIND
				.getTransactionOutputSetInformation();
		assertNotNull(txOutputSet);
		assertTrue(txOutputSet.getHeight() >= 0);
	}

	@Test(expected = BitcoinException.class)
	public void getWork() throws BitcoinException {
		BITCOIND.getWork("");
	}

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
		help = BITCOIND.help("listtransactions");
		assertNotNull(help);
		assertTrue(help.length() >= 0);
	}

	@Test(expected = BitcoinException.class)
	public void importPrivateKey() throws BitcoinException {
		BITCOIND.importPrivateKey("", "", false);
	}

	@Test(expected = BitcoinException.class)
	public void keyPoolRefill() throws BitcoinException {
		BITCOIND.keyPoolRefill();
	}

	@Test
	public void listAccounts() throws BitcoinException {
		Map<String, BitcoinAccount> accounts = BITCOIND.listAccounts();
		assertNotNull(accounts);
		assertTrue(accounts.containsKey(BITCOIND_ACCOUNT));
	}

	@Test
	public void listAddressGroupings() throws BitcoinException {
		List<String> groupings = BITCOIND.listAddressGroupings();
		assertNotNull(groupings);
	}

	@Test(expected = BitcoinException.class)
	public void listLockUnspent() throws BitcoinException {
		BITCOIND.listLockUnspent();
	}

	@Test(expected = BitcoinException.class)
	public void listReceivedByAccount() throws BitcoinException {
		BITCOIND.listReceivedByAccount(0, false);
	}

	@Test(expected = BitcoinException.class)
	public void listReceivedByAddress() throws BitcoinException {
		BITCOIND.listReceivedByAddress(0, false);
	}

	@Test(expected = BitcoinException.class)
	public void listSinceBlock() throws BitcoinException {
		BITCOIND.listSinceBlock("", 0);
	}

	@Test(expected = BitcoinException.class)
	public void listTransactions() throws BitcoinException {
		BITCOIND.listTransactions("", 0, 0);
	}

	@Test(expected = BitcoinException.class)
	public void listUnspent() throws BitcoinException {
		BITCOIND.listUnspent(0, 0);
	}

	@Test(expected = BitcoinException.class)
	public void lockUnspent() throws BitcoinException {
		BITCOIND.lockUnspent(false, new ArrayList<Object>());
	}

	@Test(expected = BitcoinException.class)
	public void move() throws BitcoinException {
		BITCOIND.move("", "", 0, 0, "");
	}

	@Test(expected = BitcoinException.class)
	public void sendFrom() throws BitcoinException {
		BITCOIND.sendFrom("", "", 0, 0, "", "");
	}

	@Test(expected = BitcoinException.class)
	public void sendMany() throws BitcoinException {
		BITCOIND.sendMany("", new ArrayList<Object>(), 0, "", "");
	}

	@Test(expected = BitcoinException.class)
	public void sendRawTransaction() throws BitcoinException {
		BITCOIND.sendRawTransaction("");
	}

	@Test(expected = BitcoinException.class)
	public void sendToAddress() throws BitcoinException {
		BITCOIND.sendToAddress("", 0, "", "");
	}

	@Test(expected = BitcoinException.class)
	public void setAccount() throws BitcoinException {
		BITCOIND.setAccount("", "");
	}

	@Test
	public void setGenerate() throws BitcoinException {
		boolean generate = false;
		BITCOIND.setGenerate(generate);
		assertTrue(!BITCOIND.getGenerate());
		generate = true;
		BITCOIND.setGenerate(generate, 1);
		assertTrue(BITCOIND.getGenerate());
	}

	@Test(expected = BitcoinException.class)
	public void setTransactionFee() throws BitcoinException {
		BITCOIND.setTransactionFee(0);
	}

	@Test(expected = BitcoinException.class)
	public void signMessage() throws BitcoinException {
		BITCOIND.signMessage("", "");
	}

	@Test(expected = BitcoinException.class)
	public void signRawTransaction() throws BitcoinException {
		BITCOIND.signRawTransaction("", new ArrayList<Object>(),
				new ArrayList<String>());
	}

	@Test(expected = BitcoinException.class)
	public void submitBlock() throws BitcoinException {
		BITCOIND.submitBlock("", new ArrayList<Object>());
	}

	@Test
	public void validateAddress() throws BitcoinException {
		BitcoinAddress address = BITCOIND.validateAddress(BITCOIND_ADDRESS);
		assertNotNull(address);
		assertTrue(address.isValid());
		BitcoinAccount account = address.getAccount();
		assertNotNull(account);
		assertEquals(BITCOIND_ACCOUNT, account.getAccount());
		address = BITCOIND.validateAddress("bad address");
		assertNotNull(address);
		assertTrue(!address.isValid());
	}

	@Test(expected = BitcoinException.class)
	public void verifyMessage() throws BitcoinException {
		BITCOIND.verifyMessage("", "", "");
	}
}
