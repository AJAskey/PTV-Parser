
package net.ajaskey.market.ta.input;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;

/**
 * This class...
 *
 * @author ajask_000 <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class SpxLongTermPrices {

	final private static File							filePath	= new File("data/spx-1950.txt");
	final private static Charset					charset		= Charset.forName("UTF-8");
	final private static SimpleDateFormat	sdf				= new SimpleDateFormat("dd-MMM-yyyy");
	static public List<SpxLongTermPrices>	spxList		= null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @throws IOException
	 * @throws ParseException
	 *
	 */
	//	public SpxLongTermPrices() throws IOException, ParseException {
	//
	//		// Singleton
	//		if (spxList != null) {
	//			return;
	//		}
	//
	//		spxList = new ArrayList<>();
	//
	//		try (BufferedReader reader = Files.newBufferedReader(filePath.toPath(), charset)) {
	//			String line = reader.readLine(); // Header
	//
	//			while ((line = reader.readLine()) != null) {
	//				final SpxLongTermPrices sp = new SpxLongTermPrices();
	//				try {
	//					sp.date = Calendar.getInstance();
	//					final String fld[] = line.trim().split("\t");
	//					sp.date.setTime(sdf.parse(fld[0].trim()));
	//					sp.open = Double.parseDouble(fld[1].trim());
	//					sp.high = Double.parseDouble(fld[2].trim());
	//					sp.low = Double.parseDouble(fld[3].trim());
	//					sp.close = Double.parseDouble(fld[4].trim());
	//					System.out.println(Utils.stringDate(sp.date) + " " + sp.close);
	//					spxList.add(sp);
	//				} catch (final Exception e) {
	//				}
	//			}
	//		}
	//	}

	public static String getClose(Calendar cal) {

		final SpxLongTermPrices s = SpxLongTermPrices.getData(cal);
		final String ret = String.format("%s,%s", Utils.stringDate(s.date), s.close);
		return ret;
	}

	public static SpxLongTermPrices getData(Calendar cal) {

		for (final SpxLongTermPrices s : spxList) {
			if (Utils.sameDate(cal, s.date)) {
				return s;
			} else if (cal.before(s.date)) {
				return s;
			}
		}
		return null;
	}

	/**
	 * net.ajaskey.market.ta.input.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, ParseException {

		new SpxLongTermPrices();
	}

	public double	open;
	public double	high;

	public double low;

	public double close;

	public long volume;

	public Calendar date;

}
