
package net.ajaskey.market.tools.optuma;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.ajaskey.market.misc.DateTime;
import net.ajaskey.market.optuma.PriceData;

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
public class OptumaPriceData {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public static List<PriceData> getPriceData(final String code) throws FileNotFoundException, IOException {

		final List<PriceData> pd = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(code))) {

			String line;
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 0) {
					final String fld[] = str.split(",");
					if (fld.length >= 7) {
						try {
							final Date d = sdf.parse(fld[1].trim());
							final DateTime dt = new DateTime(d);
							final PriceData p = new PriceData(dt, Double.parseDouble(fld[2].trim()), Double.parseDouble(fld[3].trim()),
							    Double.parseDouble(fld[4].trim()), Double.parseDouble(fld[5].trim()), Long.parseLong(fld[6].trim()));
							pd.add(p);
						} catch (final Exception e) {
						}
					}
				}
			}
		}

		//		if (pd.size() > 0) {
		//			Collections.reverse(pd);
		//		}
		return pd;

	}

}
