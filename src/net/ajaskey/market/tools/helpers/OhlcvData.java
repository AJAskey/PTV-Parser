
package net.ajaskey.market.tools.helpers;

import java.text.Format;
import java.util.Calendar;

import net.ajaskey.market.misc.Utils;

/**
 * This class...
 *
 * @author ajask_000
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
public class OhlcvData {

	private static final String TAB = "\t";

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public OhlcvData() {
		// TODO Auto-generated constructor stub
	}

	public OhlcvData(Calendar cal, double o, double h, double l, double c, long vol) {
		date = cal;
		open = o;
		high = h;
		low = l;
		close = c;
		volume = vol;
		if ((o == h) && (h == l) && (l == c)) {
			form = FormType.SHORT;
		} else {
			form = FormType.FULL;
		}
	}

	public Calendar	date;
	public double		open;
	public double		high;
	public double		low;
	public double		close;
	public long			volume;

	public enum FormType {
		SHORT, FULL
	};

	private FormType form;

	@Override
	public String toString() {
		String ret = String.format("%s\t%10.2f\t%10.2f\t%10.2f\t%10.2f\t%10d\t%s", Utils.stringDate(date), open, high, low,
		    close, volume, form);
		return ret;
	}
	
	public String toShortString() {
		String ret = String.format("%s\t%10.2f", Utils.stringDate(date), close);
		return ret;
	}

	/**
	 * @return the form
	 */
	public FormType getForm() {
		return form;
	}

	/**
	 * @param form
	 *          the form to set
	 */
	public void setForm(FormType form) {
		this.form = form;
	}

}
