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

public class BitcoinConstant {
	// BTCAPI
	public static final String BTCAPI_ACCOUNT = "getaccount";
	public static final String BTCAPI_ACCOUNT_ADDRESS = "getaccountaddress";
	public static final String BTCAPI_ACCOUNT_ADDRESSES = "getaddressesbyaccount";
	public static final String BTCAPI_ACCOUNT_BALANCE = "getbalance";
	public static final String BTCAPI_ACCOUNT_NEW_ADDRESS = "getnewaddress";
	public static final String BTCAPI_ACCOUNT_RECEIVED = "getreceivedbyaccount";
	public static final String BTCAPI_ACCOUNT_RECEIVED_ADDRESS = "getreceivedbyaddress";
	public static final String BTCAPI_ACCOUNT_LIST = "listaccounts";

	public static final String BTCAPI_BLOCK = "getblock";
	public static final String BTCAPI_BLOCK_COUNT = "getblockcount";
	public static final String BTCAPI_BLOCK_HASH = "getblockhash";

	public static final String BTCAPI_NODE_CONNECTION_COUNT = "getconnectioncount";

	public static final String BTCAPI_INFO = "getinfo";
	public static final String BTCAPI_INFO_DIFFICULTY = "getdifficulty";
	public static final String BTCAPI_INFO_GENERATE = "getgenerate";
	public static final String BTCAPI_INFO_HASHESPERSEC = "gethashespersec";
	public static final String BTCAPI_INFO_MINING = "getmininginfo";
	public static final String BTCAPI_INFO_PEER = "getpeerinfo";
	public static final String BTCAPI_INFO_RAW_MEM_POOL = "getrawmempool";
	public static final String BTCAPI_INFO_TX_OUTPUT_SET = "gettxoutsetinfo";

	public static final String BTCAPI_STATUS_HELP = "help";
	public static final String BTCAPI_STATUS_STOP = "stop";

	public static final String BTCAPI_WALLET_TX = "gettransaction";

	// BTCOBJ
	public static final String BTCOBJ_BLOCK_HASH = "hash";
	public static final String BTCOBJ_BLOCK_CONFIRMATIONS = "confirmations";
	public static final String BTCOBJ_BLOCK_SIZE = "size";
	public static final String BTCOBJ_BLOCK_HEIGHT = "height";
	public static final String BTCOBJ_BLOCK_VERSION = "version";
	public static final String BTCOBJ_BLOCK_MERKLE_ROOT = "merkleroot";
	public static final String BTCOBJ_BLOCK_TX = "tx";
	public static final String BTCOBJ_BLOCK_TIME = "time";
	public static final String BTCOBJ_BLOCK_NONCE = "nonce";
	public static final String BTCOBJ_BLOCK_BITS = "bits";
	public static final String BTCOBJ_BLOCK_DIFFICULTY = "difficulty";
	public static final String BTCOBJ_BLOCK_PREV_HASH = "previousblockhash";
	public static final String BTCOBJ_BLOCK_NEXT_HASH = "nextblockhash";

	public static final String BTCOBJ_INFO_VERSION = "version";
	public static final String BTCOBJ_INFO_PROTO_VERSION = "protocolversion";
	public static final String BTCOBJ_INFO_WALLET_VERSION = "walletversion";
	public static final String BTCOBJ_INFO_BALANCE = "balance";
	public static final String BTCOBJ_INFO_BLOCKS = "blocks";
	public static final String BTCOBJ_INFO_TIME_OFFSET = "timeoffset";
	public static final String BTCOBJ_INFO_CONNECTIONS = "connections";
	public static final String BTCOBJ_INFO_PROXY = "proxy";
	public static final String BTCOBJ_INFO_DIFFICULTY = "difficulty";
	public static final String BTCOBJ_INFO_TESTNET = "testnet";
	public static final String BTCOBJ_INFO_KEYPOOL_OLDEST = "keypoololdest";
	public static final String BTCOBJ_INFO_KEYPOOL_SIZE = "keypoolsize";
	public static final String BTCOBJ_INFO_TX_FEE = "paytxfee";
	public static final String BTCOBJ_INFO_ERRORS = "errors";
	public static final String BTCOBJ_INFO_CURRENT_BLOCK_SIZE = "currentblocksize";
	public static final String BTCOBJ_INFO_CURRENT_BLOCK_TX = "currentblocktx";
	public static final String BTCOBJ_INFO_GENERATE = "generate";
	public static final String BTCOBJ_INFO_PROC_LIMIT = "genproclimit";
	public static final String BTCOBJ_INFO_HASHESPERSEC = "hashespersec";
	public static final String BTCOBJ_INFO_POOLED_TX = "pooledtx";

