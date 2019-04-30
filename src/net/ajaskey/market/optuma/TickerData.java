
package net.ajaskey.market.optuma;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.ajaskey.market.misc.DateTime;

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

	private final static String DELIMITER = ",";

	private final static int FIELDS = 7;

	private final static SimpleDateFormat	sdf	= new SimpleDateFormat("yyyyMMdd");
	public String													ticker;
	public int														days;
	public DateTime[]											date;
	public double[]												open;
	public double[]												high;
	public double[]												low;

	public double[]	close;
	public double[]	volume;

	public double[] oi;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @param tkr
	 * @param data
	 */
	public TickerData(final String tkr, final List<String> data) {

		this.ticker = tkr;
		this.days = data.size();
		this.date = new DateTime[this.days];
		this.open = new double[this.days];
		this.high = new double[this.days];
		this.low = new double[this.days];
		this.close = new double[this.days];
		this.volume = new double[this.days];
		this.oi = new double[this.days];
		int knt = 0;
		for (final String s : data) {
			try {
				if (this.checkLine(s)) {
					final String fld[] = s.split(DELIMITER);
					final Date d = sdf.parse(fld[1].trim());
					this.date[knt] = new DateTime(d);

					this.open[knt] = Double.parseDouble(fld[2].trim());
					this.high[knt] = Double.parseDouble(fld[3].trim());
					this.low[knt] = Double.parseDouble(fld[4].trim());
					this.close[knt] = Double.parseDouble(fld[5].trim());
					this.volume[knt] = Double.parseDouble(fld[6].trim());
					this.oi[knt] = Double.parseDouble(fld[7].trim());

					knt++;
				}
			} catch (final Exception e) {
				System.out.println("Failed : " + s);
			}
		}
	}

	/**
	 *
	 * net.ajaskey.market.optuma.checkLine
	 *
	 * @param line
	 * @return
	 */
	private boolean checkLine(final String line) {

		boolean ret = true;

		if (line == null) {
			ret = false;
		}
		else {
			final String fld[] = line.trim().split(DELIMITER);
			if (fld.length != FIELDS) {
				ret = false;
			}
			else {
				Date d;
				try {
					d = sdf.parse(fld[1].trim());
					new DateTime(d);
					Double.parseDouble(fld[2].trim());

				} catch (final ParseException e) {
					ret = false;
				}
			}
		}

		return ret;
	}

}
