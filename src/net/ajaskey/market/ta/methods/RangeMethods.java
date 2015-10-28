
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
public class RangeMethods {

	/**
	 * This method serves as a constructor for the class. Because all methods are
	 * static this constructor is not to be called.
	 *
	 */
	private RangeMethods() {
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.atr
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double atr(double[] high, double[] low, double[] close, int days) {
		double atrVal = 0.0;
		if (Methods.checkParams(close, days * 2, 0,
		    "RangeMethods.atr(double[] high, double[] low, double[] close, int days)--close")) {
			if (Methods.checkParams(high, days * 2, 0,
			    "RangeMethods.atr(double[] high, double[] low, double[] close, int days)--high")) {
				if (Methods.checkParams(low, days * 2, 0,
				    "RangeMethods.atr(double[] high, double[] low, double[] close, int days)--low")) {

					double trAvg = 0;
					for (int i = days; i < (days * 2); i++) {
						trAvg += RangeMethods.trueRange(high[i], low[i], close[i + 1]);
					}
					trAvg /= days;
					atrVal = trAvg;
					for (int i = days; i >= 0; i--) {
						trAvg += RangeMethods.trueRange(high[i], low[i], close[i + 1]);
					}
				}
			}
		}
		return atrVal;
	}

	static public double trueRange(double high, double low, double pClose) {
		double tr = 0.0;
		final double h = Math.max(high, pClose);
		final double l = Math.min(low, pClose);
		tr = h - l;
		return tr;
	}

}
