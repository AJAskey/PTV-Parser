
package net.ajaskey.market.ta.gann;

import java.util.Calendar;

/**
 * This class calculates various range square angles, dates, and price levels.
 * It is currently a place holder for a future effort.
 *
 * @author Andy Askey
 *         <p>
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *         </p>
 *         <p>
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
 *         </p>
 *
 *         <p>
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *         </p>
 *
 */
public class GannData {

	// TODO Place price, time, volume knowledge here.

	private final Calendar	startDate;

	private final Calendar	endDate;

	private final double		startPrice;

	private final double		endPrice;

	private GannLines				gannLines;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public GannData(double sPrice, Calendar sDate, double ePrice, Calendar eDate) {
		this.startDate = sDate;
		this.endDate = eDate;
		this.startPrice = sPrice;
		this.endPrice = ePrice;

	}

	/**
	 * @return the endDate
	 */
	public Calendar getEndDate() {
		return this.endDate;
	}

	/**
	 * @return the endPrice
	 */
	public double getEndPrice() {
		return this.endPrice;
	}

	/**
	 * @return the gannLines
	 */
	public GannLines getGannLines() {
		return this.gannLines;
	}

	/**
	 * @return the startDate
	 */
	public Calendar getStartDate() {
		return this.startDate;
	}

	/**
	 * @return the startPrice
	 */
	public double getStartPrice() {
		return this.startPrice;
	}

}
