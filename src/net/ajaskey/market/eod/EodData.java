
package net.ajaskey.market.eod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import net.ajaskey.market.misc.Utils;

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
public class EodData {

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

	public static void main(final String[] args) {

		final EodData eod = new EodData("ADR.IDX,04-Jan-2012,683.876,683.873,678.26,682.75,1234567890");
		if (eod.valid) {
			System.out.println(eod);
		}
	}

	public String		code;
	public Calendar	date;
	public double		open;
	public double		high;
	public double		low;
	public double		close;
	public long			vol;
	public String		dayOfWeek;

	public boolean valid;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public EodData(final String data) {

		final String fld[] = data.trim().split("[\\s+,]");
		this.valid = true;
		if (fld.length > 6) {
			this.code = fld[0].trim();
			if ((this.code == null) || (this.code.length() < 1)) {
				this.valid = false;
			}
			else {

				this.date = Calendar.getInstance();
				try {
					final Date d = sdf.parse(fld[1].trim());
					this.date.setTime(d);
					final Locale locale = Locale.getDefault();

					this.dayOfWeek = this.date.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, locale);

					this.open = Double.parseDouble(fld[2].trim());
					this.high = Double.parseDouble(fld[3].trim());
					this.low = Double.parseDouble(fld[4].trim());
					this.close = Double.parseDouble(fld[5].trim());
					this.vol = Long.parseLong(fld[6].trim());

				} catch (final ParseException e) {
					this.valid = false;
					//e.printStackTrace();
				}
			}
		}
		else {
			this.valid = false;
		}
	}

	@Override
	public String toString() {

		final String s = String.format("%s, %s, %s, %.2f, %.2f, %.2f, %.2f, %d", this.code, Utils.getString(this.date), this.dayOfWeek,
		    this.open, this.high, this.low, this.close, this.vol);
		return s;
	}

}
