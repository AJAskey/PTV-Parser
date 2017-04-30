
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
public class DataSet3 {

	/**
	 *
	 * net.ajaskey.market.tools.sipro.add
	 *
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static DataSet3 add(DataSet3 set1, DataSet3 set2) {

		final DataSet3 ds = new DataSet3();
		ds.ticker = "MERGED_TICKERS";
		ds.y7 = set1.y7 + set2.y7;
		ds.y6 = set1.y6 + set2.y6;
		ds.y5 = set1.y5 + set2.y5;
		ds.y4 = set1.y4 + set2.y4;
		ds.y3 = set1.y3 + set2.y3;
		ds.y2 = set1.y2 + set2.y2;
		ds.y1 = set1.y1 + set2.y1;
		ds.ttm = set1.ttm + set2.ttm;
		return ds;
	}

	public static DataSet3 sub(DataSet3 set1, DataSet3 set2) {

		final DataSet3 ds = new DataSet3();
		ds.ticker = "MERGED_TICKERS";
		ds.y7 = set1.y7 - set2.y7;
		ds.y6 = set1.y6 - set2.y6;
		ds.y5 = set1.y5 - set2.y5;
		ds.y4 = set1.y4 - set2.y4;
		ds.y3 = set1.y3 - set2.y3;
		ds.y2 = set1.y2 - set2.y2;
		ds.y1 = set1.y1 - set2.y1;
		ds.ttm = set1.ttm - set2.ttm;
		return ds;
	}

	public static DataSet3 mult(DataSet3 set1, DataSet3 set2) {

		final DataSet3 ds = new DataSet3();
		ds.ticker = "MERGED_TICKERS";
		ds.y7 = set1.y7 * set2.y7;
		ds.y6 = set1.y6 * set2.y6;
		ds.y5 = set1.y5 * set2.y5;
		ds.y4 = set1.y4 * set2.y4;
		ds.y3 = set1.y3 * set2.y3;
		ds.y2 = set1.y2 * set2.y2;
		ds.y1 = set1.y1 * set2.y1;
		ds.ttm = set1.ttm * set2.ttm;
		return ds;
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.sum
	 *
	 * @param data
	 * @return
	 */
	public static DataSet3 sum(List<DataSet3> data) {

		final DataSet3 ret = new DataSet3();
		if (data.size() > 0) {
			ret.ticker = "SUMMATION";
			for (final DataSet3 ds : data) {
				ret.y7 += ds.y7;
				ret.y6 += ds.y6;
				ret.y5 += ds.y5;
				ret.y4 += ds.y4;
				ret.y3 += ds.y3;
				ret.y2 += ds.y2;
				ret.y1 += ds.y1;
				ret.ttm += ds.ttm;
			}
		}
		return ret;

	}

	public String	ticker;
	public double	y7;
	public double	y6;
	public double	y5;
	public double	y4;
	public double	y3;
	public double	y2;
	public double	y1;
	public double	ttm;
	public String	name;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	private DataSet3() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataSet3(String n) {
		this.ticker = "";
		this.y7 = 0;
		this.y6 = 0;
		this.y5 = 0;
		this.y4 = 0;
		this.y3 = 0;
		this.y2 = 0;
		this.y1 = 0;
		this.ttm = 0;
		this.name = n;
	}

	public DataSet3(double scaler) {
		this.ticker = "";
		this.y7 = scaler;
		this.y6 = scaler;
		this.y5 = scaler;
		this.y4 = scaler;
		this.y3 = scaler;
		this.y2 = scaler;
		this.y1 = scaler;
		this.ttm = scaler;
	}

	public DataSet3(String name, String code, String[] s, int ptr) {
		this.ticker = code.trim();
		this.y7 = this.getDouble(s[ptr + 1].trim());
		this.y6 = this.getDouble(s[ptr + 2].trim());
		this.y5 = this.getDouble(s[ptr + 3].trim());
		this.y4 = this.getDouble(s[ptr + 4].trim());
		this.y3 = this.getDouble(s[ptr + 5].trim());
		this.y2 = this.getDouble(s[ptr + 6].trim());
		this.y1 = this.getDouble(s[ptr + 7].trim());
		this.ttm = this.getDouble(s[ptr + 8].trim());
		if (this.ttm == 0.0) {
			this.ttm = this.y1;
		}
		this.name = name.trim();
	}

	public DataSet3(String name, String code, String[] s, int ptr, String mode) {
		this.ticker = code.trim();
		this.y7 = this.getDouble(s[ptr + 1].trim());
		this.y6 = this.getDouble(s[ptr + 2].trim());
		this.y5 = this.getDouble(s[ptr + 3].trim());
		this.y4 = this.getDouble(s[ptr + 4].trim());
		this.y3 = this.getDouble(s[ptr + 5].trim());
		this.y2 = this.getDouble(s[ptr + 6].trim());
		double q8 = this.getDouble(s[ptr + 7].trim());
		double q7 = this.getDouble(s[ptr + 8].trim());
		double q6 = this.getDouble(s[ptr + 9].trim());
		double q5 = this.getDouble(s[ptr + 10].trim());
		double q4 = this.getDouble(s[ptr + 11].trim());
		double q3 = this.getDouble(s[ptr + 12].trim());
		double q2 = this.getDouble(s[ptr + 13].trim());
		double q1 = this.getDouble(s[ptr + 14].trim());

		this.y1 = q5 + q6 + q7 + q8;
		if (q1 == 0.0) {
			this.ttm = q2 + q3 + q4 + q5;
		} else {
			this.ttm = q1 + q2 + q3 + q4;
		}
		this.name = name.trim();
	}

	/**
	 *
	 * net.ajaskey.market.tools.sipro.getDouble
	 *
	 * @param s
	 * @return
	 */
	private double getDouble(String s) {

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
