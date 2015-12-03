
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

	private String			ticker;
	private int					sumUp;
	private int					sumDown;
	private double			sumForceUp;
	private double			sumForceDown;
	private long				sumVol;
	private double			dayLow;
	private double			dayOpen;
	private double			dayClose;
	private int					updates;
	private double			dayHigh;
	private double			priceRange;
	private int					upDownDiff;
	private long				forceDiff;
	private double			forceVolume;
	private double			rangePercent;
	private TickerData	td	= null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public InterdayData() {
		ticker = "none";
		sumUp = 0;
		sumDown = 0;
		sumForceUp = 0;
		sumForceDown = 0;
		sumVol = 0;
		dayLow = 999999.9;
		dayOpen = -1.0;
		dayClose = 0;
		updates = 0;
		dayHigh = -999999.9;
		priceRange = 0;
		upDownDiff = 0;
		forceDiff = 0;
		forceVolume = 0.0;
		rangePercent = 0;
		td = null;
	}

	/**
	 *
	 * net.ajaskey.market.ta.addData
	 *
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param volume
	 */
	public void addData(double open, double high, double low, double close, double volume) {

		this.updates++;

		// System.out.println(ticker + " " + updates);

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
		this.priceRange = this.dayHigh - this.dayLow;

		/**
		 * The last value calculated is useful
		 */
		this.upDownDiff = this.getSumUp() - this.getSumDown();
		this.forceDiff = (long) (this.getSumForceUp() - this.getSumForceDown());
		if (this.getSumVol() > 0.0) {
			this.forceVolume = Math.abs(((double) this.forceDiff / this.getSumVol()) * 100.0);
		}
		if (this.getDayClose() > 0.0) {
			this.rangePercent = this.getPriceRange() / this.getDayClose();
		}
	}

	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return ticker;
	}

	/**
	 * @return the sumUp
	 */
	public int getSumUp() {
		return sumUp;
	}

	/**
	 * @return the sumDown
	 */
	public int getSumDown() {
		return sumDown;
	}

	/**
	 * @return the sumForceUp
	 */
	public double getSumForceUp() {
		return sumForceUp;
	}

	/**
	 * @return the sumForceDown
	 */
	public double getSumForceDown() {
		return sumForceDown;
	}

	/**
	 * @return the sumVol
	 */
	public long getSumVol() {
		return sumVol;
	}

	/**
	 * @return the dayLow
	 */
	public double getDayLow() {
		return dayLow;
	}

	/**
	 * @return the dayOpen
	 */
	public double getDayOpen() {
		return dayOpen;
	}

	/**
	 * @return the dayClose
	 */
	public double getDayClose() {
		return dayClose;
	}

	/**
	 * @return the updates
	 */
	public int getUpdates() {
		return updates;
	}

	/**
	 * @return the dayHigh
	 */
	public double getDayHigh() {
		return dayHigh;
	}

	/**
	 * @return the priceRange
	 */
	public double getPriceRange() {
		return priceRange;
	}

	/**
	 * @return the upDownDiff
	 */
	public int getUpDownDiff() {
		return upDownDiff;
	}

	/**
	 * @return the forceDiff
	 */
	public long getForceDiff() {
		return forceDiff;
	}

	/**
	 * @return the forceVolume
	 */
	public double getForceVolume() {
		return forceVolume;
	}

	/**
	 * @return the rangePercent
	 */
	public double getRangePercent() {
		return rangePercent;
	}

	/**
	 * @return the td
	 */
	public TickerData getTd() {
		return td;
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
	 * @param td
	 *          the td to set
	 */
	public void setTd(TickerData td) {
		this.td = td;
	}

	/**
	 * @param ticker
	 *          the ticker to set
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

}
