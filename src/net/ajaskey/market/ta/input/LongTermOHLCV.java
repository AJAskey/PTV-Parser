
package net.ajaskey.market.ta.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.DailyData;
import net.ajaskey.market.ta.TickerData;

/**
 * This class...
 *
 * @author ajask <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class LongTermOHLCV {

	final private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 *
	 * net.ajaskey.market.ta.input.getData
	 *
	 * @param index
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public static List<LongTermOHLCV> getData(String index) throws IOException, ParseException {

		final List<LongTermOHLCV> ret = new ArrayList<>();

		final String fname = LongTermOHLCV.getFilename(index);

		try (BufferedReader br = new BufferedReader(new FileReader(new File(fname)))) {
			String line = "";

			line = br.readLine(); // read header

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {
					final String fld[] = line.split(",");
					final LongTermOHLCV dd = new LongTermOHLCV();
					dd.date.setTime(sdf.parse(fld[0].trim()));
					dd.open = Double.parseDouble(fld[1].trim());
					dd.high = Double.parseDouble(fld[2].trim());
					dd.low = Double.parseDouble(fld[3].trim());
					dd.close = Double.parseDouble(fld[5].trim());
					dd.volume = Long.parseLong(fld[6].trim());

					ret.add(dd);
				}
			}
		}

		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.getFilename
	 *
	 * @param index
	 * @return
	 */
	public static String getFilename(String index) {

		String fname = "";
		if (index.equalsIgnoreCase("SP500")) {
			fname = "data/GSPC.CSV";
		} else if (index.equalsIgnoreCase("SP400")) {
			fname = "data/MID.CSV";
		} else if (index.equalsIgnoreCase("SP600")) {
			fname = "data/SML.CSV";
		}
		return fname;
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.getLatestPrice
	 *
	 * @param list
	 * @return
	 */
	public static double getLatestPrice(List<LongTermOHLCV> list) {

		try {
			return list.get(list.size() - 1).close;
		} catch (final Exception e) {
			return 0.0;
		}
	}

	/**
	 * net.ajaskey.market.ta.input.main
	 *
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, ParseException {

		LongTermOHLCV.update("SP400");
		LongTermOHLCV.update("SP500");
		LongTermOHLCV.update("SP600");

	}

	/**
	 *
	 * net.ajaskey.market.ta.input.queryDate
	 *
	 * @param c
	 * @param list
	 * @return
	 */
	public static LongTermOHLCV queryDate(Calendar c, List<LongTermOHLCV> list) {

		for (final LongTermOHLCV d : list) {
			if (Utils.sameDate(d.date, c)) {
				return d;
			} else if (d.date.after(c)) {
				return d;
			}
		}
		// Return last data point
		return list.get(list.size() - 1);
	}

	/**
	 *
	 * net.ajaskey.market.ta.input.update
	 *
	 * @param index
	 * @param start
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static List<LongTermOHLCV> update(String index) throws IOException, ParseException {

		String tdIndex = "";
		if (index.contains("500")) {
			tdIndex = "SPX.IDX";
		} else if (index.contains("400")) {
			tdIndex = "MID.IDX";
		} else if (index.contains("600")) {
			tdIndex = "SML.IDX";
		} else {
			return null;
		}

		final List<String> filenames = new ArrayList<>();
		final List<String> fullfilenames = new ArrayList<>();

		final List<LongTermOHLCV> data = LongTermOHLCV.getData(index);

		final Calendar today = Calendar.getInstance();
		final LongTermOHLCV last = LongTermOHLCV.queryDate(today, data);
		final Calendar latest = last.date;
		System.out.println(Utils.stringDate(latest));
		final int diffyr = today.get(Calendar.YEAR) - latest.get(Calendar.YEAR);
		int days = today.get(Calendar.DAY_OF_YEAR) - latest.get(Calendar.DAY_OF_YEAR);
		if (diffyr > 0) {
			days += 365;
		}
		System.out.println(days);

		if (days < 1) {
			return data;
		}

		ParseData.clearValidTickers();
		ParseData.setValidTicker(tdIndex);

		filenames.clear();
		final String dataPath = Utils.getDataPath();
		filenames.add(dataPath + "\\ASCII\\INDEX");

		fullfilenames.add("symbols\\INDEX_SymbolList.txt");
		TickerFullName.build(fullfilenames);

		final List<TickerData> tdList = ParseData.parseFiles(filenames, days + 10);

		for (final TickerData td : tdList) {
			for (final DailyData dd : td.getData()) {
				if (dd.getDate().after(latest)) {
					if (!Utils.sameDate(dd.getDate(), latest)) {
						data.add(new LongTermOHLCV(dd));
					}
				}
			}
		}

		try (PrintWriter pw = new PrintWriter(LongTermOHLCV.getFilename(index))) {
			pw.println("Date,Open,High,Low,Close,Adj Close,Volume");
			for (final LongTermOHLCV lt : data) {
				pw.println(lt);
			}
		}

		return data;
	}

	public Calendar date;

	public double open;

	public double high;

	public double low;

	public double close;

	public long volume;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public LongTermOHLCV() {
		this.date = Calendar.getInstance();
		this.open = 0;
		this.high = 0;
		this.low = 0;
		this.close = 0;
		this.volume = 0;
	}

	public LongTermOHLCV(DailyData dd) {
		this.date = dd.getDate();
		this.open = dd.getOpen();
		this.high = dd.getHigh();
		this.low = dd.getLow();
		this.close = dd.getClose();
		this.volume = (long) (double) dd.getVolume();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		final String ret = String.format("%s,%6.2f,%6.2f,%6.2f,%6.2f,%6.2f,%10d", sdf.format(this.date.getTime()),
		    this.open, this.high, this.low, this.close, this.close, this.volume);
		return ret;
	}

}
