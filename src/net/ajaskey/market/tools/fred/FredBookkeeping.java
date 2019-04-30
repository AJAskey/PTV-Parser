
package net.ajaskey.market.tools.fred;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import net.ajaskey.market.misc.DateTime;
import net.ajaskey.market.misc.Debug;
import net.ajaskey.market.misc.Utils;

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
public class FredBookkeeping {

	private static final String	fsiFilename				= "fred-series-info.txt";
	private static final String	tryAgainFilename	= "fred-try-again.txt";

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");

	private static List<DataSeriesInfo> dsiList = new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {

		Debug.init("fred-bookkeeping.dbg");
		FredDataDownloader.tryAgainFile = new PrintWriter(tryAgainFilename);

		final File folder = new File(FredCommon.fredPath);
		//		File existingFiles[] = folder.listFiles();
		//
		//		for(File f : existingFiles) {
		//			System.out.println(f.getName());
		//		}

		final Set<String> uniqCodes = new HashSet<>();

		final String[] ext = new String[] { "csv" };
		final List<File> files = (List<File>) FileUtils.listFiles(folder, ext, false);
		for (final File file : files) {
			final String name = file.getName();
			//Ignore derived TREAST files
			if (!name.contains("TREAST-")) {
				final String f1 = name.replace(".csv", "");
				final String f2 = f1.replace("[", "").trim();
				final int idx = f2.indexOf("]");
				String f3 = f2;
				if (idx > 0) {
					f3 = f2.substring(0, idx).trim();
				}
				uniqCodes.add(f3);
			}
		}

		// for later : List<DataSeriesInfo> oldList = FredCommon.readSeriesInfo(fsiFilename );

		final List<String> codes = new ArrayList<>(uniqCodes);
		Collections.sort(codes);

		FredBookkeeping.process(codes);

		FredDataDownloader.tryAgainFile.close();

		Utils.sleep(2500);
		Debug.log("Processing retry attempts...");

		final List<String> retry = FredCommon.readSeriesList(tryAgainFilename);
		FredBookkeeping.process(retry);

		FredDataDownloader.tryAgainFile = new PrintWriter(tryAgainFilename);

		System.out.println(codes.size());

		Collections.sort(dsiList, new DsiSorter());
		FredCommon.writeSeriesInfo(dsiList, fsiFilename);

		FredDataDownloader.tryAgainFile.close();

	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.process
	 *
	 * @param codes
	 * @throws FileNotFoundException
	 */
	private static void process(final List<String> codes) throws FileNotFoundException {

		try (PrintWriter pw = new PrintWriter("CodesToUpdate.txt")) {

			int knt = 0;
			for (final String code : codes) {
				final File f = new File(FredCommon.fredPath + "/" + code + ".csv");
				final DateTime cLastUpdate = new DateTime(f.lastModified());
				cLastUpdate.add(DateTime.DATE, -1);
				final String lastUpdate = cLastUpdate.toString();

				final DataSeriesInfo dsi = FredCommon.queryFredDsi(code, lastUpdate);
				if (dsi != null) {
					System.out.printf("%-20s --> %-20s\t\t%15s%n", code, lastUpdate, dsi.getLastObservation().toString());
					dsiList.add(dsi);

					if (cLastUpdate.isLessThan(dsi.getLastObservation())) {
						pw.printf("%s\t%s%n", dsi.getName(), dsi.getTitle());
					}
				}
				// Set to lower number for testing
				if (++knt > 20050) {
					break;
				}
			}
		}
	}
}
