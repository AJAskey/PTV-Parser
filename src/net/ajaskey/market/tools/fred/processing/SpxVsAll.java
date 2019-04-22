
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

		//codeList.add("SP500_Earnings");

		codeList.add("[GDP]");
		codeList.add("[CP]");
		codeList.add("[INDPRO]");
		codeList.add("[TTLCON]");
		codeList.add("[PAYNSA]");
		codeList.add("[TOTCINSA]");
		codeList.add("[TOTBUSSMNSA]");
		codeList.add("[RETAILSMNSA]");
		codeList.add("[WHLSLRSMNSA]");
		codeList.add("[MNFCTRSMNSA]");
		codeList.add("[A939RC0Q052SBEA]");
		codeList.add("[TNWBSHNO]");
		codeList.add("[UMTMNO]");
		codeList.add("[TOTALNS]");
		codeList.add("[GPDI]");
		codeList.add("[HSN1FNSA]");
		codeList.add("[TLMFGCON]");
		codeList.add("[AMBNS]");
		codeList.add("[CAPUTLB5640CS]");
		codeList.add("[FRGSHPUSM649NCIS]");
		codeList.add("[SP500]");

		final List<File> fileList = new ArrayList<>();

		spxPrices = OptumaPriceData.getPriceData("C:\\Users\\Andy\\Documents\\PriceData\\World Indices\\S\\SPX.csv");

		final String[] ext = new String[] { "csv" };
		final List<File> files = (List<File>) FileUtils.listFiles(folder, ext, false);
		for (final File file : files) {
			fileList.add(file);
		}
		//File pefile = new File("C:\\Data\\MA\\CSV Data\\Quandl\\SP500_Earnings.csv");
		//fileList.add(pefile);

		for (String s : codeList) {

			for (File f : fileList) {

				if (f.getName().contains(s)) {

					//System.out.println(f.getAbsolutePath());
					List<OptumaFileData> ofd = IngestOptumaFile.readDataFile(f.getAbsolutePath());

					List<OptumaFileData> mergedData = merge(ofd);

					String fname = f.getAbsolutePath();
					String outfile = "";
					if (fname.contains("Quandl")) {
						outfile = "C:\\Data\\MA\\CSV Data\\Quandl\\SPX Growth vs SP500 Earnings Growth.csv";
					} else {
						outfile = fname.replace("\\[", "\\[SPX Growth vs ").replace("- ", "- SPX Growth vs ")
						    .replace("]", " Growth]").replace(".csv", " Growth.csv");
					}
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

		double totalChg = 1.0;

		for (int i = 1; i < ofd.size(); i++) {

			double price1 = getSpxClose(ofd.get(i - 1).date);
			double price2 = getSpxClose(ofd.get(i).date);

			if (Math.abs(price1) > 0.0 && Math.abs(price2) > 0.0) {

				double pChg = (price2 - price1) / price1;

				price1 = ofd.get(i - 1).val;
				price2 = ofd.get(i).val;

				double vChg = 0.0;
				if (Math.abs(price1) > 0.0 && Math.abs(price2) > 0.0) {
					vChg = (price2 - price1) / price1;
					totalChg += (pChg - vChg);
				}

				//System.out.printf("%.3f\t %.3f\t%.3f\t%.3f\t%.3f%n", pChg, vChg, totalChg, price1, price2);

				OptumaFileData out = new OptumaFileData(ofd.get(i).date, totalChg);
				ret.add(out);
			}
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

		//System.out.printf("%s\t%s%n", Utils.sdf.format(date.getTime()), Utils.sdf.format(spxPrices.get(0).date.getTime()));

		if (date.before(spxPrices.get(0).date)) {
			return 0.0;
		}

		for (PriceData pd : spxPrices) {

			//System.out.printf("%s\t%s%n", Utils.sdf.format(date.getTime()), Utils.sdf.format(pd.date.getTime()));

			if (Utils.sameDate(pd.date, date)) {
				return pd.close;
			} else if (pd.date.after(date)) {
				return pd.close;
			}
		}
		return 0;
	}
}
