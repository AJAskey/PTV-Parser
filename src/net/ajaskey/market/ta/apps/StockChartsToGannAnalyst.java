
package net.ajaskey.market.ta.apps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.DailyData;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.ValidateData;

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
public class StockChartsToGannAnalyst {

	/**
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(final String[] args) throws IOException, ParseException {

		TickerData td = null;

		Utils.makeDir("gann");

		try (BufferedReader br = new BufferedReader(new FileReader("data\\spx-sc.txt"))) {

			String line = br.readLine();

			while (line != null) {
				line = br.readLine();
				if (line.contains("=== =====")) {
					break;
				}
			}

			while (line != null) {
				line = br.readLine();

				if ((line == null) || (line.trim().length() < 5)) {
					break;
				}

				final String fld[] = line.trim().split("\\s+");

				final DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				final Calendar cal = Calendar.getInstance();
				cal.setTime(df.parse(fld[1]));

				if (td == null) {
					td = new TickerData("SPX", cal, Double.parseDouble(fld[2]), Double.parseDouble(fld[3]), Double.parseDouble(fld[4]),
					    Double.parseDouble(fld[5]), Double.parseDouble(fld[6]), 0);
					// System.out.println(line);
				}
				else {
					final DailyData dd = new DailyData(cal, Double.parseDouble(fld[2]), Double.parseDouble(fld[3]), Double.parseDouble(fld[4]),
					    Double.parseDouble(fld[5]), Double.parseDouble(fld[6]), 0);
					// System.out.println(line);
					td.addData(dd);
				}
			}
		}

		if (ValidateData.validate(td)) {

			td.fillDataArrays(0, true);

			final DateFormat gannFmt = new SimpleDateFormat("yyyyMMdd");
			try (PrintWriter pw = new PrintWriter("gann\\spx-1990-SC.txt")) {
				for (int i = 0; i < td.getDateData().length; i++) {
					final String dat = gannFmt.format(td.getDate(i).getTime());
					pw.printf("%s,%.2f,%.2f,%.2f,%.2f,%d,0%n", dat, td.getOpen(i), td.getHigh(i), td.getLow(i), td.getClose(i),
					    (long) td.getVolume(i));
				}
			}
		}
		else {
			System.out.println("Data not valid.");
		}

		System.out.println("Done.");

	}

}
