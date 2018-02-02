
package net.ajaskey.market.tools.sipro.v5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
public class SipCommon {

	public final static double	THOUSAND	= 1e3;
	public final static double	MILLION		= 1e6;
	public final static double	BILLION		= 1e9;

	private final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	private int						ptr;
	private final int			INC;
	private final String	splitChar;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public SipCommon(String ch, int inc, int ver) {
		this.reset();
		this.INC = inc;
		this.splitChar = ch;
	}

	public DataSet5 getData5(String name, String line, DataSet5.dMode mode, double scaler) {

		final String fld[] = line.replace("\"", "").split(this.splitChar);

		final DataSet5 ds = new DataSet5(fld[1], name, fld[0], fld[2], fld, this.ptr, mode);
		final DataSet5 dsRet = DataSet5.scale(ds, scaler);
		//System.out.println(dsRet);
		this.ptr += this.INC;
		return dsRet;
	}

	/**
	 * net.ajaskey.market.tools.sipro.v4.getDate
	 *
	 * @return
	 * @throws ParseException
	 */
	public Calendar getDate(String line) throws ParseException {

		final String fld[] = line.replace("\"", "").split(this.splitChar);
		final int len = fld.length - 1;
		final String sdate = fld[len].trim();
		final Date d = sdf.parse(sdate);
		final Calendar ret = Calendar.getInstance();
		ret.setTime(d);
		return ret;
	}

	public void reset() {

		this.ptr = 2;
	}

}
