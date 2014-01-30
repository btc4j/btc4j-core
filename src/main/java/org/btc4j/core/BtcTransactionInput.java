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

import java.io.Serializable;

public class BtcTransactionInput implements Serializable {
	private static final long serialVersionUID = 8501404760721594831L;
	private String transaction = "";
	private long output = 0;
	private BtcScript script = new BtcScript();
	private long sequence = 0;

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = BtcUtil.notNull(transaction);
	}

	public long getOutput() {
		return output;
	}

	public void setOutput(long output) {
		this.output = output;
	}

	public BtcScript getScript() {
		return script;
	}

	public void setScript(BtcScript script) {
		this.script = BtcUtil.notNull(script);
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcTransactionInput [transaction=");
		builder.append(transaction);
		builder.append(", output=");
		builder.append(output);
		builder.append(", script=");
		builder.append(script);
		builder.append(", sequence=");
		builder.append(sequence);
		builder.append("]");
		return builder.toString();
	}
}