
package net.ajaskey.market.ta.methods;

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
public class MoneyFlowMethods {

	static public double mfi(double[] high, double[] low, double[] close, double[] volume, int days) {
		double mfiVal = 0.0;

		if (Methods.checkParams(close, days + 1, 0,
		    "MoneyFlowMethods.double mfi(double[] high, double[] low, double[] close, double[] volume, int days)--close")) {
			if (Methods.checkParams(high, days + 1, 0,
			    "MoneyFlowMethods.double mfi(double[] high, double[] low, double[] close, double[] volume, int days)--high")) {
				if (Methods.checkParams(low, days + 1, 0,
				    "MoneyFlowMethods.double mfi(double[] high, double[] low, double[] close, double[] volume, int days)--low")) {
					if (Methods.checkParams(volume, days + 1, 0,
					    "MoneyFlowMethods.double mfi(double[] high, double[] low, double[] close, double[] volume, int days)--volume")) {

						double upVol = 0.0;
						double downVol = 0.0;
						for (int i = 0; i < days; i++) {
							final double typicalPrice = (high[i] + low[i] + close[i]) / 3.0;
							final double typicalPricePrev = (high[i + 1] + low[i + 1] + close[i + 1]) / 3.0;
							final double chg = (typicalPrice - typicalPricePrev);
							if (chg > 0.0) {
								upVol += volume[i] * typicalPrice;
							} else if (chg < 0.0) {
								downVol += volume[i] * typicalPrice;
							}
						}
						final double ratio = upVol / downVol;
						mfiVal = 100.0 - (100.0 / (1.0 + ratio));
						// System.out.printf("%.2f %.2f %n", ratio,mfiVal);
					}
				}
			}
		}

		return mfiVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.mfiTrue
	 *
	 * @param high
	 * @param low
	 * @param close
	 * @param volume
	 * @param days
	 * @return
	 */
	static public double mfiTrue(double[] high, double[] low, double[] close, double[] volume, int days) {
		double mfiVal = 0.0;
		int len = Math.min(low.length, high.length);
		len = Math.min(len, close.length);
		len = Math.min(len, volume.length);
		if ((days + 1) < len) {
			final double[] tHigh = new double[high.length];
			final double[] tLow = new double[low.length];
			for (int i = 0; i < days; i++) {
				tHigh[i] = Math.max(high[i], close[i + 1]);
				tLow[i] = Math.min(low[i], close[i + 1]);
			}
			mfiVal = MoneyFlowMethods.mfi(tHigh, tLow, close, volume, days);
		}
		return mfiVal;
	}

}
