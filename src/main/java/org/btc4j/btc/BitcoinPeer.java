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

import java.io.Serializable;
import javax.json.JsonObject;

public class BitcoinPeer implements Serializable {
	private static final long serialVersionUID = -300084370265716627L;
	// {"addr":"141.138.205.129:18333",
	// "services":"00000000",
	// "lastsend":1389106435,
	// "lastrecv":0,
	// "bytessent":124,
	// "bytesrecv":0,
	// "conntime":1389106435,
	// "version":0,
	// "subver":"",
	// "inbound":false,
	// "startingheight":-1,"banscore":0}],"error":null,"id":"272919ff-4133-4b7b-8b55-370df8858884"}
	private String address;
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

	public static BitcoinPeer fromJson(JsonObject value)
			throws BitcoinException {
		BitcoinPeer peer = new BitcoinPeer();
		peer.setAddress(value
				.getString(BitcoinConstant.BTCOBJ_PEER_ADDRESS, ""));
		peer.setServices(value.getString(BitcoinConstant.BTCOBJ_PEER_SERVICES,
				""));
		peer.setLastSend(value.getInt(BitcoinConstant.BTCOBJ_PEER_LAST_SEND, 0));
		peer.setLastReceived(value.getInt(
				BitcoinConstant.BTCOBJ_PEER_LAST_RECEIVED, 0));
		peer.setBytesSent(value.getInt(BitcoinConstant.BTCOBJ_PEER_BYTES_SENT,
				0));
		peer.setBytesReceived(value.getInt(
				BitcoinConstant.BTCOBJ_PEER_BYTES_RECEIVED, 0));
		peer.setConnectionTime(value.getInt(
				BitcoinConstant.BTCOBJ_PEER_CONNECTION_TIME, 0));
		peer.setVersion(value.getInt(BitcoinConstant.BTCOBJ_PEER_VERSION, 0));
		peer.setSubVersion(value.getString(
				BitcoinConstant.BTCOBJ_PEER_SUBVERSION, ""));
		peer.setInbound(value.getBoolean(BitcoinConstant.BTCOBJ_PEER_INBOUND,
				false));
		peer.setStartingHeight(value.getInt(
				BitcoinConstant.BTCOBJ_PEER_START_HEIGHT, 0));
		peer.setBanScore(value.getInt(BitcoinConstant.BTCOBJ_PEER_BAN_SCORE, 0));
		peer.setSyncNode(value.getBoolean(
				BitcoinConstant.BTCOBJ_PEER_SYNC_NODE, false));
		return peer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
