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

import java.io.File;
import java.util.List;
import java.util.Map;

public interface BitcoinApi {
	public void addMultiSignatureAddress(int required, List<String> keys,
			String account) throws BitcoinException;

	public void addNode(String node, BitcoinNodeOperationEnum operation)
			throws BitcoinException;

	public void backupWallet(File destination) throws BitcoinException;

	public String createMultiSignatureAddress(int required, List<String> keys)
			throws BitcoinException;

	public String createRawTransaction(List<Object> txIds,
			List<Object> addresses) throws BitcoinException;

	public String decodeRawTransaction(String txId) throws BitcoinException;

	public String dumpPivateKey(String address) throws BitcoinException;

	public void encryptWallet(String passPhrase) throws BitcoinException;

	public String getAccount(String address) throws BitcoinException;

	public String getAccountAddress(String account) throws BitcoinException;

	public String getAddedNodeInfo(boolean dns, String node)
			throws BitcoinException;

	public List<String> getAddressesByAccount(String account)
			throws BitcoinException;

	public double getBalance(String account, int minConf)
			throws BitcoinException;

	public BitcoinBlock getBlock(String hash) throws BitcoinException;

	public int getBlockCount() throws BitcoinException;

	public String getBlockHash(int index) throws BitcoinException;

	public String getBlockTemplate(String params) throws BitcoinException;

	public int getConnectionCount() throws BitcoinException;

	public double getDifficulty() throws BitcoinException;

	public boolean getGenerate() throws BitcoinException;

	public int getHashesPerSec() throws BitcoinException;

	public BitcoinClientInfo getInfo() throws BitcoinException;

	public BitcoinMiningInfo getMiningInfo() throws BitcoinException;

	public String getNewAddress(String account) throws BitcoinException;

	public List<BitcoinPeer> getPeerInfo() throws BitcoinException;

	public List<String> getRawMemPool() throws BitcoinException;

	public String getRawTransaction(String txId, boolean verbose)
			throws BitcoinException;

	public double getReceivedByAccount(String account, int minConf)
			throws BitcoinException;

	public double getReceivedByAddress(String address, int minConf)
			throws BitcoinException;

	public String getTransaction(String txId) throws BitcoinException;

	public String getTxOutput(String txId, int n, boolean includeMemPool)
			throws BitcoinException;

	public BitcoinTxOutputSet getTxOutputSetInfo() throws BitcoinException;

	public String getWork(String data) throws BitcoinException;

	public String help(String command) throws BitcoinException;

	public String importPrivateKey(String privateKey, String label,
			boolean reScan) throws BitcoinException;

	public void keyPoolRefill() throws BitcoinException;

	public Map<String, BitcoinAccount> listAccounts(int minConf)
			throws BitcoinException;

	public List<String> listAddressGroupings() throws BitcoinException;

	public List<String> listReceivedByAccount(int minConf, boolean includeEmpty)
			throws BitcoinException;

	public List<String> listReceivedByAddress(int minConf, boolean includeEmpty)
			throws BitcoinException;

	public List<String> listSinceBlock(String blockHash, int targetConfirmations)
			throws BitcoinException;

	public String stop() throws BitcoinException;
}
