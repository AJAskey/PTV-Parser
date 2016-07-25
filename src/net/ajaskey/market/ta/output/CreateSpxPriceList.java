
package net.ajaskey.market.ta.output;

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
public class CreateSpxPriceList {

	private List<String>	filenames			= new ArrayList<>();
	private List<String>	fullfilenames	= new ArrayList<>();

	private Calendar			currentDate			= null;
	private Calendar			endDate				= null;
	private int						increment			= 1;
	private TickerData		td						= null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public CreateSpxPriceList(Calendar sDate, Calendar eDate, int inc) {
		currentDate = Utils.makeCopy(sDate);
		increment = inc;
		
		endDate = eDate;

		fullfilenames.add("symbols\\INDEX_SymbolList.txt");
		TickerFullName.build(fullfilenames);
		ParseData.setValidTicker("SPX.IDX");

		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\INDEX");

		List<TickerData> tdList;
		try {
			tdList = ParseData.parseFiles(filenames, 1700);
			td = TickerData.getFromList("SPX.IDX", tdList);
		} catch (FileNotFoundException | ParseException e) {
			td = null;
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * net.ajaskey.market.ta.output.getList
	 *
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public List<String> getList() throws FileNotFoundException, ParseException {
		
		List<String> retArr = new ArrayList<>();

		while (currentDate.before(endDate)) {
			final DailyData dd = TickerData.getDailyDate(td, currentDate);
			if (dd != null) {
				final String str = String.format("%s,%9.2f", Utils.getString(currentDate), dd.getClose());
				retArr.add(str);
			}
			currentDate.add(Calendar.DATE, increment);
			final String day = Utils.getDayName(currentDate);
			if (day.contains("SAT")) {
				currentDate.add(Calendar.DATE, 2);
			} else if (day.contains("SUN")) {
				currentDate.add(Calendar.DATE, 1);
			}
		}
		if (Utils.sameDate(currentDate, endDate)) {
			final DailyData dd = TickerData.getDailyDate(td, currentDate);
			if (dd != null) {
				final String str = String.format("%s,%9.2f", Utils.getString(currentDate), dd.getClose());
				retArr.add(str);
			}
		}
		
		return retArr;
	}
}
