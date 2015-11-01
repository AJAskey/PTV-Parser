
package net.ajaskey.market.ta;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;
import net.ajaskey.market.ta.reports.StockHTML;

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
public class SimpleTest {

	static List<TickerData> tdAll = new ArrayList<TickerData>();

	public static void main(String[] args) throws ParseException, IOException {
		
		String arg = "dataPath";
		String dataPath = System.getProperty(arg, "");
		String filePath = dataPath + "\\ASCII";
		System.out.println(filePath);

		final List<String> fnames = new ArrayList<String>();
		fnames.add("symbols\\INDEX_SymbolList.txt");
		fnames.add("symbols\\NASDAQ_SymbolList.txt");
		fnames.add("symbols\\AMEX_SymbolList.txt");
		fnames.add("symbols\\NYSE_SymbolList.txt");
		TickerFullName.build(fnames);

		ParseData.setValidTicker("qqq");
		ParseData.setValidTicker("ge");

		final List<String> filenames = new ArrayList<String>();
		filenames.add(filePath+"\\INDEX");
		filenames.add(filePath+"\\AMEX");
		filenames.add(filePath+"\\NASDAQ");
		filenames.add(filePath+"\\NYSE");
		tdAll = TickerData.build(filenames);

		/*
		 * for (final TickerData t : tdAll) { System.out.println("\n\n" +
		 * t.getTicker()); for (final DailyData dd : t.getData()) {
		 * System.out.println("\t" + dd.getDate().get(Calendar.DAY_OF_YEAR) + "\t" +
		 * dd.getClose()); } }
		 */

		for (final TickerData td : tdAll) {

			for (int i = 0; i < 100; i++) {
				final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				final String dat = sdf.format(td.getData().get(i).getDate().getTime());
				// String dat = sdf.format(td.getData().get(i).getDate());
				//System.out.printf("%s %.2f %.2f %.2f %.2f\n", dat, td.getOpenData()[i], td.getHighData()[i], td.getLowData()[i],
				//    td.getCloseData()[i]);
			}

			final StockHTML html = new StockHTML();
			html.build(td);
		}

		System.out.println("Done.");
	}
}
