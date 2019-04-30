
package net.ajaskey.market.tools.sipro;

import java.lang.reflect.Field;
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
public class DataSet4 {

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
	public static DataSet4 add(final DataSet4 set1, final DataSet4 set2) {

		final DataSet4 ds = new DataSet4();
		ds.ticker = "MERGED_TICKERS";
		ds.y7 = set1.y7 + set2.y7;
		ds.y6 = set1.y6 + set2.y6;
		ds.y5 = set1.y5 + set2.y5;
		ds.y4 = set1.y4 + set2.y4;
		ds.y3 = set1.y3 + set2.y3;
		ds.y2 = set1.y2 + set2.y2;
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

	public static DataSet4 div(final DataSet4 num, final DataSet4 div) {

		final DataSet4 ds = new DataSet4(num.name);
		if (div.ticker.equals("SCALED")) {
			ds.ticker = num.ticker;
		}
		else {
			ds.ticker = "MERGED_TICKERS";
		}
		ds.index = num.index;
		ds.y7 = DataSet4.divide(num.y7, div.y7);
		ds.y6 = DataSet4.divide(num.y6, div.y6);
		ds.y5 = DataSet4.divide(num.y5, div.y5);
		ds.y4 = DataSet4.divide(num.y4, div.y4);
		ds.y3 = DataSet4.divide(num.y3, div.y3);
		ds.y2 = DataSet4.divide(num.y2, div.y2);
		ds.q8 = DataSet4.divide(num.q8, div.q8);
		ds.q7 = DataSet4.divide(num.q7, div.q7);
		ds.q6 = DataSet4.divide(num.q6, div.q6);
		ds.q5 = DataSet4.divide(num.q5, div.q5);
		ds.q4 = DataSet4.divide(num.q4, div.q4);
		ds.q3 = DataSet4.divide(num.q3, div.q3);
		ds.q2 = DataSet4.divide(num.q2, div.q2);
		ds.q1 = DataSet4.divide(num.q1, div.q1);
		ds.mode = num.mode;
		return ds;
	}

	private static double divide(final double num, final double div) {

		double ret = 0;
		try {
			ret = num / div;
		} catch (final Exception e) {
			ret = 0.0;
		}
		return ret;
	}

	public static DataSet4 mult(final DataSet4 set1, final DataSet4 set2) {

		final DataSet4 ds = new DataSet4(set1.name);
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
	 * net.ajaskey.market.tools.sipro.scale
	 *
	 * @param shr
	 * @param d
	 * @return
	 */
	public static DataSet4 scale(final DataSet4 val, final double scaler) {

		final DataSet4 ds = DataSet4.scaleSet(scaler);
		return DataSet4.mult(val, ds);
	}

	public static DataSet4 scaleSet(final double scaler) {

		final DataSet4 ret = new DataSet4("SCALE");
		ret.ticker = "SCALED";
		ret.index = "";
		ret.y7 = scaler;
		ret.y6 = scaler;
		ret.y5 = scaler;
		ret.y4 = scaler;
		ret.y3 = scaler;
		ret.y2 = scaler;
		ret.q8 = scaler;
		ret.q7 = scaler;
		ret.q6 = scaler;
		ret.q5 = scaler;
		ret.q4 = scaler;
		ret.q3 = scaler;
		ret.q2 = scaler;
		ret.q1 = scaler;
		return ret;
	}

	public static DataSet4 sub(final DataSet4 set1, final DataSet4 set2) {

		final DataSet4 ds = new DataSet4("SUBTRACT");
		ds.ticker = "MERGED_TICKERS";
		ds.y7 = set1.y7 - set2.y7;
		ds.y6 = set1.y6 - set2.y6;
		ds.y5 = set1.y5 - set2.y5;
		ds.y4 = set1.y4 - set2.y4;
		ds.y3 = set1.y3 - set2.y3;
		ds.y2 = set1.y2 - set2.y2;
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
	public static DataSet4 sum(final List<DataSet4> data, final String index) {

		if (data.size() > 0) {
			final DataSet4 ret = new DataSet4(data.get(0).name);
			if (data.size() > 0) {
				ret.ticker = "MERGED_TICKERS";
				for (final DataSet4 ds : data) {
					if (ds.index.equalsIgnoreCase(index)) {
						ret.y7 += ds.y7;
						ret.y6 += ds.y6;
						ret.y5 += ds.y5;
						ret.y4 += ds.y4;
						ret.y3 += ds.y3;
						ret.y2 += ds.y2;
						ret.q8 += ds.q8;
						ret.q7 += ds.q7;
						ret.q6 += ds.q6;
						ret.q5 += ds.q5;
						ret.q4 += ds.q4;
						ret.q3 += ds.q3;
						ret.q2 += ds.q2;
						ret.q1 += ds.q1;
						ret.mode = ds.mode;
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
	public double	y7;
	public double	y6;
	public double	y5;
	public double	y4;
	public double	y3;
	public double	y2;
	public double	q8;
	public double	q7;
	public double	q6;
	public double	q5;

	public double q4;

	public double q3;

	public double q2;

	public double q1;

	public String name;

	public dMode mode;

	/**
	 * This constructor should not be called to ensure proper initialization.
	 *
	 * @param prefix
	 * @param dates
	 *
	 */
	private DataSet4() {

		this.init("");
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param totEps
	 */
	public DataSet4(final DataSet4 ds) {

		this.y7 = ds.y7;
		this.y6 = ds.y6;
		this.y5 = ds.y5;
		this.y4 = ds.y4;
		this.y3 = ds.y3;
		this.y2 = ds.y2;
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
	public DataSet4(final DateSet dates, final String idx) {

		this.y7 = dates.y7.q4price;
		this.y6 = dates.y6.q4price;
		this.y5 = dates.y5.q4price;
		this.y4 = dates.y4.q4price;
		this.y3 = dates.y3.q4price;
		this.y2 = dates.y2.q4price;
		this.q8 = dates.y1.q1price;
		this.q7 = dates.y1.q2price;
		this.q6 = dates.y1.q3price;
		this.q5 = dates.y1.q4price;
		this.q4 = dates.y0.q1price;
		this.q3 = dates.y0.q2price;
		this.q2 = dates.y0.q3price;
		this.q1 = dates.y0.q4price;
		this.index = idx;
		this.mode = DataSet4.dMode.NONE;
		this.name = "Date Set Prices";
		this.ticker = "None";

	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataSet4(final String n) {

		this.init(n);
	}

	public DataSet4(final String index, final String name, final String code, final String[] s, final int ptr, final dMode mode) {

		this.init(name);
		this.index = index.trim();
		this.ticker = code.trim();
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

		// Handle no value for most recent quarter
		if (mode == dMode.ACCUMULATION) {
			if (this.q1 == 0.0) {
				this.q1 = this.q5;
			}
		}
		else if (mode == dMode.SEQUENTIAL) {
			if (this.q1 == 0.0) {
				this.q1 = this.q2;
			}
		}
		//this.name = name.trim();
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param name2
	 * @param string
	 * @param string2
	 * @param fld
	 * @param ptr
	 * @param mode2
	 */
	public void DataSet41(final String name, final String code, final String sector, final String[] s, final int ptr, final dMode mode) {

		this.init(name);
		this.ticker = code.trim();
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

		// Handle no value for most recent quarter
		if (mode == dMode.ACCUMULATION) {
			if (this.q1 == 0.0) {
				this.q1 = this.q5;
			}
		}
		else if (mode == dMode.SEQUENTIAL) {
			if (this.q1 == 0.0) {
				this.q1 = this.q2;
			}
		}

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
			if (d < -99999999.0) {
				//System.out.println(d);
				d = 0.0;
			}
		} catch (final Exception e) {
			d = 0.0;
		}
		return d;
	}

	private void init(final String n) {

		this.ticker = "";
		this.y7 = 0;
		this.y6 = 0;
		this.y5 = 0;
		this.y4 = 0;
		this.y3 = 0;
		this.y2 = 0;
		this.q8 = 0;
		this.q7 = 0;
		this.q6 = 0;
		this.q5 = 0;
		this.q4 = 0;
		this.q3 = 0;
		this.q2 = 0;
		this.q1 = 0;
		this.name = n;
		this.mode = dMode.NONE;
	}

	@Override
	public String toString() {

		final StringBuilder result = new StringBuilder();
		final String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" Object {");
		result.append(newLine);

		final Field[] fields = this.getClass().getDeclaredFields();

		for (final Field field : fields) {
			result.append("  ");
			try {
				result.append(field.getName());
				result.append(": ");
				// requires access to private field:
				result.append(field.get(this));
			} catch (final IllegalAccessException ex) {
				System.out.println(ex);
			}
			result.append(newLine);
		}
		result.append("}");

		return result.toString();
	}

}
