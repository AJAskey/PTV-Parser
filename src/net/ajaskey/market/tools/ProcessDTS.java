
package net.ajaskey.market.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.ajaskey.market.ta.Utils;

/**
 * This class...
 *
 * @author Andy Askey
 *         <p>
 *         PTV-Parser Copyright (c) 2016, Andy Askey. All rights reserved.
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
public class ProcessDTS {

	final static private String						url					= "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=w&fname=";
	final static private String						urlA				= "https://www.fms.treas.gov/fmsweb/viewDTSFiles?dir=a&fname=";

	final static private SimpleDateFormat	sdf					= new SimpleDateFormat("yyMMdd");

	final static private String						folderPath	= "d:/temp/dts";

	final static private Charset					charset			= Charset.forName("UTF-8");
	final static private Locale						locale			= Locale.getDefault();

	static public Map<String, Integer>		mNames			= null;
	static public Map<String, Integer>		mDays				= null;

	/**
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		Calendar baseCal = Calendar.getInstance();

		mNames = baseCal.getDisplayNames(Calendar.MONTH, Calendar.LONG, locale);
		mDays = baseCal.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);

		// ProcessDTS.updateDtsFiles();
		ProcessDTS.readAndProcess();
	}

	/**
	 * 
	 * net.ajaskey.market.tools.getDateName
	 *
	 * @param c
	 * @return
	 */
	private static String getDateName(Calendar c) {
		if (c != null) {
			return sdf.format(c.getTime()) + "00";
		}
		return "";
	}

	/**
	 *
	 * net.ajaskey.market.tools.updateDtsFiles
	 *
	 */
	private static void updateDtsFiles() {
		Utils.makeDir(folderPath);

		final Calendar tommorrow = Calendar.getInstance();
		tommorrow.add(Calendar.DATE, 1);

		final Calendar cal = Calendar.getInstance();
		cal.set(2015, Calendar.JANUARY, 1);

		while (cal.before(tommorrow)) {

			List<String> resp = new ArrayList<>();

			final String fname = ProcessDTS.getDateName(cal);

			final String fileName = fname + ".txt";

			final File fTest = new File(folderPath + "/" + fileName);
			if (!fTest.exists()) {

				resp = WebGet.getSPDR(urlA + fileName);

				if (resp == null) {
					resp = WebGet.getSPDR(url + fileName);
				}

				if (resp != null) {

					System.out.println(Utils.stringCalendar(cal));
					try (PrintWriter pw = new PrintWriter(folderPath + "/" + fileName)) {
						for (final String s : resp) {
							pw.println(s);
						}
					} catch (final FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			cal.add(Calendar.DATE, 1);
			final String day = Utils.getDayOfWeek(cal);
			if (day.contains("SAT")) {
				cal.add(Calendar.DATE, 2);
			} else if (day.contains("SUN")) {
				cal.add(Calendar.DATE, 1);
			}
		}
	}

	/**
	 * 
	 * net.ajaskey.market.tools.readAndProcess
	 *
	 */
	private static void readAndProcess() {
		File allFiles = new File(folderPath);
		File[] listOfFiles = allFiles.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println(file.getName());
				Path path = file.toPath();
				try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
					String line;
					while ((line = reader.readLine()) != null) {
						if (line.contains("Withheld Income and Employment Taxes")) {
							System.out.println(line);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * net.ajaskey.market.tools.findName
	 *
	 * @param map
	 * @param key
	 * @return
	 */
	public static String findName(Map<String, Integer> map, Integer key) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == key) {
				return entry.getKey();
			}
		}
		return "NotFound";
	}
	
	public class DataStruct {
		Calendar calInfo;
		int daily;
		int monthly;
		int yearly;
		
	}
	
	public class DtsSorter implements Comparator<DataStruct> {

		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(DataStruct d1, DataStruct d2) {
			int ret = 0;
			if (d1.calInfo.before(d2.calInfo)) {
				ret = -1;
			} else if (d1.calInfo.after(d2.calInfo)) {
				ret = 1;
			}
			return ret;
		}
		
	}

}
