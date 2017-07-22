
package net.ajaskey.market.optuma;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This class...
 *
 * @author aja <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class TickerData {

	public String ticker;

	public int days;

	public Calendar[]	date;
	public double[]		open;
	public double[]		high;
	public double[]		low;
	public double[]		close;
	public double[]		volume;
	public double[]		oi;

	private final static String DELIMITER = ",";
	private final static int FIELDS = 7;

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param tkr
	 * @param data
	 */
	public TickerData(String tkr, List<String> data) {
		ticker = tkr;
		days = data.size();
		date = new Calendar[days];
		open = new double[days];
		high = new double[days];
		low = new double[days];
		close = new double[days];
		volume = new double[days];
		oi = new double[days];
		int knt = 0;
		for (String s : data) {
			try {
				if (checkLine(s)) {
					String fld[] = s.split(DELIMITER);
					final Date d = sdf.parse(fld[1].trim());
					date[knt] = Calendar.getInstance();
					date[knt].setTime(d);

					open[knt] = Double.parseDouble(fld[2].trim());
					high[knt] = Double.parseDouble(fld[3].trim());
					low[knt] = Double.parseDouble(fld[4].trim());
					close[knt] = Double.parseDouble(fld[5].trim());
					volume[knt] = Double.parseDouble(fld[6].trim());
					oi[knt] = Double.parseDouble(fld[7].trim());

					knt++;
				}
			} catch (Exception e) {
				System.out.println("Failed : " + s);
			}
		}
	}

	private boolean checkLine(String line) {

		boolean ret = true;

		if (line == null) {
			ret = false;
		} else {
			String fld[] = line.trim().split(DELIMITER);
			if (fld.length != FIELDS) {
				ret = false;
			} else {
				Date d;
				try {
					d = sdf.parse(fld[1].trim());
					Calendar cal = Calendar.getInstance();
					cal.setTime(d);

					@SuppressWarnings("unused")
					double dd = Double.parseDouble(fld[2].trim());
				} catch (ParseException e) {
					ret = false;
				}
			}
		}

		return ret;
	}

}
