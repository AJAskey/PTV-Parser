
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

	final static String	p1	= "openinsider.com/screener?s=";
	final static String	p2	= "&o=&pl=&ph=&ll=&lh=&fd=7&fdr=&td=0&tdr=&fdlyl=&fdlyh=&daysago=&xp=1&xs=1&excludeDerivRelated=1&vl=&vh=&ocl=&och=&sic1=-1&sicl=100&sich=9999&isofficer=1&iscob=1&isceo=1&ispres=1&iscoo=1&iscfo=1&isgc=1&isvp=1&isdirector=1&grp=0&nfl=&nfh=&nil=&nih=&nol=&noh=&v2l=&v2h=&oc2l=&oc2h=&sortcol=8&cnt=100&page=1";

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		//TickerNames tn = new TickerNames("lists/ivv-components.csv");
		final TickerNames tn = new TickerNames("data/SP-Stocks.txt", "500");
		final String s = tn.get();
		System.out.println(p1 + s + p2);

	}

	private final String	listName;
	private final String	idx;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public TickerNames(String list, String spidx) {
		this.listName = list;
		this.idx = spidx;
	}

	public String get() throws FileNotFoundException, IOException {

		String ret = "";
		int knt = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(new File(this.listName)))) {
			String line = "";

			while (line != null) {
				line = br.readLine();
				if (line != null) {
					final String fld[] = line.split("[,\\s+]");
					final String s = fld[0].replace("\n", "").replaceAll("\"", "");
					String idx = fld[1].replace("\n", "").replaceAll("\"", "");
					if (idx.equalsIgnoreCase(this.idx)) {
						System.out.println(s);
						if (knt == 0) {
							ret += s.trim();
							knt++;
						} else {
							ret += "+" + s.trim();
							knt++;
						}
					}
				}
			}
		}
		System.out.println(knt);
		return ret.trim();
	}

}
