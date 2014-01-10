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

public class BtcPeer implements Serializable {
	private static final long serialVersionUID = -300084370265716627L;
	private String networkAddress;
	private String services;
	private int lastSend;
	private int lastReceived;
	private int bytesSent;
	private int bytesReceived;
	private int connectionTime;
	private int version;
	private String subVersion;
	private boolean inbound;
	private int startingHeight;
	private int banScore;
	private boolean syncNode;

	public String getNetworkAddress() {
		return networkAddress;
	}

	public void setNetworkAddress(String networkAddress) {
		this.networkAddress = networkAddress;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public int getLastSend() {
		return lastSend;
	}

	public void setLastSend(int lastSend) {
		this.lastSend = lastSend;
	}

	public int getLastReceived() {
		return lastReceived;
	}

	public void setLastReceived(int lastReceived) {
		this.lastReceived = lastReceived;
	}

	public int getBytesSent() {
		return bytesSent;
	}

	public void setBytesSent(int bytesSent) {
		this.bytesSent = bytesSent;
	}

	public int getBytesReceived() {
		return bytesReceived;
	}

	public void setBytesReceived(int bytesReceived) {
		this.bytesReceived = bytesReceived;
	}

	public int getConnectionTime() {
		return connectionTime;
	}

	public void setConnectionTime(int connectionTime) {
		this.connectionTime = connectionTime;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getSubVersion() {
		return subVersion;
	}

	public void setSubVersion(String subVersion) {
		this.subVersion = subVersion;
	}

	public boolean isInbound() {
		return inbound;
	}

	public void setInbound(boolean inbound) {
		this.inbound = inbound;
	}

	public int getStartingHeight() {
		return startingHeight;
	}

	public void setStartingHeight(int startingHeight) {
		this.startingHeight = startingHeight;
	}

	public int getBanScore() {
		return banScore;
	}

	public void setBanScore(int banScore) {
		this.banScore = banScore;
	}

	public boolean isSyncNode() {
		return syncNode;
	}

	public void setSyncNode(boolean syncNode) {
		this.syncNode = syncNode;
	}
}
