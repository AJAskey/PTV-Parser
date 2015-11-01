
package net.ajaskey.market.ta.methods;

import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

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

	private static MInteger	outBegIdx			= new MInteger();
	private static MInteger	outNBElement	= new MInteger();

	static private Core			talib					= new Core();

	@Override
	public int calcAdvDecl(double[] close, int days) {
		int retVal = 0;
		// System.out.println("\n\n\n" + td.getTicker());
		if ((days + 1) < close.length) {
			for (int i = 0; i < days; i++) {
				if (close[i] > close[i + 1]) {
					retVal++;
				} else if (close[i] < close[i + 1]) {
					retVal--;
				}
				// System.out.printf("%.2f %.2f %d %n", close[i], close[i + 1], retVal);
			}
		}
		return retVal;
	}

	@Override
	public double calcAdx(double[] high, double[] low, double[] close, int days) {
		double retVal = 0.0;
		final int len = close.length;
		final int daysPlus = days * 3;
		if (daysPlus < len) {
			final double ret[] = new double[len];
			final RetCode rc = talib.adx(0, daysPlus, high, low, close, days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcATR(double[] high, double[] low, double[] close, int days) {
		final double retVal = RangeMethods.avgTrueRange(high, low, close, days);
		return retVal;
	}

	@Override
	public double calcDiMinus(double[] high, double[] low, double[] close, int days) {
		double retVal = 0.0;
		final int daysPlus = days * 2;
		if (daysPlus < close.length) {
			final double ret[] = new double[close.length];
			final RetCode rc = talib.minusDI(0, daysPlus, high, low, close, days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}

		}
		return retVal;
	}

	@Override
	public double calcDiPlus(double[] high, double[] low, double[] close, int days) {
		double retVal = 0.0;
		final int daysPlus = days * 2;
		if (daysPlus < close.length) {
			final double ret[] = new double[close.length];
			final RetCode rc = talib.plusDI(0, daysPlus, high, low, close, days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcHigh(double[] high, int days) {
		double retVal = 0.0;
		final int daysPlus = days + 1;
		if (daysPlus < high.length) {
			final double ret[] = new double[high.length];
			final RetCode rc = talib.max(0, daysPlus, high, days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
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
	public double calcIndexMoneyFlow(double[] adv, double[] decl, double[] advVol, double[] declVol, double[] close,
	    int days) {
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
	public double calcLinearRegression(double[] close, int days) {
		double retVal = 0.0;
		final int len = close.length;
		final int daysPlus = days + 1;
		if (daysPlus < len) {
			final double ret[] = new double[len];
			final RetCode rc = talib.linearReg(0, daysPlus, close, days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcLinearRegressionAngle(double[] close, int days) {
		double retVal = 0.0;
		final int len = close.length;
		final int daysPlus = days + 1;
		if (daysPlus < len) {
			final double ret[] = new double[len];
			final RetCode rc = talib.linearRegAngle(0, daysPlus, close, days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcLinearRegressionInt(double[] close, int days) {
		double retVal = 0.0;
		final int len = close.length;
		final int daysPlus = days + 1;
		if (daysPlus < len) {
			final double ret[] = new double[len];
			final RetCode rc = talib.linearRegIntercept(0, daysPlus, close, days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcLinearRegressionSlope(double[] close, int days) {
		double retVal = 0.0;
		final int len = close.length;
		final int daysPlus = days + 1;
		if (daysPlus < len) {
			final double ret[] = new double[len];
			final RetCode rc = talib.linearRegSlope(0, daysPlus, close, days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcLow(double[] low, int days) {
		double retVal = 0.0;
		final int daysPlus = days + 1;
		if (daysPlus < low.length) {
			final double ret[] = new double[low.length];
			final RetCode rc = talib.min(0, daysPlus, low, days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcMFI(double[] high, double[] low, double[] close, double[] volume, int days) {
		return MoneyFlowMethods.mfi(high, low, close, volume, days);
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
	public double calcPercentChange(double p1, double p2) {
		double ret = 0.0;
		if (p2 != 0.0) {
			ret = (p1 - p2) / p2;
		}
		return ret * 100.0;
	}

	@Override
	public double calcRsi(double[] close, int days) {
		return RsiMethods.calcRSI(close, days);
	}

	/**
	 *
	 * @param td
	 * @param days
	 * @return
	 */
	@Override
	// public double calcSma(TickerData td, int days, FieldName fldName) {
	// double retVal = 0;
	// switch (fldName) {
	// case CLOSE:
	// retVal = MovingAverageMethods.sma(td, days);
	// break;
	// case HIGH:
	// retVal = MovingAverageMethods.sma(td.getHighData(), days);
	// break;
	// case LOW:
	// retVal = MovingAverageMethods.sma(td.getLowData(), days);
	// break;
	// case OPEN:
	// retVal = MovingAverageMethods.sma(td.getOpenData(), days);
	// break;
	// case VOLUME:
	// retVal = MovingAverageMethods.sma(td.getVolumeData(), days);
	// break;
	// default:
	// break;
	// }
	// return retVal;
	// }

	public double calcSma(double[] data, int days) {
		double retVal = 0;
		retVal = MovingAverageMethods.sma(data, days);
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
	public TrendType calcSmaTrend(double[] data, int days, int span) {
		TrendType trend = TrendType.FLAT;
		final double val1 = MovingAverageMethods.sma(data, days);
		final double val2 = MovingAverageMethods.sma(data, days, span);

		if (val1 > val2) {
			trend = TrendType.UP;
		} else if (val1 < val2) {
			trend = TrendType.DOWN;
		}
		return trend;
	}
}
