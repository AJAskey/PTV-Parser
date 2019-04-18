
package net.ajaskey.market.tools.fred.processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class IngestOptumaFile {

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static final int	ADD				= 1;
	public static final int	SUBTRACT	= 2;
	public static final int	MULTIPLY	= 3;
	public static final int	DIVIDE		= 4;

	/**
	 *
	 * Interface to world. net.ajaskey.market.tools.fred.processing.process
	 *
	 * @param f1name
	 * @param f2name
	 * @param title
	 * @param operation
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void process(String f1name, String f2name, String title, int operation)
	    throws FileNotFoundException, IOException {

		System.out.printf("%s\t%s%n", f1name, f2name);
		final IngestOptumaFile iof = new IngestOptumaFile(f1name, f2name);
		final List<OptumaFileData> diffList = iof.processFiles(operation);

		final String fname = String.format("%s%s", FredCommon.fredPath, title);
		try (PrintWriter pw = new PrintWriter(fname)) {
			for (final OptumaFileData ofd : diffList) {
				pw.println(ofd);
			}
		}
	}

	String								title;
	List<OptumaFileData>	f1List	= new ArrayList<>();
	List<OptumaFileData>	f2List	= new ArrayList<>();

	List<OptumaFileData>	diffList	= new ArrayList<>();
	File									file1			= null;

	File file2 = null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	private IngestOptumaFile(String f1, String f2) {

		this.file1 = new File(f1);
		this.file2 = new File(f2);
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processing.processFiles
	 *
	 * @param operation
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private List<OptumaFileData> processFiles(int operation) throws FileNotFoundException, IOException {

		final List<OptumaFileData> resultList = new ArrayList<>();

		this.f1List = this.readFile(this.file1);
		this.f2List = this.readFile(this.file2);

		System.out.printf("%d\t%d%n", this.f1List.size(), this.f2List.size());

		final int f1size = this.f1List.size();
		final int f2size = this.f2List.size();

		if (f1size == f2size) {
			for (int i = 0; i < f1size; i++) {
				double result = 0.0;
				try {
					if (operation == ADD) {
						result = this.f1List.get(i).val + this.f2List.get(i).val;
					} else if (operation == SUBTRACT) {
						result = this.f1List.get(i).val - this.f2List.get(i).val;
					} else if (operation == MULTIPLY) {
						result = this.f1List.get(i).val * this.f2List.get(i).val;
					} else if (operation == DIVIDE) {
						result = this.f1List.get(i).val / this.f2List.get(i).val;
					}
				} catch (final Exception e) {
					result = 0.0;
				}
				final OptumaFileData ofd = new OptumaFileData(this.f1List.get(i).date, result);
				resultList.add(ofd);
			}
		}

		return resultList;

	}

	/**
	 * net.ajaskey.market.tools.fred.readFile
	 *
	 * @param f1
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private List<OptumaFileData> readFile(File f) throws FileNotFoundException, IOException {

		final List<OptumaFileData> ret = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(f))) {

			String line;
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				final String fld[] = str.split(",");
				try {
					final Date d = sdf.parse(fld[0].trim());
					final Calendar c = Calendar.getInstance();
					c.setTime(d);
					final double val = Double.parseDouble(fld[1]);
					ret.add(new OptumaFileData(c, val));
				} catch (final ParseException e) {
				}
			}
		}
		return ret;
	}

}
