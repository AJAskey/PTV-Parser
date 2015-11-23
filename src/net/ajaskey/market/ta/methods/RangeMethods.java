
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
	static public double avgTrueRange(double[] high, double[] low, double[] close, int days) {
		double atrVal = 0.0;

		if (Methods.checkParams(close, days * 2, 0,
		    "RangeMethods.atr(double[] high, double[] low, double[] close, int days)--close")) {
			if (Methods.checkParams(high, days * 2, 0,
			    "RangeMethods.atr(double[] high, double[] low, double[] close, int days)--high")) {
				if (Methods.checkParams(low, days * 2, 0,
				    "RangeMethods.atr(double[] high, double[] low, double[] close, int days)--low")) {

					double trSum = 0.0;
					final int len = Math.min(close.length, 250) - 1;
					// for (int i = days; i < days*2; i++) {
					for (int i = len - days; i < len; i++) {
						final double tr = RangeMethods.trueRange(high[i], low[i], close[i + 1]);
						trSum += tr;
						// System.out.println(tr);
					}
					atrVal = trSum / days;
					// System.out.println(atrVal);

					for (int i = len - days - 1; i >= 0; i--) {
						final double rng = RangeMethods.trueRange(high[i], low[i], close[i + 1]);
						atrVal = ((atrVal * 13.0) + rng) / 14.0;
						// System.out.printf("%d %.2f %.2f %n",i, close[i + 1], atrVal);
					}
				}
			}
		}
		return atrVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.atrPercent
	 *
	 * @param high
	 * @param low
	 * @param close
	 * @param days
	 * @return
	 */
	static public double avgTrueRangePercent(double[] high, double[] low, double[] close, int days) {
		double atrVal = 0.0;
		double atrPercent = 0.0;
		atrVal = RangeMethods.avgTrueRange(high, low, close, days);
		if (atrVal > 0.0) {
			final double ma = UtilMethods.sma(close, days);
			atrPercent = (atrVal / ma) * 100.0;
		}
		return atrPercent;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.trueRange
	 *
	 * @param high
	 * @param low
	 * @param pClose
	 * @return
	 */
	static public double trueRange(double high, double low, double pClose) {
		double tr = 0.0;
		final double h = Math.max(high, pClose);
		final double l = Math.min(low, pClose);
		tr = h - l;
		// System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f%n", high, low, pClose,
		// h, l, tr);
		return tr;
	}

}
