
package net.ajaskey.market.tools.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This class...
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class SpxEarningsData {

	private static final double NA_VALUE = -99999999.99;

	public String	ticker;
	public double	mktcap;
	public double	shares;
	public double	netIncAfterTax;
	public double	eps;
	public double	eps1y;
	public double	div;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public SpxEarningsData() {
		this.ticker = null;
		this.mktcap = 0;
		this.shares = 0;
		this.netIncAfterTax = 0;
		this.eps = 0;
		this.eps1y = 0;
		this.div = 0;
	}

	public static List<SpxEarningsData> readData(String fname) throws IOException {

		final List<SpxEarningsData> data = new ArrayList<>();
		final Charset charset = Charset.forName("UTF-8");

		final File file = new File("data\\" + fname);
		final Path path = file.toPath();

		String line;
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {

			while ((line = reader.readLine()) != null) {
				if (line.length() > 10) {
					try {
						final SpxEarningsData d = new SpxEarningsData();

						final String fld[] = line.split("\\t");

						// for (String s : fld) {
						// System.out.printf("%12s", s);
						// }
						// System.out.println();

						d.ticker = fld[0].trim().replaceAll("\"", "");

						if (!d.ticker.contains("BRK.A")) {

							if (fld[1].trim().length() > 0.0) {
								d.mktcap = Double.parseDouble(fld[1].trim());
							}

							if (fld[2].trim().length() > 0.0) {
								d.shares = Double.parseDouble(fld[2].trim());
								if (d.shares == NA_VALUE) {
									d.shares = 0.0;
								}
							}

							if (fld[3].trim().length() > 0.0) {
								d.netIncAfterTax = Double.parseDouble(fld[3].trim());
								if (d.netIncAfterTax == NA_VALUE) {
									d.netIncAfterTax = 0.0;
								}
							}

							if (fld[4].trim().length() > 0.0) {
								d.eps = Double.parseDouble(fld[4].trim());
								if (d.eps == NA_VALUE) {
									d.eps = 0.0;
								}
							}

							if (fld[5].trim().length() > 0.0) {
								d.eps1y = Double.parseDouble(fld[5].trim());
								if (d.eps1y == NA_VALUE) {
									d.eps1y = 0.0;
								}
							}

							if (fld[6].trim().length() > 0.0) {
								d.div = Double.parseDouble(fld[6].trim());
							}

							System.out.print(d);

							data.add(d);
						}
					} catch (final Exception e) {
						System.out.println("Error : " + line);
					}
				}
			}
		}

		return data;
	}

	@Override
	public String toString() {

		final String str = String.format("%-9s %10.1f %11.3f %10.1f %10.3f %10.3f %n", this.ticker, this.mktcap,
		    this.shares, this.netIncAfterTax, this.eps, this.eps1y);
		return str;

	}

}
