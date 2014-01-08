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

	public String createRawTransaction(List<Object> transactionIds,
			List<Object> addresses) throws BitcoinException;

	public String decodeRawTransaction(String transactionId)
			throws BitcoinException;

	public String dumpPrivateKey(String address) throws BitcoinException;

	public void encryptWallet(String passPhrase) throws BitcoinException;

	public String getAccount(String address) throws BitcoinException;

	public String getAccountAddress(String account) throws BitcoinException;

	public String getAddedNodeInformation(boolean dns, String node)
			throws BitcoinException;

	public List<String> getAddressesByAccount(String account)
			throws BitcoinException;

	public double getBalance(String account, int minConfirms)
			throws BitcoinException;

	public BitcoinBlock getBlock(String hash) throws BitcoinException;

	public int getBlockCount() throws BitcoinException;

	public String getBlockHash(int index) throws BitcoinException;

	public String getBlockTemplate(String params) throws BitcoinException;

	public int getConnectionCount() throws BitcoinException;

	public double getDifficulty() throws BitcoinException;

	public boolean getGenerate() throws BitcoinException;

	public int getHashesPerSecond() throws BitcoinException;

	public BitcoinStatusInfo getInformation() throws BitcoinException;

	public BitcoinMining getMiningInformation() throws BitcoinException;

	public String getNewAddress(String account) throws BitcoinException;

	public List<BitcoinPeer> getPeerInformation() throws BitcoinException;

	public List<String> getRawMemoryPool() throws BitcoinException;

	public String getRawTransaction(String transactionId, boolean verbose)
			throws BitcoinException;

	public double getReceivedByAccount(String account, int minConfirms)
			throws BitcoinException;

	public double getReceivedByAddress(String address, int minConfirms)
			throws BitcoinException;

	public String getTransaction(String transactionId) throws BitcoinException;

	public String getTransactionOutput(String transactionId, int n,
			boolean includeMemoryPool) throws BitcoinException;

	public BitcoinTransactionOutputSet getTransactionOutputSetInformation()
			throws BitcoinException;

	public String getWork(String data) throws BitcoinException;

	public String help(String command) throws BitcoinException;

	public String importPrivateKey(String privateKey, String label,
			boolean rescan) throws BitcoinException;

	public void keyPoolRefill() throws BitcoinException;

	public Map<String, BitcoinAccount> listAccounts(int minConfirms)
			throws BitcoinException;

	public List<String> listAddressGroupings() throws BitcoinException;

	public List<String> listLockUnspent() throws BitcoinException;

	public List<String> listReceivedByAccount(int minConfirms,
			boolean includeEmpty) throws BitcoinException;

	public List<String> listReceivedByAddress(int minConfirms,
			boolean includeEmpty) throws BitcoinException;

	public List<String> listSinceBlock(String blockHash, int targetConfirms)
			throws BitcoinException;

	public List<String> listTransactions(String account, int count, int from)
			throws BitcoinException;

	public List<String> listUnspent(int minConfirms, int maxConfirms)
			throws BitcoinException;

	public void lockUnspent(boolean unlock, List<Object> outputs)
			throws BitcoinException;

	public void move(String fromAccount, String toAccount, double amount,
			int minConfirms, String comment) throws BitcoinException;

	public String sendFrom(String fromAccount, String toAddress, double amount,
			int minConfirms, String commentFrom, String commentTo)
			throws BitcoinException;

	public String sendMany(String fromAccount, List<Object> addresses,
			int minConfirms, String commentFrom, String commentTo)
			throws BitcoinException;

	public void sendRawTransaction(String transactionId)
			throws BitcoinException;

	public String sendToAddress(String toAddress, double amount,
			String commentFrom, String commentTo) throws BitcoinException;

	public void setAccount(String address, String account)
			throws BitcoinException;

	public void setGenerate(boolean generate, int generateProcessorsLimit)
			throws BitcoinException;

	public boolean setTransactionFee(double amount) throws BitcoinException;

	public void signMessage(String address, String message)
			throws BitcoinException;

	public void signRawTransaction(String transactionId,
			List<Object> signatures, List<String> keys) throws BitcoinException;

	public String stop() throws BitcoinException;

	public void submitBlock(String data, List<Object> params)
			throws BitcoinException;

	public BitcoinAddress validateAddress(String address)
			throws BitcoinException;

	public String verifyMessage(String address, String signature, String message)
			throws BitcoinException;
}
