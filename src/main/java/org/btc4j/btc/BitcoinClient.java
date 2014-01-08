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

public class BitcoinClient implements BitcoinApi {

	@Override
	public void addMultiSignatureAddress(int required, List<String> keys,
			String account) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void addNode(String node, BitcoinNodeOperationEnum operation)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void backupWallet(File destination) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String createMultiSignatureAddress(int required, List<String> keys)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String createRawTransaction(List<Object> transactionIds,
			List<Object> addresses) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String decodeRawTransaction(String transactionId)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String dumpPrivateKey(String address) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void encryptWallet(String passPhrase) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getAccount(String address) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getAccountAddress(String account) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getAddedNodeInformation(boolean dns, String node)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> getAddressesByAccount(String account)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public double getBalance(String account, int minConfirms)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public BitcoinBlock getBlock(String hash) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public int getBlockCount() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getBlockHash(int index) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getBlockTemplate(String params) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);

	}

	@Override
	public int getConnectionCount() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public double getDifficulty() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public boolean getGenerate() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public int getHashesPerSecond() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public BitcoinStatusInfo getInformation() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public BitcoinMining getMiningInformation() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getNewAddress(String account) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<BitcoinPeer> getPeerInformation() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> getRawMemoryPool() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getRawTransaction(String transactionId, boolean verbose)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public double getReceivedByAccount(String account, int minConfirms)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public double getReceivedByAddress(String address, int minConfirms)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getTransaction(String transactionId) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getTransactionOutput(String transactionId, int n,
			boolean includeMemoryPool) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public BitcoinTransactionOutputSet getTransactionOutputSetInformation()
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String getWork(String data) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	public String help() throws BitcoinException {
		return help("");
	}

	public String help(String command) throws BitcoinException {
		return "Bitcoin Client not yet implemented";
	}

	@Override
	public String importPrivateKey(String privateKey, String label,
			boolean rescan) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void keyPoolRefill() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public Map<String, BitcoinAccount> listAccounts(int minConfirms)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> listAddressGroupings() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> listLockUnspent() throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> listReceivedByAccount(int minConfirms,
			boolean includeEmpty) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> listReceivedByAddress(int minConfirms,
			boolean includeEmpty) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> listSinceBlock(String blockHash, int targetConfirms)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> listTransactions(String account, int count, int from)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public List<String> listUnspent(int minConfirms, int maxConfirms)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void lockUnspent(boolean unlock, List<Object> outputs)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void move(String fromAccount, String toAccount, double amount,
			int minConfirms, String comment) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String sendFrom(String fromAccount, String toAddress, double amount,
			int minConfirms, String commentFrom, String commentTo)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String sendMany(String fromAccount, List<Object> addresses,
			int minConfirms, String commentFrom, String commentTo)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void sendRawTransaction(String transactionId)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String sendToAddress(String toAddress, double amount,
			String commentFrom, String commentTo) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void setAccount(String address, String account)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void setGenerate(boolean generate, int generateProcessorsLimit)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public boolean setTransactionFee(double amount) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void signMessage(String address, String message)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public void signRawTransaction(String transactionId,
			List<Object> signatures, List<String> keys) throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	public String stop() throws BitcoinException {
		return "Stopping Bitcoin Client";
	}

	@Override
	public void submitBlock(String data, List<Object> params)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public BitcoinAddress validateAddress(String address)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}

	@Override
	public String verifyMessage(String address, String signature, String message)
			throws BitcoinException {
		throw new BitcoinException(BitcoinConstant.BTC4J_ERROR_CODE,
				BitcoinConstant.BTC4J_ERROR_MESSAGE + ": "
						+ BitcoinConstant.BTC4J_ERROR_DATA_NOT_IMPLEMENTED);
	}
}