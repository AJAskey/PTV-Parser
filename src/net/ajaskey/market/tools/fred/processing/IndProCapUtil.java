
package net.ajaskey.market.tools.fred.processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

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
public class IndProCapUtil {

	final static File				folder		= new File(FredCommon.fredPath);
	static List<File>				files			= null;
	static List<FilePairs>	pairList	= new ArrayList<>();

	/**
	 *
	 * net.ajaskey.market.tools.fred.processing.getIndproFile
	 *
	 * @param num
	 * @return
	 */
	private static File getIndproFile(final int num) {

		try {
			final String s = Integer.toString(num);
			for (final File file : files) {
				final String fname = file.getName();
				if (fname.contains(s) && fname.contains("[IP") && fname.contains("Industrial Production")) {
					final int n = IndProCapUtil.getNumber(fname);
					if (n == num) {
						return file;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processing.getNumber
	 *
	 * @param str
	 * @return
	 */
	private static int getNumber(final String str) {

		int ret = 0;
		try {
			final StringBuilder builder = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				final char c = str.charAt(i);
				if (Character.isDigit(c)) {
					builder.append(c);
				}
			}
			final String s = builder.toString();
			if (s.length() > 0) {
				ret = Integer.parseInt(builder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret = 0;
		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processing.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(final String[] args) throws FileNotFoundException, IOException {

		final File folder = new File(FredCommon.fredPath);
		final String[] ext = new String[] { "csv" };
		files = (List<File>) FileUtils.listFiles(folder, ext, false);

		pairList.add(new FilePairs(FredCommon.fredPath + "INDPRO.csv",  FredCommon.fredPath + "TCU.csv",
				 "Industrial Production times Capacity Utilization.csv"));

		IndProCapUtil.process();

	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.processing.process
	 *
	 */
	private static void process() {

		for (final File file : files) {
			if (file.getName().contains("[CAPUTL")) {
				final int n = IndProCapUtil.getNumber(file.getName());
				if (n > 0) {
					final File indproFile = IndProCapUtil.getIndproFile(n);
					if (indproFile != null) {
						System.out.println(file.getAbsolutePath() + "\t" + indproFile.getAbsolutePath());
						String fname = file.getName();
						int idx = fname.indexOf(']') + 3;
						String fullname = fname.substring(idx).replace("CapUtil", "Capacity Utiliztion times Productivity").trim();
						try {
							IngestOptumaFile.process(file.getAbsolutePath(), indproFile.getAbsolutePath(), fullname, IngestOptumaFile.MULTIPLY, 0.01);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		for (FilePairs pair : pairList) {
			try {
				IngestOptumaFile.process(pair.file1.getAbsolutePath(), pair.file2.getAbsolutePath(), pair.outfile.getName(), IngestOptumaFile.MULTIPLY, 0.01);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
