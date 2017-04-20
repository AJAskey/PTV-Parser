
package net.ajaskey.market.ta.apps;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.apps.helpers.OptionData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;

/**
 * This class...
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class OexOptions {

	private static List<TickerData>	tdList				= new ArrayList<>();
	private static List<String>			filenames			= new ArrayList<>();
	private static List<String>			fullfilenames	= new ArrayList<>();

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParseException, IOException {

		System.out.println("Processing...");

		fullfilenames.add("symbols\\OPRA-OEX_SymbolList.txt");
		TickerFullName.build(fullfilenames);
		// TickerFullName.dumpTickers();

		final String dataPath = Utils.getDataPath();
		filenames.add(dataPath + "\\ASCII\\OPRA");

		TickerData.clearTickerData(tdList);
		ParseData.setValidTickers(ParseData.getTickerList("lists\\OEX-Options-list.txt"));
		tdList = ParseData.parseFiles(filenames, 15);

		final Calendar today = Calendar.getInstance();

		long puts = 0;
		long calls = 0;

		for (final TickerData td : tdList) {
			td.fillDataArrays(0, true);
			final OptionData od = new OptionData(td.getTickerName());

			if (od.getOpex().after(today)) {

				if (od.getType() == OptionData.OptionType.CALL) {
					calls += od.getOi();
				} else if (od.getType() == OptionData.OptionType.PUT) {
					puts += od.getOi();
				}

				for (int j = 0; j < td.getDataCount(); j++) {
					od.setData(td.getDate(j), td.getClose(j), (long) td.getVolume(j), (long) td.getOi(j));
				}
				System.out.println(td.toString() + Utils.getString(od.getDate()) + "\t" + od.getPrice() + "\t" + od.getVolume()
				    + "\t" + od.getOi());
			}
		}

		System.out.println("Puts :  " + puts);
		System.out.println("Calls : " + calls);
		System.out.println("Done.");

	}

}
