
package net.ajaskey.randoop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class GenerateTests {

	/**
	 * net.ajaskey.randoop.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		//System.out.println(randoop);

		final File folder = new File("src/");
		final Set<String> uniqPackages = new HashSet<>();

		String[] ext = new String[] { "java" };
		List<File> files = (List<File>) FileUtils.listFiles(folder, ext, true);
		for (File file : files) {

			try (BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {

				String line;
				while ((line = reader.readLine()) != null) {
					final String str = line.trim();
					if (isPackageDeclation(str)) {
						String addStr = str.replace("package ", "").replace(";", "");
						uniqPackages.add(addStr);
						break;
					}
				}
			}

		}

		List<PackageData> packageList = new ArrayList<>();

		for (String pkg : uniqPackages) {
			PackageData pd = new PackageData(pkg);
			packageList.add(pd);
			System.out.println(pkg);
		}

		for (PackageData pd : packageList) {

			String fname = "src/" + pd.packageName.replace(".", "/");
			File dir = new File(fname);

			//Only need to set the path once per package
			if (pd.fullpath.length() == 0) {
				pd.fullpath = dir.getAbsolutePath();
			}

			List<File> javaFiles = (List<File>) FileUtils.listFiles(dir, ext, false);

			for (File f : javaFiles) {

				try (BufferedReader reader = new BufferedReader(new FileReader(f))) {

					String line;
					while ((line = reader.readLine()) != null) {
						final String str = line.trim();
						if (isClass(str)) {
							String tmp = str.substring(13).trim();
							int idxSpace = getIndex(tmp, " ");
							int idxParen = getIndex(tmp, "(");
							int idxBracket = getIndex(tmp, "{");
							int last = Math.min(idxBracket, Math.min(idxSpace, idxParen));
							String classname = tmp.substring(0, last);
							pd.classNames.add(classname);
							break;
						}
					}
				}
			}
		}

		String randoop1 = "java -cp c:/dev/randoop/randoop-all-4.1.1.jar;c:/dev/PTV-Investing/bin randoop.main.Main gentests --junit-output-dir=c:/dev/PTV-Investing/Test";
		String randoop4 = String.format("--log=C:/Dev/PTV-Investing/src/net/ajaskey/randoop/randoop.log --time-limit=60 --flaky-test-behavior=DISCARD");

		for (PackageData pd : packageList) {
			String fname = pd.fullpath + "/classlist.txt";
			try (PrintWriter pw = new PrintWriter(fname)) {
				for (String s : pd.classNames) {
					pw.println(pd.packageName + "." + s);
				}
			}

			String randoop2 = String.format("--classlist=%s", fname);
			String randoop3 = String.format("--junit-package-name=%s", pd.packageName);

			try (PrintWriter pw = new PrintWriter(pd.fullpath + "/gentests.bat")) {

				pw.printf("cd c:\\temp\\randoopout%n%s %s %s %s%n", randoop1, randoop2, randoop3, randoop4);

			}
			System.out.println(pd);
		}

	}

	/**
	 * net.ajaskey.randoop.getIndex
	 *
	 * @param tmp
	 * @param string
	 * @return
	 */
	private static int getIndex(String tmp, String lookfor) {

		int ret = 0;
		int idx = tmp.indexOf(lookfor);
		if (idx < 0) {
			ret = 1024;
		} else {
			ret = idx;
		}
		return ret;
	}

	/**
	 * net.ajaskey.randoop.isClass
	 *
	 * @param str
	 * @return
	 */
	private static boolean isClass(String str) {

		boolean ret = false;

		if (str.startsWith("public class ")) {
			ret = true;
		}
		return ret;
	}

	/**
	 * net.ajaskey.randoop.isPackageDeclation
	 *
	 * @param str
	 * @return
	 */
	private static boolean isPackageDeclation(String str) {

		boolean ret = false;

		if (str.startsWith("package ")) {
			ret = true;
		}
		return ret;
	}
}
