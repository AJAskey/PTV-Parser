
package net.ajaskey.market.ta.apps;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;

/**
 * This class serves as a template for building a new application.
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
public class AppTemplate {

	private static List<String>			filenames	= new ArrayList<String>();
	private static List<TickerData>	tdList		= new ArrayList<>();

	/**
	 * The main class is used to drive the application and any other classes used.
	 *
	 * @param args
	 *          Whatever are you need
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParseException, IOException {

		/**
		 * For www.eoddata.com data files:
		 *
		 * Setup data file directories. Variable "dataPath" can be a property, set
		 * using "args", or hard coded.
		 *
		 */
		filenames.clear();
		final String prop = "dataPath";
		final String dataPath = System.getProperty(prop, "");
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		filenames.add(dataPath + "\\ASCII\\NYSE");

		/**
		 * Set valid tickers for processing. Other ticker data will be ignored.
		 *
		 * Setting the first ticker to "PROCESS_ALL_TICKERS" will retrieve data for
		 * all tickers.
		 *
		 * You can use a ticker list file or individual ticker symbols.
		 */
		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList("lists\\sp500-list.txt"));
		ParseData.setValidTicker("MSFT");
		ParseData.setValidTicker("FANG");

		/**
		 * Use tdList to store all ticker data for valid tickers.
		 *
		 * ParseData.parseFiles has two forms.
		 */
		tdList.clear();
		tdList = ParseData.parseFiles(filenames); // read all data
		/**
		 * or request calendar days of data. Probably will get only 100*5/7 trading
		 * days. Example: 30 calendar days = 21 trading days. This is important for
		 * calculations. Make sure you read enough data.
		 *
		 * Example: ParseData.parseFiles(filenames, 50) will not return enough data
		 * the calculate a 50 day moving average.
		 */
		tdList = ParseData.parseFiles(filenames, 100);

		/**
		 * Or read only one file in the format of
		 *
		 * <code>
		 * FANG
		 * Date,Open,High,Low,Close,Volume
		 * 19-Nov-2015,80.42,81.00,76.05,77.06,1124500
		 * 18-Nov-2015,80.00,81.86,78.11,81.42,1429500
		 * 17-Nov-2015,80.00,80.99,78.10,79.61,842500
		 * </code>
		 *
		 * The "DumpTickerData" app will create files of this format from eoddata.
		 * You can also get data from Yahoo or Stockcharts for individual tickers.
		 * You can download the last 30 days of free data from www.eoddata.com and
		 * use it to test this example app.
		 *
		 * The time order of the data does not matter as the SortDailyData class can
		 * be used to sort to the order needed for algorithms in this project.
		 *
		 * A few files have been committed to use as examples.
		 */
		final TickerData tdOne = ParseData.parseOneFile("ptv-data\\FANG.txt");
		System.out.println(tdOne.getTicker());

		/**
		 * Or read all the valid ticker files in a directory of the ticker per file
		 * format.
		 */
		tdList = ParseData.parsePTVData("ptv-data", 100);
		// or
		tdList = ParseData.parsePTVData("ptv-data");

		/**
		 * Ways to process the parsed data.
		 */
		for (final TickerData td : tdList) {
			// process each set of ticker data in the list.
			System.out.println(td.getTicker());
		}

		/**
		 * Or retrieve individual ticker data.
		 */
		final TickerData fang = TickerData.getTickerData(tdList, "FANG");
		if (fang != null) {
			System.out.println(fang.getTicker());
		}
	}

}
