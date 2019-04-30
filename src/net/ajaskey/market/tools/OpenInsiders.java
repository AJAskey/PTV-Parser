
package net.ajaskey.market.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import net.ajaskey.market.misc.Utils;

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
public class OpenInsiders {

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(final String[] args) throws FileNotFoundException, IOException {

		final Calendar cal = Calendar.getInstance();

		final int d = cal.get(Calendar.DAY_OF_YEAR) + 1;

		final int days = d;
		final int minDollar = 10;
		final int page = 1;

		new OpenInsiders("data/SP-Stocks.txt", days, minDollar, page, "out/1.html");

	}

	private String		resp;
	private String		tickers;
	private final int	days;
	private final int	minDollar;

	private int page;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public OpenInsiders(final String t, final int d, final int md, final int p, final String outfile) {

		try {
			this.tickers = this.getTickers(t);
		} catch (final IOException e) {
			this.tickers = "";
		}
		this.days = d;
		this.minDollar = md;
		this.page = p;
		this.get(outfile);
	}

	private void get(final String outfile) {

		final String url = "http://openinsider.com/screener?s=" + this.tickers + "&o=&pl=&ph=&ll=&lh=&fd=0&fdr=&td=" + this.days
		    + "&tdr=&fdlyl=&fdlyh=&daysago=&xp=1&xs=1&excludeDerivRelated=1&vl=" + this.minDollar
		    + "&vh=&ocl=&och=&sic1=-1&sicl=100&sich=9999&isofficer=1" + "&iscob=1&isceo=1&ispres=1&iscoo=1&iscfo=1&isgc=1&isvp=1&grp=0"
		    + "&nfl=&nfh=&nil=&nih=&nol=&noh=&v2l=&v2h=&oc2l=&oc2h=&sortcol=1&cnt=5000&page=" + this.page;

		try (PrintWriter pw = new PrintWriter(outfile)) {

			System.out.println("Processing : " + url);

			this.resp = Utils.getFromUrl(url);
			pw.println(this.resp);

		} catch (final Exception e) {
			System.out.println("No response received.");
		}
	}

	public void getNextPage(final String outfile) {

		this.page++;
		this.get(outfile);
	}

	public String getResponse() {

		return this.resp;
	}

	private String getTickers(final String listName) throws FileNotFoundException, IOException {

		final TickerNames tn = new TickerNames(listName, "500");
		return tn.get();
	}

}
