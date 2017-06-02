
package net.ajaskey.market.ta.methods;

/**
 * This class provides static simple statistical methods.
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
public class UtilMethods {

	/**
	 *
	 * net.ajaskey.market.ta.methods.avgRng
	 *
	 * @param high
	 * @param low
	 * @param days
	 * @return
	 */
	static public double avgRng(double[] high, double[] low, int days) {

		double retVal = 0.0;
		if ((high != null) && (low != null)) {
			if (days <= high.length) {
				for (int i = 0; i < days; i++) {
					retVal += (high[i] - low[i]);
				}
			}
		}
		return retVal / days;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.avgRngPercent
	 *
	 * @param high
	 * @param low
	 * @param days
	 * @return
	 */
	static public double avgRngPercent(double[] high, double[] low, int days) {

		final double ma = UtilMethods.rngAvg(high, low, days);
		double retVal = 0.0;
		if (ma > 0.0) {
			retVal = (UtilMethods.avgRng(high, low, days) / ma) * 100.0;
		}
		return retVal;
	}

	/**
	 * Calculate the percentage change from p2 to p1
	 *
	 * @param p1
	 *          most recent data point
	 * @param p2
	 *          historic data point
	 * @return percentage change
	 */
	static public double calcPercentChange(double p1, double p2) {

		double ret = 0.0;
		try {
			if (p2 != 0.0) {
				ret = (p1 - p2) / p2;
			}
		} catch (final Exception e) {
			ret = 0.0;
		}
		return ret * 100.0;
	}

	/**
	 * Calculate the percentage change from p2 to p1
	 *
	 * @param p1
	 *          most recent data point
	 * @param p2
	 *          historic data point
	 * @return change
	 */
	static public double calcPriceChange(double p1, double p2) {

		return p1 - p2;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.getDataSlice
	 *
	 * @param val
	 * @param start
	 * @param days
	 * @return
	 */
	static public double[] getDataSlice(double[] val, int start, int days) {

		double[] ret = null;
		if (val != null) {
			if ((start + days) <= val.length) {
				ret = new double[days];
				int j = 0;
				for (int i = start; i < (start + days); i++) {
					ret[j++] = val[i];
				}
			}
		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.max
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double max(double[] val, int days) {

		return UtilMethods.max(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.max
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public double max(double[] val, int days, int start) {

		double retVal = 0;
		try {
			retVal = org.apache.commons.math3.stat.StatUtils.max(val, start, days);
		} catch (final Exception e) {
			retVal = 0;
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.max
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public float max(float[] val, int days) {

		return UtilMethods.max(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.max
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public float max(float[] val, int days, int start) {

		float retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (float) UtilMethods.max(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.max
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public int max(int[] val, int days) {

		return UtilMethods.max(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.max
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public int max(int[] val, int days, int start) {

		int retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (int) UtilMethods.max(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.max
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public long max(long[] val, int days) {

		return UtilMethods.max(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.max
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public long max(long[] val, int days, int start) {

		long retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (int) UtilMethods.max(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.min
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double min(double[] val, int days) {

		return UtilMethods.min(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.min
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public double min(double[] val, int days, int start) {

		double retVal = 0;
		try {
			retVal = org.apache.commons.math3.stat.StatUtils.min(val, start, days);
		} catch (final Exception e) {
			retVal = 0;
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.min
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public float min(float[] val, int days) {

		return UtilMethods.min(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.min
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public float min(float[] val, int days, int start) {

		float retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (float) UtilMethods.min(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.min
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public int min(int[] val, int days) {

		return UtilMethods.min(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.min
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public int min(int[] val, int days, int start) {

		int retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (int) UtilMethods.min(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.min
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public long min(long[] val, int days) {

		return UtilMethods.min(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.min
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public long min(long[] val, int days, int start) {

		long retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (int) UtilMethods.min(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.rngMA
	 *
	 * @param high
	 * @param low
	 * @param days
	 * @return
	 */
	static public double rngAvg(double[] high, double[] low, int days) {

		double ma = 0.0;
		final double[] da = new double[high.length];
		if ((high != null) && (low != null)) {
			if (days <= high.length) {
				for (int i = 0; i < days; i++) {
					da[i] = (high[i] + low[i]) / 2.0;
				}
				ma = UtilMethods.sma(da, days);
			}
		}
		return ma;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double sma(double[] val, int days) {

		return UtilMethods.sma(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public double sma(double[] val, int days, int start) {

		double retVal = 0;
		try {
			retVal = org.apache.commons.math3.stat.StatUtils.mean(val, start, days);
		} catch (final Exception e) {
			retVal = 0;
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public float sma(float[] val, int days) {

		return UtilMethods.sma(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public float sma(float[] val, int days, int start) {

		float retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (float) UtilMethods.sma(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public int sma(int[] val, int days) {

		return UtilMethods.sma(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public int sma(int[] val, int days, int start) {

		int retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (int) UtilMethods.sma(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public long sma(long[] val, int days) {

		return UtilMethods.sma(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sma
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public long sma(long[] val, int days, int start) {

		long retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (int) UtilMethods.sma(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sum
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public double sum(double[] val, int days) {

		return UtilMethods.sum(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sum
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public double sum(double[] val, int days, int start) {

		double retVal = 0;
		try {
			retVal = org.apache.commons.math3.stat.StatUtils.sum(val, start, days);
		} catch (final Exception e) {
			retVal = 0;
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sum
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public float sum(float[] val, int days) {

		return UtilMethods.sum(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sum
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public float sum(float[] val, int days, int start) {

		float retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (float) UtilMethods.sum(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sum
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public int sum(int[] val, int days) {

		return UtilMethods.sum(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sum
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public int sum(int[] val, int days, int start) {

		int retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (int) UtilMethods.sum(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sum
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public long sum(long[] val, int days) {

		return UtilMethods.sum(val, days, 0);
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.sum
	 *
	 * @param val
	 * @param days
	 * @return
	 */
	static public long sum(long[] val, int days, int start) {

		long retVal = 0;
		final double[] da = UtilMethods.toDouble(val, days, start);
		if (da != null) {
			retVal = (long) UtilMethods.sum(da, days, 0);
		}
		return retVal;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.toDouble
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public double[] toDouble(float[] val, int days, int start) {

		double[] da = null;
		if (val != null) {
			if ((start + days) <= val.length) {
				da = new double[days];
				int knt = 0;
				for (int i = start; i < (start + days); i++) {
					da[knt++] = val[i];
				}
			}
		}
		return da;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.toDouble
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public double[] toDouble(int[] val, int days, int start) {

		double[] da = null;
		if (val != null) {
			if ((start + days) <= val.length) {
				da = new double[days];
				int knt = 0;
				for (int i = start; i < (start + days); i++) {
					da[knt++] = val[i];
				}
			}
		}
		return da;
	}

	/**
	 *
	 * net.ajaskey.market.ta.methods.toDouble
	 *
	 * @param val
	 * @param days
	 * @param start
	 * @return
	 */
	static public double[] toDouble(long[] val, int days, int start) {

		double[] da = null;
		if (val != null) {
			if ((start + days) <= val.length) {
				da = new double[days];
				int knt = 0;
				for (int i = start; i < (start + days); i++) {
					da[knt++] = val[i];
				}
			}
		}
		return da;

	}

	/**
	 * This method serves as a constructor for the class. Because all methods are
	 * static this constructor is not to be called.
	 *
	 */
	private UtilMethods() {
	}

}
