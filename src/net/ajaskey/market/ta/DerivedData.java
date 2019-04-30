
package net.ajaskey.market.ta;

import net.ajaskey.market.ta.methods.UtilMethods;

/**
 * This class...
 *
 * @author Andy Askey <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class DerivedData {

	private Double	sma23;
	private Double	smaPerc23;
	private Double	sma65;
	private Double	smaPerc65;
	private Double	sma130;
	private Double	smaPerc130;
	private Double	sma260;
	private Double	smaPerc260;
	private double	currentPrice;
	private double	avgVol65;
	private double	avgVol20;
	private double	chg;
	private double	chg23;
	private double	chg65;
	private double	chg130;
	private double	chg260;
	private double	low260;
	private double	high260;
	private double	rsRaw;
	private double	rsStRaw;
	private double	atr23;
	private double	diPlus;
	private double	diMinus;
	private double	atrPercent23;
	private double	mfi23;
	private double	mfi65;
	private double	mfi130;
	private double	mfi14;
	private double	priceInRng260;
	private double	priceOffHigh260;
	private double	priceOffLow260;
	private double	lr260;
	private double	lrAngle260;
	private double	lrInt260;
	private double	lrSlope260;
	private double	rsi14;

	private TickerData td;

	final private double INITVAL = -98765432.1;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DerivedData() {

		this.sma23 = this.INITVAL;
		this.sma65 = this.INITVAL;
		this.sma130 = this.INITVAL;
		this.sma260 = this.INITVAL;
		this.smaPerc23 = this.INITVAL;
		this.smaPerc65 = this.INITVAL;
		this.smaPerc130 = this.INITVAL;
		this.smaPerc260 = this.INITVAL;
		this.avgVol65 = this.INITVAL;
		this.chg = this.INITVAL;
		this.chg23 = this.INITVAL;
		this.chg65 = this.INITVAL;
		this.chg130 = this.INITVAL;
		this.chg260 = this.INITVAL;
		this.rsRaw = this.INITVAL;
		this.rsStRaw = this.INITVAL;
		this.atr23 = this.INITVAL;
		this.atrPercent23 = this.INITVAL;
		this.diPlus = this.INITVAL;
		this.diMinus = this.INITVAL;
		this.mfi23 = this.INITVAL;
		this.mfi65 = this.INITVAL;
		this.mfi130 = this.INITVAL;
		this.mfi14 = this.INITVAL;
		this.currentPrice = this.INITVAL;
		this.lr260 = this.INITVAL;
		this.lrAngle260 = this.INITVAL;
		this.lrInt260 = this.INITVAL;
		this.lrSlope260 = this.INITVAL;
		this.rsi14 = this.INITVAL;
		this.td = null;
	}

	/**
	 * @return the atr23
	 */
	public double getAtr23() {

		if (this.atr23 == this.INITVAL) {
			this.setAtr23();
		}
		return this.atr23;
	}

	/**
	 * @return the atrPercent23
	 */
	public double getAtrPercent23() {

		if (this.atrPercent23 == this.INITVAL) {
			this.setAtrPercent23();
		}
		return this.atrPercent23;
	}

	/**
	 * @return the avgVol20
	 */
	public double getAvgVol20() {

		if (this.avgVol20 == this.INITVAL) {
			this.setAvgVol20();
		}
		return this.avgVol20;
	}

	/**
	 * @return the avgVol65
	 */
	public double getAvgVol65() {

		if (this.avgVol65 == this.INITVAL) {
			this.setAvgVol65();
		}
		return this.avgVol65;
	}

	/**
	 * @return the chg
	 */
	public double getChg() {

		if (this.chg == this.INITVAL) {
			this.setChg();
		}
		return this.chg;
	}

	/**
	 * @return the chg130
	 */
	public double getChg130() {

		if (this.chg130 == this.INITVAL) {
			this.setChg130();
		}
		return this.chg130;
	}

	/**
	 * @return the chg23
	 */
	public double getChg23() {

		if (this.chg23 == this.INITVAL) {
			this.setChg23();
		}
		return this.chg23;
	}

	/**
	 * @return the chg260
	 */
	public double getChg260() {

		if (this.chg260 == this.INITVAL) {
			this.setChg260();
		}
		return this.chg260;
	}

	/**
	 * @return the chg65
	 */
	public double getChg65() {

		if (this.chg65 == this.INITVAL) {
			this.setChg65();
		}
		return this.chg65;
	}

	/**
	 * @return the currentPrice
	 */
	public double getCurrentPrice() {

		if (this.currentPrice == this.INITVAL) {
			this.setCurrentPrice();
		}
		return this.currentPrice;
	}

	/**
	 * @return the diMinus
	 */
	public double getDiMinus() {

		if (this.diMinus == this.INITVAL) {
			this.setDiMinus();
		}
		return this.diMinus;
	}

	/**
	 * @return the diPlus
	 */
	public double getDiPlus() {

		if (this.diPlus == this.INITVAL) {
			this.setDiPlus();
		}
		return this.diPlus;
	}

	/**
	 * @return the high260
	 */
	public double getHigh260() {

		if (this.high260 == this.INITVAL) {
			this.setHigh260();
		}
		return this.high260;
	}

	/**
	 * @return the low260
	 */
	public double getLow260() {

		if (this.low260 == this.INITVAL) {
			this.setLow260();
		}
		return this.low260;
	}

	/**
	 * @return the lr260
	 */
	public double getLr260() {

		if (this.lr260 == this.INITVAL) {
			this.setLr260();
		}
		return this.lr260;
	}

	/**
	 * @return the lrAngle260
	 */
	public double getLrAngle260() {

		if (this.lrAngle260 == this.INITVAL) {
			this.setLrAngle260();
		}
		return this.lrAngle260;
	}

	/**
	 * @return the lrInt260
	 */
	public double getLrInt260() {

		if (this.lrInt260 == this.INITVAL) {
			this.setLrInt260();
		}
		return this.lrInt260;
	}

	/**
	 * @return the lrSlope260
	 */
	public double getLrSlope260() {

		if (this.lrSlope260 == this.INITVAL) {
			this.setLrSlope260();
		}
		return this.lrSlope260;
	}

	/**
	 * @return the mfi130
	 */
	public double getMfi130() {

		if (this.mfi130 == this.INITVAL) {
			this.setMfi130();
		}
		return this.mfi130;
	}

	/**
	 * @return the mfi14
	 */
	public double getMfi14() {

		if (this.mfi14 == this.INITVAL) {
			this.setMfi14();
		}
		return this.mfi14;
	}

	/**
	 * @return the mfi23
	 */
	public double getMfi23() {

		if (this.mfi23 == this.INITVAL) {
			this.setMfi23();
		}
		return this.mfi23;
	}

	/**
	 * @return the mfi65
	 */
	public double getMfi65() {

		if (this.mfi65 == this.INITVAL) {
			this.setMfi65();
		}
		return this.mfi65;
	}

	/**
	 * @return the priceInRng260
	 */
	public double getPriceInRng260() {

		if (this.priceInRng260 == this.INITVAL) {
			this.setPriceInRng260();
		}
		return this.priceInRng260;
	}

	/**
	 * @return the priceOffHigh260
	 */
	public double getPriceOffHigh260() {

		if (this.priceOffHigh260 == this.INITVAL) {
			this.setPriceOffHigh260();
		}
		return this.priceOffHigh260;
	}

	/**
	 * @return the priceOffLow260
	 */
	public double getPriceOffLow260() {

		if (this.priceOffLow260 == this.INITVAL) {
			this.setPriceOffLow260();
		}
		return this.priceOffLow260;
	}

	/**
	 * @return the rsi14
	 */
	public double getRsi14() {

		if (this.rsi14 == this.INITVAL) {
			this.setRsi14();
		}
		return this.rsi14;
	}

	/**
	 * @return the rsRaw
	 */
	public double getRsRaw() {

		if (this.rsRaw == this.INITVAL) {
			this.setRsRaw();
		}
		return this.rsRaw;
	}

	/**
	 * @return the rsStRaw
	 */
	public double getRsStRaw() {

		if (this.rsStRaw == this.INITVAL) {
			this.setRsStRaw();
		}
		return this.rsStRaw;
	}

	/**
	 * @return the sma130
	 */
	public Double getSma130() {

		if (this.sma130 == this.INITVAL) {
			this.setSma130();
		}
		return this.sma130;
	}

	/**
	 * @return the sma23
	 */
	public Double getSma23() {

		if (this.sma23 == this.INITVAL) {
			this.setSma23();
		}
		return this.sma23;
	}

	/**
	 * @return the sma260
	 */
	public Double getSma260() {

		if (this.sma260 == this.INITVAL) {
			this.setSma260();
		}
		return this.sma260;
	}

	/**
	 * @return the sma65
	 */
	public Double getSma65() {

		if (this.sma65 == this.INITVAL) {
			this.setSma65();
		}
		return this.sma65;
	}

	/**
	 * @return the smaPerc130
	 */
	public Double getSmaPerc130() {

		if (this.smaPerc130 == this.INITVAL) {
			this.setSmaPerc130();
		}
		return this.smaPerc130;
	}

	/**
	 * @return the smaPerc23
	 */
	public Double getSmaPerc23() {

		if (this.smaPerc23 == this.INITVAL) {
			this.setSmaPerc23();
		}
		return this.smaPerc23;
	}

	/**
	 * @return the smaPerc260
	 */
	public Double getSmaPerc260() {

		if (this.smaPerc260 == this.INITVAL) {
			this.setSmaPerc260();
		}
		return this.smaPerc260;
	}

	/**
	 * @return the smaPerc65
	 */
	public Double getSmaPerc65() {

		if (this.smaPerc65 == this.INITVAL) {
			this.setSmaPerc65();
		}
		return this.smaPerc65;
	}

	/**
	 *
	 * net.ajaskey.market.ta.build
	 *
	 * @param td
	 */
	public void set(final TickerData td) {

		try {
			if (td != null) {
				this.td = td;
				this.setSma23();
				this.setSmaPerc23();
				this.setSma65();
				this.setSmaPerc65();
				this.setSma130();
				this.setSmaPerc130();
				this.setSma260();
				this.setSmaPerc260();
				this.setCurrentPrice();
				this.setAvgVol20();
				this.setAvgVol65();
				this.setChg();
				this.setChg23();
				this.setChg65();
				this.setChg130();
				this.setChg260();
				this.setLow260();
				this.setHigh260();
				this.setRsRaw();
				this.setRsStRaw();
			}
		} catch (final Exception e) {
		}
	}

	/**
	 */
	private void setAtr23() {

		double val = 0;
		try {
			val = 0;
		} catch (final Exception e) {
			this.atr23 = 0.0;
		}
		this.atr23 = val;
	}

	/**
	 */
	private void setAtrPercent23() {

		double val = 0;
		try {
			val = 0.0;
		} catch (final Exception e) {
			val = 0.0;
		}
		this.atrPercent23 = val;
	}

	/**
	 * @param avgVol20
	 *          the avgVol20 to set
	 */
	private void setAvgVol20() {

		try {
			final double sma = UtilMethods.sma(this.td.getVolumeData(), 20);
			this.avgVol20 = sma;
		} catch (final Exception e) {
			this.avgVol20 = 0.0;
		}
	}

	/**
	 * @param avgVol65
	 *          the avgVol65 to set
	 */
	private void setAvgVol65() {

		try {
			final double sma = UtilMethods.sma(this.td.getVolumeData(), 65);
			this.avgVol65 = sma;
		} catch (final Exception e) {
			this.avgVol65 = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.setChg
	 *
	 */
	private void setChg() {

		try {
			final double chg = UtilMethods.calcPercentChange(this.td.getClose(0), this.td.getClose(1));
			this.chg = chg;
		} catch (final Exception e) {
			this.chg = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.setChg130
	 *
	 */
	private void setChg130() {

		try {
			final double chg = UtilMethods.calcPercentChange(this.td.getClose(0), this.td.getClose(130));
			this.chg130 = chg;
		} catch (final Exception e) {
			this.chg130 = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.setChg23
	 *
	 */
	private void setChg23() {

		try {
			final double chg = UtilMethods.calcPercentChange(this.td.getClose(0), this.td.getClose(23));
			this.chg23 = chg;
		} catch (final Exception e) {
			this.chg23 = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.setChg260
	 *
	 */
	private void setChg260() {

		try {
			final double chg = UtilMethods.calcPercentChange(this.td.getClose(0), this.td.getClose(260));
			this.chg260 = chg;
		} catch (final Exception e) {
			this.chg260 = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.setChg65
	 *
	 */
	private void setChg65() {

		try {
			final double chg = UtilMethods.calcPercentChange(this.td.getClose(0), this.td.getClose(65));
			this.chg65 = chg;
		} catch (final Exception e) {
			this.chg65 = 0.0;
		}
	}

	/**
	 * @param currentPrice
	 *          the currentPrice to set
	 */
	private void setCurrentPrice() {

		try {
			this.currentPrice = this.td.getClose(0);
		} catch (final Exception e) {
			this.currentPrice = 0.0;
		}
	}

	/**
	 */
	private void setDiMinus() {

		this.diMinus = 0;
	}

	/**
	 */
	private void setDiPlus() {

		this.diPlus = 0;
	}

	/**
	 *
	 * net.ajaskey.market.ta.setHigh260
	 *
	 */
	private void setHigh260() {

		try {
			final double high = UtilMethods.max(this.td.getCloseData(), 260);
			this.high260 = high;
		} catch (final Exception e) {
			this.high260 = 0.0;
		}
	}

	/**
	 * @param low260
	 *          the low260 to set
	 */
	private void setLow260() {

		try {
			final double low = UtilMethods.min(this.td.getCloseData(), 260);
			this.low260 = low;
		} catch (final Exception e) {
			this.low260 = 0.0;
		}
	}

	/**
	 */
	private void setLr260() {

		this.lr260 = 0;
	}

	/**
	 */
	private void setLrAngle260() {

		this.lrAngle260 = 0;
	}

	/**
	 */
	private void setLrInt260() {

		this.lrInt260 = 0;
	}

	/**
	 */
	private void setLrSlope260() {

		this.lrSlope260 = 0;
	}

	/**
	 */
	private void setMfi130() {

		this.mfi130 = 0;
	}

	/**
	 */
	private void setMfi14() {

		this.mfi14 = 0;
	}

	/**
	 */
	private void setMfi23() {

		this.mfi23 = 0;
	}

	/**
	 */
	private void setMfi65() {

		this.mfi65 = 0;
	}

	/**
	 */
	private void setPriceInRng260() {

		this.priceInRng260 = 0;
	}

	/**
	 */
	private void setPriceOffHigh260() {

		this.priceOffHigh260 = 0;
	}

	/**
	 * @param priceOffLow260
	 *          the priceOffLow260 to set
	 */
	private void setPriceOffLow260() {

		this.priceOffLow260 = 0;
	}

	/**
	 */
	private void setRsi14() {

		this.rsi14 = 0;
	}

	/**
	 * @param rsRaw
	 *          the rsRaw to set
	 */
	private void setRsRaw() {

		try {
			final double raw = (0.67 * this.getChg260()) + (0.33 * this.getChg130());
			this.rsRaw = raw;
		} catch (final Exception e) {
			this.rsRaw = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.setRsStRaw
	 *
	 */
	private void setRsStRaw() {

		try {
			final double raw = (0.67 * this.getChg65()) + (0.33 * this.getChg23());
			this.rsStRaw = raw;
		} catch (final Exception e) {
			this.rsStRaw = 0.0;
		}
	}

	/**
	 * @param sma130
	 *          the sma130 to set
	 */
	private void setSma130() {

		try {
			final double sma = UtilMethods.sma(this.td.getCloseData(), 130);
			this.sma130 = sma;
		} catch (final Exception e) {
			this.sma130 = 0.0;
		}
	}

	/**
	 * @param sma23
	 *          the sma23 to set
	 */
	private void setSma23() {

		try {
			final double sma = UtilMethods.sma(this.td.getCloseData(), 23);
			this.sma23 = sma;
		} catch (final Exception e) {
			this.sma23 = 0.0;
		}
	}

	/**
	 * @param sma260
	 *          the sma260 to set
	 */
	private void setSma260() {

		try {
			final double sma = UtilMethods.sma(this.td.getCloseData(), 260);
			this.sma260 = sma;
		} catch (final Exception e) {
			this.sma260 = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.setSma65
	 *
	 */
	private void setSma65() {

		try {
			final double sma = UtilMethods.sma(this.td.getCloseData(), 65);
			this.sma65 = sma;
		} catch (final Exception e) {
			this.sma65 = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.setSmaPerc130
	 *
	 */
	private void setSmaPerc130() {

		try {
			this.smaPerc130 = UtilMethods.calcPercentChange(this.td.getClose(0), this.td.getClose(130));
		} catch (final Exception e) {
			this.smaPerc130 = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.setSmaPerc23
	 *
	 */
	private void setSmaPerc23() {

		try {
			this.smaPerc23 = UtilMethods.calcPercentChange(this.td.getClose(0), this.td.getClose(23));
		} catch (final Exception e) {
			this.smaPerc23 = 0.0;
		}
	}

	/**
	 * @param smaPerc260
	 *          the smaPerc260 to set
	 */
	private void setSmaPerc260() {

		try {
			this.smaPerc260 = UtilMethods.calcPercentChange(this.td.getClose(0), this.td.getClose(260));
		} catch (final Exception e) {
			this.smaPerc260 = 0.0;
		}
	}

	/**
	 *
	 * net.ajaskey.market.ta.setSmaPerc65
	 *
	 * @param smaPerc65
	 */
	private void setSmaPerc65() {

		try {
			this.smaPerc65 = UtilMethods.calcPercentChange(this.td.getClose(0), this.td.getClose(65));
		} catch (final Exception e) {
			this.smaPerc65 = 0.0;
		}
	}

}
