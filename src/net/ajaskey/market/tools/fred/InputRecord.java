
package net.ajaskey.market.tools.fred;

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
public class InputRecord {

	public String		series;
	public double		change;
	public boolean	noZeros;
	public boolean	estimateData;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public InputRecord(String input) {

		try {
			final String fld[] = input.split("\\s+");
			change = 0;
			noZeros = true;
			estimateData = false;
			series = fld[0].trim();
			
			if (fld.length == 2) {
				change = Double.parseDouble(fld[1].trim());
			} else if (fld.length == 3) {
				change = Double.parseDouble(fld[1].trim());
				noZeros = Boolean.parseBoolean(fld[2].trim());
			} else if (fld.length >= 4) {
				change = Double.parseDouble(fld[1].trim());
				noZeros = Boolean.parseBoolean(fld[2].trim());
				estimateData = Boolean.parseBoolean(fld[3].trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
			series = "";
		}
	}

	@Override
	public String toString() {

		return String.format("%-25s %9.1f  %5s  %5s", series, change, noZeros, estimateData);
	}

}
