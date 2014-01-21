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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BtcUtil {
	
	public static long atLeast(long value, long least) {
		return (value < least) ? least : value;
	}

	public static BigDecimal atLeast(BigDecimal value, double least) {
		BigDecimal floor = BigDecimal.valueOf(least);
		return (value == null) ? floor : ((value.compareTo(floor) < 0) ? floor : value);
	}

	public static long bool(boolean value) {
		return value ? 1 : 0;
	}
	
	public static String nil(String value) {
		return (value == null) ? null : ((value.length() > 0) ? value : null);
	}

	public static BigDecimal notNull(BigDecimal value) {
		return (value == null) ? BigDecimal.ZERO : value;
	}

	public static BtcAccount notNull(BtcAccount value) {
		return (value == null) ? new BtcAccount() : value;
	}

	public static BtcScript notNull(BtcScript value) {
		return (value == null) ? new BtcScript() : value;
	}

	public static BtcScript.Type notNull(BtcScript.Type value) {
		return (value == null) ? BtcScript.Type.NULL : value;
	}

	public static BtcTransaction.Category notNull(BtcTransaction.Category value) {
		return (value == null) ? BtcTransaction.Category.NULL : value;
	}

	public static <T> List<T> notNull(List<T> value) {
		return (value == null) ? new ArrayList<T>() : value;
	}

	public static String notNull(String value) {
		return (value == null) ? "" : value;
	}
}
