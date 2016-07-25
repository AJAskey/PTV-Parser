
package net.ajaskey.market.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.helpers.DtsData;
import net.ajaskey.market.tools.helpers.PEAnalysisData;

/**
 * This class...
 *
 * @author ajask_000
 *         <p>
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *         </p>
 *         <p>
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 *
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software.
 *         </p>
 * 
 *         <p>
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *         </p>
 *
 */
public class PEAnalysis {

	public static List<PEAnalysisData>	GaapEps	= new ArrayList<>();
	public static List<PEAnalysisData>	Vix			= new ArrayList<>();
	public static List<PEAnalysisData>	Spx			= new ArrayList<>();

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ParseException {
		// final String folderPath = "d:/temp/dts";
		final Charset charset = Charset.forName("UTF-8");
		String line = null;

		// Read SPX data
		File file = new File("data\\SPX-Close.txt");
		Path path = file.toPath();
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {

			while ((line = reader.readLine()) != null) {
				if (line.length() > 10) {
					String fld[] = line.split("\\s+");

					PEAnalysisData d = new PEAnalysisData(fld[0].trim(), fld[1].trim());
					if (d.price > 0.0) {
						Spx.add(d);
					}
				}
			}
		}

		// Read VIX data
		file = new File("data\\VIX.txt");
		path = file.toPath();
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {

			while ((line = reader.readLine()) != null) {
				if (line.length() > 10) {
					String fld[] = line.split("\\s+");

					PEAnalysisData d = new PEAnalysisData(fld[0].trim(), fld[1].trim());
					if (d.price > 0.0) {
						Vix.add(d);
					}
				}
			}
		}

		// Read EPS data
		file = new File("data\\GAAP-EPS.txt");
		path = file.toPath();
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {

			while ((line = reader.readLine()) != null) {
				if (line.length() > 10) {
					String fld[] = line.split("\\s+");

					PEAnalysisData d = new PEAnalysisData(fld[0].trim(), fld[1].trim());
					if (d.price > 0.0) {
						GaapEps.add(d);
					}
				}
			}
		}

		System.out.println("Date,EPS,SPX,VIX,PE,PE-VIX");
		
		// Process based on GAAP-EPS Date
		for (PEAnalysisData pe : GaapEps) {
			PEAnalysisData spx = getSPX(pe.date);
			PEAnalysisData vix = getVIX(pe.date);

			if ((spx != null) && (vix != null)) {
				double gpe = spx.price / pe.price;
				double gpeVix = gpe / vix.price;
				System.out.println(Utils.getString(pe.date) + "," + pe.price + "," + spx.price + "," + vix.price + "," + gpe + "," + gpeVix);
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.getSPX
	 *
	 * @param date
	 * @return
	 */
	private static PEAnalysisData getSPX(Calendar date) {
		for (PEAnalysisData pe : Spx) {
			if (Utils.sameDate(date, pe.date)) {
				return pe;
			}
		}
		return null;
	}

	private static PEAnalysisData getVIX(Calendar date) {
		for (PEAnalysisData pe : Vix) {
			if (Utils.sameDate(date, pe.date)) {
				return pe;
			}
		}
		return null;
	}

}
