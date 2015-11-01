
package net.ajaskey.market.ta.apps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.ta.SortTickerRs;
import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;

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
public class WhosHot {

	// final private static TaMethods taMethods = new TaMethods();
	private static List<TickerData>	tdAll;
	private static List<String>			filenames	= new ArrayList<>();

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @throws ParseException
	 * @throws IOException
	 *
	 */
	public WhosHot() throws ParseException, IOException {

		TickerFullName.build("lists\\master-list.txt");
		ParseData.setValidTickers(ParseData.getTickerList("lists\\sector-list.txt"));

		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		final String filePath = dataPath + "\\ASCII\\INDEX";
		System.out.println(filePath);
		filenames.add(filePath);
		tdAll = ParseData.parseFiles(filenames);

		this.sectors(tdAll,0);
		System.out.println("\n\n");
		sectors(tdAll,23);
		System.out.println("\n\n");
		sectors(tdAll,65);

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

		new WhosHot();
		System.out.println("Done.");
	}

	/**
	 * 
	 * net.ajaskey.market.ta.apps.sectors
	 *
	 * @param tdList
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	private void sectors(List<TickerData> tdList, int start) throws FileNotFoundException, IOException, ParseException {

		if (tdList != null) {
			for (final TickerData td : tdList) {
				td.generateDerived(start);
			}
			final File outDir = new File("out");
			if (!outDir.exists()) {
				outDir.mkdir();
			}

			Collections.sort(tdList, new SortTickerRs());

			for (final TickerData td : tdList) {
				System.out.printf("%-10s %-50s %10.2f%% %n", td.getTicker(), td.getTickerName(), td.getChg260());
			}
		}
	}

}
