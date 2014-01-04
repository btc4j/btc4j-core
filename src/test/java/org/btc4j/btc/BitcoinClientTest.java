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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.btc4j.btc.BitcoinClient;
import org.btc4j.btc.BitcoinException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BitcoinClientTest {
	private static BitcoinClient BITCOINC;

	@BeforeClass
	public static void testSetup() throws Exception {
		BITCOINC = new BitcoinClient();
	}

	@AfterClass
	public static void testCleanup() throws Exception {
		String stop = BITCOINC.stop();
		assertNotNull(stop);
		assertTrue(stop.length() >= 0);
	}

	@Test
	public void help() throws BitcoinException {
		String help = BITCOINC.help();
		assertNotNull(help);
		assertTrue(help.length() >= 0);
		help = BITCOINC.help("fakecommand");
		assertNotNull(help);
		assertTrue(help.length() >= 0);
		help = BITCOINC.help("getrawtransaction");
		assertNotNull(help);
		assertTrue(help.length() >= 0);
	}
}
