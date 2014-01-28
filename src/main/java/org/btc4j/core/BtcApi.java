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

package org.btc4j.core;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface BtcApi {
	public String addMultiSignatureAddress(long required, List<String> keys,
			String account) throws BtcException;

	public void addNode(String node, BtcNode.Operation operation)
			throws BtcException;

	public void backupWallet(File destination) throws BtcException;

	public BtcMultiSignatureAddress createMultiSignatureAddress(long required,
			List<String> keys) throws BtcException;

	public String createRawTransaction(List<Object> transactionIds,
			List<Object> addresses) throws BtcException;

	public BtcRawTransaction decodeRawTransaction(String hex)
			throws BtcException;

	public String dumpPrivateKey(String address) throws BtcException;

	public String getAccount(String address) throws BtcException;

	public String getAccountAddress(String account) throws BtcException;

	public List<BtcAddedNode> getAddedNodeInformation(boolean dns, String node)
			throws BtcException;

	public List<String> getAddressesByAccount(String account)
			throws BtcException;

	public BigDecimal getBalance(String account, long minConfirms)
			throws BtcException;

	public BtcBlock getBlock(String hash) throws BtcException;

	public long getBlockCount() throws BtcException;

	public String getBlockHash(long index) throws BtcException;

	public BtcBlockTemplate getBlockTemplate(List<String> capabilities, BtcBlockTemplate.Mode mode) throws BtcException;

	public long getConnectionCount() throws BtcException;

	public BigDecimal getDifficulty() throws BtcException;

	public boolean getGenerate() throws BtcException;

	public long getHashesPerSecond() throws BtcException;

	public BtcInfo getInformation() throws BtcException;

	public BtcMiningInfo getMiningInformation() throws BtcException;

	public String getNewAddress(String account) throws BtcException;

	public List<BtcPeer> getPeerInformation() throws BtcException;

	public List<String> getRawMemoryPool() throws BtcException;

	public BtcRawTransaction getRawTransaction(String transactionId,
			boolean verbose) throws BtcException;

	public BigDecimal getReceivedByAccount(String account, long minConfirms)
			throws BtcException;

	public BigDecimal getReceivedByAddress(String address, long minConfirms)
			throws BtcException;

	public BtcTransaction getTransaction(String transactionId)
			throws BtcException;

	public String getTransactionOutput(String transactionId, long index,
			boolean includeMemoryPool) throws BtcException;

	public BtcTransactionOutputSet getTransactionOutputSetInformation()
			throws BtcException;

	public BtcWork getWork(String data) throws BtcException;

	public String help(String command) throws BtcException;

	public String importPrivateKey(String privateKey, String label,
			boolean rescan) throws BtcException;

	public void keyPoolRefill() throws BtcException;

	public Map<String, BtcAccount> listAccounts(long minConfirms) throws BtcException;

	public List<BtcAddress> listAddressGroupings() throws BtcException;

	public List<String> listLockUnspent() throws BtcException;

	public List<BtcAccount> listReceivedByAccount(long minConfirms,
			boolean includeEmpty) throws BtcException;

	public List<BtcAddress> listReceivedByAddress(long minConfirms,
			boolean includeEmpty) throws BtcException;

	public BtcLastBlock listSinceBlock(String blockHash, long targetConfirms)
			throws BtcException;

	public List<BtcTransaction> listTransactions(String account, long count,
			long from) throws BtcException;

	public List<String> listUnspent(long minConfirms, long maxConfirms)
			throws BtcException;

	public void lockUnspent(boolean unlock, List<Object> outputs)
			throws BtcException;

	public boolean move(String fromAccount, String toAccount, BigDecimal amount,
			long minConfirms, String comment) throws BtcException;

	public String sendFrom(String account, String address,
			BigDecimal amount, long minConfirms, String comment,
			String commentTo) throws BtcException;

	public String sendMany(String account, Map<String, BigDecimal> amounts,
			long minConfirms, String comment)
			throws BtcException;

	public void sendRawTransaction(String transactionId) throws BtcException;

	public String sendToAddress(String address, BigDecimal amount,
			String comment, String commentTo) throws BtcException;

	public void setAccount(String address, String account) throws BtcException;

	public void setGenerate(boolean generate, long generateProcessorsLimit)
			throws BtcException;

	public boolean setTransactionFee(BigDecimal amount) throws BtcException;

	public String signMessage(String address, String message) throws BtcException;

	public void signRawTransaction(String transactionId,
			List<Object> signatures, List<String> keys) throws BtcException;

	public String stop() throws BtcException;

	public void submitBlock(String data, List<Object> params)
			throws BtcException;

	public BtcAddress validateAddress(String address) throws BtcException;

	public boolean verifyMessage(String address, String signature, String message)
			throws BtcException;
	
	public void walletLock() throws BtcException;
	
	public void walletPassphrase(String passphrase, long timeout) throws BtcException;
	
	public void walletPassphraseChange(String passphrase, String newPassphrase) throws BtcException;
}
