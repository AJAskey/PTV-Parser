
package net.ajaskey.market.misc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

public class Zip {

	static final int BUFFER = 2048;

	/**
	 *
	 * net.ajaskey.market.misc.create
	 *
	 * @param dirs
	 * @param files
	 * @param outdir
	 * @param outfile
	 */
	public static void create(final List<String> dirs, final List<String> files, final String outdir, final String outfile) {

		try {

			final FileOutputStream dest = new FileOutputStream(outdir + "\\" + outfile);
			final ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

			final List<File> fileList = new ArrayList<>();

			BufferedInputStream origin = null;
			out.setMethod(ZipOutputStream.DEFLATED);
			final byte data[] = new byte[Zip.BUFFER];

			/**
			 * Add files from directories
			 */
			for (final String dir : dirs) {
				final File[] fils = new File(dir).listFiles();

				for (final File ff : fils) {
					fileList.add(ff);
				}
			}

			/**
			 * Add individual files
			 */
			for (final String fil : files) {
				fileList.add(new File(fil));
			}

			/**
			 * Process list of files and add to zip
			 */
			for (final File ff : fileList) {
				//System.out.println("Adding: " + ff.getAbsolutePath());

				final FileInputStream fi = new FileInputStream(ff);
				origin = new BufferedInputStream(fi, Zip.BUFFER);

				final ZipEntry entry = new ZipEntry(ff.getPath());
				out.putNextEntry(entry);
				int count;
				while ((count = origin.read(data, 0, Zip.BUFFER)) != -1) {
					out.write(data, 0, count);
				}
				origin.close();
			}

			out.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * net.ajaskey.market.misc.main
	 *
	 * @param argv
	 */
	public static void main(final String argv[]) {

		final List<String> dir = new ArrayList<>();
		dir.add("output\\SIP");
		final List<String> fil = new ArrayList<>();
		fil.add("data\\SP-Stocks.txt");
		fil.add("data\\SP-Stocks-B.txt");

		Zip.create(dir, fil, "archive", "newSip.zip");

	}
}
