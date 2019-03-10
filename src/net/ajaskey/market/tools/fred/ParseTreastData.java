
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;

/**
 * This class...
 *
 * @author ajask <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class ParseTreastData {

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException5
	 */
	public static void main(String[] args) throws IOException {

		final List<DateValue> pastList = ParseTreastData.readFile(
		    FredCommon.fredPath + "[TREAST] - US Treasury Securities Held By the Federal Reserve All Maturities.csv", 1);
		//final List<DateValue> dvList = readFile("data\\treast-data.csv");
		final List<DateValue> dvList = ParseTreastData.readFile("data\\SomaNonMbs-030619.csv", 6);
		
		for (DateValue dv : dvList) {
			System.out.println(dv);
		}

		ParseTreastData.process(pastList, dvList);

	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.process
	 *
	 * @param pastList
	 * @param dvList
	 * @throws FileNotFoundException
	 */
	public static void process(List<DateValue> pastList, List<DateValue> dvList) throws FileNotFoundException {

		final List<DateValue> cumList = new ArrayList<>();

		for (final DateValue dv : dvList) {
			boolean found = false;
			for (final DateValue cdv : cumList) {
				if (Utils.sameDate(dv.date, cdv.date)) {
					cdv.value += dv.value;
					found = true;
					break;
				}
			}
			if (!found) {
				final DateValue dvv = new DateValue(dv);
				cumList.add(dvv);
			}
		}

		try (PrintWriter pw = new PrintWriter(FredCommon.fredPath + "/TREAST-ALL.csv");
		    PrintWriter pw2019 = new PrintWriter(FredCommon.fredPath + "/TREAST-2019.csv");
		    PrintWriter pw50 = new PrintWriter(FredCommon.fredPath + "/TREAST-ALL-50.csv");
		    PrintWriter pw90 = new PrintWriter(FredCommon.fredPath + "/TREAST-ALL-90.csv")) {

			double last = 0;
			double last50 = 0;
			double last90 = 0;
			Calendar lastDate = null;
			final Calendar end2018 = Calendar.getInstance();
			end2018.set(2020, Calendar.JANUARY, 1);
			for (final DateValue dv : pastList) {
				pw.printf("%s,%.1f%n", DateValue.sdf.format(dv.date.getTime()), dv.value);
				pw50.printf("%s,%.1f%n", DateValue.sdf.format(dv.date.getTime()), dv.value);
				pw90.printf("%s,%.1f%n", DateValue.sdf.format(dv.date.getTime()), dv.value);
				pw2019.printf("%s,%.1f%n", DateValue.sdf.format(dv.date.getTime()), dv.value);
				last = dv.value;
				last50 = dv.value;
				last90 = dv.value;
				lastDate = dv.date;
			}
			Calendar calLast = Utils.buildCalendar(2000, 1, 1);
			for (final DateValue dv : cumList) {
				System.out.println("Last Date : " + Utils.getString(lastDate));
				//System.out.println("End 2018  : " + Utils.getString(end2018));
				System.out.println(dv);
				if (dv.date.after(lastDate)) {
					final double tot = last - dv.value;
					final double tot50 = last50 - (dv.value / 2.0);
					final double tot90 = last90 - (dv.value * 0.1);
					last = tot;
					last50 = tot50;
					last90 = tot90;
					if ((tot > 0.0) && (dv.date.after(calLast))) {
						calLast.setTime(dv.date.getTime());
						pw.printf("%s,%.1f%n", DateValue.sdf.format(dv.date.getTime()), tot);
						pw50.printf("%s,%.1f%n", DateValue.sdf.format(dv.date.getTime()), tot50);
						pw90.printf("%s,%.1f%n", DateValue.sdf.format(dv.date.getTime()), tot90);
						if (dv.date.before(end2018)) {
							//System.out.println(Utils.getString(dv.date) + "\t"+  Utils.getString(end2018));
							System.out.printf("%s,%.1f%n", DateValue.sdf.format(dv.date.getTime()), tot);
							pw2019.printf("%s,%.1f%n", DateValue.sdf.format(dv.date.getTime()), tot);
						}
					}
				}
			}
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.readFile
	 *
	 * @param fname
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<DateValue> readFile(String fname, int fldptr) throws FileNotFoundException, IOException {

		final List<DateValue> dvList = new ArrayList<>();

		File f = new File(fname);
		if (f.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(f))) {

				String line;
				while ((line = reader.readLine()) != null) {
					final String str = line.trim();
					final DateValue dv = new DateValue(str, fldptr);
					if (dv.valid) {
						dvList.add(dv);
					}
				}
			}
		}

		return dvList;
	}

}
