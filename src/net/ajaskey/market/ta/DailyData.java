
package net.ajaskey.market.ta;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
public class DailyData {

	private final Calendar	date;
	private final Double		open;
	private final Double		high;
	private final Double		low;
	private final Double		close;
	private final Double		volume;

	private double					trueHigh;
	private double					trueLow;
	private double					dailyChg;
	private double					dailyPercentChg;
	private double					dailyRng;
	private double					dailyPercentRng;

	/**
	 *
	 * This methods serves as a constructor for the class.
	 *
	 * @param d
	 * @param o
	 * @param h
	 * @param l
	 * @param c
	 * @param v
	 */
	public DailyData(Calendar d, double o, double h, double l, double c, double v) {
		this.date = d;
		this.open = o;
		this.high = h;
		this.low = l;
		this.close = c;
		this.volume = v;
		this.trueHigh = 0.0;
		this.trueLow = 0.0;
		this.dailyChg = 0.0;
		this.dailyPercentChg = 0.0;
		this.dailyRng = 0.0;
		this.dailyPercentRng = 0.0;
	}

	/**
	 * @return the close
	 */
	public Double getClose() {
		return this.close;
	}

	/**
	 * @return the dailyChg
	 */
	public double getDailyChg() {
		return this.dailyChg;
	}

	/**
	 * @return the dailyPercentChg
	 */
	public double getDailyPercentChg() {
		return this.dailyPercentChg;
	}

	/**
	 * @return the dailyPercentRng
	 */
	public double getDailyPercentRng() {
		return this.dailyPercentRng;
	}

	/**
	 * @return the dailyRng
	 */
	public double getDailyRng() {
		return this.dailyRng;
	}

	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return this.date;
	}

	/**
	 * @return the high
	 */
	public Double getHigh() {
		return this.high;
	}

	/**
	 * @return the low
	 */
	public Double getLow() {
		return this.low;
	}

	/**
	 * @return the open
	 */
	public Double getOpen() {
		return this.open;
	}

	/**
	 * @return the trueHigh
	 */
	public double getTrueHigh() {
		return this.trueHigh;
	}

	/**
	 * @return the trueLow
	 */
	public double getTrueLow() {
		return this.trueLow;
	}

	/**
	 * @return the volume
	 */
	public Double getVolume() {
		return this.volume;
	}

	/**
	 *
	 * net.ajaskey.market.ta.setDailyChg
	 *
	 * @param closeYesterday
	 */
	public void setDailyChg(double closeYesterday) {
		this.dailyChg = this.close - closeYesterday;
		if (closeYesterday > 0.0) {
			this.dailyPercentChg = ((this.close - closeYesterday) / closeYesterday) * 100.0;
		}

		this.dailyRng = this.trueHigh - this.trueLow;
		this.dailyPercentRng = (this.dailyRng / this.close) * 100.0;
	}

	/**
	 *
	 * net.ajaskey.market.ta.setTrueHigh
	 *
	 * @param closeYesterday
	 */
	public void setTrueHigh(double closeYesterday) {
		this.trueHigh = Math.max(closeYesterday, this.high);
	}

	/**
	 *
	 * net.ajaskey.market.ta.setTrueLow
	 *
	 * @param closeYesterday
	 */
	public void setTrueLow(double closeYesterday) {
		this.trueLow = Math.min(closeYesterday, this.low);
	}

	@Override
	public String toString() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		final String sDate = sdf.format(this.date.getTime());
		final String ret = String.format("%s  %.2f  %.2f  %.2f  %.2f %d%n", sDate, this.open, this.high, this.low,
		    this.close, (int) (double) (this.volume));
		return ret.trim();
	}

}
