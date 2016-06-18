
package net.ajaskey.market.tools.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
public class DtsData {

	final static public SimpleDateFormat	sdf	= new SimpleDateFormat("yyMMdd");

	private final DtsDataTally						with;
	private final DtsDataTally						ind;
	private final DtsDataTally						corp;
	private final Calendar								date;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DtsData(String theDate) {
		this.with = new DtsDataTally();
		this.ind = new DtsDataTally();
		this.corp = new DtsDataTally();
		this.date = Calendar.getInstance();
		this.setDate(theDate);
	}

	/**
	 * 
	 * net.ajaskey.market.tools.helpers.getCorp
	 *
	 * @return
	 */
	public DtsDataTally getCorp() {
		return this.corp;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.getDate
	 *
	 * @return
	 */
	public Calendar getDate() {
		return this.date;
	}

	/**
	 * 
	 * net.ajaskey.market.tools.helpers.getInd
	 *
	 * @return
	 */
	public DtsDataTally getInd() {
		return this.ind;
	}

	/**
	 * 
	 * net.ajaskey.market.tools.helpers.getWith
	 *
	 * @return
	 */
	public DtsDataTally getWith() {
		return this.with;
	}

	/**
	 * 
	 * net.ajaskey.market.tools.helpers.setCorp
	 *
	 * @param str
	 */
	public void setCorp(String str) {

		if (str == null) {
			System.out.println("Error : setCorp(String str) String is NULL!");
			return;
		}

		try {
			final int idx = str.indexOf("Taxes") + 6;
			final String s = str.substring(idx).trim().replaceAll("\\$", "").replaceAll(",", "").trim();

			final String fld[] = s.split("\\s+");
			this.corp.daily = Integer.parseInt(fld[0].trim());
			this.corp.monthly = Integer.parseInt(fld[1].trim());
			this.corp.yearly = Integer.parseInt(fld[2].trim());
		} catch (final Exception e) {
			System.out.println("Error processing line : " + str);
			e.printStackTrace();
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.setDate
	 *
	 * @param str
	 */
	public void setDate(String str) {

		if (str == null) {
			System.out.println("Error : setDate(String str) String is NULL!");
			return;
		}

		try {

			final int idx = str.indexOf("00.txt");
			if (idx > 5) {
				final String aDate = str.substring(0, idx);
				this.date.setTime(sdf.parse(aDate));
				//Utils.printCalendar(this.date);
			}
		} catch (Exception e) {
			System.out.println("Error processing date : " + str);
			e.printStackTrace();
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.setInd
	 *
	 * @param str
	 */
	public void setInd(String str) {

		if (str == null) {
			System.out.println("Error : setInd(String str) String is NULL!");
			return;
		}

		try {
			final int idx = str.indexOf("Taxes") + 6;
			final String s = str.substring(idx).trim().replaceAll("\\$", "").replaceAll(",", "").trim();

			final String fld[] = s.split("\\s+");
			this.ind.daily = Integer.parseInt(fld[0].trim());
			this.ind.monthly = Integer.parseInt(fld[1].trim());
			this.ind.yearly = Integer.parseInt(fld[2].trim());
		} catch (final Exception e) {
			System.out.println("Error processing line : " + str);
			e.printStackTrace();
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.setWith
	 *
	 * @param str
	 */
	public void setWith(String str) {

		if (str == null) {
			System.out.println("Error : setWith(String str) String is NULL!");
			return;
		}

		try {
			final int idx = str.indexOf("Taxes") + 6;
			final String s = str.substring(idx).trim().replaceAll("\\$", "").replaceAll(",", "").trim();

			final String fld[] = s.split("\\s+");
			this.with.daily = Integer.parseInt(fld[0].trim());
			this.with.monthly = Integer.parseInt(fld[1].trim());
			this.with.yearly = Integer.parseInt(fld[2].trim());
		} catch (final Exception e) {
			System.out.println("Error processing line : " + str);
			e.printStackTrace();
		}
	}

	public String toString() {
		String str = Utils.stringCalendar(this.date);
		//str += "\n\tWithheld   : " + this.with + "\n\tIndividual : " + this.ind + "\n\tCorporate  : " + this.corp;
		str += String.format("%n\tWithheld   ==> %s%n\tIndividual ==> %s%n\tCorporate  ==> %s", this.with, this.ind, this.corp);
		return str;
	}

}
