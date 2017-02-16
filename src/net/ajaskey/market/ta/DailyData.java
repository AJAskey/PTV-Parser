
package net.ajaskey.market.ta;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.ajaskey.market.misc.Utils;

/**
 *
 * This class serves as a container for daily price and volume data for a
 * specific entity.
 *
 * A java.utils.List of DailyData objects is used to hold available price,
 * volume, and time data for a specific entity.
 *
 * @author <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *         </p> <p> Permission is hereby granted, free of charge, to any person
 *         obtaining a copy of this software and associated documentation files
 *         (the "Software"), to deal in the Software without restriction,
 *         including without limitation the rights to use, copy, modify, merge,
 *         publish, distribute, sublicense, and/or sell copies of the Software,
 *         and to permit persons to whom the Software is furnished to do so,
 *         subject to the following conditions:
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
 *         SOFTWARE. </p>
 *
 */
public class DailyData {

	private final Calendar	date;
	private final Double		open;
	private final Double		high;
	private final Double		low;
	private final Double		close;
	private Double					volume;
	private final Double		oi;

	private double	trueHigh;
	private double	trueLow;
	private double	dailyChg;
	private double	dailyPercentChg;
	private double	dailyRng;
	private double	dailyPercentRng;

	private long daysSinceBase;

	private final SimpleDateFormat sdf = new SimpleDateFormat("E dd-MMM-yyyy");

	/**
	 *
	 * This methods serves as a constructor for the class.
	 *
	 * @param d
	 *          Calendar date of the data.
	 * @param o
	 *          Opening price.
	 * @param h
	 *          High price.
	 * @param l
	 *          Low price.
	 * @param c
	 *          Closing price.
	 * @param v
	 *          Volume of daily activity.
	 */
	public DailyData(Calendar d, double o, double h, double l, double c, double v, double oi) {
		this.date = d;
		this.date.set(Calendar.HOUR_OF_DAY, 0);
		this.date.set(Calendar.MINUTE, 0);
		this.date.set(Calendar.SECOND, 1);
		this.date.set(Calendar.MILLISECOND, 0);
		this.setDaysSinceBase();
		this.open = o;
		this.high = h;
		this.low = l;
		this.close = c;
		this.oi = oi;
		this.setVolume(v);
		this.trueHigh = 0.0;
		this.trueLow = 0.0;
		this.dailyChg = 0.0;
		this.dailyPercentChg = 0.0;
		this.dailyRng = 0.0;
		this.dailyPercentRng = 0.0;
	}

	/**
	 * Returns the closing value for this specific object. This is usually a price
	 * value but can be used for other entities such as Up/Down counts.
	 *
	 * @return the close
	 */
	public Double getClose() {

		return this.close;
	}

	/**
	 * Returns the change in the close of the current day minus the previous day.
	 *
	 * @return the dailyChg
	 */
	public double getDailyChg() {

		return this.dailyChg;
	}

	/**
	 * Returns the percent change in the close of the current day minus the
	 * previous day.
	 *
	 * @return the dailyPercentChg
	 */
	public double getDailyPercentChg() {

		return this.dailyPercentChg;
	}

	/**
	 * Returns the percent range (high to low) in the close of the current day
	 * minus the previous day.
	 *
	 * @return the dailyPercentRng
	 */
	public double getDailyPercentRng() {

		return this.dailyPercentRng;
	}

	/**
	 * Returns the range (high to low) in the close of the current day minus the
	 * previous day.
	 *
	 * @return the dailyRng
	 */
	public double getDailyRng() {

		return this.dailyRng;
	}

	/**
	 * Return the date of the data.
	 *
	 * @return the date
	 */
	public Calendar getDate() {

		return this.date;
	}

	/**
	 * @return the daysSinceBase
	 */
	public long getDaysSinceBase() {

		return this.daysSinceBase;
	}

	/**
	 * Returns the daily high.
	 *
	 * @return the high
	 */
	public Double getHigh() {

		return this.high;
	}

	/**
	 * Returns the daily low.
	 *
	 * @return the low
	 */
	public Double getLow() {

		return this.low;
	}

	/**
	 *
	 * net.ajaskey.market.ta.getOi
	 *
	 * @return the Oi
	 */
	public Double getOi() {

		return this.oi;
	}

	/**
	 * Returns the daily open.
	 *
	 * @return the open
	 */
	public Double getOpen() {

		return this.open;
	}

	/**
	 * Returns the true high when considering the previous day's close.
	 *
	 * @return the trueHigh
	 */
	public double getTrueHigh() {

		return this.trueHigh;
	}

	/**
	 * Returns the true low when considering the previous day's close.
	 *
	 * @return the trueLow
	 */
	public double getTrueLow() {

		return this.trueLow;
	}

	/**
	 * Returns the daily volume.
	 *
	 * @return the volume
	 */
	public Double getVolume() {

		return this.volume;
	}

	/**
	 * Sets the change value based on the price passed in. It is assumed that this
	 * price is the close from the previous day, but can be any price the use
	 * wants to send in.
	 *
	 * @param closeYesterday
	 *          the close from the previous day.
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
	 * Sets the high of the daily daily and the close from price passed in.
	 *
	 * @param closeYesterday
	 *          previous closing price.
	 */
	public void setTrueHigh(double closeYesterday) {

		this.trueHigh = Math.max(closeYesterday, this.high);
	}

	/**
	 *
	 * Sets the low of the daily daily and the close from price passed in.
	 *
	 * @param closeYesterday
	 *          previous closing price.
	 */
	public void setTrueLow(double closeYesterday) {

		this.trueLow = Math.min(closeYesterday, this.low);
	}

	/**
	 * Sets the daily volume
	 *
	 * @param vol
	 *          Volume
	 */
	public void setVolume(double vol) {

		this.volume = vol;
	}

	/**
	 * Returns a readable string representing the contents of this object.
	 */
	@Override
	public String toString() {

		final String sDate = this.sdf.format(this.date.getTime());
		final String ret = String.format("%s  %.2f  %.2f  %.2f  %.2f %5d %5d %9.2f %9.2f%n", sDate, this.open, this.high,
		    this.low, this.close, (int) (double) (this.volume), (int) (double) (this.oi), this.close * this.volume,
		    this.close * this.oi);
		return ret.trim();
	}

	/**
	 * Set calendar days since the base of 1900.
	 */
	private void setDaysSinceBase() {

		this.daysSinceBase = Utils.getTimeSpan(this.date, Utils.getBaseDate());
	}

}
