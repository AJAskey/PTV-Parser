
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.Utils;
import net.ajaskey.market.ta.ValidateData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;

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
public class Gannalyst {

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		final List<String> filenames = new ArrayList<>();
		final List<String> fullfilenames = new ArrayList<>();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		fullfilenames.add("symbols\\INDEX_SymbolList.txt");
		fullfilenames.add("symbols\\AMEX_SymbolList.txt");
		fullfilenames.add("symbols\\NASDAQ_SymbolList.txt");
		TickerFullName.build(fullfilenames);

		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\AMEX");
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		filenames.add(dataPath + "\\ASCII\\INDEX");

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList("lists\\gann-list.txt"));

		final List<TickerData> tdAll = ParseData.parseFiles(filenames);

		Utils.makeDir("gann");

		for (final TickerData td : tdAll) {
			// if (ValidateData.validate(td)) {
			td.generateDerived();
			try (PrintWriter pw = new PrintWriter("gann\\" + td.getTicker() + ".csv")) {
				for (int i = td.getDaysOfData() - 2; i >= 0; i--) {
					final String d = sdf.format(td.getDate(i).getTime());
					pw.printf("%s,%.2f,%.2f,%.2f,%.2f,%d,0%n", d, td.getOpen(i), td.getHigh(i), td.getLow(i), td.getClose(i),
					    (int) td.getVolume(i));
					// System.out.printf("%s,%.2f,%.2f,%.2f,%.2f,%d,0%n", d,
					// td.getOpen(i), td.getHigh(i), td.getLow(i),
					// td.getClose(i), (int) td.getVolume(i));
				}
			}
			// }
		}
		System.out.println("Done.");
	}
}
