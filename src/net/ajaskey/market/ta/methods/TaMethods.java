
package net.ajaskey.market.ta.methods;

import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

import net.ajaskey.market.ta.FieldName;
import net.ajaskey.market.ta.TickerData;
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
	public int calcAdvDecl(TickerData td, int days) {
		int retVal = 0;
		// System.out.println("\n\n\n" + td.getTicker());
		if ((days + 1) < td.getDaysOfData()) {
			final double[] close = td.getCloseData();
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
	public double calcAdx(TickerData td, int days) {
		double retVal = 0.0;
		final int daysPlus = days * 3;
		if (daysPlus < td.getDaysOfData()) {
			final double ret[] = new double[td.getDaysOfData()];
			final RetCode rc = talib.adx(0, daysPlus, td.getTrueHighData(), td.getTrueLowData(), td.getCloseData(), days,
			    outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	/**
	 *
	 * @param td
	 * @param days
	 * @return
	 */
	@Override
	public double calcATR(TickerData td, int days) {
		final double retVal = RangeMethods.avgTrueRange(td.getHighData(), td.getLowData(), td.getCloseData(), days);
		return retVal;
	}

	@Override
	public double calcDiMinus(TickerData td, int days) {
		double retVal = 0.0;
		final int daysPlus = days * 2;
		if (daysPlus < td.getDaysOfData()) {
			final double ret[] = new double[td.getDaysOfData()];
			final RetCode rc = talib.minusDI(0, daysPlus, td.getTrueHighData(), td.getTrueLowData(), td.getCloseData(), days,
			    outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}

		}
		return retVal;
	}

	@Override
	public double calcDiPlus(TickerData td, int days) {
		double retVal = 0.0;
		final int daysPlus = days * 2;
		if (daysPlus < td.getDaysOfData()) {
			final double ret[] = new double[td.getDaysOfData()];
			final RetCode rc = talib.plusDI(0, daysPlus, td.getTrueHighData(), td.getTrueLowData(), td.getCloseData(), days,
			    outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcHigh(TickerData td, int days) {
		double retVal = 0.0;
		final int daysPlus = days + 1;
		if (daysPlus < td.getDaysOfData()) {
			final double ret[] = new double[td.getDaysOfData()];
			final RetCode rc = talib.max(0, daysPlus, td.getTrueHighData(), days, outBegIdx, outNBElement, ret);
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
	public double calcLinearRegression(TickerData td, int days) {
		double retVal = 0.0;
		final int daysPlus = days + 1;
		if (daysPlus < td.getDaysOfData()) {
			final double ret[] = new double[td.getDaysOfData()];
			final RetCode rc = talib.linearReg(0, daysPlus, td.getCloseData(), days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcLinearRegressionAngle(TickerData td, int days) {
		double retVal = 0.0;
		final int daysPlus = days + 1;
		if (daysPlus < td.getDaysOfData()) {
			final double ret[] = new double[td.getDaysOfData()];
			final RetCode rc = talib.linearRegAngle(0, daysPlus, td.getCloseData(), days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcLinearRegressionInt(TickerData td, int days) {
		double retVal = 0.0;
		final int daysPlus = days + 1;
		if (daysPlus < td.getDaysOfData()) {
			final double ret[] = new double[td.getDaysOfData()];
			final RetCode rc = talib.linearRegIntercept(0, daysPlus, td.getCloseData(), days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcLinearRegressionSlope(TickerData td, int days) {
		double retVal = 0.0;
		final int daysPlus = days + 1;
		if (daysPlus < td.getDaysOfData()) {
			final double ret[] = new double[td.getDaysOfData()];
			final RetCode rc = talib.linearRegSlope(0, daysPlus, td.getCloseData(), days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	@Override
	public double calcLow(TickerData td, int days) {
		double retVal = 0.0;
		final int daysPlus = days + 1;
		if (daysPlus < td.getDaysOfData()) {
			final double ret[] = new double[td.getDaysOfData()];
			final RetCode rc = talib.min(0, daysPlus, td.getTrueLowData(), days, outBegIdx, outNBElement, ret);
			if (rc == RetCode.Success) {
				retVal = ret[0];
			}
		}
		return retVal;
	}

	/**
	 *
	 * @param td
	 * @param days
	 * @return
	 */
	@Override
	public double calcMFI(TickerData td, int days) {
		return MoneyFlowMethods.mfi(td.getHighData(), td.getLowData(), td.getCloseData(), td.getVolumeData(), days);
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

	/**
	 *
	 * @param td
	 * @return
	 */
	@Override
	public double calcRawRS(TickerData td) {
		return (0.50 * td.getChg260()) + (0.25 * td.getChg130()) + (0.20 * td.getChg65()) + (0.05 * td.getChg23());
	}

	@Override
	public double calcRawStRS(TickerData td) {
		return ((0.25 * td.getChg65()) + (0.75 * td.getChg23()));
	}

	@Override
	public double calcRsi(TickerData td, int days) {
		return RsiMethods.calcRSI(td.getCloseData(), days);
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
	public TrendType calcSmaTrend(TickerData td, int days, FieldName fldName) {
		TrendType retVal = TrendType.FLAT;
		final double ret[] = new double[td.getDaysOfData()];
		final int daysPlus = days + 6;

		RetCode rc = RetCode.BadParam;
		if (daysPlus < td.getDaysOfData()) {
			switch (fldName) {
				case CLOSE:
					rc = talib.sma(0, daysPlus, td.getCloseData(), days, outBegIdx, outNBElement, ret);
					break;
				case HIGH:
					rc = talib.sma(0, daysPlus, td.getHighData(), days, outBegIdx, outNBElement, ret);
					break;
				case LOW:
					rc = talib.sma(0, daysPlus, td.getLowData(), days, outBegIdx, outNBElement, ret);
					break;
				case OPEN:
					rc = talib.sma(0, daysPlus, td.getOpenData(), days, outBegIdx, outNBElement, ret);
					break;
				case VOLUME:
					rc = talib.sma(0, daysPlus, td.getVolumeData(), days, outBegIdx, outNBElement, ret);
					break;
				default:
					break;
			}
			if (rc == RetCode.Success) {
				if (ret[0] > ret[5]) {
					retVal = TrendType.UP;
				} else if (ret[0] < ret[5]) {
					retVal = TrendType.DOWN;
				}
			}
		}
		return retVal;
	}
}
