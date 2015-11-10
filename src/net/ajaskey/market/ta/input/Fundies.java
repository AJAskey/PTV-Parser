
package net.ajaskey.market.ta.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
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
public class Fundies {

	static List<Fundies>	fundieList	= new ArrayList<>();
	static List<String>		tickers			= new ArrayList<>();
	private String				ticker;
	private String				sector;
	private String				exchange;

	private String				industry;

	private long					shares;

	/**
	 *
	 * net.ajaskey.market.ta.input.build
	 *
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void build() throws FileNotFoundException, IOException {
		Fundies.getTickers();
		Fundies.setYahoo();
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

		Fundies.build();

		try (PrintWriter pw = new PrintWriter("lists\\stock-fundie-list.txt")) {
			for (final Fundies f : fundieList) {
				pw.printf("%-10s\t%-25s\t%-60s\t%12d%n", f.ticker, f.sector, f.industry, f.shares);
			}
		}

		System.out.println("Done.");
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.getTickers
	 *
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void getTickers() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("lists\\stock-list.txt"))) {
			String line = br.readLine();
			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.trim().length() > 10)) {
					final String[] flds = line.split("\t");
					tickers.add(flds[0].trim().toUpperCase());
				}
			}
		}
	}

	/**
	 * net.ajaskey.market.ta.input.getWithTicker
	 *
	 * @param trim
	 * @return
	 */
	private static Fundies getWithTicker(String tkr) {
		for (final Fundies f : fundieList) {
			if (f.ticker.equalsIgnoreCase(tkr)) {
				return f;
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.setYahoo
	 *
	 */
	private static void setYahoo() {

		for (final String tkr : tickers) {
			final String[] secind = YahooData.getSectorIndustry(tkr);
			final Fundies fundie = new Fundies();
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
			final List<String> data = YahooData.get(tickers.subList(i, last), "f6");

			for (final String d : data) {
				final String[] fld = d.split(",");
				final Fundies fund = Fundies.getWithTicker(fld[0].trim());
				long shr = 0;
				if (fund != null) {
					try {
						shr = Long.parseLong(fld[1].trim());
					} catch (final Exception e) {
						shr = 0;
					}
					if (shr > 0) {
						fund.shares = shr;
					}
				}
			}
		}
	}

	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return this.industry;
	}

	/**
	 * @return the sector
	 */
	public String getSector() {
		return this.sector;
	}

	/**
	 * @return the shares
	 */
	public long getShares() {
		return this.shares;
	}

	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return this.ticker;
	}

	/**
	 * @param industry
	 *          the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * @param sector
	 *          the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * @param shares
	 *          the shares to set
	 */
	public void setShares(long shares) {
		this.shares = shares;
	}

	/**
	 * @param ticker
	 *          the ticker to set
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	/**
	 * @return the exchange
	 */
	public String getExchange() {
		return exchange;
	}

	/**
	 * @param exchange
	 *          the exchange to set
	 */
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

}
