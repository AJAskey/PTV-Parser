
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.DateTime;

/**
 * This class parses TREAST data from FRED.
 *
 * @author Andy Askey
 *
 *         <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
 *         reserved.</p>
 *
 *         <p> Permission is hereby granted, free of charge, to any person
 *         obtaining a copy of this software and associated documentation files
 *         (the "Software"), to deal in the Software without restriction,
 *         including without limitation the rights to use, copy, modify, merge,
 *         publish, distribute, sublicense, and/or sell copies of the Software,
 *         and to permit persons to whom the Software is furnished to do so,
 *         subject to the following conditions:
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
	public static void main(final String[] args) throws IOException {

		final List<DateValue> pastDvList = ParseTreastData.readFile(FredCommon.fredPath + "TREAST.csv", 1);
		final List<DateValue> FutureDvList = ParseTreastData.readFile("TREAST\\SomaNonMbs-073119.csv", 6);
		
		System.out.println(FutureDvList.size());

		ParseTreastData.process(pastDvList, FutureDvList);

	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.process
	 *
	 * @param pastDvList
	 * @param futureDvList
	 * @throws FileNotFoundException
	 */
	public static void process(final List<DateValue> pastDvList, final List<DateValue> futureDvList) throws FileNotFoundException {

		final List<DateValue> cumList = new ArrayList<>();

		// Process TREAST data
		for (final DateValue dv : futureDvList) {
			boolean found = false;
			for (final DateValue cdv : cumList) {
				if (dv.date.isEqual(cdv.date)) {
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

		Collections.sort(cumList, new DateValueSorter());
		for (final DateValue dv : cumList) {
			System.out.println(dv);
		}

		double lastValue = 0.0;
		DateTime lastDate = new DateTime();

		// Write TREAST data
		try (PrintWriter pw = new PrintWriter(FredCommon.fredPath + "/TREAST-ALL.csv");
		    PrintWriter pw2019 = new PrintWriter(FredCommon.fredPath + "/TREAST-2019.csv");) {

			final DateTime end2019 = new DateTime(2020, DateTime.JANUARY, 1);
			for (final DateValue dv : pastDvList) {
				final String d = dv.date.format("yyyy-MM-dd");
				pw.printf("%s,%.1f%n", d, dv.value);

				pw2019.printf("%s,%.1f%n", d, dv.value);
				lastDate.set(dv.date);
				lastValue = dv.value;
			}

			for (final DateValue dv : cumList) {
				if (dv.date.isGreaterThan(lastDate)) {

					final String d = dv.date.format("yyyy-MM-dd");
					lastValue -= dv.value;

					pw.printf("%s,%.1f%n", d, lastValue);

					if (dv.date.isLessThanOrEqual(end2019)) {
						pw2019.printf("%s,%.1f%n", d, lastValue);
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
	public static List<DateValue> readFile(final String fname, final int fldptr) throws FileNotFoundException, IOException {

		final List<DateValue> dvList = new ArrayList<>();

		final File f = new File(fname);
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
