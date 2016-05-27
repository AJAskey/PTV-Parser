
package net.ajaskey.market.ta.apps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
public class OexOptions {

	private static List<TickerData>	tdList		= new ArrayList<>();
	private static List<String>	filenames			= new ArrayList<>();
	private static List<String>	fullfilenames	= new ArrayList<>();
	final private static String	TAB						= "\t";

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
		//TickerFullName.dumpTickers();

		final String arg = "dataPath";
		final String dataPath = System.getProperty(arg, "");
		filenames.add(dataPath + "\\ASCII\\OPRA");
		
		TickerData.clearTickerData(tdList);
		ParseData.setValidTickers(ParseData.getTickerList("lists\\OEX-Options-list.txt"));
		tdList = ParseData.parseFiles(filenames, 5);
		
		for (TickerData td : tdList) {
			System.out.println(td.toString());
		}

		System.out.println("Done.");

	}

}
