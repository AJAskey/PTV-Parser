
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
public class DataSet {

	public String	ticker;
	public double	y8;
	public double	y7;
	public double	y6;
	public double	y5;
	public double	y4;
	public double	y3;
	public double	y2;
	public double	y1;
	public double	ttm;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataSet(String symbol, String sy8, String sy7, String sy6, String sy5, String sy4, String sy3, String sy2,
	    String sy1, String sttm) {
		ticker = symbol.trim();
		y8 = getDouble(sy8);
		y7 = getDouble(sy7);
		y6 = getDouble(sy6);
		y5 = getDouble(sy5);
		y4 = getDouble(sy4);
		y3 = getDouble(sy3);
		y2 = getDouble(sy2);
		y1 = getDouble(sy1);
		ttm = getDouble(sttm);
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataSet() {
		ticker = "";
		y8 = 0;
		y7 = 0;
		y6 = 0;
		y5 = 0;
		y4 = 0;
		y3 = 0;
		y2 = 0;
		y1 = 0;
		ttm = 0;
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param s
	 */
	public DataSet(String[] s) {
		ticker = s[0].trim();
		y8 = getDouble(s[1]);
		y7 = getDouble(s[2]);
		y6 = getDouble(s[3]);
		y5 = getDouble(s[4]);
		y4 = getDouble(s[5]);
		y3 = getDouble(s[6]);
		y2 = getDouble(s[7]);
		y1 = getDouble(s[8]);
		ttm = getDouble(s[9]);
	}

	/**
	 * 
	 * net.ajaskey.market.tools.sipro.add
	 *
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static DataSet add(DataSet set1, DataSet set2) {

		DataSet ds = new DataSet();
		ds.ticker = "MERGED_TICKERS";
		ds.y8 = set1.y8 + set2.y8;
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

	public static DataSet sub(DataSet set1, DataSet set2) {

		DataSet ds = new DataSet();
		ds.ticker = "MERGED_TICKERS";
		ds.y8 = set1.y8 - set2.y8;
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

	/**
	 * 
	 * net.ajaskey.market.tools.sipro.sum
	 *
	 * @param data
	 * @return
	 */
	public static DataSet sum(List<DataSet> data) {

		DataSet ret = new DataSet();
		if (data.size() > 0) {
			ret.ticker = "SUMMATION";
			for (DataSet ds : data) {
				ret.y8 += ds.y8;
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

	public double getDouble(String s) {

		double d = 0;
		try {
			d = Double.parseDouble(s.trim());
		} catch (Exception e) {
			d = 0;
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
