
package net.ajaskey.market.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
public class TickerNames {

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		//TickerNames tn = new TickerNames("lists/ivv-components.csv");
		final TickerNames tn = new TickerNames("data/SP500-SIP3.csv");
		final String s = tn.get();
		System.out.println(s);

	}

	private final String listName;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public TickerNames(String list) {
		this.listName = list;
	}

	public String get() throws FileNotFoundException, IOException {

		String ret = "";
		try (BufferedReader br = new BufferedReader(new FileReader(new File(this.listName)))) {
			String line = "";

			int knt = 0;
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					final String fld[] = line.split("[,\\s+]");
					final String s = fld[0].replace("\n", "").replaceAll("\"", "");
					System.out.println(s);
					if (knt == 0) {
						ret += s.trim();
						knt++;
					} else {
						ret += "+" + s.trim();
					}
				}
			}
		}
		return ret.trim();
	}

}
