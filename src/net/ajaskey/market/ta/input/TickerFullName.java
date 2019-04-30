
package net.ajaskey.market.ta.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.ta.SortTickerFullNames;

/**
 *
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
public class TickerFullName {

	static public List<TickerFullName> tickerNames = new ArrayList<>();

	/**
	 *
	 * net.ajaskey.market.ta.input.build
	 *
	 * @param fnames
	 */
	static public void build(final List<String> fnames) {

		for (final String f : fnames) {
			TickerFullName.build(f);
		}

		Collections.sort(tickerNames, new SortTickerFullNames());
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.build
	 *
	 * @param fname
	 */
	static public void build(final String fname) {

		try (BufferedReader br = new BufferedReader(new FileReader(fname))) {

			String line = br.readLine();
			while (line != null) {
				line = br.readLine();

				if ((line != null) && (line.length() > 7)) {

					final String fld[] = line.split("\t");

					final TickerFullName tfn = new TickerFullName();
					tfn.ticker = fld[0].trim().toUpperCase();
					tfn.name = fld[1].trim();
					if (!tickerNames.contains(tfn)) {
						tickerNames.add(tfn);
					}
				}
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.debug
	 *
	 * @param fname
	 * @throws FileNotFoundException
	 */
	static public void debug(final String fname) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter(new File(fname))) {
			for (final TickerFullName tfn : tickerNames) {
				pw.println(tfn.ticker + "\t" + tfn.name);
			}
		}
	}

	static public void dumpTickers() {

		for (final TickerFullName tkr : tickerNames) {
			System.out.println(tkr.ticker + "\t" + tkr.name);
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.getName
	 *
	 * @param ticker
	 *          symbol to check
	 * @return ticker name or null
	 */
	static public String getName(final String ticker) {

		for (final TickerFullName t : tickerNames) {
			// System.out.println(ticker + "\t" + t.ticker);
			if (t.ticker.equalsIgnoreCase(ticker)) {
				return t.name;
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.isValid
	 *
	 * @param ticker
	 * @return
	 */
	static public boolean isValid(final String ticker) {

		boolean status = false;
		for (final TickerFullName tkr : tickerNames) {
			if (tkr.ticker.equalsIgnoreCase(ticker)) {
				status = true;
				break;
			}
		}
		return status;
	}

	private String ticker;

	private String name;

	public String getName() {

		return this.name;
	}

	public String getTicker() {

		return this.ticker;
	}

}
