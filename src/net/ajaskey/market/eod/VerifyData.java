
package net.ajaskey.market.eod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.tools.optuma.OptumaCommon;

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

	public static List<String> codeInUse = new ArrayList<>();

	/**
	 * net.ajaskey.market.eod.add
	 *
	 * @param eod
	 */
	private static void add(EodData eod) {

		boolean found = false;
		if (eod.valid) {
			for (final EodDataList tick : tl) {
				try {
					if (eod.code.equalsIgnoreCase(tick.code)) {
						tick.list.add(eod);
						found = true;
						break;
					}
				} catch (final Exception e) {
					System.out.println("here");
				}
			}
			if (!found) {
				final EodDataList td = new EodDataList(eod.code);
				td.list.add(eod);
				tl.add(td);
			}
		}
	}

	/**
	 * net.ajaskey.market.eod.fileInUse
	 *
	 * @param code
	 *
	 * @return
	 */
	private static boolean fileInUse(String code) {

		for (String s : codeInUse) {
			if (code.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * net.ajaskey.market.eod.getStats
	 *
	 * @param td
	 * @return
	 */
	private static SummaryStatistics getStats(EodDataList eList) {

		final SummaryStatistics stats = new SummaryStatistics();
		for (final EodData e : eList.list) {
			stats.addValue(e.open);
			stats.addValue(e.high);
			stats.addValue(e.low);
			stats.addValue(e.close);
		}
		return stats;
	}

	/**
	 * net.ajaskey.market.eod.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final String optumaEodDir = OptumaCommon.optumaPath + "\\EOD-Data\\";
		VerifyData.setEodInUse(optumaEodDir);
		for (String s : codeInUse) {
			System.out.println(s);
		}

		final String dataPath = Utils.getDataPath() + "\\ASCII\\";
		final File file = new File(dataPath + "INDEX");

		final File list[] = file.listFiles();

		for (final File f : list) {

			final List<EodData> dataList = VerifyData.parseOneFile(f);
			//System.out.println(f.getName() + "\t" + dataList.size());

			for (final EodData eod : dataList) {
				//if (fileInUse(eod.code)) 
				VerifyData.add(eod);
			}
		}

		final String sdir = "out\\debug\\";
		final File dir = new File(sdir);
		for (final File f : dir.listFiles()) {
			if (!f.isDirectory()) {
				f.delete();
			}
		}

		try (PrintWriter pw = new PrintWriter("out\\eod-verify.txt")) {
			for (final EodDataList td : tl) {
				final SummaryStatistics stat = VerifyData.getStats(td);
				final double stddev = stat.getStandardDeviation();
				final double mean = stat.getMean();
				final double stddev25 = Math.abs(stddev * 6.0);
				final double upFromMean = mean + stddev25;
				final double downFromMean = mean - stddev25;
				//System.out.println(td);

				String fileUsed = "";
				if (VerifyData.fileInUse(td.code)) {
					fileUsed = "*";
				}

				pw.println("\n" + fileUsed + td.code + "\t" + downFromMean + "\t" + mean + "\t" + upFromMean);
				for (final EodData eod : td.list) {
					if ((eod.open > upFromMean) || (eod.open < downFromMean)) {
						pw.println("\t" + eod + " ... OPEN out of bounds!");
						VerifyData.writeDbg(td, "open", fileUsed);
					}
					if ((eod.high > upFromMean) || (eod.high < downFromMean)) {
						pw.println("\t" + eod + " ... HIGH out of bounds!");
						VerifyData.writeDbg(td, "high", fileUsed);
					}
					if ((eod.low > upFromMean) || (eod.low < downFromMean)) {
						pw.println("\t" + eod + " ... LOW out of bounds!");
						VerifyData.writeDbg(td, "low", fileUsed);
					}
					if ((eod.close > upFromMean) || (eod.close < downFromMean)) {
						pw.println("\t" + eod + " ... CLOSE out of bounds!");
						VerifyData.writeDbg(td, "close", fileUsed);
					}
				}
			}
		}
	}

	public static List<EodData> parseOneFile(File f) throws FileNotFoundException, IOException {

		final List<EodData> ret = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(f))) {

			String line = reader.readLine(); //header line

			while ((line = reader.readLine()) != null) {
				//System.out.println(line);
				final EodData eod = new EodData(line);
				if (eod.valid) {
					ret.add(eod);
				}
			}
		}
		return ret;
	}

	/**
	 * net.ajaskey.market.eod.setEodInUse
	 *
	 * @param optumaEodDir
	 */
	private static void setEodInUse(String dir) {

		final File file = new File(dir);
		final File list[] = file.listFiles();

		for (final File f : list) {
			String fname = f.getName();
			final int idx = fname.indexOf(".csv");
			if (idx > 1) {
				if (fname.contains("[")) {
					int idx2 = fname.indexOf("-");
					if (idx2 > 1) {
						String stmp = fname.substring(0, idx2);
						fname = stmp.replaceAll("\\[", "").replaceAll("\\]", "").trim();
						fname += ".IDX";
					}
				}
				String code = fname.replaceAll(".csv", "");
				int idx3 = code.indexOf(".IDX");
				if (idx3 < 1) {
					code += ".IDX";
				}

				boolean found = false;
				for (String s : codeInUse) {
					if (code.equalsIgnoreCase(s)) {
						found = true;
						break;
					}
				}
				if (!found) {
					//System.out.println(code + "\t" + f.getName());
					codeInUse.add(code.trim());
				}
			}
		}
		Collections.sort(codeInUse);
	}

	/**
	 * net.ajaskey.market.eod.writeDbg
	 *
	 * @param td
	 */
	private static void writeDbg(EodDataList td, String desc, String fileUsed) {

		final String sdir = "out\\debug\\";
		final String fname = sdir + td.code + "_" + desc + "_dbg.csv";
		final File f = new File(fname);
		if (!Files.exists(f.toPath())) {

			try (PrintWriter pw = new PrintWriter(f)) {
				System.out.println("Writing to " + f.getName());

				pw.println(fileUsed + td);
			} catch (final FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
