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

public class BtcAddedNode implements Serializable {
	private static final long serialVersionUID = 4376507327713059735L;
	private String addedNode = "";
	private boolean connected = false;
	private List<BtcNode> addresses = new ArrayList<BtcNode>();

	public String getAddedNode() {
		return addedNode;
	}

	public void setAddedNode(String addedNode) {
		this.addedNode = BtcUtil.notNull(addedNode);
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public List<BtcNode> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<BtcNode> addresses) {
		this.addresses = BtcUtil.notNull(addresses);
	}
}