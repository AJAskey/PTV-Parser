
package net.ajaskey.market.ta.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.sipro.DataSet4;
import net.ajaskey.market.tools.sipro.SipCommon;

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
public class LongTermOHLCV {

	public Calendar	date;
	public double		open;
	public double		high;
	public double		low;
	public double		close;
	public long			volume;

	final private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public LongTermOHLCV() {
		date = Calendar.getInstance();
		open = 0;
		high = 0;
		low = 0;
		close = 0;
		volume = 0;
	}

	/**
	 * net.ajaskey.market.ta.input.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, ParseException {

		List<LongTermOHLCV> data = getData("SP600");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse("2017-10-01"));
		LongTermOHLCV dd = queryDate(c, data);
		System.out.println(dd);

	}

	/**
	 * 
	 * net.ajaskey.market.ta.input.getData
	 *
	 * @param index
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public static List<LongTermOHLCV> getData(String index) throws IOException, ParseException {

		List<LongTermOHLCV> ret = new ArrayList<>();
		String fname = "";
		if (index.equalsIgnoreCase("SP500")) {
			fname = "data/GSPC.CSV";
		} else if (index.equalsIgnoreCase("SP400")) {
			fname = "data/MID.CSV";
		} else if (index.equalsIgnoreCase("SP600")) {
			fname = "data/SML.CSV";
		} else {
			return null;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(new File(fname)))) {
			String line = "";

			line = br.readLine(); // read header

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {
					String fld[] = line.split(",");
					LongTermOHLCV dd = new LongTermOHLCV();
					dd.date.setTime(sdf.parse(fld[0].trim()));
					dd.open = Double.parseDouble(fld[1].trim());
					dd.high = Double.parseDouble(fld[2].trim());
					dd.low = Double.parseDouble(fld[3].trim());
					dd.close = Double.parseDouble(fld[5].trim());
					dd.volume = Long.parseLong(fld[6].trim());

					ret.add(dd);
					System.out.println(dd);
				}
			}
		}

		return ret;
	}

	public static LongTermOHLCV queryDate(Calendar c, List<LongTermOHLCV> list) {

		for (LongTermOHLCV d : list) {
			if (Utils.sameDate(d.date, c)) {
				return d;
			} else if (d.date.after(c)) {
				return d;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = String.format("%s\t%6.2f %6.2f %6.2f %6.2f %10d", Utils.stringDate(this.date), open, high, low, close,
		    volume);
		return ret;
	}

}
