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

public class BtcWork implements Serializable{
	private static final long serialVersionUID = 5010576309297492760L;
	private String midState = "";
	private String data = "";
	private String hash = "";
	private String target = "";
	private boolean success = false;
	
	public String getMidState() {
		return midState;
	}
	
	public void setMidState(String midState) {
		this.midState = BtcUtil.notNull(midState);
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = BtcUtil.notNull(data);
	}
	
	public String getHash() {
		return hash;
	}
	
	public void setHash(String hash) {
		this.hash = BtcUtil.notNull(hash);
	}
	
	public String getTarget() {
		return target;
	}
	
	public void setTarget(String target) {
		this.target = BtcUtil.notNull(target);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcWork [midState=");
		builder.append(midState);
		builder.append(", data=");
		builder.append(data);
		builder.append(", hash=");
		builder.append(hash);
		builder.append(", target=");
		builder.append(target);
		builder.append(", success=");
		builder.append(success);
		builder.append("]");
		return builder.toString();
	}
}
