
package net.ajaskey.market.tools.smartmoney;

import java.util.Calendar;

import net.ajaskey.market.misc.Utils;

/**
 * This class...
 *
 * @author Andy <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class SmartMoneyData {

	public Calendar	day;
	public double		high;
	public double		low;
	public double		close;
	public long			volume;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public SmartMoneyData(Calendar hour, String line) {

		this.day = Utils.buildCalendar(hour);
		String fld[] = line.split(",");
		this.high = Double.parseDouble(fld[1]);
		this.low = Double.parseDouble(fld[2]);
		this.close = Double.parseDouble(fld[3]);
		this.volume = Long.parseLong(fld[4]);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		String s = String.format("%s : %15.2f %15.2f %15.2f %10d",Utils.getStringFull(this.day), this.high, this.low, this.close, this.volume);
		return s;
	}
}
