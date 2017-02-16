
package net.ajaskey.market.ta.apps.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class...
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class OptionData {

	public enum OptionType {
		PUT, CALL
	};

	final static private DateFormat	df	= new SimpleDateFormat("dd-MMM-yyyy");
	private Calendar								opex;
	private int											level;
	private OptionType							type;
	private Calendar								date;
	private double									price;
	private long										volume;

	private long oi;

	/**
	 * This method serves as a constructor for the class.
	 *
	 * @throws ParseException
	 *
	 */
	public OptionData(String str) throws ParseException {

		if (str == null) {
			return;
		}

		final String fld[] = str.split("_");
		if (fld.length == 4) {
			this.setOpex(fld[1]);
			if (fld[3].contains("Put")) {
				this.type = OptionType.PUT;
			} else {
				this.type = OptionType.CALL;
			}
			this.level = Integer.parseInt(fld[2]);

		}
	}

	/**
	 * @return the date
	 */
	public Calendar getDate() {

		return this.date;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {

		return this.level;
	}

	/**
	 * @return the oi
	 */
	public long getOi() {

		return this.oi;
	}

	/**
	 * @return the opex
	 */
	public Calendar getOpex() {

		return this.opex;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {

		return this.price;
	}

	/**
	 * @return the type
	 */
	public OptionType getType() {

		return this.type;
	}

	/**
	 * @return the volume
	 */
	public long getVolume() {

		return this.volume;
	}

	/**
	 *
	 * net.ajaskey.market.ta.apps.helpers.setData
	 *
	 * @param cal
	 * @param pr
	 * @param vol
	 * @param interest
	 * @throws ParseException
	 */
	public void setData(Calendar cal, double pr, long vol, long interest) throws ParseException {

		if (this.date == null) {
			this.date = Calendar.getInstance();
			this.date.set(1900, 1, 1);
			this.setPrice(pr);
			this.setVolume(vol);
			this.setOi(interest);
		}
		if (cal.compareTo(this.date) > 0) {
			this.date = cal;
			this.setPrice(pr);
			this.setVolume(vol);
			this.setOi(interest);
		}
	}

	public void setOi(long interest) {

		this.oi = interest;
	}

	/**
	 * @param opex
	 *          the opex to set
	 * @throws ParseException
	 */
	public void setOpex(String sDate) throws ParseException {

		this.opex = Calendar.getInstance();
		this.opex.setTime(df.parse(sDate));
		this.opex.set(Calendar.HOUR_OF_DAY, 12);
		this.opex.set(Calendar.HOUR, 12);
	}

	/**
	 * @param price
	 *          the price to set
	 */
	public void setPrice(double price) {

		this.price = price;
	}

	public void setVolume(long vol) {

		this.volume = vol;
	}
}
