/**
 *
 */

package net.ajaskey.market.ta.methods;

import net.ajaskey.market.ta.FieldName;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.TrendType;

/**
 *
 * @author Andy Askey
 *
 *         PTV-Parser Copyright (c) 2015, Andy Askey All rights reserved.
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

	public int calcAdvDecl(TickerData td, int days);

	public double calcAdx(TickerData td, int days);

	/**
	 *
	 * @param td
	 * @param days
	 * @return
	 */
	public double calcATR(TickerData td, int days);

	public double calcDiMinus(TickerData td, int days);

	public double calcDiPlus(TickerData td, int days);

	public double calcHigh(TickerData td, int days);

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

	public double calcLinearRegression(TickerData td, int days);

	public double calcLinearRegressionAngle(TickerData td, int days);

	public double calcLinearRegressionInt(TickerData td, int days);

	public double calcLinearRegressionSlope(TickerData td, int days);

	public double calcLow(TickerData td, int days);

	/**
	 *
	 * @param td
	 * @param days
	 * @return
	 */
	public double calcMFI(TickerData td, int days);

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
	 * @param td
	 * @return
	 */
	public double calcRawRS(TickerData td);

	public double calcRsi(TickerData td, int days);

	/**
	 *
	 * @param td
	 * @param days
	 * @return
	 */
	public double calcSma(TickerData td, int days, FieldName fldName);

	/**
	 *
	 * @param td
	 * @param days
	 * @param fldName
	 * @return
	 */
	public TrendType calcSmaTrend(TickerData td, int days, FieldName fldName);

}
