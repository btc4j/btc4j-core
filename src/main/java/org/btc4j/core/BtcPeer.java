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

public class BtcPeer implements Serializable {
	private static final long serialVersionUID = -300084370265716627L;
	private String networkAddress = "";
	private String services = "";
	private long lastSend = 0;
	private long lastReceived = 0;
	private long bytesSent = 0;
	private long bytesReceived = 0;
	private long connectionTime = 0;
	private long version = 0;
	private String subVersion = "";
	private boolean inbound = false;
	private long startingHeight = 0;
	private long banScore = 0;
	private boolean syncNode = false;

	public String getNetworkAddress() {
		return networkAddress;
	}

	public void setNetworkAddress(String networkAddress) {
		this.networkAddress = BtcUtil.notNull(networkAddress);
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = BtcUtil.notNull(services);
	}

	public long getLastSend() {
		return lastSend;
	}

	public void setLastSend(long lastSend) {
		this.lastSend = lastSend;
	}

	public long getLastReceived() {
		return lastReceived;
	}

	public void setLastReceived(long lastReceived) {
		this.lastReceived = lastReceived;
	}

	public long getBytesSent() {
		return bytesSent;
	}

	public void setBytesSent(long bytesSent) {
		this.bytesSent = bytesSent;
	}

	public long getBytesReceived() {
		return bytesReceived;
	}

	public void setBytesReceived(long bytesReceived) {
		this.bytesReceived = bytesReceived;
	}

	public long getConnectionTime() {
		return connectionTime;
	}

	public void setConnectionTime(long connectionTime) {
		this.connectionTime = connectionTime;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getSubVersion() {
		return subVersion;
	}

	public void setSubVersion(String subVersion) {
		this.subVersion = BtcUtil.notNull(subVersion);
	}

	public boolean isInbound() {
		return inbound;
	}

	public void setInbound(boolean inbound) {
		this.inbound = inbound;
	}

	public long getStartingHeight() {
		return startingHeight;
	}

	public void setStartingHeight(long startingHeight) {
		this.startingHeight = startingHeight;
	}

	public long getBanScore() {
		return banScore;
	}

	public void setBanScore(long banScore) {
		this.banScore = banScore;
	}

	public boolean isSyncNode() {
		return syncNode;
	}

	public void setSyncNode(boolean syncNode) {
		this.syncNode = syncNode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!(obj instanceof BtcPeer))
			return false;
		BtcPeer other = (BtcPeer) obj;
		if (networkAddress == null) {
			if (other.networkAddress != null)
				return false;
		} else if (!networkAddress.equals(other.networkAddress))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BtcPeer [networkAddress=");
		builder.append(networkAddress);
		builder.append(", services=");
		builder.append(services);
		builder.append(", lastSend=");
		builder.append(lastSend);
		builder.append(", lastReceived=");
		builder.append(lastReceived);
		builder.append(", bytesSent=");
		builder.append(bytesSent);
		builder.append(", bytesReceived=");
		builder.append(bytesReceived);
		builder.append(", connectionTime=");
		builder.append(connectionTime);
		builder.append(", version=");
		builder.append(version);
		builder.append(", subVersion=");
		builder.append(subVersion);
		builder.append(", inbound=");
		builder.append(inbound);
		builder.append(", startingHeight=");
		builder.append(startingHeight);
		builder.append(", banScore=");
		builder.append(banScore);
		builder.append(", syncNode=");
		builder.append(syncNode);
		builder.append("]");
		return builder.toString();
	}
}
