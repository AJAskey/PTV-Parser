
package net.ajaskey.market.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class...
 *
 * @author ajask_000 <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class DiffDtsFiles {

	final static private String	folderPath1	= "d:/temp/dts";
	final static private String	folderPath2	= "d:/temp/dts-lt";

	static private PrintWriter pw = null;

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		pw = new PrintWriter("dts-diffs.txt");

		final File allFiles1 = new File(folderPath1);
		final File[] listOfFiles1 = allFiles1.listFiles();

		final File allFiles2 = new File(folderPath2);
		final File[] listOfFiles2 = allFiles2.listFiles();

		for (final File file1 : listOfFiles1) {
			final String name = file1.getName();
			for (final File file2 : listOfFiles2) {
				if (name.contentEquals(file2.getName())) {
					System.out.println(name);
					DiffDtsFiles.diffFiles(file1, file2);
					break;
				}
			}
		}

		pw.close();

	}

	/**
	 * net.ajaskey.market.tools.diffFiles
	 *
	 * @param file1
	 * @param file2
	 */
	private static void diffFiles(File file1, File file2) {

		int lineknt = 0;
		final String fname = file1.getName();

		try (BufferedReader reader1 = new BufferedReader(new FileReader(file1.getAbsoluteFile()));
		    BufferedReader reader2 = new BufferedReader(new FileReader(file2.getAbsoluteFile()))) {

			String str1 = " ";
			String str2 = " ";

			while ((str1 != null) && (str2 != null)) {
				str1 = DiffDtsFiles.readFile(reader1);
				str2 = DiffDtsFiles.readFile(reader2);

				if ((str1 != null) && (str2 != null)) {
					lineknt++;
					if (!str1.contentEquals(str2)) {
						pw.println("\nFile : " + fname + "  line number : " + lineknt);
						pw.println("  line1 : " + str1);
						pw.println("  line2 : " + str2);
					}
				}
			}
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * net.ajaskey.market.tools.readFile
	 *
	 * @param reader1
	 * @return
	 * @throws IOException
	 */
	private static String readFile(BufferedReader reader) throws IOException {

		final String line = reader.readLine();
		return line;
	}

}
