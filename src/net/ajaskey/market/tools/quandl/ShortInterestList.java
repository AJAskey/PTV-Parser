
package net.ajaskey.market.tools.quandl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;

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
public class ShortInterestList {

	public String						name;
	public Calendar					latest;
	public int							dateKnt;
	List<ShortInterestData>	list	= null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public ShortInterestList() {
		this.dateKnt = 0;
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public ShortInterestList(String name) {
		this.name = name;
		this.latest = Calendar.getInstance();
		this.latest.add(Calendar.YEAR, -10);
		this.dateKnt = 0;
		this.list = new ArrayList<>();
	}

	@Override
	public String toString() {

		final StringBuilder result = new StringBuilder();
		final String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" Object {");
		result.append(newLine);

		final Field[] fields = this.getClass().getDeclaredFields();

		for (final Field field : fields) {
			result.append("  ");
			try {
				result.append(field.getName());
				result.append(": ");

				//System.out.println(field.getType());

				final String ft = field.getType().toString();
				if (ft.equals("class java.util.Calendar")) {
					result.append(Utils.stringDate((Calendar) field.get(this)));
				} else {
					result.append(field.get(this));
				}

			} catch (final IllegalAccessException ex) {
				System.out.println(ex);
			}
			result.append(newLine);
		}
		result.append("}");

		return result.toString();
	}

}
