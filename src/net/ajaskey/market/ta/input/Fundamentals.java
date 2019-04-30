
package net.ajaskey.market.ta.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class Fundamentals {

	public static List<Fundamentals>	fundieList			= new ArrayList<>();
	private static int								maxSectorLen		= 0;
	private static int								maxIndustryLen	= 0;
	private static String							fmt;

	public static void build(final String dataFile) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
			String line = br.readLine();
			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.trim().length() > 10)) {
					final String[] fld = line.split("\t");
					final Fundamentals f = new Fundamentals();
					f.ticker = fld[0].trim().toUpperCase();
					f.sector = fld[1].trim();
					f.industry = fld[2].trim();
					f.marketCap = fld[4].trim();
					String sTmp = fld[3].trim();
					sTmp = sTmp.replaceAll(",", "");
					try {
						f.shares = Long.parseLong(sTmp);
					} catch (final Exception e) {
						f.shares = 0;
						// System.out.println(sTmp);
					}
					// if (f.shares > 1000000) {
					maxSectorLen = Math.max(maxSectorLen, f.sector.length() + 2);
					maxIndustryLen = Math.max(maxIndustryLen, f.industry.length() + 1);
					fundieList.add(f);
					// }
				}
			}
		}
		fmt = String.format("%%-10s %%-%ds %%-%ds %%15d", maxSectorLen, maxIndustryLen);

		// Fundamentals.setYahoo();
	}

	/**
	 * @return the industry
	 */
	public static List<Fundamentals> getWithIndusty(final String ind) {

		final List<Fundamentals> fun = new ArrayList<>();
		for (final Fundamentals f : fundieList) {
			if (f.industry.equalsIgnoreCase(ind)) {
				fun.add(f);
			}
		}
		return fun;
	}

	/**
	 * @return the sector
	 */
	public static List<Fundamentals> getWithSector(final String sec) {

		final List<Fundamentals> sect = new ArrayList<>();
		for (final Fundamentals f : fundieList) {
			if (f.sector.equalsIgnoreCase(sec)) {
				sect.add(f);
			}
		}
		return sect;
	}

	/**
	 * @return the ticker
	 */
	public static Fundamentals getWithTicker(final String tkr) {

		for (final Fundamentals f : fundieList) {
			if (f.ticker.equalsIgnoreCase(tkr)) {
				return f;
			}
		}
		return null;
	}

	public static void main(final String[] args) throws FileNotFoundException, IOException, ParseException {

		Fundamentals.build("lists\\stock-fundie-list.txt");
		// Fundamentals.build(dataPath + "\\ASCII\\Nasdaq_fundies.txt");
		// Fundamentals.build(dataPath + "\\ASCII\\NYSE_fundies.txt");

		for (final Fundamentals f : fundieList) {
			System.out.println(f.toString());
		}

		System.out.println("Done.");

	}

	private String ticker;

	private String industry;

	private String sector;

	private long shares;

	private String marketCap;

	/**
	 * @return the industry
	 */
	public String getIndustry() {

		return this.industry;
	}

	/**
	 * @return the marketCap
	 */
	public String getMarketCap() {

		return this.marketCap;
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

	@Override
	public String toString() {

		final String s = String.format(fmt, this.ticker, this.sector, this.industry, this.shares);
		return s;
	}

}
