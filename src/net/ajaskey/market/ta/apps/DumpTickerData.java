
package net.ajaskey.market.ta.apps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;

/**
 * @author Andy Askey
 *
 * @copyright PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *
 *            Permission is hereby granted, free of charge, to any person
 *            obtaining a copy of this software and associated documentation
 *            files (the "Software"), to deal in the Software without
 *            restriction, including without limitation the rights to use, copy,
 *            modify, merge, publish, distribute, sublicense, and/or sell copies
 *            of the Software, and to permit persons to whom the Software is
 *            furnished to do so, subject to the following conditions:
 *
 *            The above copyright notice and this permission notice shall be
 *            included in all copies or substantial portions of the Software.
 *
 *            THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *            EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *            MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *            NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *            HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *            WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *            OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 *            DEALINGS IN THE SOFTWARE.
 *
 */
public class DumpTickerData {

	private static List<TickerData>	tdAll;
	private static List<String>			filenames	= new ArrayList<String>();

	/**
	 *
	 * This method serves as a constructor for the class.
	 *
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	public DumpTickerData() throws ParseException, FileNotFoundException {

		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		final String filePath = dataPath + "\\ASCII\\NASDAQ";
		System.out.println(filePath);
		filenames.add(filePath);
		tdAll = ParseData.parseFiles(filenames);

		final File outDir = new File("out");
		if (!outDir.exists()) {
			outDir.mkdir();
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {

		ParseData.setValidTicker("QQQ");
		ParseData.setValidTicker("MSFT");

		new DumpTickerData();

		for (final TickerData td : tdAll) {

			td.generateDerived(10);

			try (PrintWriter pw = new PrintWriter("out\\" + td.getTicker() + ".txt")) {
				pw.println(td.getTicker() + "\n" + "Date,Open,High,Low,Close,Volume");
				for (int i = 0; i < td.getDaysOfData(); i++) {
					final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
					final String sDate = sdf.format(td.getDate(i).getTime());
					pw.printf("%s,%.2f,%.2f,%.2f,%.2f,%d%n", sDate, td.getOpen(i), td.getHigh(i), td.getLow(i), td.getClose(i),
					    (int) td.getVolume(i));
				}
			}
		}
		System.out.println("Done.");
	}

}
