
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
public class RsiMethods {

	/**
	 * This method serves as a constructor for the class. Because all methods are
	 * static this constructor is not to be called.
	 *
	 */
	private RsiMethods() {
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.calcAvgGain
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double calcAvgGain(double[] val, int days) {
		double avgGain = 0.0;
		final int len = Math.min(val.length, 250);
		final int start = len - days - 1;

		for (int i = start; i < (len - 1); i++) {
			final double chg = val[i] - val[i + 1];
			if (chg > 0.0) {
				avgGain += chg;
			}
		}
		avgGain /= days;

		for (int i = start - 1; i >= 0; i--) {
			double chg = val[i] - val[i + 1];
			if (chg < 0.0) {
				chg = 0.0;
			}
			avgGain = ((avgGain * 13.0) + chg) / 14.0;
			// System.out.println(avgGain);
		}

		return avgGain;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.calcAvgLoss
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double calcAvgLoss(double[] val, int days) {
		double avgLoss = 0.0;
		final int len = Math.min(val.length, 250);
		final int start = len - days - 1;

		for (int i = start; i < (len - 1); i++) {
			final double chg = val[i] - val[i + 1];
			if (chg < 0.0) {
				avgLoss += Math.abs(chg);
			}
		}
		avgLoss /= days;
		// System.out.println(avgLoss);

		for (int i = start - 1; i >= 0; i--) {
			double chg = val[i] - val[i + 1];
			if (chg > 0.0) {
				chg = 0.0;
			} else {
				chg = Math.abs(chg);
			}
			avgLoss = ((avgLoss * 13.0) + chg) / 14.0;
			// System.out.println(avgLoss);
		}

		return avgLoss;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.calcRS
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double calcRS(double[] val, int days) {
		double rs = 0.0;
		final double ag = RsiMethods.calcAvgGain(val, days);
		final double al = RsiMethods.calcAvgLoss(val, days);
		if (al != 0.0) {
			rs = ag / al;
		}
		return rs;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.calcRSI
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double calcRSI(double[] val, int days) {
		double rsi = 0.0;
		if (Methods.checkParams(val, (days * 2 + 2), 0, "RsiMethods.calcSI(double[] val, int days)")) {
			final double rs = RsiMethods.calcRS(val, days);
			if (rs < 0.01) {
				rsi = 100.0;
			} else {
				rsi = 100.0 - (100.0 / (1.0 + rs));
			}
		}
		return rsi;
	}

}
