
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
public class ExportImportBalance {

	/**
	 * net.ajaskey.market.tools.fred.processing.main
	 *
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final File folder = new File(FredCommon.fredPath);

		final List<File> izList = new ArrayList<>();

		final String[] ext = new String[] { "csv" };

		final List<File> files = (List<File>) FileUtils.listFiles(folder, ext, false);

		for (final File file : files) {

			final String name = file.getName().trim();
			if (name.startsWith("[IZ")) {
				izList.add(file);
			}

		}

		for (File fiz : izList) {
		//	System.out.println(fiz.getAbsolutePath());
			String iy = fiz.getName().replace("IZ", "IY").replace("Import", "Export");
			File fiy = new File(folder.getAbsolutePath() + "\\" + iy);
			if (fiy.exists()) {
			//	System.out.println("  " + fiy.getAbsolutePath());
				final String tmp = iy.replace("Export Price Index", "Export minus Import Trade Balance");
				int idx = tmp.indexOf('-');
				String fullname = tmp;
				if (idx > 0) {
					fullname = tmp.substring(idx + 1).trim();
				}
				System.out.println("    " + fullname);
				process(fiy, fiz, fullname);
			} else {
				//System.out.println(fiy.getName());
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.fred.processing.process
	 *
	 * @param fiz
	 * @param fiy
	 * @param fullname 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private static void process(File fiz, File fiy, String fullname) throws FileNotFoundException, IOException {

		 IngestOptumaFile.process(fiz.getAbsolutePath(),fiy.getAbsolutePath(), fullname, IngestOptumaFile.SUBTRACT, 1.0);

	}

}
