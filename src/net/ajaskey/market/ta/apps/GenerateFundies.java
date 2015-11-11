
package net.ajaskey.market.ta.apps;

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
public class GenerateFundies {

	static List<GenerateFundies>	fundieList	= new ArrayList<>();
	static List<String>						tickers			= new ArrayList<>();
	private String								ticker;
	private String								sector;
	private String								industry;
	private long									shares;

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

		GenerateFundies.build();

		try (PrintWriter pw = new PrintWriter("lists\\stock-fundie-list.txt")) {
			for (final GenerateFundies f : fundieList) {
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
	private static void build() throws FileNotFoundException, IOException {
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

}
