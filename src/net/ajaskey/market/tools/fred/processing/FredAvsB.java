
package net.ajaskey.market.tools.fred.processing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.tools.fred.FredCommon;

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
public class FredAvsB {

	/**
	 * net.ajaskey.market.tools.fred.processing.main
	 *
	 * @param args
	 */
	public static void main(final String[] args) {

		final List<String> fileOnes = new ArrayList<>();
		final List<String> fileTwos = new ArrayList<>();

		fileOnes.add("GDP");
		fileTwos.add("MVGFD027MNFRBDAL");

		fileOnes.add("GDP");
		fileTwos.add("CASACBM027NBOG");

		fileOnes.add("GDP");
		fileTwos.add("CNP16OV");

		fileOnes.add("BOGMBASE");
		fileTwos.add("CNP16OV");

		fileOnes.add("DPSACBM027NBOG");
		fileTwos.add("CNP16OV");

		fileOnes.add("MVGFD027MNFRBDAL");
		fileTwos.add("CNP16OV");

		fileOnes.add("TOTALNS");
		fileTwos.add("CNP16OV");

		fileOnes.add("INDPRO");
		fileTwos.add("CNP16OV");

		fileOnes.add("TTLCON");
		fileTwos.add("CNP16OV");

		fileOnes.add("PAYNSA");
		fileTwos.add("CNP16OV");

		fileOnes.add("A576RC1");
		fileTwos.add("CNP16OV");

		fileOnes.add("DSPI");
		fileTwos.add("CNP16OV");

		fileOnes.add("A068RC1");
		fileTwos.add("CNP16OV");

		fileOnes.add("PCE");
		fileTwos.add("CNP16OV");

		fileOnes.add("W055RC1");
		fileTwos.add("CNP16OV");

		fileOnes.add("PMSAVE");
		fileTwos.add("CNP16OV");

		fileOnes.add("TOTBUSSMNSA");
		fileTwos.add("CNP16OV");


		
		for (int i = 0; i < fileOnes.size(); i++) {

			try {

				String f2 = String.format("over %s", fileTwos.get(i));
				if (fileTwos.get(i).equalsIgnoreCase("CNP16OV")) {
					f2 = "per Capita";
				}

				final String fullname = String.format("%s %s.csv", fileOnes.get(i), f2);
				System.out.println(fullname);

				IngestOptumaFile.process(FredCommon.fredPath + fileOnes.get(i) + ".csv", FredCommon.fredPath + fileTwos.get(i) + ".csv", fullname,
				    IngestOptumaFile.DIVIDE, 1.0);

			} catch (final FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
