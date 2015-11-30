
package net.ajaskey.market.ta;

/**
 * This class...
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
public class InterdayData {

	private String	ticker;
	private int			sumUp					= 0;
	private int			sumDown				= 0;
	private double	sumForceUp		= 0;
	private double	sumForceDown	= 0;
	private long		sumVol				= 0;
	private double	dayLow				= 999999.9;
	private double	dayOpen				= -1.0;
	private double	dayClose			= 0;
	private int			updates				= 0;

	private double	dayHigh				= -999999.9;

	public void addData(double open, double high, double low, double close, double volume) {

		this.updates++;

		if (this.dayOpen < 0.0) {
			this.dayOpen = open;
		}
		this.dayClose = close;

		final double chg = close - open;
		if (chg > 0.0) {
			this.sumUp++;
			this.sumForceUp += (chg * volume);
		} else if (chg < 0.0) {
			this.sumDown++;
			this.sumForceDown += Math.abs(chg * volume);
		}
		this.sumVol += (long) volume;
		this.dayLow = Math.min(this.dayLow, low);
		this.dayHigh = Math.max(this.dayHigh, high);
	}

	/**
	 * @return the dayClose
	 */
	public double getDayClose() {
		return this.dayClose;
	}

	/**
	 * @return the dayHigh
	 */
	public double getDayHigh() {
		return this.dayHigh;
	}

	/**
	 * @return the dayLow
	 */
	public double getDayLow() {
		return this.dayLow;
	}

	/**
	 * @return the dayOpen
	 */
	public double getDayOpen() {
		return this.dayOpen;
	}

	/**
	 * @return the sumDown
	 */
	public int getSumDown() {
		return this.sumDown;
	}

	/**
	 * @return the sumForceDown
	 */
	public double getSumForceDown() {
		return this.sumForceDown;
	}

	/**
	 * @return the sumForceUp
	 */
	public double getSumForceUp() {
		return this.sumForceUp;
	}

	/**
	 * @return the sumUp
	 */
	public int getSumUp() {
		return this.sumUp;
	}

	/**
	 * @return the sumVol
	 */
	public long getSumVol() {
		return this.sumVol;
	}

	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return this.ticker;
	}

	/**
	 * @return the updates
	 */
	public int getUpdates() {
		return this.updates;
	}

	/**
	 * @param sumForceDown
	 *          the sumForceDown to set
	 */
	public void setSumForceDown(double sumForceDown) {
		this.sumForceDown = sumForceDown;
	}

	/**
	 * @param sumForceUp
	 *          the sumForceUp to set
	 */
	public void setSumForceUp(double sumForceUp) {
		this.sumForceUp = sumForceUp;
	}

	/**
	 * @param ticker
	 *          the ticker to set
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

}
