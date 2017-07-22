
package net.ajaskey.market.optuma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Utils;

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
public class InputData {

	private List<File> files;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public InputData(List<String> paths, List<String> exts) {

		files = new ArrayList<>();

		for (String s : paths) {
			List<File> fil = Utils.getDirTree(new File(s), exts);
			for (File f : fil) {
				files.add(f);
			}
		}
	}

	private File getDataFile(String tkr) {

		for (File f : files) {
			String name = Utils.removeFileExt(f);
			if (name.trim().equalsIgnoreCase(tkr.trim())) {
				return f;
			}
		}
		return null;
	}

	public TickerData read(String tkr) throws FileNotFoundException, IOException {

		List<String> data = new ArrayList<>();
		TickerData td = null;

		File f = getDataFile("");
		if (f != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(f))) {

				String line;
				while ((line = reader.readLine()) != null) {
					if (line != null) {
						data.add(line.trim());
					}
				}
			}
			Collections.reverse(data);

			td = new TickerData(tkr, data);

		}

		return td;

	}

	/**
	 * net.ajaskey.market.optuma.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> dNames = new ArrayList<>();
		List<String> ext = new ArrayList<>();
		dNames.add("C:\\temp\\redline-master");
		ext.add(".txt");
		ext.add(".xml");
		ext.add(".sh");
		InputData id = new InputData(dNames, ext);

		for (File f : id.files) {
			System.out.println(f.getAbsolutePath() + "   " + Utils.removeFileExt(f));
		}

	}

}
