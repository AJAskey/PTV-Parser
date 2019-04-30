
package net.ajaskey.market.tools.sipro.v5;

import java.util.List;

/**
 * This class...
 *
 * @author aja <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class DataSet5 {

	public enum dMode {
		NONE, ACCUMULATION, SEQUENTIAL
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.add
	 *
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static DataSet5 add(final DataSet5 set1, final DataSet5 set2) {

		final DataSet5 ds = new DataSet5(set1.name, 0);
		ds.ticker = "MERGED_TICKERS";
		ds.y7 = set1.y7 + set2.y7;
		ds.y6 = set1.y6 + set2.y6;
		ds.y5 = set1.y5 + set2.y5;
		ds.y4 = set1.y4 + set2.y4;
		ds.y3 = set1.y3 + set2.y3;
		ds.y2 = set1.y2 + set2.y2;
		ds.y1 = set1.y1 + set2.y1;
		ds.y0 = set1.y0 + set2.y0;
		ds.q8 = set1.q8 + set2.q8;
		ds.q7 = set1.q7 + set2.q7;
		ds.q6 = set1.q6 + set2.q6;
		ds.q5 = set1.q5 + set2.q5;
		ds.q4 = set1.q4 + set2.q4;
		ds.q3 = set1.q3 + set2.q3;
		ds.q2 = set1.q2 + set2.q2;
		ds.q1 = set1.q1 + set2.q1;
		ds.mode = set1.mode;

		return ds;
	}

	public static DataSet5 div(final DataSet5 num, final DataSet5 div) {

		final DataSet5 ds = new DataSet5(num.name, 0);
		if (div.ticker.equals("SCALED")) {
			ds.ticker = num.ticker;
		}
		else {
			ds.ticker = "MERGED_TICKERS";
		}
		ds.index = num.index;
		ds.y7 = DataSet5.divide(num.y7, div.y7);
		ds.y6 = DataSet5.divide(num.y6, div.y6);
		ds.y5 = DataSet5.divide(num.y5, div.y5);
		ds.y4 = DataSet5.divide(num.y4, div.y4);
		ds.y3 = DataSet5.divide(num.y3, div.y3);
		ds.y2 = DataSet5.divide(num.y2, div.y2);
		ds.y1 = DataSet5.divide(num.y1, div.y1);
		ds.y0 = DataSet5.divide(num.y0, div.y0);
		ds.q8 = DataSet5.divide(num.q8, div.q8);
		ds.q7 = DataSet5.divide(num.q7, div.q7);
		ds.q6 = DataSet5.divide(num.q6, div.q6);
		ds.q5 = DataSet5.divide(num.q5, div.q5);
		ds.q4 = DataSet5.divide(num.q4, div.q4);
		ds.q3 = DataSet5.divide(num.q3, div.q3);
		ds.q2 = DataSet5.divide(num.q2, div.q2);
		ds.q1 = DataSet5.divide(num.q1, div.q1);
		ds.mode = num.mode;
		return ds;
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.v4.divide
	 *
	 * @param num
	 * @param div
	 * @return
	 */
	private static double divide(final double num, final double div) {

		double ret = 0;
		try {
			ret = num / div;
		} catch (final Exception e) {
			ret = 0.0;
		}
		return ret;
	}

	public static DataSet5 mult(final DataSet5 set1, final DataSet5 set2) {

		final DataSet5 ds = new DataSet5(set1.name, 0);
		if (set2.ticker.equals("SCALED")) {
			ds.ticker = set1.ticker;
		}
		else {
			ds.ticker = "MERGED_TICKERS";
		}
		ds.index = set1.index;
		ds.y7 = set1.y7 * set2.y7;
		ds.y6 = set1.y6 * set2.y6;
		ds.y5 = set1.y5 * set2.y5;
		ds.y4 = set1.y4 * set2.y4;
		ds.y3 = set1.y3 * set2.y3;
		ds.y2 = set1.y2 * set2.y2;
		ds.y1 = set1.y1 * set2.y1;
		ds.y0 = set1.y0 * set2.y0;
		ds.q8 = set1.q8 * set2.q8;
		ds.q7 = set1.q7 * set2.q7;
		ds.q6 = set1.q6 * set2.q6;
		ds.q5 = set1.q5 * set2.q5;
		ds.q4 = set1.q4 * set2.q4;
		ds.q3 = set1.q3 * set2.q3;
		ds.q2 = set1.q2 * set2.q2;
		ds.q1 = set1.q1 * set2.q1;
		ds.mode = set1.mode;
		return ds;
	}

	/**
	 * net.ajaskey.market.tools.sipro.v4.ratio
	 *
	 * @param totIncome
	 * @param totEquity
	 * @return
	 */
	public static DataSet5 ratio(final DataSet5 num, final DataSet5 div) {

		final DataSet5 ds = new DataSet5(num.name, 0);
		if (div.ticker.equals("SCALED")) {
			ds.ticker = num.ticker;
		}
		else {
			ds.ticker = "MERGED_TICKERS";
		}
		ds.index = num.index;
		ds.y7 = DataSet5.divide(num.y7, div.y7);
		ds.y6 = DataSet5.divide(num.y6, div.y6);
		ds.y5 = DataSet5.divide(num.y5, div.y5);
		ds.y4 = DataSet5.divide(num.y4, div.y4);
		ds.y3 = DataSet5.divide(num.y3, div.y3);
		ds.y2 = DataSet5.divide(num.y2, div.y2);
		ds.y1 = DataSet5.divide(num.y1, div.y1);
		ds.y0 = DataSet5.divide(num.y0, div.y0);
		ds.q8 = ds.y1;
		ds.q7 = ds.y1;
		ds.q6 = ds.y1;
		ds.q5 = ds.y1;
		ds.q4 = ds.y0;
		ds.q3 = ds.y0;
		ds.q2 = ds.y0;
		ds.q1 = ds.y0;
		ds.mode = DataSet5.dMode.SEQUENTIAL;
		return ds;
	}

	/**
	 * net.ajaskey.market.tools.sipro.scale
	 *
	 * @param shr
	 * @param d
	 * @return
	 */
	public static DataSet5 scale(final DataSet5 val, final double scaler) {

		final DataSet5 ds = DataSet5.scaleSet(scaler);
		return DataSet5.mult(val, ds);
	}

	public static DataSet5 scaleSet(final double scaler) {

		final DataSet5 ret = new DataSet5("SCALE", scaler);
		ret.ticker = "SCALED";
		ret.index = "";

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.v4.sub
	 *
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static DataSet5 sub(final DataSet5 set1, final DataSet5 set2) {

		final DataSet5 ds = new DataSet5("SUBTRACT", 0);
		ds.ticker = "MERGED_TICKERS";
		ds.y7 = set1.y7 - set2.y7;
		ds.y6 = set1.y6 - set2.y6;
		ds.y5 = set1.y5 - set2.y5;
		ds.y4 = set1.y4 - set2.y4;
		ds.y3 = set1.y3 - set2.y3;
		ds.y2 = set1.y2 - set2.y2;
		ds.y1 = set1.y1 - set2.y1;
		ds.y0 = set1.y0 - set2.y0;
		ds.q8 = set1.q8 - set2.q8;
		ds.q7 = set1.q7 - set2.q7;
		ds.q6 = set1.q6 - set2.q6;
		ds.q5 = set1.q5 - set2.q5;
		ds.q4 = set1.q4 - set2.q4;
		ds.q3 = set1.q3 - set2.q3;
		ds.q2 = set1.q2 - set2.q2;
		ds.q1 = set1.q1 - set2.q1;
		ds.mode = set1.mode;

		return ds;
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.sum
	 *
	 * @param data
	 * @param index
	 * @return
	 */
	public static DataSet5 sum(final List<DataSet5> data, final String index) {

		if (data.size() > 0) {
			final DataSet5 ret = new DataSet5(data.get(0).name, 0);
			if (data.size() > 0) {
				ret.ticker = "MERGED_TICKERS";
				ret.index = index;
				ret.mode = data.get(0).mode;
				for (final DataSet5 ds : data) {
					if (ds.index.equalsIgnoreCase(index)) {
						ret.y7 += ds.y7;
						ret.y6 += ds.y6;
						ret.y5 += ds.y5;
						ret.y4 += ds.y4;
						ret.y3 += ds.y3;
						ret.y2 += ds.y2;
						ret.y1 += ds.y1;
						ret.y0 += ds.y0;
						ret.q8 += ds.q8;
						ret.q7 += ds.q7;
						ret.q6 += ds.q6;
						ret.q5 += ds.q5;
						ret.q4 += ds.q4;
						ret.q3 += ds.q3;
						ret.q2 += ds.q2;
						ret.q1 += ds.q1;
					}
				}
			}
			return ret;
		}
		else {
			return null;
		}

	}

	public static DataSet5 sum(final List<DataSet5> data, final String index, final String sector) {

		if (data.size() > 0) {
			final DataSet5 ret = new DataSet5(data.get(0).name, 0);
			if (data.size() > 0) {
				ret.ticker = "MERGED_TICKERS";
				ret.index = index;
				ret.mode = data.get(0).mode;
				for (final DataSet5 ds : data) {
					if (ds.index.equalsIgnoreCase(index)) {
						if (ds.sector.equalsIgnoreCase(sector)) {
							ret.y7 += ds.y7;
							ret.y6 += ds.y6;
							ret.y5 += ds.y5;
							ret.y4 += ds.y4;
							ret.y3 += ds.y3;
							ret.y2 += ds.y2;
							ret.y1 += ds.y1;
							ret.y0 += ds.y0;
							ret.q8 += ds.q8;
							ret.q7 += ds.q7;
							ret.q6 += ds.q6;
							ret.q5 += ds.q5;
							ret.q4 += ds.q4;
							ret.q3 += ds.q3;
							ret.q2 += ds.q2;
							ret.q1 += ds.q1;
						}
					}
				}
			}
			return ret;
		}
		else {
			return null;
		}

	}

	public String	ticker;
	public String	index;
	public String	sector;
	public double	y7;
	public double	y6;
	public double	y5;
	public double	y4;
	public double	y3;
	public double	y2;
	public double	y1;
	public double	y0;
	public double	q8;
	public double	q7;
	public double	q6;
	public double	q5;
	public double	q4;
	public double	q3;
	public double	q2;
	public double	q1;

	public String	name;
	public dMode	mode;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param totEps
	 */
	public DataSet5(final DataSet5 ds) {

		this.y7 = ds.y7;
		this.y6 = ds.y6;
		this.y5 = ds.y5;
		this.y4 = ds.y4;
		this.y3 = ds.y3;
		this.y2 = ds.y2;
		this.y1 = ds.y1;
		this.y0 = ds.y0;
		this.q8 = ds.q8;
		this.q7 = ds.q7;
		this.q6 = ds.q6;
		this.q5 = ds.q5;
		this.q4 = ds.q4;
		this.q3 = ds.q3;
		this.q2 = ds.q2;
		this.q1 = ds.q1;
		this.index = ds.index;
		this.mode = ds.mode;
		this.name = ds.name;
		this.ticker = ds.ticker;
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param dates
	 */
	public DataSet5(final DateSet dates, final String idx) {

		this.y7 = dates.y7.q4.value;
		this.y6 = dates.y6.q4.value;
		this.y5 = dates.y5.q4.value;
		this.y4 = dates.y4.q4.value;
		this.y3 = dates.y3.q4.value;
		this.y2 = dates.y2.q4.value;
		this.y1 = dates.y0.q4.value;
		this.y0 = dates.y0.q4.value;
		this.q8 = dates.y1.q1.value;
		this.q7 = dates.y1.q2.value;
		this.q6 = dates.y1.q3.value;
		this.q5 = dates.y1.q4.value;
		this.q4 = dates.y0.q1.value;
		this.q3 = dates.y0.q2.value;
		this.q2 = dates.y0.q3.value;
		this.q1 = dates.y0.q4.value;
		this.index = idx;
		this.mode = DataSet5.dMode.NONE;
		this.name = "Date Set Prices";
		this.ticker = "None";
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataSet5(final String n, final double val) {

		this.init(n, val);
	}

	public DataSet5(final String index, final String name, final String code, final String sector, final String[] s, final int ptr,
	    final dMode mode) {

		this.init(name, 0);
		this.index = index.trim();
		this.ticker = code.trim();
		this.sector = sector.trim();
		this.y7 = this.getDouble(s[ptr + 1].trim());
		this.y6 = this.getDouble(s[ptr + 2].trim());
		this.y5 = this.getDouble(s[ptr + 3].trim());
		this.y4 = this.getDouble(s[ptr + 4].trim());
		this.y3 = this.getDouble(s[ptr + 5].trim());
		this.y2 = this.getDouble(s[ptr + 6].trim());
		this.q8 = this.getDouble(s[ptr + 7].trim());
		this.q7 = this.getDouble(s[ptr + 8].trim());
		this.q6 = this.getDouble(s[ptr + 9].trim());
		this.q5 = this.getDouble(s[ptr + 10].trim());
		this.q4 = this.getDouble(s[ptr + 11].trim());
		this.q3 = this.getDouble(s[ptr + 12].trim());
		this.q2 = this.getDouble(s[ptr + 13].trim());
		this.q1 = this.getDouble(s[ptr + 14].trim());
		this.mode = mode;

		//		System.out.print(name + " - " + ptr + " :");
		//		for (int i = ptr + 1; i < ptr + 15; i++) {
		//			System.out.print("  " + s[i]);
		//		}
		//		System.out.println("\n" + this);

		// Handle no value for most recent quarter
		if (mode == dMode.ACCUMULATION) {
			if (this.q1 == 0.0) {
				if (this.q5 != 0.0) {
					this.q1 = this.q5;
				}
				else if (this.q2 != 0.0) {
					this.q1 = this.q2;
				}
				else if (this.q3 != 0.0) {
					this.q1 = this.q3;
				}
				else {
					this.q1 = this.q2;
				}
				if (this.q2 == 0.0) {
					this.q2 = this.q1;
				}
				if (this.q3 == 0.0) {
					this.q3 = this.q1;
				}

			}
			this.y1 = this.q8 + this.q7 + this.q6 + this.q5;
			this.y0 = this.q4 + this.q3 + this.q2 + this.q1;
		}
		else if (mode == dMode.SEQUENTIAL) {
			if (this.q1 == 0.0) {
				if (this.q2 != 0.0) {
					this.q1 = this.q2;
				}
				else if (this.q3 != 0.0) {
					this.q1 = this.q3;
				}
				else if (this.q4 != 0.0) {
					this.q1 = this.q4;
				}
			}
			this.y1 = this.q5;
			this.y0 = this.q1;
		}

		//System.out.println(this);
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.getDouble
	 *
	 * @param s
	 * @return
	 */
	private double getDouble(final String s) {

		double d = 0.0;
		try {
			d = Double.parseDouble(s.trim());
			if (d < -999999.990) {
				//System.out.println(d);
				d = 0.0;
			}
		} catch (final Exception e) {
			d = 0.0;
		}
		return d;
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.v4.init
	 *
	 * @param n
	 * @param val
	 */
	private void init(final String n, final double val) {

		this.ticker = "";
		this.sector = "";
		this.index = "";
		this.y7 = val;
		this.y6 = val;
		this.y5 = val;
		this.y4 = val;
		this.y3 = val;
		this.y2 = val;
		this.y1 = val;
		this.y0 = val;
		this.q8 = val;
		this.q7 = val;
		this.q6 = val;
		this.q5 = val;
		this.q4 = val;
		this.q3 = val;
		this.q2 = val;
		this.q1 = val;
		this.name = n;
		this.mode = dMode.NONE;
	}

	@Override
	public String toString() {

		final String ret = this.y7 + " " + this.y6 + " " + this.y5 + " " + this.y4 + " " + this.y3 + " " + this.q8 + " " + this.q7 + " "
		    + this.q6 + " " + this.q5 + " " + this.q4 + " " + this.q3 + " " + this.q2 + " " + this.q1;
		return ret;
	}

}
