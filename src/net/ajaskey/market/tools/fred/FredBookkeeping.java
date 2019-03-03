
package net.ajaskey.market.tools.fred;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

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

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Debug.pwDbg = new PrintWriter("fred-bookkeeping.dbg");
		FredDataDownloader.tryAgainFile = new PrintWriter("fred-try-again.txt");

		final File folder = new File(FredCommon.fredPath);
		//		File existingFiles[] = folder.listFiles();
		//		
		//		for(File f : existingFiles) {
		//			System.out.println(f.getName());
		//		}

		final Set<String> uniqCodes = new HashSet<>();

		String[] ext = new String[] { "csv" };
		List<File> files = (List<File>) FileUtils.listFiles(folder, ext, false);
		for (File file : files) {
			String name = file.getName();
			if (!name.contains("TREAST-")) {
				String f1 = name.replace(".csv", "");
				String f2 = f1.replace("[", "").trim();
				int idx = f2.indexOf("]");
				String f3 = f2;
				if (idx > 0) {
					f3 = f2.substring(0, idx).trim();
				}
				uniqCodes.add(f3);
			}
		}
		
		String fsiFilename = "fred-series-info.txt";
		
		// for later : List<DataSeriesInfo> oldList = FredCommon.readSeriesInfo(fsiFilename );

		final List<String> codes = new ArrayList<>(uniqCodes);
		Collections.sort(codes);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");

		PrintWriter pw = new PrintWriter(fsiFilename);

		List<DataSeriesInfo> dsiList = new ArrayList<>();

		int knt = 0;
		for (String s : codes) {
			File f = new File(FredCommon.fredPath + "/" + s + ".csv");

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(f.lastModified());

			String date = sdf.format(f.lastModified());

			DataSeriesInfo dsi = FredCommon.queryFredDsi(s);
			if (dsi != null) {
				System.out.printf("%-20s --> %-20s\t\t%15s%n", s, date, Utils.getCurrentTime());
				dsiList.add(dsi);
			}
			// Set to lower number for testing
			if (++knt > 20000) {
				break;
			}
		}
		System.out.println(codes.size());

		Collections.sort(dsiList, new DsiSorter());
		FredCommon.writeSeriesInfo(dsiList, "fredseriesinfo.txt");

		pw.close();
		FredDataDownloader.tryAgainFile.close();

	}

}
