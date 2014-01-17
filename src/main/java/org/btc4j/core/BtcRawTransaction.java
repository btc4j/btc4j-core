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

import java.util.List;

public class BtcRawTransaction extends BtcTransactionBase {
	private static final long serialVersionUID = 6599053559390310432L;
	private String hex;
	private int version;
	private int lockTime;
	private List<BtcVIn> vIn;
	private List<BtcVOut> vOut;
	
	// "hex":"010000000110f7af4e331b02cb2d0300bc879c65803274969da9aa305bade614058b32152d010000006b4830450220744d68a227a390e170e0f7d23ecb41ef883d6b1059d0e8b04cd6b00db2b0fd12022100d61a88715e6f0b192c4d09b8a302e93c7eb202c4346386d918a0668caa57df6c012102d94d41c62b1d0cd455772bcca8be0ffbbcee3c7bc87e6ee79689715137b96abeffffffff0240787d01000000001976a914ca8ac94e5f147ed553a0d8e6497e0bfa7e53a92588ac00e1f505000000001976a9149006180537784880b99fc57efdf25eee152cdd4588ac00000000",
	// "txid":"98dafef582ae53e8af30e8ad09577bbd472d4bf24a173121d58a5900747fd082",
	// "version":1,
	// "locktime":0,
	// "vin":[{
			// "txid":"2d15328b0514e6ad5b30aaa99d96743280659c87bc00032dcb021b334eaff710",
			// "vout":1,
			// "scriptSig":{
						// "asm":"30450220744d68a227a390e170e0f7d23ecb41ef883d6b1059d0e8b04cd6b00db2b0fd12022100d61a88715e6f0b192c4d09b8a302e93c7eb202c4346386d918a0668caa57df6c01 02d94d41c62b1d0cd455772bcca8be0ffbbcee3c7bc87e6ee79689715137b96abe",
						// "hex":"4830450220744d68a227a390e170e0f7d23ecb41ef883d6b1059d0e8b04cd6b00db2b0fd12022100d61a88715e6f0b192c4d09b8a302e93c7eb202c4346386d918a0668caa57df6c012102d94d41c62b1d0cd455772bcca8be0ffbbcee3c7bc87e6ee79689715137b96abe"
			// },
			// "sequence":4294967295
	// }],
	// "vout":[{
			// "value":0.25000000,
			// "n":0,
			// "scriptPubKey":{
						// "asm":"OP_DUP OP_HASH160 ca8ac94e5f147ed553a0d8e6497e0bfa7e53a925 OP_EQUALVERIFY OP_CHECKSIG",
						// "hex":"76a914ca8ac94e5f147ed553a0d8e6497e0bfa7e53a92588ac",
						// "reqSigs":1,
						// "type":"pubkeyhash",
						// "addresses":["myyu3rApeR3JHsvXQxjT3vAyNyVx9gm9UY"]
			// }
	// }, {
			// "value":1.00000000,
			// "n":1,
			// "scriptPubKey":{
						// "asm":"OP_DUP OP_HASH160 9006180537784880b99fc57efdf25eee152cdd45 OP_EQUALVERIFY OP_CHECKSIG",
						// "hex":"76a9149006180537784880b99fc57efdf25eee152cdd4588ac",
						// "reqSigs":1,
						// "type":"pubkeyhash",
						// "addresses":["mteUu5qrZJAjybLJwVQpxxmpnyGFUhPYQD"]
			// }
	// }],
	// "blockhash":"00000000cbe0e6c57353cdfb595ed2f7f920f5a311a29e7451398de24583ee4a",
	// "confirmations":4373,
	// "time":1389305876,
	// "blocktime":1389305876}
	
	public String getHex() {
		return hex;
	}
	
	public void setHex(String hex) {
		this.hex = hex;
	}
	
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public int getLockTime() {
		return lockTime;
	}
	
	public void setLockTime(int lockTime) {
		this.lockTime = lockTime;
	}
	
	public List<BtcVIn> getvIn() {
		return vIn;
	}
	
	public void setvIn(List<BtcVIn> vIn) {
		this.vIn = vIn;
	}
	
	public List<BtcVOut> getvOut() {
		return vOut;
	}
	
	public void setvOut(List<BtcVOut> vOut) {
		this.vOut = vOut;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcRawTransaction [hex=");
		builder.append(hex);
		builder.append(", version=");
		builder.append(version);
		builder.append(", lockTime=");
		builder.append(lockTime);
		builder.append(", vIn=");
		builder.append(vIn);
		builder.append(", vOut=");
		builder.append(vOut);
		builder.append(", getTransaction()=");
		builder.append(getTransaction());
		builder.append(", getConfirmations()=");
		builder.append(getConfirmations());
		builder.append(", getTime()=");
		builder.append(getTime());
		builder.append(", getBlockHash()=");
		builder.append(getBlockHash());
		builder.append(", getBlockTime()=");
		builder.append(getBlockTime());
		builder.append("]");
		return builder.toString();
	}
}