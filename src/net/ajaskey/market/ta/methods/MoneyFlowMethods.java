
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

	static public double mfi(final double[] typicalPrice, final double[] volume, final int days) {

		double mfiVal = 0.0;

		if (Methods.checkParams(typicalPrice, days + 1, 0,
		    "MoneyFlowMethods.double mfi(double[] high, double[] low, double[] close, double[] volume, int days)--typicalPrice")) {
			if (Methods.checkParams(volume, days + 1, 0,
			    "MoneyFlowMethods.double mfi(double[] high, double[] low, double[] close, double[] volume, int days)--volume")) {

				double upVol = 0.0;
				double downVol = 0.0;
				for (int i = 0; i < days; i++) {
					final double chg = (typicalPrice[i] - typicalPrice[i + 1]);
					if (chg > 0.0) {
						upVol += volume[i] * typicalPrice[i];
					}
					else if (chg < 0.0) {
						downVol += volume[i] * typicalPrice[i];
					}
				}
				final double ratio = upVol / downVol;
				mfiVal = 100.0 - (100.0 / (1.0 + ratio));
				// System.out.printf("%.2f %.2f %n", ratio,mfiVal);
			}
		}

		return mfiVal;
	}

}
