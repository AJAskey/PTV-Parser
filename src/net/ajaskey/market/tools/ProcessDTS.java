
package net.ajaskey.market.tools;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.ta.Utils;

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
public class ProcessDTS {

	final static String url = "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=w&fname=";
	
	final static SimpleDateFormat	sdf					= new SimpleDateFormat("yyMMdd");

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final Calendar tommorrow = Calendar.getInstance();
		tommorrow.add(Calendar.DATE, 1);

		final Calendar cal = Calendar.getInstance();
		cal.set(2016, Calendar.JUNE, 1);

		while (cal.before(tommorrow)) {


			List<String> resp = new ArrayList<>();
			
			String fname = ProcessDTS.getDateName(cal);
			
			//System.out.println(fname);

			resp = WebGet.getSPDR(url + fname + ".txt");

			if (resp != null) {
				
				System.out.println(Utils.stringCalendar(cal));


				for (final String s : resp) {
					if (s.contains("Withheld Income and Employment Taxes")) {
						System.out.println("\t" + s.trim());
					}
				}
			}
			cal.add(Calendar.DATE, 1);
		}
	}

	private static String getDateName(Calendar c) {
		if (c != null) {
			return sdf.format(c.getTime())+ "00";
		}
		return "";
		//return "16061000";
	}

}
