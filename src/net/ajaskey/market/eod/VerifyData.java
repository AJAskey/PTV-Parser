
package net.ajaskey.market.eod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
public class VerifyData {

	public static List<EodDataList> tl = new ArrayList<>();

	public static List<EodData> parseOneFile(File f) throws FileNotFoundException, IOException {

		List<EodData> ret = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(f))) {

			String line = reader.readLine(); //header line

			while ((line = reader.readLine()) != null) {
				//System.out.println(line);
				EodData eod = new EodData(line);
				if (eod.valid) {
					ret.add(eod);
				}
			}
		}
		return ret;
	}

	/**
	 * net.ajaskey.market.eod.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final String dataPath = Utils.getDataPath() + "\\ASCII\\";
		File file = new File(dataPath + "INDEX");

		final File list[] = file.listFiles();

		for (File f : list) {

			List<EodData> dataList = parseOneFile(f);
			//System.out.println(f.getName() + "\t" + dataList.size());

			for (EodData eod : dataList) {
				VerifyData.add(eod);
			}
		}

		for (EodDataList td : tl) {
			int i = getStats(td);
			System.out.println(td);
		}
	}

	/**
	 * net.ajaskey.market.eod.getStats
	 *
	 * @param td
	 * @return
	 */
	private static int getStats(EodDataList td) {

		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * net.ajaskey.market.eod.add
	 *
	 * @param eod
	 */
	private static void add(EodData eod) {

		boolean found = false;
		if (eod.valid) {
			for (EodDataList tick : tl) {
				try {
					if (eod.code.equalsIgnoreCase(tick.code)) {
						tick.list.add(eod);
						found = true;
						break;
					}
				} catch (Exception e) {
					System.out.println("here");
				}
			}
			if (!found) {
				EodDataList td = new EodDataList(eod.code);
				td.list.add(eod);
				tl.add(td);
			}
		}
	}

}
