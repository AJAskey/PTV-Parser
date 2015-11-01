
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
import net.ajaskey.market.ta.methods.TaMethods;

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

	final private static TaMethods	taMethods	= new TaMethods();
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

		TickerFullName.build("lists\\sector-list.txt");
		
		ParseData.setValidTickers(ParseData.getTickerList("lists\\sector-list.txt"));

		filenames.add("e:\\temp\\ASCII\\INDEX");
		tdAll = ParseData.parseFiles(filenames);
		if (tdAll != null) {
			for (TickerData td : tdAll) {
				td.generateDerived();
			}
			final File outDir = new File("out");
			if (!outDir.exists()) {
				outDir.mkdir();
			}
		}
	}

	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
		WhosHot who = new WhosHot();

		Collections.sort(tdAll, new SortTickerRs());

		for (TickerData td : tdAll) {
			System.out.printf("%-10s %-50s %10.2f%% %n",td.getTicker() , td.getTickerName() , td.getChg260() );
		}

		System.out.println("Done.");
	}

}
