
package net.ajaskey.market.tools.bigo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import net.ajaskey.market.misc.Utils;

/**
 * This class...
 *
 * @author Andy <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
 *         reserved. </p> <p> Permission is hereby granted, free of charge, to
 *         any person obtaining a copy of this software and associated
 *         documentation files (the "Software"), to deal in the Software without
 *         restriction, including without limitation the rights to use, copy,
 *         modify, merge, publish, distribute, sublicense, and/or sell copies of
 *         the Software, and to permit persons to whom the Software is furnished
 *         to do so, subject to the following conditions:
 *
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software. </p>
 *
 *         <p> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE. </p>
 *
 */
public class SeriesData {

	public Calendar	date;
	public double		value;

	public double	mean;
	public double	median;
	public double	stddev;
	public double	min;
	public double	max;

	public double	delta;
	public double	score;

	public List<Percentiles> perc = null;

	public long knt;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param cal
	 * @param d
	 */
	public SeriesData(final Calendar cal, final double d) {

		this.date = Utils.buildCalendar(cal);
		this.value = d;
		this.mean = 0.0;
		this.median = 0.0;
		this.stddev = 0.0;
		this.min = 0.0;
		this.max = 0.0;
		this.delta = 0.0;
		this.score = 0.0;
		this.perc = new ArrayList<>();
		this.knt = 0;
	}

	/**
	 *
	 * net.ajaskey.market.tools.bigo.getPerctile
	 *
	 * @return
	 */
	public double getScore() {

		double ret = 100.0;
		Percentiles prev = null;
		for (final Percentiles p : this.perc) {
			if (this.value == p.value) {
				ret = p.percentile;
				break;
			}
			else if (this.value < p.value) {
				if (prev == null) {
					ret = this.perc.get(0).percentile;
					break;
				}
				else {
					final double rng1 = this.value - prev.value;
					final double rng = p.value - prev.value;
					final double amt = rng1 / rng;
					ret = prev.percentile + amt;
					break;
				}
			}
			prev = p;
		}
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.bigo.setStats
	 *
	 * @param ds
	 * @param direction
	 *
	 */
	public void setStats(final DescriptiveStatistics ds, final BigO.Direction direction) {

		this.mean = ds.getMean();
		this.median = ds.getPercentile(50.0);
		this.stddev = ds.getStandardDeviation();
		this.min = ds.getMin();
		this.max = ds.getMax();

		if (this.stddev > 0.0) {
			final double d = this.value - this.mean;
			this.delta = d / this.stddev;
		}

		for (int i = 1; i < 101; i++) {
			final double p = ds.getPercentile(i);
			int pct = i;
			if (direction == BigO.Direction.REVERSE) {
				pct = i - 101;
			}
			final Percentiles pt = new Percentiles(Math.abs(pct), p);
			this.perc.add(pt);
		}

		this.score = this.getScore();

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = Utils.stringDate(this.date) + "\t" + this.value + "\t" + this.knt;
		if (this.mean > 0) {
			ret += "\n";
			ret += String.format("  Mean   : %.1f%n", this.mean);
			ret += String.format("  Median : %.1f%n", this.median);
			ret += String.format("  StdDev : %.1f%n", this.stddev);
			ret += String.format("  Min    : %.1f%n", this.min);
			ret += String.format("  Max    : %.1f%n", this.max);
			for (final Percentiles p : this.perc) {
				ret += String.format("  %s%n", p);
			}
			ret += String.format("  Score  : %.2f%n", this.score);

		}
		return ret;
	}
}
