
package net.ajaskey.market.tools.SIP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
public class CashData {

	final private static String TAB = "\t";

	/**
	 * net.ajaskey.market.tools.SIP.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		QuarterlyData.init();

		try (BufferedReader reader = new BufferedReader(new FileReader("data/US-STOCKS-CASH.TXT"))) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				final String str = line.replaceAll("\"", "").trim();
				if (str.length() > 1) {

					//System.out.println(str);
					final String fld[] = str.split(TAB);

					final CashData cashData = CashData.setCashDataInfo(fld);
					System.out.println(fld[0]);
					System.out.println(cashData);
				}
			}
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.setCashDataInfo
	 *
	 * @param fld
	 * @return
	 */
	public static CashData setCashDataInfo(String[] fld) {

		final CashData cashData = new CashData();

		cashData.capEx.parse(fld);
		cashData.cashFromFin.parse(fld);
		cashData.cashFromInv.parse(fld);
		cashData.cashFromOps.parse(fld);

		return cashData;

	}

	public QuarterlyData	capEx;
	public QuarterlyData	cashFromOps;

	public QuarterlyData cashFromFin;

	public QuarterlyData cashFromInv;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public CashData() {

		this.capEx = new QuarterlyData("capEx");
		this.cashFromOps = new QuarterlyData("cashFromOps");
		this.cashFromFin = new QuarterlyData("cashFromFin");
		this.cashFromInv = new QuarterlyData("cashFromInv");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = "";
		ret += TAB + this.capEx;
		ret += TAB + this.cashFromOps;
		ret += TAB + this.cashFromFin;
		ret += TAB + this.cashFromInv;
		return ret;
	}

}
