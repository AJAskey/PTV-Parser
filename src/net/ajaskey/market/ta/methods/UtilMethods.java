
package net.ajaskey.market.ta.methods;

/**
 *
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
public class UtilMethods {

	/**
	 * This method serves as a constructor for the class. Because all methods are
	 * static this constructor is not to be called.
	 *
	 */
	private UtilMethods() {
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.avgRng
	 *
	 * @param high
	 * @param low
	 * @param days
	 * @return
	 */
	static public double avgRng(double[] high, double[] low, int days) {
		double retVal = 0.0;
		if ((high != null) && (low != null)) {
			if (days <= high.length) {
				for (int i = 0; i < days; i++) {
					retVal += (high[i] - low[i]);
				}
			}
		}
		return retVal / days;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.avgRngPercent
	 *
	 * @param high
	 * @param low
	 * @param days
	 * @return
	 */
	static public double avgRngPercent(double[] high, double[] low, int days) {
		final double ma = UtilMethods.rngMA(high, low, days);
		double retVal = 0.0;
		if (ma > 0.0) {
			retVal = (UtilMethods.avgRng(high, low, days) / ma) * 100.0;
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.getDataSlice
	 *
	 * @param val
	 * @param start
	 * @param days
	 * @return
	 */
	static public double[] getDataSlice(double[] val, int start, int days) {
		double[] ret = null;
		if (val != null) {
			if ((start + days) <= val.length) {
				ret = new double[days];
				int j = 0;
				for (int i = start; i < (start + days); i++) {
					ret[j++] = val[i];
				}
			}
		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.rngMA
	 *
	 * @param high
	 * @param low
	 * @param days
	 * @return
	 */
	static public double rngMA(double[] high, double[] low, int days) {
		double ma = 0.0;
		if ((high != null) && (low != null)) {
			if (days <= high.length) {
				for (int i = 0; i < days; i++) {
					ma += (high[i] + low[i]) / 2.0;
				}
			}
		}
		return ma;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sum
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double sum(double[] val, int days) {
		double retVal = 0.0;
		if (val != null) {
			if (days <= val.length) {
				for (int i = 0; i < days; i++) {
					retVal += val[i];
				}
			}
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sum
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public double sum(double[] val, int days, int start) {
		return UtilMethods.sum(UtilMethods.getDataSlice(val, start, days), days);
	}

}
