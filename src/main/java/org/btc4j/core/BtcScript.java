/*
 The MIT License (MIT)
 
 Copyright (c) 2013, 2014 by ggbusto

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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BtcScript implements Serializable {
	private static final long serialVersionUID = -6396033986415109507L;
	private String asm = "";
	private String publicKey = "";
	private long requiredSignatures = 0;
	private Type type = Type.NULL;
	private List<String> addresses = new ArrayList<String>();

	public enum Type {
		PUBKEYHASH, NULL;

		public static Type getValue(String value) {
			try {
				return Type.valueOf(value.toUpperCase());
			} catch (Throwable t) {
				return NULL;
			}
		}
	}

	public String getAsm() {
		return asm;
	}

	public void setAsm(String asm) {
		this.asm = BtcUtil.notNull(asm);
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public long getRequiredSignatures() {
		return requiredSignatures;
	}

	public void setRequiredSignatures(long requiredSignatures) {
		this.requiredSignatures = requiredSignatures;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = BtcUtil.notNull(type);
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = BtcUtil.notNull(addresses);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcScript [asm=");
		builder.append(asm);
		builder.append(", publicKey=");
		builder.append(publicKey);
		builder.append(", requiredSignatures=");
		builder.append(requiredSignatures);
		builder.append(", type=");
		builder.append(type);
		builder.append(", addresses=");
		builder.append(addresses);
		builder.append("]");
		return builder.toString();
	}
}