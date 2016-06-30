
package net.ajaskey.market.tools.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;

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

	final static public SimpleDateFormat	sdf			= new SimpleDateFormat("yyMMdd");

	public static final List<DtsData>			dtsList	= new ArrayList<>();

	/**
	 *
	 * net.ajaskey.market.tools.helpers.findData
	 *
	 * @param cal
	 * @return
	 */
	public static DtsData findData(Calendar cal) {
		if (cal != null) {
			for (final DtsData d : DtsData.dtsList) {
				if (d.getDate().equals(cal)) {
					return d;
				} else if (d.getDate().after(cal)) {
					return d;
				}
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.findData
	 *
	 * @param cal
	 * @return
	 */
	public static DtsData findData(int days, int year) {
		int knt = 0;
		for (final DtsData d : DtsData.dtsList) {
			if (d.getDate().get(Calendar.YEAR) == year) {
				knt++;
				if (knt >= days) {
					return d;
				}
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.findData
	 *
	 * @param days
	 * @param month
	 * @param year
	 * @return
	 */
	public static DtsData findData(int days, int month, int year) {
		int knt = 0;
		for (final DtsData d : DtsData.dtsList) {
			if (d.getDate().get(Calendar.YEAR) == year) {
				if (d.getDate().get(Calendar.MONTH) == month) {
					knt++;
					if (knt >= days) {
						return d;
					}
				}
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.findLastOfMonthData
	 *
	 * @param month
	 * @param year
	 * @return
	 */
	public static DtsData findLastOfMonthData(int month, int year) {
		boolean monthFound = false;
		DtsData lastDayData = null;
		for (final DtsData d : DtsData.dtsList) {
			if (d.getDate().get(Calendar.YEAR) == year) {
				if (d.getDate().get(Calendar.MONTH) == month) {
					lastDayData = d;
					monthFound = true;
				} else if (monthFound) {
					return lastDayData;
				}
			}
		}
		return lastDayData;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.findMonthlyChangeTotal
	 *
	 * @param older
	 * @param newer
	 * @return
	 */
	public static double findMonthlyChangeTotal(DtsData older, DtsData newer) {
		final double newTot = newer.getWith().monthly + newer.getInd().monthly + newer.getCorp().monthly;
		final double oldTot = older.getWith().monthly + older.getInd().monthly + older.getCorp().monthly;
		final double chg = (newTot - oldTot) / oldTot;
		return chg * 100.0;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.findYearlyChangeTotal
	 *
	 * @param older
	 * @param newer
	 * @return
	 */
	public static double findYearlyChangeTotal(DtsData older, DtsData newer) {
		final double newTot = newer.getWith().yearly + newer.getInd().yearly + newer.getCorp().yearly;
		final double oldTot = older.getWith().yearly + older.getInd().yearly + older.getCorp().yearly;
		final double chg = (newTot - oldTot) / oldTot;
		return chg * 100.0;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.formatDate
	 *
	 * @param date
	 * @return
	 */
	public static String formatDate(Calendar date) {
		String str = Utils.stringDate2(date) + "\t" + date.get(Calendar.DAY_OF_YEAR);
		str += "\t" + DtsData.getDataDaysInYear(date.get(Calendar.DATE), date.get(Calendar.MONTH), date.get(Calendar.YEAR));
		str += "\t"
		    + DtsData.getDataDaysInMonth(date.get(Calendar.DATE), date.get(Calendar.MONTH), date.get(Calendar.YEAR));
		return str;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.getDataDaysInMonth
	 *
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static int getDataDaysInMonth(int day, int month, int year) {
		int ret = 0;
		for (final DtsData d : dtsList) {
			if (d.getDate().get(Calendar.YEAR) == year) {
				if (d.getDate().get(Calendar.MONTH) == month) {
					if (d.getDate().get(Calendar.DATE) <= day) {
						ret++;
					}
				}
			}
		}

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.getDataDaysInYear
	 *
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static int getDataDaysInYear(int day, int month, int year) {
		int ret = 0;
		for (final DtsData d : dtsList) {
			if (d.getDate().get(Calendar.YEAR) == year) {
				if (d.getDate().get(Calendar.MONTH) <= month) {
					ret++;
					if ((d.getDate().get(Calendar.MONTH) == month) && (d.getDate().get(Calendar.DATE) >= day)) {
						return ret;
					}
				}
			}
		}

		return 0;
	}

	/**
	 *
	 * net.ajaskey.market.tools.helpers.newCalendar
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Calendar newCalendar(int year, int month, int day) {
		final Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, 0, 0, 0);
		return cal;
	}

	private final DtsDataTally	with;

	private final DtsDataTally	ind;

	private final DtsDataTally	corp;

	private final Calendar			date;

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
				// Utils.printCalendar(this.date);
			}
		} catch (final Exception e) {
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

	@Override
	public String toString() {
		String str = DtsData.formatDate(this.date);

		final long dtot = this.getWith().daily + this.getInd().daily + this.getCorp().daily;
		final long mtot = this.getWith().monthly + this.getInd().monthly + this.getCorp().monthly;
		final long ytot = this.getWith().yearly + this.getInd().yearly + this.getCorp().yearly;
		str += String.format(
		    "%n\tWithheld   ==> %s%n\tIndividual ==> %s%n\tCorporate  ==> %s%n\tTotal      ==>%sDaily:%7d    MTD:%9d    YTD:%10d",
		    this.with, this.ind, this.corp, " ", dtot, mtot, ytot);
		return str;
	}

	public String toWithheldString() {
		String str = Utils.stringDate2(this.date) + "\t" + this.date.get(Calendar.DAY_OF_YEAR);
		str += "\t" + DtsData.getDataDaysInYear(this.date.get(Calendar.DATE), this.date.get(Calendar.MONTH),
		    this.date.get(Calendar.YEAR));
		str += "\t" + DtsData.getDataDaysInMonth(this.date.get(Calendar.DATE), this.date.get(Calendar.MONTH),
		    this.date.get(Calendar.YEAR));
		str += String.format("%n\tWithheld   ==> %s%n", this.with);
		return str;
	}

}
