
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.tools.optuma.OptumaCommon;

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
public class GetRateData {

	/**
	 *
	 * net.ajaskey.market.tools.fred.dumpRates
	 *
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void dumpRates() throws FileNotFoundException, IOException {

		final List<String> rateFiles = new ArrayList<>();

		rateFiles.add("[DGS3MO] - 3M Treasury Constant Maturity Rate");
		rateFiles.add("[DGS6MO] - 6M Treasury Constant Maturity Rate");
		rateFiles.add("[DGS2] - 2Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS3] - 3Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS5] - 5Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS7] - 7Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS10] - 10Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS20] - 20Y Treasury Constant Maturity Rate");
		rateFiles.add("[DGS30] - 30Y Treasury Constant Maturity Rate");

		for (final String fil : rateFiles) {
			final String line = GetRateData.getLastLine(fil + ".csv");
			System.out.println(fil + "," + line);
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.getLastLine
	 *
	 * @param fname
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static String getLastLine(final String fname) throws FileNotFoundException, IOException {

		String ret = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(OptumaCommon.optumaPath + "FRED-Download\\" + fname))) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					ret = str;
				}
			}
		}

		return ret.trim();
	}

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(final String[] args) throws FileNotFoundException, IOException {

		GetRateData.dumpRates();

	}

}
