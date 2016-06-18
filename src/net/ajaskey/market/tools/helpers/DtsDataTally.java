
package net.ajaskey.market.tools.helpers;

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
public class DtsDataTally {

	public int		daily;
	public int		monthly;
	public int		yearly;
	public double	dailyAvg;
	public double	yearlyAvg;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DtsDataTally() {
		this.daily = 0;
		this.monthly = 0;
		this.yearly = 0;
		this.dailyAvg = 0.0;
		this.yearlyAvg = 0.0;
	}

	public String toString() {
		String str = String.format("Daily:%7d  MTD:%9d  YTD:%10d  DailyAvg:%11.2f  YTDAvg:%11.2f", this.daily,
		    this.monthly, this.yearly, this.dailyAvg, this.yearlyAvg);
		return str;
	}
}
