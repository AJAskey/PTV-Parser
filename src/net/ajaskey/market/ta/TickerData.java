
package net.ajaskey.market.ta;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.misc.Utils;
import net.ajaskey.market.ta.input.Fundamentals;
import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.input.TickerFullName;
import net.ajaskey.market.ta.methods.RangeMethods;
import net.ajaskey.market.ta.methods.TaMethods;
import net.ajaskey.market.ta.methods.UtilMethods;

/**
 *
 * This class serves as the main class for gathering data associated with a
 * specific ticker symbol. A collection of market data is stored in a list of
 * TickerData objects.
 *
 * @author Andy Askey
 *         <p>
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
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
public class TickerData {

	final static private String		TAB				= "\t";
	final static private String		NL				= System.lineSeparator();
	private String								ticker;

	private String								tickerName;

	private String								tickerExchange;

	private Fundamentals					fundies;

	private final List<DailyData>	data			= new ArrayList<DailyData>();

	/**
	 * Derived values
	 */
	private Integer								daysOfData;
	private DerivedData						derived;
	private Double								sma23;
	private Double								smaPerc23;
	private TrendType							sma23Trend;
	private Double								sma65;
	private Double								smaPerc65;
	private TrendType							sma65Trend;
	private Double								sma130;
	private Double								smaPerc130;
	private TrendType							sma130Trend;
	private Double								sma260;
	private Double								smaPerc260;
	private TrendType							sma260Trend;
	private double[]							openData;
	private double[]							highData;
	private double[]							lowData;
	private double[]							closeData;
	private double[]							volumeData;
	private double[]							oiData;
	private double[]							trueHighData;
	private double[]							trueLowData;
	private double[]							typicalPriceData;
	private Calendar[]						dateData;
	private double								currentPrice;
	private double								avgVol65;
	private double								avgVol20;
	private double								chg;
	private double								chg23;
	private double								chg65;
	private double								chg130;
	private double								chg260;
	private double								low260;
	private double								high260;
	private double								rsRaw;
	private double								rsStRaw;
	private double								atr23;
	private double								adx;
	private double								diPlus;
	private double								diMinus;
	private double								atrPercent23;
	private double								mfi23;
	private double								mfi65;
	private double								mfi130;
	private double								mfi14;
	private double								priceInRng260;
	private double								priceOffHigh260;
	private double								priceOffLow260;
	private double								lr260;
	private double								lrAngle260;
	private double								lrInt260;
	private double								lrSlope260;

	private double								rsi14;
	private final TaMethods				taMethods	= new TaMethods();

	/**
	 *
	 * This methods serves as a constructor for the class.
	 *
	 */
	public TickerData() {
	}

	/**
	 *
	 * This methods serves as a constructor for the class.
	 *
	 * @param t
	 *          Ticker symbol name
	 * @param d
	 *          Data of DailyData
	 * @param o
	 *          Opening price.
	 * @param h
	 *          High daily price.
	 * @param l
	 *          Low daily price.
	 * @param c
	 *          Closing price.
	 * @param v
	 *          Volume traded.
	 */
	public TickerData(String t, Calendar d, double o, double h, double l, double c, double v, double oi) {
		final DailyData dd = new DailyData(d, o, h, l, c, v, oi);
		this.setTicker(t);
		this.tickerName = TickerFullName.getName(t);
		this.tickerExchange = "Unknown";
		this.fundies = Fundamentals.getWithTicker(this.ticker);
		this.data.add(dd);
		this.daysOfData = 0;

		this.derived = null;

		this.sma23 = 0.0;
		this.sma65 = 0.0;
		this.sma130 = 0.0;
		this.sma260 = 0.0;
		this.smaPerc23 = 0.0;
		this.smaPerc65 = 0.0;
		this.smaPerc130 = 0.0;
		this.smaPerc260 = 0.0;
		this.sma23Trend = TrendType.FLAT;
		this.sma65Trend = TrendType.FLAT;
		this.sma130Trend = TrendType.FLAT;
		this.sma260Trend = TrendType.FLAT;
		this.avgVol65 = 0.0;
		this.chg = 0.0;
		this.chg23 = 0.0;
		this.chg65 = 0.0;
		this.chg130 = 0.0;
		this.chg260 = 0.0;
		this.rsRaw = 0.0;
		this.rsStRaw = 0.0;
		this.atr23 = 0.0;
		this.atrPercent23 = 0.0;
		this.adx = 0.0;
		this.diPlus = 0.0;
		this.diMinus = 0.0;
		this.mfi23 = 0.0;
		this.mfi65 = 0.0;
		this.mfi130 = 0.0;
		this.mfi14 = 0.0;
		this.currentPrice = 0.0;
		this.lr260 = 0.0;
		this.lrAngle260 = 0.0;
		this.lrInt260 = 0.0;
		this.lrSlope260 = 0.0;
		this.rsi14 = 0.0;
		this.closeData = null;
	}

	/**
	 * Parses a list file names containing ticker data.
	 *
	 * @param directoryNames
	 *          List of directories to read data files.
	 * @return List of TickerData corresponding to the list for filenames.
	 * @throws ParseException
	 *           Error occurred during parsing.
	 * @throws FileNotFoundException
	 *           A file in the list was not found.
	 */
	static public List<TickerData> build(List<String> directoryNames) throws ParseException, FileNotFoundException {

		if ((directoryNames == null) || (directoryNames.size() < 1)) {
			System.out.println("Invalid list of fileNames sent to net.ajaskey.market.ta.build()");
			throw new FileNotFoundException();
		}
		List<TickerData> tdList = null;
		try {
			tdList = ParseData.parseFiles(directoryNames);
			for (final TickerData t : tdList) {
				t.generateDerived(false);
			}
		} catch (final FileNotFoundException e) {
		}
		return tdList;
	}

	/**
	 *
	 * net.ajaskey.market.ta.clearTickerData
	 *
	 * @param tdList
	 */
	public static void clearTickerData(List<TickerData> tdList) {
		if (tdList != null) {
			for (final TickerData td : tdList) {
				TickerData.clearTickerData(td);
			}
			tdList.clear();
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.clearTickerData
	 *
	 * @param td
	 */
	public static void clearTickerData(TickerData td) {
		if (td != null) {
			td.data.clear();
			td.openData = null;
			td.highData = null;
			td.lowData = null;
			td.closeData = null;
			td.volumeData = null;
			td.oiData = null;
			td.trueHighData = null;
			td.trueLowData = null;
			td.typicalPriceData = null;
			td.dateData = null;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.getDataOfDate
	 *
	 * @param td
	 * @param cal
	 * @return
	 */
	static public DailyData getDataOfDate(TickerData td, Calendar cal) {
		return TickerData.getDataOfDate(td, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
		    cal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 *
	 * net.ajaskey.market.ta.getDataOfDate
	 *
	 * @param td
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	static public DailyData getDataOfDate(TickerData td, int year, int month, int day) {
		DailyData dd = null;
		final int idx = TickerData.getIndexOfDate(td, year, month, day);
		if ((idx >= 0) && (idx < td.getDaysOfData())) {
			dd = td.data.get(idx);
		}
		// SimpleDateFormat sdf = new SimpleDateFormat("E dd-MMM-yyyy");
		// String s = sdf.format(dd.getDate().getTime());
		// System.out.println(s);
		return dd;
	}

	/**
	 *
	 * net.ajaskey.market.ta.getFromList
	 *
	 * @param ticker
	 * @param tdList
	 * @return
	 */
	public static TickerData getFromList(String ticker, List<TickerData> tdList) {
		for (final TickerData td : tdList) {
			if (td.getTicker().equalsIgnoreCase(ticker)) {
				return td;
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.ta.getIndexOfDate
	 *
	 * @param td
	 * @param cal
	 * @return
	 */
	static public int getIndexOfDate(TickerData td, Calendar cal) {
		return TickerData.getIndexOfDate(td, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
	}

	static public DailyData getDailyDate(TickerData td, Calendar cal) {

		for (DailyData dd : td.getData()) {
			if (Utils.sameDate(cal, dd.getDate())) {
				return dd;
			} else if (dd.getDate().after(cal)) {
				return dd;
			}
		}
		return null;

	}

	/**
	 *
	 * net.ajaskey.market.ta.getIndexOfDate
	 *
	 * @param td
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	static public int getIndexOfDate(TickerData td, int year, int month, int day) {

		final Calendar calBase = Calendar.getInstance();

		if ((year < 1900) || (year > calBase.get(Calendar.YEAR))) {
			return -1;
		} else if ((month < Calendar.JANUARY) || (month > Calendar.DECEMBER)) {
			return -1;
		}
		calBase.set(year, month, 1, 0, 0, 1);
		final int dim = calBase.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (day > dim) {
			return -1;
		}

		calBase.set(Calendar.MILLISECOND, 0);
		calBase.set(year, month, day, 0, 0, 1);
		final int idx = -1;
		long shortSpan = td.getDaysOfData();
		int knt = 0;
		long lastSpan = 99999999999L;
		for (final DailyData dd : td.data) {
			final long span = Math.abs(Utils.getTimeSpan(dd.getDate(), calBase));
			// System.out.printf("%s %s %d %d %d %n", Utils.getString(calBase),
			// Utils.getString(dd.getDate()), (int) span,
			// (int) shortSpan, idx);
			if (span == 0) {
				return knt;
			} else if (span > lastSpan) {
				return knt - 1;
			} else if (span < shortSpan) {
				shortSpan = span;
			} else if (span > shortSpan) {
				return -1;
			}
			lastSpan = span;
			knt++;
		}

		return idx;
	}

	/**
	 *
	 * net.ajaskey.market.ta.getSlice
	 *
	 * @param td
	 * @param earliest
	 * @param recent
	 * @return
	 */
	static public List<DailyData> getSlice(TickerData td, Calendar start, int days) {
		if ((td != null) && (start != null) && (days >= 0)) {
			if (days > td.getDaysOfData()) {
				days = td.getDaysOfData();
			} else if (days == 0) {
				days = td.getDaysOfData();
			}
			final int idx = TickerData.getIndexOfDate(td, start);
			if (idx >= 0) {
				return td.getData().subList(idx, idx + days);
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.ta.getTickerData
	 *
	 * @param list
	 * @param ticker
	 * @return
	 */
	public static TickerData getTickerData(List<TickerData> list, String ticker) {
		for (final TickerData td : list) {
			if (td.getTicker().compareTo(ticker.toUpperCase()) == 0) {
				return td;
			}
		}
		return null;
	}

	/**
	 *
	 * net.ajaskey.market.ta.getTradingDays
	 *
	 * @param td
	 * @param start
	 * @param stop
	 * @return
	 */
	public static int getTradingDays(TickerData td, Calendar start, Calendar stop) {

		int ret = 0;
		final int idx1 = TickerData.getIndexOfDate(td, start.get(Calendar.YEAR), start.get(Calendar.MONTH),
		    start.get(Calendar.DAY_OF_MONTH));
		if (idx1 >= 0) {
			final int idx2 = TickerData.getIndexOfDate(td, stop.get(Calendar.YEAR), stop.get(Calendar.MONTH),
			    stop.get(Calendar.DAY_OF_MONTH));
			if (idx2 < idx1) {
				ret = ((idx1 - idx2) + 1);
			}
		}
		return ret;
	}

	public static void mergeData(TickerData td, TickerData tdNew) {
		td.getData().addAll(tdNew.getData());
	}

	/**
	 *
	 * net.ajaskey.market.ta.sortData
	 *
	 * @param td
	 * @param sortReverse
	 */
	public static void sortDailyData(TickerData td, boolean sortReverse) {
		if (sortReverse) {
			Collections.sort(td.data, new SortDailyDataReverse());
		} else {
			Collections.sort(td.data, new SortDailyData());
		}

	}

	/**
	 *
	 * net.ajaskey.market.ta.addData
	 *
	 * @param dd
	 */
	public void addData(DailyData dd) {
		this.data.add(dd);
	}

	public String DailyDataString(int day) {
		return this.data.get(day).toString();
	}

	/**
	 *
	 * net.ajaskey.market.ta.fillDataArrays
	 *
	 * @param start
	 */
	public void fillDataArrays(int start, boolean sortReversed) {

		TickerData.sortDailyData(this, sortReversed);

		this.daysOfData = this.data.size() - start;

		if (this.daysOfData < 1) {
			return;
		}

		this.dateData = new Calendar[this.daysOfData];
		this.openData = new double[this.daysOfData];
		this.highData = new double[this.daysOfData];
		this.lowData = new double[this.daysOfData];
		this.closeData = new double[this.daysOfData];
		this.volumeData = new double[this.daysOfData];
		this.oiData = new double[this.daysOfData];
		int knt = 0;
		int pos = 0;
		for (final DailyData dd : this.data) {
			if (knt >= start) {
				this.openData[pos] = dd.getOpen();
				this.highData[pos] = dd.getHigh();
				this.lowData[pos] = dd.getLow();
				this.closeData[pos] = dd.getClose();
				this.volumeData[pos] = dd.getVolume();
				this.oiData[pos] = dd.getOi();
				this.dateData[pos] = dd.getDate();
				pos++;
			}
			knt++;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.generateDerived
	 *
	 */
	public void generateDerived(boolean isReverse) {
		this.generateDerived(0, isReverse);
	}

	/**
	 *
	 * net.ajaskey.market.ta.generateDerived
	 *
	 * @param start
	 */
	public void generateDerived(int start, boolean isReverse) {

		/**
		 * Must sort prices by date before many of the following calculations
		 */
		Collections.sort(this.data, new SortDailyData());
		this.normalizeZeroVolume();

		this.fillDataArrays(start, isReverse);

		/**
		 * TrueHigh and TrueLow are set for entire data series without regard to
		 * start
		 */
		this.trueHighData = new double[this.daysOfData];
		this.trueLowData = new double[this.daysOfData];
		this.typicalPriceData = new double[this.daysOfData];
		int pos = 0;
		for (int i = start; i < (this.data.size() - 1); i++) {
			this.data.get(i).setTrueHigh(this.data.get(i + 1).getClose());
			this.data.get(i).setTrueLow(this.data.get(i + 1).getClose());
			this.data.get(i).setDailyChg(this.data.get(i + 1).getClose());

			this.trueHighData[pos] = this.data.get(i).getTrueHigh();
			this.trueLowData[pos] = this.data.get(i).getTrueLow();

			this.typicalPriceData[pos] = (this.trueLowData[pos] + this.closeData[pos] + this.trueHighData[pos]) / 3.0;

			pos++;

		}
		this.data.get(this.daysOfData - 1).setTrueHigh(this.closeData[this.daysOfData - 1]);
		this.data.get(this.daysOfData - 1).setTrueLow(this.closeData[this.daysOfData - 1]);
		this.trueHighData[this.daysOfData - 1] = this.data.get(this.daysOfData - 1).getTrueHigh();
		this.trueLowData[this.daysOfData - 1] = this.data.get(this.daysOfData - 1).getTrueLow();

		this.currentPrice = this.closeData[0];
		this.chg = this.calcPriceChange(1);

		this.setRs();

		if (this.daysOfData > 19) {
			this.avgVol20 = this.taMethods.calcSma(this.volumeData, 20);
		}

		if (this.daysOfData > 64) {
			this.avgVol65 = this.taMethods.calcSma(this.volumeData, 65);
		}

		if (this.daysOfData > 28) {
			this.sma23 = UtilMethods.sma(this.getCloseData(), 23);
			this.smaPerc23 = this.taMethods.calcPercentChange(this.currentPrice, this.sma23);
			this.sma23Trend = this.taMethods.calcSmaTrend(this.closeData, 23, 5);
		}
		if (this.daysOfData > 70) {
			this.sma65 = this.taMethods.calcSma(this.getCloseData(), 65);
			this.smaPerc65 = this.taMethods.calcPercentChange(this.currentPrice, this.sma65);
			this.sma65Trend = this.taMethods.calcSmaTrend(this.closeData, 65, 5);
		}
		if (this.daysOfData > 135) {
			this.sma130 = this.taMethods.calcSma(this.getCloseData(), 130);
			this.smaPerc130 = this.taMethods.calcPercentChange(this.currentPrice, this.sma130);
			this.sma130Trend = this.taMethods.calcSmaTrend(this.closeData, 130, 5);

		}
		if (this.daysOfData > 265) {
			this.sma260 = this.taMethods.calcSma(this.getCloseData(), 260);
			this.smaPerc260 = this.taMethods.calcPercentChange(this.currentPrice, this.sma260);
			this.sma260Trend = this.taMethods.calcSmaTrend(this.closeData, 260, 5);
		}

		if (this.daysOfData > 46) {
			this.atr23 = this.taMethods.calcATR(this.getHighData(), this.getLowData(), this.getCloseData(), 23);
			if (this.sma23 > 0.0) {
				this.atrPercent23 = RangeMethods.avgTrueRangePercent(this.getHighData(), this.getLowData(), this.getCloseData(),
				    23);
			}
		}

		if (this.daysOfData > 46) {
			this.adx = this.taMethods.calcAdx(this.getHighData(), this.getLowData(), this.getCloseData(), 23);
			this.diPlus = this.taMethods.calcDiPlus(this.highData, this.lowData, this.closeData, 23);
			this.diMinus = this.taMethods.calcDiMinus(this.highData, this.lowData, this.closeData, 23);
		}

		if (this.daysOfData > 24) {
			this.mfi23 = this.taMethods.calcMFI(this.typicalPriceData, this.volumeData, 23);
		}
		if (this.daysOfData > 66) {
			this.mfi65 = this.taMethods.calcMFI(this.typicalPriceData, this.volumeData, 65);
		}
		if (this.daysOfData > 131) {
			this.mfi130 = this.taMethods.calcMFI(this.typicalPriceData, this.volumeData, 130);
		}
		if (this.daysOfData > 15) {
			this.mfi14 = this.taMethods.calcMFI(this.typicalPriceData, this.volumeData, 14);
		}

		if (this.daysOfData > 260) {
			this.high260 = UtilMethods.max(this.getHighData(), 260);
			this.low260 = UtilMethods.min(this.getLowData(), 260);

			this.priceInRng260 = (this.currentPrice - this.low260) / (this.high260 - this.low260);
			this.priceOffHigh260 = this.taMethods.calcPercentChange(this.currentPrice, this.high260);
			this.priceOffLow260 = this.taMethods.calcPercentChange(this.currentPrice, this.low260);

			// this.lr260 = this.taMethods.calcLinearRegression(this.closeData, 260);
			// this.lrAngle260 =
			// this.taMethods.calcLinearRegressionAngle(this.closeData, 260);
			// this.lrInt260 = this.taMethods.calcLinearRegressionInt(this.closeData,
			// 260);
			// this.lrSlope260 =
			// this.taMethods.calcLinearRegressionSlope(this.closeData, 260);
		}

		if (this.daysOfData > 30) {
			this.rsi14 = this.taMethods.calcRsi(this.closeData, 14);
		}
	}

	/**
	 * @return the adx
	 */
	public double getAdx() {
		return this.adx;
	}

	/**
	 * @return the atr23
	 */
	public double getAtr23() {
		return this.atr23;
	}

	/**
	 * @return the atrPercent23
	 */
	public double getAtrPercent23() {
		return this.atrPercent23;
	}

	/**
	 * @return the avgVol20
	 */
	public double getAvgVol20() {
		return this.avgVol20;
	}

	/**
	 * @return the avgVol65
	 */
	public double getAvgVol65() {
		return this.avgVol65;
	}

	/**
	 * @return the chg
	 */
	public double getChg() {
		return this.chg;
	}

	/**
	 * @return the chg130
	 */
	public double getChg130() {
		return this.chg130;
	}

	/**
	 * @return the chg23
	 */
	public double getChg23() {
		return this.chg23;
	}

	/**
	 * @return the chg260
	 */
	public double getChg260() {
		return this.chg260;
	}

	/**
	 * @return the chg65
	 */
	public double getChg65() {
		return this.chg65;
	}

	public double getClose(int day) {
		return this.closeData[day];
	}

	/**
	 * @return the closeData
	 */
	public double[] getCloseData() {
		return this.closeData;
	}

	/**
	 * @return the currentPrice
	 */
	public double getCurrentPrice() {
		return this.currentPrice;
	}

	public String getDailyDataString(int day) {
		final DailyData dd = new DailyData(this.dateData[day], this.openData[day], this.highData[day], this.lowData[day],
		    this.closeData[day], this.volumeData[day], this.oiData[day]);
		return dd.toString();
	}

	/**
	 *
	 * net.ajaskey.market.ta.getDataCount
	 *
	 * @return
	 */
	public int getDataCount() {
		return this.data.size();
	}

	public Calendar getDate(int day) {
		return this.dateData[day];
	}

	/**
	 * @return the closeData
	 */
	public Calendar[] getDateData() {
		return this.dateData;
	}

	/**
	 *
	 * @return
	 */
	public Integer getDaysOfData() {
		return this.daysOfData;
	}

	/**
	 * @return the diMinus
	 */
	public double getDiMinus() {
		return this.diMinus;
	}

	/**
	 * @return the diPlus
	 */
	public double getDiPlus() {
		return this.diPlus;
	}

	/**
	 * @return the fundies
	 */
	public Fundamentals getFundies() {
		return this.fundies;
	}

	public double getHigh(int day) {
		return this.highData[day];
	}

	/**
	 * @return the high260
	 */
	public double getHigh260() {
		return this.high260;
	}

	/**
	 * @return the highData
	 */
	public double[] getHighData() {
		return this.highData;
	}

	public double getLow(int day) {
		return this.lowData[day];
	}

	/**
	 * @return the low260
	 */
	public double getLow260() {
		return this.low260;
	}

	/**
	 * @return the lowData
	 */
	public double[] getLowData() {
		return this.lowData;
	}

	/**
	 * @return the lr260
	 */
	public double getLr260() {
		return this.lr260;
	}

	/**
	 * @return the lrAngle260
	 */
	public double getLrAngle260() {
		return this.lrAngle260;
	}

	/**
	 * @return the lrInt260
	 */
	public double getLrInt260() {
		return this.lrInt260;
	}

	/**
	 * @return the lrSlope260
	 */
	public double getLrSlope260() {
		return this.lrSlope260;
	}

	/**
	 * @return the mfi130
	 */
	public double getMfi130() {
		return this.mfi130;
	}

	/**
	 * @return the mfi14
	 */
	public double getMfi14() {
		return this.mfi14;
	}

	/**
	 * @return the mfi23
	 */
	public double getMfi23() {
		return this.mfi23;
	}

	/**
	 * @return the mfi65
	 */
	public double getMfi65() {
		return this.mfi65;
	}

	public double getOi(int day) {
		return this.oiData[day];
	}

	/**
	 * @return the openData
	 */
	public double[] getOiData() {
		return this.oiData;
	}

	public double getOpen(int day) {
		return this.openData[day];
	}

	/**
	 * @return the openData
	 */
	public double[] getOpenData() {
		return this.openData;
	}

	/**
	 * @return the priceInRng260
	 */
	public double getPriceInRng260() {
		return this.priceInRng260;
	}

	/**
	 * @return the priceOffHigh260
	 */
	public double getPriceOffHigh260() {
		return this.priceOffHigh260;
	}

	/**
	 * @return the priceOffLow260
	 */
	public double getPriceOffLow260() {
		return this.priceOffLow260;
	}

	/**
	 * @return the rsi14
	 */
	public double getRsi14() {
		return this.rsi14;
	}

	/**
	 * @return the rsRaw
	 */
	public double getRsRaw() {
		return this.rsRaw;
	}

	/**
	 * @return the rsStRaw
	 */
	public double getRsStRaw() {
		return this.rsStRaw;
	}

	/**
	 * @return the sma130
	 */
	public Double getSma130() {
		return this.sma130;
	}

	/**
	 * @return the sma130Trend
	 */
	public TrendType getSma130Trend() {
		return this.sma130Trend;
	}

	/**
	 * @return the sma23
	 */
	public Double getSma23() {
		return this.sma23;
	}

	/**
	 * @return the sma23Trend
	 */
	public TrendType getSma23Trend() {
		return this.sma23Trend;
	}

	/**
	 * @return the sma260
	 */
	public Double getSma260() {
		return this.sma260;
	}

	/**
	 * @return the sma260Trend
	 */
	public TrendType getSma260Trend() {
		return this.sma260Trend;
	}

	/**
	 * @return the sma65
	 */
	public Double getSma65() {
		return this.sma65;
	}

	/**
	 * @return the sma65Trend
	 */
	public TrendType getSma65Trend() {
		return this.sma65Trend;
	}

	/**
	 * @return the smaPerc130
	 */
	public Double getSmaPerc130() {
		return this.smaPerc130;
	}

	/**
	 * @return the smaPerc23
	 */
	public Double getSmaPerc23() {
		return this.smaPerc23;
	}

	/**
	 * @return the smaPerc260
	 */
	public Double getSmaPerc260() {
		return this.smaPerc260;
	}

	/**
	 * @return the smaPerc65
	 */
	public Double getSmaPerc65() {
		return this.smaPerc65;
	}

	/**
	 * @return the taMethods
	 */
	public TaMethods getTaMethods() {
		return this.taMethods;
	}

	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return this.ticker;
	}

	/**
	 * @return the tickerExchange
	 */
	public String getTickerExchange() {
		return this.tickerExchange;
	}

	/**
	 * @return the tickerName
	 */
	public String getTickerName() {
		return this.tickerName;
	}

	/**
	 * @return the trueHighData
	 */
	public double[] getTrueHighData() {
		return this.trueHighData;
	}

	/**
	 * @return the trueLowData
	 */
	public double[] getTrueLowData() {
		return this.trueLowData;
	}

	/**
	 * @return the typicalPriceData
	 */
	public double[] getTypicalPriceData() {
		return this.typicalPriceData;
	}

	public double getVolume(int day) {
		return this.volumeData[day];
	}

	/**
	 * @return the volumeData
	 */
	public double[] getVolumeData() {
		return this.volumeData;
	}

	/**
	 *
	 * net.ajaskey.market.ta.rSort
	 *
	 */
	public void rSort() {
		Collections.sort(this.data, new SortDailyDataReverse());
		this.fillDataArrays(0, true);
	}

	/**
	 * @param ticker
	 *          the ticker to set
	 */
	public void setTicker(String tickerIn) {
		if (tickerIn != null) {
			this.ticker = tickerIn.trim().toUpperCase();
		} else {
			this.ticker = "UNKNOWN";
		}
	}

	/**
	 * @param tickerExchange
	 *          the tickerExchange to set
	 */
	public void setTickerExchange(String tickerExchange) {
		this.tickerExchange = tickerExchange;
	}

	@Override
	public String toString() {
		String str = this.ticker + TAB + this.tickerName + TAB + this.tickerExchange + NL;
		for (final DailyData dd : this.data) {
			str += TAB + dd.toString() + NL;
		}

		return str;

	}

	/**
	 *
	 * net.ajaskey.market.ta.calcPriceChange
	 *
	 * Calculate the closing price change from n days previous
	 *
	 * @param days
	 * @return
	 */
	private double calcPriceChange(int days) {
		double ret = 0.0;
		if (this.daysOfData > days) {
			if (this.closeData[days] > 0.0) {
				ret = this.taMethods.calcPercentChange(this.closeData[0], this.closeData[days]);
			}
		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.ta.getData
	 *
	 * @return
	 */
	private List<DailyData> getData() {
		return this.data;
	}

	/**
	 * Data from www.eoddata.com occasionally has volumes of zero. Set these to
	 * the average volume of 5 days before and 5 days after.
	 *
	 * net.ajaskey.market.ta.normalizeZeroVolume
	 *
	 */
	private void normalizeZeroVolume() {
		for (int i = 0; i < this.data.size(); i++) {

			if ((int) (double) this.data.get(i).getVolume() < 1) {

				int knt = 0;
				double sum = 0.0;
				for (int j = i - 1; j >= 0; j--) {
					if ((int) (double) this.data.get(j).getVolume() > 0) {
						knt++;
						sum += this.data.get(j).getVolume();
						if (knt == 5) {
							break;
						}
					}
				}
				final double avg5m = sum / knt;

				sum = 0.0;
				knt = 0;
				for (int j = i + 1; j < this.data.size(); j++) {
					if ((int) (double) this.data.get(j).getVolume() > 0) {
						knt++;
						sum += this.data.get(j).getVolume();
						if (knt == 5) {
							break;
						}
					}
				}
				if (knt > 0) {
					final double avg5p = sum / knt;
					final double avg10 = (avg5p + avg5m) / 2.0;
					this.data.get(i).setVolume(avg10);
					// System.out.printf("%d %d %d%n", (int) avg5m, (int) avg10, (int)
					// avg5p);
				} else {
					this.data.get(i).setVolume(0);
				}
			}
		}

	}

	/**
	 *
	 * net.ajaskey.market.ta.setRawRS
	 *
	 * @return
	 */
	private double setRawRS() {
		// System.out.println(getTicker() + "\t" + getChg260() + "\t" + getChg130()
		// + "\t" + getChg65() + "\t" + getChg23());
		// return (0.50 * this.getChg260()) + (0.25 * this.getChg130()) + (0.1675 *
		// this.getChg65())
		// + (0.0825 * this.getChg23());
		return (0.66 * this.getChg260()) + (0.25 * this.getChg130()) + (0.09 * this.getChg65());
	}

	/**
	 *
	 * net.ajaskey.market.ta.setRawStRS
	 *
	 * @return
	 */
	private double setRawStRS() {
		return ((0.33 * this.getChg65()) + (0.67 * this.getChg23()));
	}

	/**
	 *
	 * net.ajaskey.market.ta.setRsRaw
	 *
	 * Sets the price change increments and calculates the raw RS for sorting
	 * later.
	 *
	 */
	private void setRs() {
		this.chg23 = this.calcPriceChange(23);
		this.chg65 = this.calcPriceChange(65);
		this.chg130 = this.calcPriceChange(130);
		this.chg260 = this.calcPriceChange(260);
		if (this.daysOfData > 260) {
			this.rsRaw = this.setRawRS();
		}
		if (this.daysOfData > 65) {
			this.rsStRaw = this.setRawStRS();
		}
	}
}
