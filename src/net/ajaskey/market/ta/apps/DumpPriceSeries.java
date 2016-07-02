
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.DailyData;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;

/**
 * This class...
 *
 * @author Andy Askey
 *         <p>
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *         </p>
 *         <p>
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
 *         </p>
 *
 *         <p>
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *         </p>
 *
 */
public class DumpPriceSeries {

	private static List<String>	filenames			= new ArrayList<>();
	private static List<String>	fullfilenames	= new ArrayList<>();

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		
		System.out.println("Processing...");

		try (PrintWriter pw = new PrintWriter("out\\SPX-COTS-Prices.csv")) {

			fullfilenames.add("symbols\\INDEX_SymbolList.txt");
			TickerFullName.build(fullfilenames);
			ParseData.setValidTicker("SPX.IDX");

			final String arg = "dataPath";
			final String dataPath = System.getProperty(arg, "");
			filenames.add(dataPath + "\\ASCII\\INDEX");

			final Calendar cal = Utils.buildCalendar(2012, Calendar.JANUARY, 3);
			final Calendar endCal = Utils.buildCalendar(2016, Calendar.JULY, 1);

			final List<TickerData> tdList = ParseData.parseFiles(filenames, 1700);

			final TickerData td = TickerData.getFromList("SPX.IDX", tdList);

			while (cal.before(endCal)) {
				final DailyData dd = TickerData.getDailyDate(td, cal);
				if (dd != null) {
					final String str = String.format("%s,%9.2f", Utils.getString(cal), dd.getClose());
					pw.println(str);
				}
				cal.add(Calendar.DATE, 7);
			}
		}

		System.out.println("Done.");
	}
}
