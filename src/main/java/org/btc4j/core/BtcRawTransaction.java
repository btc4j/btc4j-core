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

import java.util.ArrayList;
import java.util.List;

public class BtcRawTransaction extends BtcTransactionBase {
	private static final long serialVersionUID = 6599053559390310432L;
	private String hex = "";
	private long version = 0;
	private long lockTime = 0;
	private List<BtcInput> inputs = new ArrayList<BtcInput>();
	private List<BtcOutput> outputs = new ArrayList<BtcOutput>();

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = BtcUtil.notNull(hex);
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public long getLockTime() {
		return lockTime;
	}

	public void setLockTime(long lockTime) {
		this.lockTime = lockTime;
	}

	public List<BtcInput> getInputs() {
		return inputs;
	}

	public void setInputs(List<BtcInput> inputs) {
		this.inputs = BtcUtil.notNull(inputs);
	}

	public List<BtcOutput> getOutputs() {
		return outputs;
	}

	public void setOutputs(
			List<BtcOutput> outputs) {
		this.outputs = BtcUtil.notNull(outputs);
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
		builder.append(", inputs=");
		builder.append(inputs);
		builder.append(", outputs=");
		builder.append(outputs);
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