
package net.ajaskey.market.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.helpers.OhlcvData;
import net.ajaskey.market.tools.helpers.ProcessExcel;
import net.ajaskey.market.tools.helpers.SortOhlcv;

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
public class ConvertOHLCV {

	final static private Charset					charset		= Charset.forName("UTF-8");
	final private static SimpleDateFormat	sdf				= new SimpleDateFormat("MM-dd-yyyy");
	static private List<OhlcvData>				data			= new ArrayList<>();;
	static private OhlcvData.FormType			form			= OhlcvData.FormType.SHORT;
	final private static String						shortPath	= "C:/Users/ajask_000/Documents/Market Analyst 8/CSV Data/Dc";
	final private static String						fullPath	= "C:/Users/ajask_000/Documents/Market Analyst 8/CSV Data/Dohlcv";

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ParseException {

		final JFileChooser chooser = new JFileChooser("C:\\Users\\ajask_000\\Downloads");
		final FileNameExtensionFilter filter = new FileNameExtensionFilter("Data File", "html", "xls", "xlsx");
		chooser.setFileFilter(filter);

		final int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			final String fName = chooser.getSelectedFile().getName();

			final String ext = ProcessExcel.getExtention(fName);
			if (ext.contains("xls")) {
				ConvertOHLCV.parseXlsFile(chooser.getSelectedFile().getAbsolutePath());

			} else 	if (ext.contains("htm")) {
				ConvertOHLCV.parseHtmlFile(chooser.getSelectedFile().toPath());
			}
		}
		
		System.out.println("Done.");
	}

	/**
	 *
	 * net.ajaskey.market.tools.readFile
	 *
	 * @param path
	 * @throws IOException
	 * @throws ParseException
	 */
	private static void parseHtmlFile(Path path) throws IOException, ParseException {

		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("<pre>")) {
					line = reader.readLine();
					line = reader.readLine();
					break;
				}
			}
			while ((line = reader.readLine()) != null) {
				if (line.trim().length() == 0) {
					break;
				}
				final String fld[] = line.trim().split("\\s+");
				if (fld[0].trim().contains("</pre>")) {
					break;
				}

				final double c = Double.parseDouble(fld[5].trim());

				final double tmp = c * 10000.0;
				if ((long) tmp != 0) {
					final Calendar cal = Calendar.getInstance();
					cal.setTime(sdf.parse(fld[1].trim()));
					final double o = Double.parseDouble(fld[2].trim());
					final double h = Double.parseDouble(fld[3].trim());
					final double l = Double.parseDouble(fld[4].trim());
					final long v = Long.parseLong(fld[6].trim());
					final OhlcvData d = new OhlcvData(cal, o, h, l, c, v);
					if (d.getForm() == OhlcvData.FormType.FULL) {
						form = OhlcvData.FormType.FULL;
					}
					data.add(d);
				}
			}
		}

		Collections.sort(data, new SortOhlcv());
		if (form == OhlcvData.FormType.SHORT) {
			ConvertOHLCV.writeShortForm(path.toFile().getName());
		} else {
			ConvertOHLCV.writeFullForm(path.toFile().getName());
		}

	}

	/**
	 * net.ajaskey.market.tools.parseXlsFile
	 *
	 * @param absolutePath
	 * @throws IOException
	 */
	private static void parseXlsFile(String fullFileName) throws IOException {
		final List<ProcessExcel> peList = ProcessExcel.parseFred(fullFileName);
		for (final ProcessExcel pe : peList) {
			System.out.println(Utils.stringDate(pe.date) + "\t" + pe.value);
		}
	}

	/**
	 * net.ajaskey.market.tools.writeFullForm
	 *
	 * @param name
	 * @throws FileNotFoundException
	 */
	private static void writeFullForm(String name) throws FileNotFoundException {
		final int idx = name.indexOf(".");
		final String fname = name.substring(0, idx) + ".csv";

		try (PrintWriter pw = new PrintWriter(fullPath + "/" + fname)) {
			for (final OhlcvData d : data) {
				pw.printf("%s,%.2f,%.2f,%.2f,%.2f,%d%n", sdf.format(d.date.getTime()), d.open, d.high, d.low, d.close,
				    d.volume);
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.writeShortForm
	 *
	 * @param name
	 * @throws FileNotFoundException
	 */
	private static void writeShortForm(String name) throws FileNotFoundException {

		final int idx = name.indexOf(".");
		final String fname = name.substring(0, idx) + ".csv";

		try (PrintWriter pw = new PrintWriter(shortPath + "/" + fname)) {
			for (final OhlcvData d : data) {
				pw.printf("%s,%.2f%n", sdf.format(d.date.getTime()), d.close);
			}
		}

	}

}
