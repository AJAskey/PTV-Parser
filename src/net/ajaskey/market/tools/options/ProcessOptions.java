
package net.ajaskey.market.tools.options;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Calendar;

/**
 * This class...
 *
 * @author Andy <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class ProcessOptions {

	/**
	 * net.ajaskey.market.tools.options.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws ParseException, FileNotFoundException {

		final Calendar c = Calendar.getInstance();
		final Calendar sellit = Calendar.getInstance();

		try (PrintWriter pw = new PrintWriter("out/options.out")) {

			c.setTime(OptionsProcessor.sdf.parse("20190816"));
			//sellit.setTime(OptionsProcessor.sdf.parse("20190416"));

			double cp = 2822.0;
			double iv = 0.24;

			final DataItem di = new DataItem(DataItem.APUT, cp, 2200.0, c, 0.01, iv, sellit);
			pw.println(di);

			double downrng = 900.0;
			double downtime = 90;
			double downperday = downrng / downtime;

			double ivrng = 0.15;
			double ivperday = ivrng / downtime;

			for (int i = 0; i < (int) downtime; i++) {

				sellit.add(Calendar.DATE, 1);
				cp -= downperday;

				DataItem di2 = di.getPutPrice(cp, OptionsProcessor.sdf.format(sellit.getTime()), iv);

				iv += ivperday;

				pw.println(di2);
				//pw.printf("%.2f%n",iv);
			}

		}
		//final double p = di.getPutPrice(1700.0, "20190621", .35);
		//System.out.println(p);

		// double y = getDeltaYears(c);
		//
		// double price = getCallPrice(2850.0, 2475.0, 0.01, y, 0.19);
		//
		// System.out.println(y);
		// System.out.println(price);
		//
		// price = getPutPrice(2850.0, 2475.0, 0.01, y, 0.19);
		// System.out.println(price);

	}

}
