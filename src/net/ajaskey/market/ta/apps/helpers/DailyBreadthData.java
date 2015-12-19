
package net.ajaskey.market.ta.apps.helpers;

import java.text.NumberFormat;
import java.util.List;

import net.ajaskey.market.ta.TickerData;
import net.ajaskey.market.ta.methods.UtilMethods;

/**
 * This class...
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
public class DailyBreadthData {

	private static int		newLowsTotal	= 0;
	private static int		newHighsTotal	= 0;

	private int						adv;
	private int						dec;
	private int						adDiff10dma;

	private long					advVol;
	private long					decVol;
	private long					adVolDiff10dma;
	private long					totVol;
	private double				percentVolume;

	private double				percentAdvancing;
	private double				percentAdvancingVol;

	private int						newLows;
	private int						newHighs;

	final private String	TAB						= "\t";

	/**
	 *
	 * This method serves as a constructor for the class.
	 *
	 * @param tdList
	 */
	public DailyBreadthData(List<TickerData> tdList) {
		this.init();
		final int knt = tdList.size();
		int sumAdv = 0;
		int sumDec = 0;
		long sumVolAdv = 0;
		long sumVolDec = 0;
		double sumAvgVol = 0;

		for (final TickerData td : tdList) {
			td.generateDerived();
			double chg = UtilMethods.calcPriceChange(td.getCurrentPrice(), td.getClose(1));
			if (chg > 0.0) {
				this.adv++;
				this.advVol += td.getVolume(0);
			} else if (chg < 0.0) {
				this.dec++;
				this.decVol += td.getVolume(0);
			}
			this.totVol += td.getVolume(0);
			sumAvgVol += UtilMethods.sma(td.getVolumeData(), 50, 1);

			final double minPrice = UtilMethods.min(td.getLowData(), 260, 1);
			if ((minPrice > 1.0) && (td.getCurrentPrice() < minPrice)) {
				if (this.newLows == -1) {
					this.newLows = 0;
					this.newHighs = 0;
				}
				this.newLows++;
				// System.out.println("low : " + td.getTicker());
			}

			final double maxPrice = UtilMethods.max(td.getHighData(), 260, 1);
			if ((maxPrice > 1.0) && (td.getCurrentPrice() > maxPrice)) {
				if (this.newHighs == -1) {
					this.newHighs = 0;
					this.newLows = 0;
				}
				this.newHighs++;
				// System.out.println("high : " + td.getTicker());
			}

			int a = 0;
			int d = 0;
			long av = 0;
			long dv = 0;
			for (int i = 0; i < 10; i++) {
				chg = UtilMethods.calcPriceChange(td.getClose(i), td.getClose(i + 1));
				if (chg > 0.0) {
					a++;
					av += td.getVolume(i);
				} else if (chg < 0.0) {
					d++;
					dv += td.getVolume(i);
				}
			}
			sumAdv += a;
			sumDec += d;
			sumVolAdv += av;
			sumVolDec += dv;

		}

		//System.out.println(totVol + "  " + (long) sumAvgVol);
		percentVolume = (double) totVol / sumAvgVol * 100.0;

		this.advVol /= 1000000;
		this.decVol /= 1000000;
		this.totVol /= 1000000;
		this.percentAdvancing = ((double) this.adv / (double) knt) * 100.0;
		this.percentAdvancingVol = ((double) this.advVol / (double) this.totVol) * 100.0;

		adDiff10dma = (sumAdv - sumDec) / 10;
		adVolDiff10dma = (sumVolAdv - sumVolDec) / 10 / 1000000;

	}

	/**
	 * 
	 * This method serves as a constructor for the class.
	 *
	 * @param advancing
	 * @param declining
	 * @param advancingVol
	 * @param decliningVol
	 * @param highs
	 * @param lows
	 */
	public DailyBreadthData(TickerData advancing, TickerData declining, TickerData advancingVol, TickerData decliningVol,
	    TickerData highs, TickerData lows) {

		this.init();
		advancing.generateDerived();
		declining.generateDerived();
		advancingVol.generateDerived();
		decliningVol.generateDerived();
		if (highs != null) {
			highs.generateDerived();
			this.newHighs = (int) highs.getClose(0);
		} else {
			this.newHighs = 0;
		}
		if (lows != null) {
			lows.generateDerived();
			this.newLows = (int) lows.getClose(0);
		} else {
			this.newLows = 0;
		}
		newHighsTotal += this.newHighs;
		newLowsTotal += this.newLows;

		this.adv = (int) advancing.getClose(0);
		this.dec = (int) declining.getClose(0);
		this.advVol = (long) advancingVol.getClose(0);
		this.decVol = (long) decliningVol.getClose(0);
		this.totVol = this.advVol + this.decVol;

		this.percentAdvancing = ((double) this.adv / (double) (this.adv + this.dec)) * 100.0;
		this.percentAdvancingVol = ((double) this.advVol / (double) this.totVol) * 100.0;

		int sum = 0;
		long sumVol = 0;
		for (int i = 0; i < 10; i++) {
			sum += (advancing.getClose(i) - declining.getClose(i));
			sumVol += (advancingVol.getClose(i) - decliningVol.getClose(i));
		}
		this.adDiff10dma = sum / 10;
		this.adVolDiff10dma = sumVol / 10;

		double sumVolume = 0;
		final int days = 50;
		for (int i = 0; i < days; i++) {
			sumVolume += (advancingVol.getClose(i) + decliningVol.getClose(i));
		}
		final double avgVol = sumVolume / days;
		this.percentVolume = (this.totVol / avgVol) * 100.0;

		if ((newHighs == 0) && (newLows == 0)) {
			newHighs = -1;
			newLows = -1;
		}

	}

	/**
	 * @return the newHighsTotal
	 */
	public static int getNewHighsTotal() {
		return newHighsTotal;
	}

	/**
	 * @return the newLowsTotal
	 */
	public static int getNewLowsTotal() {
		return newLowsTotal;
	}

	/**
	 * @return the adDiff10dma
	 */
	public int getAdDiff10dma() {
		return this.adDiff10dma;
	}

	/**
	 * @return the adv
	 */
	public int getAdv() {
		return this.adv;
	}

	/**
	 * @return the adv
	 */
	public long getAdvancing() {
		return this.adv;
	}

	/**
	 * @return the adVolDiff10dma
	 */
	public long getAdVolDiff10dma() {
		return this.adVolDiff10dma;
	}

	/**
	 * @return the advVol
	 */
	public long getAdvVol() {
		return this.advVol;
	}

	/**
	 * @return the dec
	 */
	public int getDec() {
		return this.dec;
	}

	/**
	 * @return the dec
	 */
	public long getDeclining() {
		return this.dec;
	}

	/**
	 * @return the decVol
	 */
	public long getDecVol() {
		return this.decVol;
	}

	/**
	 * @return the newHigh52
	 */
	public int getNewHighs() {
		return this.newHighs;
	}

	/**
	 * @return the newLow52
	 */
	public int getNewLows() {
		return this.newLows;
	}

	/**
	 * @return the percentAD
	 */
	public double getPercentAD() {
		return this.percentAdvancing;
	}

	/**
	 * @return the percentADV
	 */
	public double getPercentADV() {
		return this.percentAdvancingVol;
	}

	/**
	 * @return the percentAdvancing
	 */
	public double getPercentAdvancing() {
		return this.percentAdvancing;
	}

	/**
	 * @return the percentAdvancingVol
	 */
	public double getPercentAdvancingVol() {
		return this.percentAdvancingVol;
	}

	/**
	 * @return the percentVolume
	 */
	public double getPercentVolume() {
		return this.percentVolume;
	}

	/**
	 * @return the tAB
	 */
	public String getTAB() {
		return this.TAB;
	}

	/**
	 * @return the totVol
	 */
	public long getTotVol() {
		return this.totVol;
	}

	/**
	 * @param newHighs
	 *          the newHighs to set
	 */
	public void setNewHighs() {
		this.newHighs = newHighsTotal;
	}

	/**
	 * @param newLows
	 *          the newLows to set
	 */
	public void setNewLows() {
		this.newLows = newLowsTotal;
	}

	@Override
	public String toString() {
		String nhStr = "-";
		String nlStr = "-";
		String diffStr = "-";
		String diffVolStr = "-";

		if (this.newHighs > -1) {
			nhStr = NumberFormat.getIntegerInstance().format(this.newHighs);
		}
		if (this.newLows > -1) {
			nlStr = NumberFormat.getIntegerInstance().format(this.newLows);
		}
		if (Math.abs(this.adDiff10dma) > -1) {
			diffStr = NumberFormat.getIntegerInstance().format(this.adDiff10dma);
		}
		if (Math.abs(this.adVolDiff10dma) > -1) {
			diffVolStr = NumberFormat.getIntegerInstance().format(this.adVolDiff10dma);
		}

		final String str = this.adv + this.TAB + this.dec + this.TAB + (int) this.percentAdvancing + "%" + this.TAB
		    + diffStr + this.TAB + this.advVol + this.TAB + this.decVol + this.TAB + (int) this.percentAdvancingVol + "%"
		    + this.TAB + diffVolStr + this.TAB + (int) this.percentVolume + "%" + this.TAB + nhStr + this.TAB + nlStr;
		return str;
	}

	private void init() {
		this.adv = 0;
		this.dec = 0;
		this.adDiff10dma = 0;
		this.advVol = 0;
		this.decVol = 0;
		this.adVolDiff10dma = 0;
		this.totVol = 0;
		this.percentAdvancing = 0;
		this.percentVolume = 0;
		this.percentAdvancingVol = 0;
		this.newHighs = -1;
		this.newLows = -1;
	}

}
