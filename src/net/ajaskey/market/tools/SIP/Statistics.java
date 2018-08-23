
package net.ajaskey.market.tools.SIP;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Statistics {

	final private static String	NL		= "\n";
	final private static String	TAB		= "\t";
	final private static String	TAB2	= "\t\t";

	/**
	 * net.ajaskey.market.tools.SIP.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final Statistics stats = new Statistics("atest");
		for (double i = -200.0; i < 100.0; i += 1.5) {
			stats.addValue(i);
		}
		for (double i = 1000.0; i < 2000.0; i += .255) {
			stats.addValue(i);
		}
		stats.addValue(5000.0);
		stats.addValue(0.0);

		System.out.println(stats.ds.getMin());
		System.out.println(stats.ds.getMax());
		System.out.println(stats.ds.getStandardDeviation());
		System.out.println(stats.getN());
		System.out.println(stats.getMean());
		System.out.println(stats.getMedian());

	}

	public String name;

	private final DescriptiveStatistics ds;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public Statistics(String n) {

		this.ds = new DescriptiveStatistics();
		this.name = n;
	}

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.addValue
	 *
	 * @param d
	 */
	public void addValue(double d) {

		if (d != 0.0) {
			this.ds.addValue(d);
		}
	}

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.addValues
	 *
	 * @param qd
	 */
	public void addValues(QuarterlyData qd) {

		if (qd.q1 != 0.0) {
			this.ds.addValue(qd.q1);
		}
		if (qd.q2 != 0.0) {
			this.ds.addValue(qd.q2);
		}
		if (qd.q3 != 0.0) {
			this.ds.addValue(qd.q3);
		}
		if (qd.q4 != 0.0) {
			this.ds.addValue(qd.q4);
		}
		if (qd.q5 != 0.0) {
			this.ds.addValue(qd.q5);
		}
		if (qd.q6 != 0.0) {
			this.ds.addValue(qd.q6);
		}
		if (qd.q7 != 0.0) {
			this.ds.addValue(qd.q7);
		}
		if (qd.q8 != 0.0) {
			this.ds.addValue(qd.q8);
		}
	}

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.getMax
	 *
	 * @return
	 */
	public double getMax() {

		return this.ds.getMax();
	}

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.getMean
	 *
	 * @return
	 */
	public double getMean() {

		return this.ds.getMean();
	}

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.getMedian
	 *
	 * @return
	 */
	public double getMedian() {

		return this.ds.getPercentile(50);
	}

	public double get25Percentile() {

		return this.ds.getPercentile(25);
	}

	public double get75Percentile() {

		return this.ds.getPercentile(75);
	}

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.getMin
	 *
	 * @return
	 */
	public double getMin() {

		return this.ds.getMin();
	}

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.getN
	 *
	 * @return
	 */
	public long getN() {

		return this.ds.getN();
	}

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.getStdDev
	 *
	 * @return
	 */
	public double getStdDev() {

		return this.ds.getStandardDeviation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = "Stats for " + this.name + NL;
		ret += TAB + "Count  : " + this.getN() + NL;
		ret += TAB + "Mean   : " + QuarterlyData.fmt(this.getMean()) + NL;
		ret += TAB + "StdDev : " + QuarterlyData.fmt(this.getStdDev()) + NL;
		ret += TAB + "Min    : " + QuarterlyData.fmt(this.getMin()) + NL;
		ret += TAB + "25 Per : " + QuarterlyData.fmt(this.get25Percentile()) + NL;
		ret += TAB + "Median : " + QuarterlyData.fmt(this.getMedian()) + NL;
		ret += TAB + "75 Per : " + QuarterlyData.fmt(this.get75Percentile()) + NL;
		ret += TAB + "Max    : " + QuarterlyData.fmt(this.getMax()) + NL;
		return ret;
	}
}
