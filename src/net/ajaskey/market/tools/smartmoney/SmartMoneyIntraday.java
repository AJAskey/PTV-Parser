
package net.ajaskey.market.tools.smartmoney;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import net.ajaskey.market.misc.Utils;

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
public class SmartMoneyIntraday {

	public SmartMoneyIntraday data[] = new SmartMoneyIntraday[14];

	/**
	 * net.ajaskey.market.tools.smartmoney.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader("data/spy-30min.txt"))) {
			String line;
			// Utils.printCalendar(d.getDate());
			while ((line = br.readLine()) != null) {
				if (line.contains("TIMEZONE_OFFSET")) {
					SmartMoneyIntraday smi = new SmartMoneyIntraday(br, Calendar.getInstance());
				}

			}
		}

	}

	private static void newDay(Calendar yesterday) {

		yesterday.set(Calendar.HOUR_OF_DAY, 9);
		yesterday.set(Calendar.MINUTE, 30);
		yesterday.set(Calendar.SECOND, 0);
		yesterday.set(Calendar.MILLISECOND, 0);
		yesterday.add(Calendar.DATE, -1);
		while ((yesterday.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
		    || (yesterday.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
			yesterday.add(Calendar.DATE, -1);
		}
	}

	/**
	 * This method serves as a constructor for the class.
	 * 
	 * @throws IOException
	 *
	 */
	public SmartMoneyIntraday(BufferedReader br, Calendar day) throws IOException {

		int knt = 0;
		String line;
		day.set(Calendar.HOUR_OF_DAY, 9);
		day.set(Calendar.MINUTE, 30);
		day.set(Calendar.SECOND, 0);
		day.set(Calendar.MILLISECOND, 0);
		System.out.println(Utils.getStringFull(day));
		while ((line = br.readLine()) != null) {
			SmartMoneyData smd = new SmartMoneyData(day, line);

			System.out.println(smd);

			day.add(Calendar.MINUTE, 30);
			knt++;
			if (knt == 14) {
				newDay(day);
				knt = 0;
			}
		}
	}

}
