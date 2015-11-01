/**
 *
 */

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
public interface TaMethodsIF {

	/**
	 *
	 * @param adv
	 * @param decl
	 * @param advVol
	 * @param declVol
	 * @param days
	 * @return
	 */
	public double calcIndexMoneyFlow(double[] adv, double[] decl, double[] advVol, double[] declVol, double[] close,
	    int days);

	/**
	 * Calculate the percentage change from p2 to p1
	 *
	 * @param p1
	 *          most recent data point
	 * @param p2
	 *          historic data point
	 * @return percentage change
	 */
	public double calcPercentChange(double p1, double p2);

	/**
	 *
	 * net.ajaskey.market.ta.methods.calcRsi
	 *
	 * @param close
	 * @param days
	 * @return
	 */
	public double calcRsi(double[] close, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcAdvDecl
	 *
	 * @param close
	 * @param days
	 * @return
	 */
	int calcAdvDecl(double[] close, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcAdx
	 *
	 * @param high
	 * @param low
	 * @param close
	 * @param days
	 * @return
	 */
	double calcAdx(double[] high, double[] low, double[] close, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcATR
	 *
	 * @param high
	 * @param low
	 * @param close
	 * @param days
	 * @return
	 */
	double calcATR(double[] high, double[] low, double[] close, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcDiMinus
	 *
	 * @param high
	 * @param low
	 * @param close
	 * @param days
	 * @return
	 */
	double calcDiMinus(double[] high, double[] low, double[] close, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcDiPlus
	 *
	 * @param high
	 * @param low
	 * @param close
	 * @param days
	 * @return
	 */
	double calcDiPlus(double[] high, double[] low, double[] close, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcHigh
	 *
	 * @param high
	 * @param days
	 * @return
	 */
	double calcHigh(double[] high, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcLinearRegression
	 *
	 * @param close
	 * @param days
	 * @return
	 */
	double calcLinearRegression(double[] close, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcLinearRegressionAngle
	 *
	 * @param close
	 * @param days
	 * @return
	 */
	double calcLinearRegressionAngle(double[] close, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcLinearRegressionInt
	 *
	 * @param close
	 * @param days
	 * @return
	 */
	double calcLinearRegressionInt(double[] close, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcLinearRegressionSlope
	 *
	 * @param close
	 * @param days
	 * @return
	 */
	double calcLinearRegressionSlope(double[] close, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcLow
	 *
	 * @param low
	 * @param days
	 * @return
	 */
	double calcLow(double[] low, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcMFI
	 *
	 * @param high
	 * @param low
	 * @param close
	 * @param volume
	 * @param days
	 * @return
	 */
	double calcMFI(double[] high, double[] low, double[] close, double[] volume, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcSma
	 *
	 * @param data
	 * @param days
	 * @return
	 */
	double calcSma(double[] data, int days);

	/**
	 * net.ajaskey.market.ta.methods.calcSmaTrend
	 *
	 * @param data
	 * @param days
	 * @param span
	 * @return
	 */
	TrendType calcSmaTrend(double[] data, int days, int span);

}
