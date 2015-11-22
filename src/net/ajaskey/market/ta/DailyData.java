
package net.ajaskey.market.ta;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * This class serves as a container for daily price and volume data for a
 * specific entity.
 *
 * A java.utils.List of DailyData objects is used to hold available price and
 * time data for a specific entity.
 *
 * @author
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
 *
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
public class DailyData {

	private final Calendar					date;
	private final Double						open;
	private final Double						high;
	private final Double						low;
	private final Double						close;
	private Double									volume;

	private double									trueHigh;
	private double									trueLow;
	private double									dailyChg;
	private double									dailyPercentChg;
	private double									dailyRng;
	private double									dailyPercentRng;

	private long										daysSinceBase;

	private final SimpleDateFormat	sdf	= new SimpleDateFormat("E dd-MMM-yyyy");

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
		this.date.set(Calendar.HOUR_OF_DAY, 0);
		this.date.set(Calendar.MINUTE, 0);
		this.date.set(Calendar.SECOND, 1);
		this.date.set(Calendar.MILLISECOND, 0);
		this.setDaysSinceBase();
		this.open = o;
		this.high = h;
		this.low = l;
		this.close = c;
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
	 * Sets the daily change value.
	 *
	 * net.ajaskey.market.ta.setDailyChg
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
	 * net.ajaskey.market.ta.setDateData
	 *
	 * @param date2
	 */
	public void setDateData(Calendar cal) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param daysSinceBase
	 *          the daysSinceBase to set
	 */
	public void setDaysSinceBase() {
		this.daysSinceBase = Utils.getTimeSpan(this.date, Utils.baseDate);
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

	/**
	 * net.ajaskey.market.ta.setVolume
	 *
	 * @param vol
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
		final String ret = String.format("%s  %.2f  %.2f  %.2f  %.2f %d%n", sDate, this.open, this.high, this.low,
		    this.close, (int) (double) (this.volume));
		return ret.trim();
	}

}
