
package net.ajaskey.market.ta.apps;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;

/**
 * This class...
 *
 * @author Andy <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class NewHighsLows {

	private static List<String>	filenames			= new ArrayList<>();
	private static List<String>	fullfilenames	= new ArrayList<>();

	public static boolean checkHigh(final TickerData td, final int len) {

		double today = td.getHigh(0);
		for (int i = 1; i < 5; i++) {
			today = Math.max(today, td.getHigh(i));
		}

		for (int i = 5; i < len; i++) {
			if (today < td.getHigh(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(final String[] args) throws ParseException, IOException {

		fullfilenames.add("symbols\\NASDAQ_SymbolList.txt");
		fullfilenames.add("symbols\\NYSE_SymbolList.txt");
		fullfilenames.add("symbols\\AMEX_SymbolList.txt");
		TickerFullName.build(fullfilenames);

		final String dataPath = Utils.getDataPath();
		filenames.add(dataPath + "\\ASCII\\NASDAQ");
		filenames.add(dataPath + "\\ASCII\\NYSE");
		filenames.add(dataPath + "\\ASCII\\AMEX");

		ParseData.clearValidTickers();
		ParseData.setValidTickers(ParseData.getTickerList("lists\\stock-list.txt"));

		final List<TickerData> tdAll = ParseData.parseFiles(filenames, 1070);

		if (tdAll == null) {
			return;
		}

		int knt = 0;
		Calendar cal = Calendar.getInstance();
		for (final TickerData td : tdAll) {
			td.fillDataArrays(0, false);
			final int len = td.getDataCount();
			if (len >= 750) {
				final boolean high = NewHighsLows.checkHigh(td, 749);
				System.out.printf("%s\t%d\t%s\t%B\t%.2f\n", td.getTicker(), len, Utils.getString(td.getDate(len - 1)), high, td.getHigh(0));
				if (td.getDate(len - 1).before(cal)) {
					cal = td.getDate(len - 1);
					System.out.println(Utils.getString(cal));
				}
				knt++;
			}

		}
		System.out.printf("%d\t: %d\n", tdAll.size(), knt);
		System.out.println(Utils.getString(cal));
	}

}
