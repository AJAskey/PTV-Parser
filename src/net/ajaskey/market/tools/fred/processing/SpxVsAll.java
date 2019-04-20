
package net.ajaskey.market.tools.fred.processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.optuma.PriceData;
import net.ajaskey.market.tools.fred.FredCommon;
import net.ajaskey.market.tools.optuma.OptumaPriceData;

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
public class SpxVsAll {

	private static List<PriceData> spxPrices = null;

	/**
	 * 
	 * net.ajaskey.market.tools.fred.processing.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final File folder = new File(FredCommon.fredPath);

		final List<String> codeList = new ArrayList<>();
		codeList.add("[GDP]");

		final List<File> fileList = new ArrayList<>();

		spxPrices = OptumaPriceData.getPriceData("C:\\Users\\Andy\\Documents\\PriceData\\World Indices\\S\\SPX.csv");
		for (PriceData pd : spxPrices) {
			System.out.println(pd);
		}

		final String[] ext = new String[] { "csv" };
		final List<File> files = (List<File>) FileUtils.listFiles(folder, ext, false);
		for (final File file : files) {
			fileList.add(file);
		}

		for (String s : codeList) {
			for (File f : fileList) {

				if (f.getName().contains(s)) {

					System.out.println(f.getAbsolutePath());
					List<OptumaFileData> ofd = IngestOptumaFile.readDataFile(f.getAbsolutePath());

					List<OptumaFileData> mergedData = merge(ofd);

					String outfile = f.getAbsolutePath().replace("\\[", "\\[SPX over ").replace("- ", "- SPX over ");
					System.out.println(outfile);

					try (PrintWriter pw = new PrintWriter(outfile)) {

						for (OptumaFileData d : mergedData) {
							pw.println(d);
						}
					}

				}
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.fred.processing.merge
	 *
	 * @param spxPrices
	 * @param of
	 * @return
	 */
	private static List<OptumaFileData> merge(List<OptumaFileData> ofd) {

		List<OptumaFileData> ret = new ArrayList<>();

		for (OptumaFileData d : ofd) {

			double scaler = 100000000000.0 * 100.0;

			double price = getSpxClose(d.date);
			double ratio = getRatio(price, d.val, scaler);
			OptumaFileData out = new OptumaFileData(d.date, ratio);
			ret.add(out);
		}

		return ret;
	}

	/**
	 * net.ajaskey.market.tools.fred.processing.getRatio
	 *
	 * @param price
	 * @param val
	 * @param scaler
	 * @return
	 */
	private static double getRatio(double price, double val, double scaler) {

		double ret = 0.0;

		if ((Math.abs(price) > 0.0) && (Math.abs(val) > 0.0)) {
			ret = price / val * scaler;
		}
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.fred.processing.getSpxClose
	 *
	 * @param date
	 * @return
	 */
	private static double getSpxClose(Calendar date) {

		for (PriceData pd : spxPrices) {
			if (Utils.sameDate(pd.date, date)) {
				return pd.close;
			} else if (date.after(pd.date)) {
				return pd.close;
			}
		}
		return 0;
	}
}
