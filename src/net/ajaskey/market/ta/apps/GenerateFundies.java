
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.YahooData;

/**
 * This application reads the contents of stock-list.txt and uses Yahoo to find
 * additional data. The data is written to stocks-fundie-list.txt.
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class GenerateFundies {

	static List<GenerateFundies>	fundieList	= new ArrayList<>();
	static List<String>						tickers			= null;

	/**
	 *
	 * net.ajaskey.market.ta.input.getTickers
	 *
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void build() throws FileNotFoundException, IOException {

		tickers = ParseData.getTickerList("lists\\stock-list.txt");
		GenerateFundies.setYahoo();
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.getWithTicker
	 *
	 * @param tkr
	 * @return
	 */
	public static GenerateFundies getWithTicker(String tkr) {

		for (final GenerateFundies f : fundieList) {
			if (f.ticker.equalsIgnoreCase(tkr)) {
				return f;
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		System.out.println("GenerateFundies Processing...");

		GenerateFundies.build();

		try (PrintWriter pw = new PrintWriter("lists\\stock-fundie-list.txt")) {
			for (final GenerateFundies f : fundieList) {
				pw.printf("%-10s\t%-25s\t%-60s\t%12d\t%12s%n", f.ticker, f.sector, f.industry, f.shares, f.marketCap);
			}
		}

		System.out.println("GenerateFundies Done.");
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.setYahoo
	 *
	 */
	private static void setYahoo() {

		for (final String tkr : tickers) {
			final String[] secind = YahooData.getSectorIndustry(tkr);
			final GenerateFundies fundie = new GenerateFundies();
			fundie.ticker = tkr;
			fundie.sector = secind[0].trim();
			fundie.industry = secind[1].trim();
			fundieList.add(fundie);
		}

		final int inc = 250;
		for (int i = 0; i < tickers.size(); i += inc) {
			int last = (i + inc) - 1;
			last = Math.min(tickers.size() - 1, last);
			System.out.printf("Processing Yahoo data for tickers %d to %d%n", i, last);
			final List<String> data = YahooData.get(tickers.subList(i, last), "f6j1");

			for (final String d : data) {
				final String[] fld = d.split(",");
				final GenerateFundies fund = GenerateFundies.getWithTicker(fld[0].trim());
				if (fund != null) {
					try {
						final long shr = Long.parseLong(fld[1].trim());
						fund.shares = shr;
						fund.marketCap = fld[2].trim();
					} catch (final Exception e) {
						fund.shares = 0;
					}
				}
			}
		}
	}

	private String marketCap;

	private String ticker;

	private String sector;

	private String industry;

	private long shares;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public GenerateFundies() {
		this.marketCap = "N/A";
		this.shares = 0;
	}

}
