
package net.ajaskey.market.tools.SIP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
public class QuarterlyData {

	final private static String	NL		= "\n";
	final private static String	TAB		= "\t";
	final private static String	TAB2	= "\t\t";

	public static Map<String, Integer> colPos = new HashMap<>();

	/**
	 *
	 * net.ajaskey.market.tools.SIP.init
	 *
	 */
	public static void init() {

		int pos = 5;
		colPos.put("cash", pos);
		pos += 8;
		colPos.put("stInvestments", pos);
		pos += 8;
		colPos.put("acctReceiveable", pos);
		pos += 8;
		colPos.put("inventory", pos);
		pos += 8;
		colPos.put("otherAssets", pos);
		pos += 8;
		colPos.put("currentAssets", pos);
		pos += 8;
		colPos.put("fixedAssets", pos);
		pos += 8;
		colPos.put("ltInvestments", pos);
		pos += 8;
		colPos.put("goodwill", pos);
		pos += 8;
		colPos.put("otherLtAssets", pos);
		pos += 8;
		colPos.put("totalAssets", pos);
		pos += 8;
		colPos.put("acctPayable", pos);
		pos += 8;
		colPos.put("stDebt", pos);
		pos += 8;
		colPos.put("otherCurrLiab", pos);
		pos += 8;
		colPos.put("currLiab", pos);
		pos += 8;
		colPos.put("ltDebt", pos);
		pos += 8;
		colPos.put("otherLtLiab", pos);
		pos += 8;
		colPos.put("totalLiab", pos);
		pos += 8;
		colPos.put("prefStock", pos);
		pos += 8;
		colPos.put("equity", pos);
		pos += 8;
		colPos.put("liabEquity", pos);
		pos += 8;
		colPos.put("bvps", pos);
		pos += 8;

	}

	/**
	 * net.ajaskey.market.tools.SIP.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		QuarterlyData.init();

		try (BufferedReader reader = new BufferedReader(new FileReader("data/SP500-BALANCESHEETQTR.TXT"))) {

			String line = reader.readLine(); //header line

			while ((line = reader.readLine()) != null) {
				final String str = line.trim().replaceAll("\"", "").replaceAll("[MN] - ", "");
				if (str.length() > 1) {
					//System.out.println(str);
					final String fld[] = str.split(TAB);
					final QuarterlyData qd = new QuarterlyData("cash");
					qd.parse(fld);

					System.out.println(qd);
				}

			}
		}

		final QuarterlyData qd = new QuarterlyData("cash");
		System.out.println(qd);

	}

	public String	type;
	public int		pos;
	public double	q8;
	public double	q7;
	public double	q6;
	public double	q5;
	public double	q4;
	public double	q3;
	public double	q2;
	public double	q1;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param string
	 */
	public QuarterlyData(String t) {

		this.type = t;
		this.pos = colPos.get(t);
		this.initData();
	}

	/**
	 * 
	 * net.ajaskey.market.tools.SIP.initData
	 *
	 */
	private void initData() {

		this.q8 = 0.0;
		this.q7 = 0.0;
		this.q6 = 0.0;
		this.q5 = 0.0;
		this.q4 = 0.0;
		this.q3 = 0.0;
		this.q2 = 0.0;
		this.q1 = 0.0;
	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.parse
	 *
	 * @param fld
	 */
	public void parse(String fld[]) {

		try {
			int pos = colPos.get(this.type);
			this.q1 = this.parseDouble(fld[pos++]);
			this.q2 = this.parseDouble(fld[pos++]);
			this.q3 = this.parseDouble(fld[pos++]);
			this.q4 = this.parseDouble(fld[pos++]);
			this.q5 = this.parseDouble(fld[pos++]);
			this.q6 = this.parseDouble(fld[pos++]);
			this.q7 = this.parseDouble(fld[pos++]);
			this.q8 = this.parseDouble(fld[pos++]);

		} catch (final Exception e) {
			this.initData();
		}
	}

	/**
	 * net.ajaskey.market.tools.SIP.parseDouble
	 *
	 * @param string
	 * @return
	 */
	private double parseDouble(String fld) {

		try {
			double d = Double.parseDouble(fld);
			if (d < 0.0001) {
				d = 0.0;
			}
			return d;
		} catch (final Exception e) {
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = this.type + NL;
		ret += TAB2 + "Q1" + TAB + this.q1 + NL;
		ret += TAB2 + "Q2" + TAB + this.q2 + NL;
		ret += TAB2 + "Q3" + TAB + this.q3 + NL;
		ret += TAB2 + "Q4" + TAB + this.q4 + NL;
		ret += TAB2 + "Q5" + TAB + this.q5 + NL;
		ret += TAB2 + "Q6" + TAB + this.q6 + NL;
		ret += TAB2 + "Q7" + TAB + this.q7 + NL;
		ret += TAB2 + "Q8" + TAB + this.q8 + NL;
		return ret;
	}

}
