package org.btc4j.api;

/*
 Copyright (c) 2013 btc4j.org

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

public interface BitcoinNodeService {
	// addnode
	// <node> <add/remove/onetry>
	// version 0.8 Attempts add or remove <node> from the addnode list or try a
	// connection to <node> once.
	// N
	// public void addNode() throws BitcoinException;

	// getaddednodeinfo
	// <dns> [node]
	// version 0.8 Returns information about the given added node, or all added
	// nodes (note that onetry addnodes are not listed here) If dns is false,
	// only a list of added nodes will be provided, otherwise connected
	// information will also be available.
	//
	// public void getAddedNodeInfo() throws BitcoinException;

	// getpeerinfo version 0.7 Returns data about each connected node. N

	// getconnectioncount Returns the number of connections to other nodes. N
}