	public static final String BTCOBJ_PEER_ADDRESS = "addr";
	public static final String BTCOBJ_PEER_SERVICES = "services";
	public static final String BTCOBJ_PEER_LAST_SEND = "lastsend";
	public static final String BTCOBJ_PEER_LAST_RECEIVED = "lastrecv";
	public static final String BTCOBJ_PEER_BYTES_SENT = "bytessent";
	public static final String BTCOBJ_PEER_BYTES_RECEIVED = "bytesrecv";
	public static final String BTCOBJ_PEER_CONNECTION_TIME = "conntime";
	public static final String BTCOBJ_PEER_VERSION = "version";
	public static final String BTCOBJ_PEER_SUBVERSION = "subver";
	public static final String BTCOBJ_PEER_INBOUND = "inbound";
	public static final String BTCOBJ_PEER_START_HEIGHT = "startingheight";
	public static final String BTCOBJ_PEER_BAN_SCORE = "banscore";
	public static final String BTCOBJ_PEER_SYNC_NODE = "syncnode";

	public static final String BTCOBJ_TXOUTSET_HEIGHT = "height";
	public static final String BTCOBJ_TXOUTSET_BEST_BLOCK = "bestblock";
	public static final String BTCOBJ_TXOUTSET_TRANSACTIONS = "transactions";
	public static final String BTCOBJ_TXOUTSET_TX_OUTS = "txouts";
	public static final String BTCOBJ_TXOUTSET_BYTES_SERIALIZED = "bytes_serialized";
	public static final String BTCOBJ_TXOUTSET_HASH_SERIALIZED = "hash_serialized";
	public static final String BTCOBJ_TXOUTSET_TOTAL_AMOUT = "total_amount";

	// JSONRPC
	public static final String JSONRPC = "jsonrpc";
	public static final String JSONRPC_VERSION = "2.0";
	public static final String JSONRPC_ID = "id";
	public static final String JSONRPC_METHOD = "method";
	public static final String JSONRPC_PARAMS = "params";
	public static final String JSONRPC_RESULT = "result";
	public static final String JSONRPC_ERROR = "error";
	public static final String JSONRPC_CODE = "code";
	public static final String JSONRPC_MESSAGE = "message";
	public static final String JSONRPC_DATA = "data";

	// BTC4J
	public static final String BTC4J_HTTP_HEADER = "Content-Type";
	public static final String BTC4J_JSONRPC_CONTENT_TYPE = "application/json-rpc";
	public static final String BTC4J_JSON_CONTENT_TYPE = "application/json";
	public static final String BTC4J_ERROR_MESSAGE = "Server error";
	public static final String BTC4J_ERROR_DATA_NULL_URL = "Server URL is null";
	public static final String BTC4J_ERROR_DATA_NULL_RESPONSE = "Response is empty";
	public static final String BTC4J_ERROR_DATA_INVALID_ID = "Response id does not match request id";
	public static final String BTC4J_ERROR_DATA_NOT_IMPLEMENTED = "Bitcoin command not yet implemented";
	public static final String[] BTC4J_VERSIONS = { "0.8.6" };
	public static final int BTC4J_ERROR_CODE = -32077;
}
