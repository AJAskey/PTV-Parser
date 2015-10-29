
package net.ajaskey.market.ta.methods;

import net.ajaskey.market.ta.TickerData;

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
public class MovingAverageMethods {

	/**
	 * This method serves as a constructor for the class. Because all methods are
	 * static this constructor is not to be called.
	 *
	 */
	private MovingAverageMethods() {
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.ema
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double ema(double[] val, int days) {
		double retVal = 0.0;
		if (Methods.checkParams(val, days * 2, 0, "MovingAverageMethods.ema(double[] val, int days)")) {
			final double smooth = 2.0 / (days + 1);
			retVal = MovingAverageMethods.sma(val, days, days * 2);
			for (int i = days * 2; i >= 0; i--) {
				final double tmp = retVal;
				retVal = (smooth * (val[i] - tmp)) + tmp;
			}
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.ema
	 *
	 * @param td
	 * @param days
	 * @return
	 */
	static public double ema(TickerData td, int days) {
		double retVal = 0.0;
		if (Methods.checkParams(td, days, 0, "MovingAverageMethods.ema(TickerData td, int days)")) {
			retVal = MovingAverageMethods.ema(td.getCloseData(), days);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double sma(double[] val, int days) {
		double retVal = 0.0;
		if (Methods.checkParams(val, days, 0, "MovingAverageMethods.sma(double[] val, int days)")) {
			retVal = UtilMethods.sum(val, days) / days;
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public double sma(double[] val, int days, int start) {
		double retVal = 0.0;
		if (Methods.checkParams(val, days, start, "MovingAverageMethods.sma(double[] val, int days, int start)")) {
			final double[] slice = UtilMethods.getDataSlice(val, start, days);
			retVal = MovingAverageMethods.sma(slice, days);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param td
	 * @param days
	 * @return
	 */
	static public double sma(TickerData td, int days) {
		double retVal = 0.0;
		if (Methods.checkParams(td, days, 0, "MovingAverageMethods.sma(TickerData td, int days)")) {
			retVal = MovingAverageMethods.sma(td.getCloseData(), days);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param td
	 * @param days
	 * @param start
	 * @return
	 */
	static public double sma(TickerData td, int days, int start) {
		double retVal = 0.0;
		if (Methods.checkParams(td, days, start, "MovingAverageMethods.sma(TickerData td, int days, int start)")) {
			retVal = MovingAverageMethods.sma(td.getCloseData(), days, start);
		}
		return retVal;
	}

}
