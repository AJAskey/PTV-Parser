/**
 *
 * @author Andy Askey
 *
 *         PTV-Parser Copyright (c) 2015, Andy Askey All rights reserved.
 *
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 *
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software.
 *
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */

package net.ajaskey.market.ta.methods;

import net.ajaskey.market.ta.TickerData;

/**
 * @author Andy Askey
 *
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 *
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software.
 *
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */
public class Methods {

	/**
	 * This method serves as a constructor for the class. Because all methods are
	 * static this constructor is not to be called.
	 *
	 */
	private Methods() {
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.checkParams
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @param method
	 * @return
	 */
	static public boolean checkParams(double[] val, int days, int start, String method) {

		boolean status = true;
		if (val == null) {
			System.out.printf("Warning - array is null in \"%s\"%n", method);
			status = false;
		} else if ((days < 1) || (days > val.length)) {
			System.out.printf("Warning - Invalid days \"%d\" with total days \"%d\"in \"%s\"%n", days, val.length, method);
			status = false;
		} else if ((start < 0) || (start > val.length)) {
			System.out.printf("Warning - Invalid start \"%d\" with total days \"%d\" in \"%s\"%n", start, val.length, method);
			status = false;
		}
		return status;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.checkParams
	 *
	 * @param td
	 * @param days
	 * @param start
	 * @param method
	 * @return
	 */
	static public boolean checkParams(TickerData td, int days, int start, String method) {

		boolean status = true;
		if ((td == null) || (td.getCloseData() == null)) {
			System.out.printf("Warning - array is null in \"%s\"%n", method);
			status = false;
		} else if ((days < 1) || (days > td.getDaysOfData())) {
			System.out.printf("Warning - Invalid days \"%d\" with total days \"%d\" in \"%s\"%n", days, td.getDaysOfData(),
			    method);
			status = false;
		} else if ((start < 0) || (start > td.getDaysOfData())) {
			System.out.printf("Warning - Invalid start \"%d\" with total days \"%d\" in \"%s\"%n", start, td.getDaysOfData(),
			    method);
			status = false;
		}
		return status;
	}

}
