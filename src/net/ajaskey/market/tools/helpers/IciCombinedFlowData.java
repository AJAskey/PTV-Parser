
package net.ajaskey.market.tools.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.optuma.ProcessICI;

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
public class IciCombinedFlowData {

	public Calendar	date;
	public long			equityDomestic;
	public long			equityWorld;
	public long			bondTaxable;
	public long			bondMuni;
	public long			commodity;
	public boolean	valid;

	private static SimpleDateFormat	sdf				= new SimpleDateFormat("MM/dd/yyyy");
	private static SimpleDateFormat	sdfOptuma	= new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public IciCombinedFlowData() {
		this.valid = false;
		equityDomestic = 0;
		equityWorld = 0;
		bondTaxable = 0;
		bondMuni = 0;
		commodity = 0;
	}

	public void build(String line) {

		IciCombinedFlowData ret = new IciCombinedFlowData();
		try {
			String str = line.replaceAll(",", "").replaceAll("\"", "").trim();
			String fld[] = str.split("\\s+");
			final Date date = sdf.parse(fld[0].trim());
			this.date = Calendar.getInstance();
			this.date.setTime(date);
			this.equityDomestic = Long.parseLong(fld[3].trim());
			this.equityWorld = Long.parseLong(fld[4].trim());
			this.bondTaxable = Long.parseLong(fld[7].trim());
			this.bondMuni = Long.parseLong(fld[8].trim());
			this.commodity = Long.parseLong(fld[9].trim());
			this.valid = true;
		} catch (Exception e) {
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = sdfOptuma.format(date.getTime());
		ret += Utils.TAB + equityDomestic;
		ret += Utils.TAB + equityWorld;
		ret += Utils.TAB + bondTaxable;
		ret += Utils.TAB + bondMuni;
		ret += Utils.TAB + commodity;
		return ret;
	}

}
