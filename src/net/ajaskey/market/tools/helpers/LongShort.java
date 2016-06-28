
package net.ajaskey.market.tools.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
public class LongShort {

	public enum MarketType {
		DEALER, PM, LEVERED, OTHER, TOTAL, NONRPT
	};
	
	public enum SourceType {
		NAS100,SP500
	}

	public final static SimpleDateFormat	sdf		= new SimpleDateFormat("yyMMdd");

	public MarketType											type;
	public SourceType                     source;
	public long														longPos;
	public long														shortPos;
	public double													pc;
	public Calendar												date	= Calendar.getInstance();

	/**
	 * This method serves as a constructor for the class.
	 * 
	 * @param d
	 *
	 */
	public LongShort(String l, String s, String d, MarketType mt, SourceType st) {
		try {

			date.setTime(sdf.parse(d.trim()));
			type=mt;
			source=st;

			longPos = Long.parseLong(l.trim());
			shortPos = Long.parseLong(s.trim());
			if (longPos > 0) {
				pc = (double) shortPos / (double) longPos;
			} else {
				pc = 0.0;
			}
		} catch (Exception e) {
			longPos = 0;
			shortPos = 0;
			pc = 0.0;
			e.printStackTrace();
		}
	}
}
