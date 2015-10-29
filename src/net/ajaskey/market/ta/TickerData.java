
package net.ajaskey.market.ta;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import net.ajaskey.market.ta.input.ParseData;
import net.ajaskey.market.ta.methods.MovingAverageMethods;
import net.ajaskey.market.ta.methods.RangeMethods;
import net.ajaskey.market.ta.methods.TaMethods;

/**
 *
 * @author Andy Askey
 *
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *
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
 *
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */
public class TickerData {

	private String								ticker;

	private final List<DailyData>	data			= new ArrayList<DailyData>();

	/**
	 * Derived values
	 */
	private Integer								daysOfData;

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
	private double[]							trueHighData;
	private double[]							trueLowData;
	private double								currentPrice;
	private double								avgVol65;
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
	 * @param d
	 * @param o
	 * @param h
	 * @param l
	 * @param c
	 * @param v
	 */
	public TickerData(String t, Calendar d, double o, double h, double l, double c, double v) {
		final DailyData dd = new DailyData(d, o, h, l, c, v);
		this.setTicker(t);
		this.data.add(dd);
		this.daysOfData = 0;
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
	 *
	 * net.ajaskey.market.ta.build
	 *
	 * @param fileNames
	 * @return
	 * @throws ParseException
	 * @throws FileNotFoundException
	 */
	static public List<TickerData> build(List<String> fileNames) throws ParseException, FileNotFoundException {

		if ((fileNames == null) || (fileNames.size() < 1)) {
			System.out.println("Invalid list of fileNames sent to net.ajaskey.market.ta.build()");
			throw new FileNotFoundException();
		}
		final List<TickerData> tdList = ParseData.parseFiles(fileNames);
		for (final TickerData t : tdList) {
			t.generateDerived();
		}
		return tdList;
	}

	/**
	 *
	 * net.ajaskey.market.ta.getDailyField
	 *
	 * @param tdata
	 * @param ftype
	 * @return
	 */
	static public double[] getDailyField(TickerData tdata, FieldName ftype) {
		final double retData[] = new double[tdata.getData().size()];
		int knt = 0;
		for (final DailyData dd : tdata.getData()) {
			switch (ftype) {
				case OPEN:
					retData[knt++] = dd.getOpen();
					break;
				case CLOSE:
					retData[knt++] = dd.getClose();
					break;
				case HIGH:
					retData[knt++] = dd.getHigh();
					break;
				case LOW:
					retData[knt++] = dd.getLow();
					break;
				case VOLUME:
					retData[knt++] = dd.getVolume();
					break;
				case TRUEHIGH:
					retData[knt++] = dd.getTrueHigh();
					break;
				case TRUELOW:
					retData[knt++] = dd.getTrueLow();
					break;
				default:
					break;
			}
		}

		return retData;
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
	 * net.ajaskey.market.ta.addData
	 *
	 * @param ddata
	 */
	public void addData(DailyData ddata) {
		this.data.add(ddata);
	}

	/**
	 *
	 * net.ajaskey.market.ta.generateDerived
	 *
	 */
	public void generateDerived() {

		/**
		 * Must sort prices by date before many of the following calculations
		 */
		Collections.sort(this.data, new SortData());
		this.normalizeZeroVolume();

		this.daysOfData = this.data.size();
		this.openData = TickerData.getDailyField(this, FieldName.OPEN);
		this.highData = TickerData.getDailyField(this, FieldName.HIGH);
		this.lowData = TickerData.getDailyField(this, FieldName.LOW);
		this.closeData = TickerData.getDailyField(this, FieldName.CLOSE);
		this.volumeData = TickerData.getDailyField(this, FieldName.VOLUME);

		this.currentPrice = this.closeData[0];

		for (int i = 0; i < (this.data.size() - 1); i++) {
			this.data.get(i).setTrueHigh(this.data.get(i + 1).getClose());
			this.data.get(i).setTrueLow(this.data.get(i + 1).getClose());
			this.data.get(i).setDailyChg(this.data.get(i + 1).getClose());
		}
		this.data.get(this.data.size() - 1).setTrueHigh(this.data.get(this.data.size() - 1).getHigh());
		this.data.get(this.data.size() - 1).setTrueLow(this.data.get(this.data.size() - 1).getLow());
		this.trueHighData = TickerData.getDailyField(this, FieldName.TRUEHIGH);
		this.trueLowData = TickerData.getDailyField(this, FieldName.TRUELOW);

		if (this.daysOfData > 260) {
			this.setRsRaw();

		}

		if (this.daysOfData > 23) {
			this.sma23 = MovingAverageMethods.sma(this.getCloseData(), 23);
			this.smaPerc23 = this.taMethods.calcPercentChange(this.currentPrice, this.sma23);
			this.sma23Trend = this.taMethods.calcSmaTrend(this, 23, FieldName.CLOSE);
		}
		if (this.daysOfData > 70) {
			this.sma65 = this.taMethods.calcSma(this, 65, FieldName.CLOSE);
			this.smaPerc65 = this.taMethods.calcPercentChange(this.currentPrice, this.sma65);
			this.sma65Trend = this.taMethods.calcSmaTrend(this, 65, FieldName.CLOSE);

			this.avgVol65 = this.taMethods.calcSma(this, 65, FieldName.VOLUME);
		}
		if (this.daysOfData > 135) {
			this.sma130 = this.taMethods.calcSma(this, 130, FieldName.CLOSE);
			this.smaPerc130 = this.taMethods.calcPercentChange(this.currentPrice, this.sma130);
			this.sma130Trend = this.taMethods.calcSmaTrend(this, 130, FieldName.CLOSE);

		}
		if (this.daysOfData > 265) {
			this.sma260 = this.taMethods.calcSma(this, 260, FieldName.CLOSE);
			this.smaPerc260 = this.taMethods.calcPercentChange(this.currentPrice, this.sma260);
			this.sma260Trend = this.taMethods.calcSmaTrend(this, 260, FieldName.CLOSE);
		}

		this.atr23 = this.taMethods.calcATR(this, 23);
		if (this.sma23 > 0.0) {
			this.atrPercent23 = RangeMethods.avgTrueRangePercent(getHighData(), getLowData(), getCloseData(), 23);
			// (this.atr23 / this.sma23) * 100.0;
		}

		this.adx = this.taMethods.calcAdx(this, 23);
		this.diPlus = this.taMethods.calcDiPlus(this, 23);
		this.diMinus = this.taMethods.calcDiMinus(this, 23);

		this.mfi23 = this.taMethods.calcMFI(this, 23);
		this.mfi65 = this.taMethods.calcMFI(this, 65);
		this.mfi130 = this.taMethods.calcMFI(this, 130);
		this.mfi14 = this.taMethods.calcMFI(this, 14);

		this.high260 = this.taMethods.calcHigh(this, 260);
		this.low260 = this.taMethods.calcLow(this, 260);

		this.priceInRng260 = (this.currentPrice - this.low260) / (this.high260 - this.low260);
		this.priceOffHigh260 = this.taMethods.calcPercentChange(this.currentPrice, this.high260);
		this.priceOffLow260 = this.taMethods.calcPercentChange(this.currentPrice, this.low260);

		this.lr260 = this.taMethods.calcLinearRegression(this, 260);
		this.lrAngle260 = this.taMethods.calcLinearRegressionAngle(this, 260);
		this.lrInt260 = this.taMethods.calcLinearRegressionInt(this, 260);
		this.lrSlope260 = this.taMethods.calcLinearRegressionSlope(this, 260);

		this.rsi14 = this.taMethods.calcRsi(this, 14);

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
	 * @return the avgVol65
	 */
	public double getAvgVol65() {
		return this.avgVol65;
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

	/**
	 * @return the data
	 */
	public List<DailyData> getData() {
		return this.data;
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

	public double getVolume(int day) {
		return this.volumeData[day];
	}

	/**
	 * @return the openData
	 */
	public double[] getVolumeData() {
		return this.volumeData;
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
				final double avg5p = sum / knt;
				final double avg10 = (avg5p + avg5m) / 2.0;
				this.data.get(i).setVolume(avg10);
				// System.out.printf("%d %d %d%n", (int) avg5m, (int) avg10, (int)
				// avg5p);
			}
		}

	}

	/**
	 *
	 * net.ajaskey.market.ta.setRsRaw
	 *
	 * Sets the price change increments and calculates the raw RS for sorting
	 * later.
	 *
	 */
	private void setRsRaw() {

		this.chg23 = this.calcPriceChange(23);
		this.chg65 = this.calcPriceChange(65);
		this.chg130 = this.calcPriceChange(130);
		this.chg260 = this.calcPriceChange(260);
		this.rsRaw = this.taMethods.calcRawRS(this);
		this.rsStRaw = this.taMethods.calcRawStRS(this);
	}

}
