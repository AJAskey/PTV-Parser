
package net.ajaskey.market.ta.methods;

import net.ajaskey.market.ta.TrendType;

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
public class TaMethods implements TaMethodsIF {

	@Override
	public int calcAdvDecl(final double[] close, final int days) {

		int retVal = 0;
		// System.out.println("\n\n\n" + td.getTicker());
		if ((days + 1) < close.length) {
			for (int i = 0; i < days; i++) {
				if (close[i] > close[i + 1]) {
					retVal++;
				}
				else if (close[i] < close[i + 1]) {
					retVal--;
				}
				// System.out.printf("%.2f %.2f %d %n", close[i], close[i + 1], retVal);
			}
		}
		return retVal;
	}

	@Override
	public double calcAdx(final double[] high, final double[] low, final double[] close, final int days) {

		final double retVal = 0.0;
		final int len = close.length;
		final int daysPlus = days * 3;
		if (daysPlus < len) {
		}
		return retVal;
	}

	@Override
	public double calcATR(final double[] high, final double[] low, final double[] close, final int days) {

		final double retVal = RangeMethods.avgTrueRange(high, low, close, days);
		return retVal;
	}

	@Override
	public double calcDiMinus(final double[] high, final double[] low, final double[] close, final int days) {

		final double retVal = 0.0;
		final int daysPlus = days * 2;
		if (daysPlus < close.length) {

		}
		return retVal;
	}

	@Override
	public double calcDiPlus(final double[] high, final double[] low, final double[] close, final int days) {

		final double retVal = 0.0;
		final int daysPlus = days * 2;
		if (daysPlus < close.length) {
		}
		return retVal;
	}

	/**
	 *
	 * @param adv
	 * @param decl
	 * @param advVol
	 * @param declVol
	 * @param close
	 * @param days
	 * @return
	 */
	@Override
	public double calcIndexMoneyFlow(final double[] adv, final double[] decl, final double[] advVol, final double[] declVol,
	    final double[] close, final int days) {

		double retVal = 0.0;
		for (int i = 0; i < days; i++) {
			double delta = Math.abs(close[i] - close[i + 1]);
			if (delta == 0.0) {
				delta = 1.0;
			}
			final double val = (delta * ((adv[i] * advVol[i]) - (decl[i] * declVol[i]))) / (advVol[i] + declVol[i]);
			retVal += val;

			// System.out.printf("%.2f %.2f %d %d %d %d : %d %d %n", close[i], delta,
			// (int) adv[i], (int) decl[i],
			// (int) advVol[i], (int) declVol[i], (int) (val / days), (int) (retVal /
			// days));
		}
		return retVal / days;
	}

	@Override
	public double calcMFI(final double[] typicalPrice, final double[] volume, final int days) {

		return MoneyFlowMethods.mfi(typicalPrice, volume, days);
	}

	/**
	 * Calculate the percentage change from p2 to p1
	 *
	 * @param p1
	 *          most recent data point
	 * @param p2
	 *          historic data point
	 * @return percentage change
	 */
	@Override
	public double calcPercentChange(final double p1, final double p2) {

		double ret = 0.0;
		if (p2 != 0.0) {
			ret = (p1 - p2) / p2;
		}
		return ret * 100.0;
	}

	@Override
	public double calcRsi(final double[] close, final int days) {

		return RsiMethods.calcRSI(close, days);
	}

	public double calcSma(final double[] data, final int days) {

		double retVal = 0;
		retVal = UtilMethods.sma(data, days);
		return retVal;
	}

	/**
	 *
	 * @param td
	 * @param days
	 * @param fldName
	 * @return
	 */
	@Override
	public TrendType calcSmaTrend(final double[] data, final int days, final int span) {

		TrendType trend = TrendType.FLAT;
		final double val1 = UtilMethods.sma(data, days);
		final double val2 = UtilMethods.sma(data, days, span);

		if (val1 > val2) {
			trend = TrendType.UP;
		}
		else if (val1 < val2) {
			trend = TrendType.DOWN;
		}
		return trend;
	}
}
