
package net.ajaskey.market.ta;

import java.util.ArrayList;
import java.util.List;

/**
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
public class IndustryData {

	private String							name;
	private String							ticker;
	private double							rawRs;
	private double							rawRsSt;
	private double							chg260;
	private double							avgVol;
	private final List<Integer>	rank	= new ArrayList<>();
	private final List<Double>	slope	= new ArrayList<>();

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public IndustryData() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the avgVol
	 */
	public double getAvgVol() {
		return this.avgVol;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	public List<Integer> getRank() {
		return this.rank;
	}

	/**
	 * @return the rank
	 */
	public int getRank(int pos) {
		return this.rank.get(pos);
	}

	public String getRanks() {
		String ranks = "";
		for (final Integer i : this.rank) {
			ranks += String.format("%3d  ", (i + 1));
		}
		return ranks;
	}

	/**
	 * @return the rawRs
	 */
	public double getRawRs() {
		return this.rawRs;
	}

	/**
	 * @return the slope
	 */
	public double getSlope(int pos) {
		return this.slope.get(pos);
	}

	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return this.ticker;
	}

	/**
	 * @param avgVol
	 *          the avgVol to set
	 */
	public void setAvgVol(double avgVol) {
		this.avgVol = avgVol;
	}

	/**
	 * @param name
	 *          the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param rank
	 *          the rank to set
	 */
	public void setRank(int rank) {
		this.rank.add(rank);
	}

	/**
	 * @param rawRs
	 *          the rawRs to set
	 */
	public void setRawRs(double rawRs) {
		this.rawRs = rawRs;
	}

	/**
	 * @param slope
	 *          the slope to set
	 */
	public void setSlope(double slope) {
		this.slope.add(slope);
	}

	/**
	 * @param ticker
	 *          the ticker to set
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	/**
	 * @return the rawRsSt
	 */
	public double getRawRsSt() {
		return rawRsSt;
	}

	/**
	 * @param rawRsSt
	 *          the rawRsSt to set
	 */
	public void setRawRsSt(double rawRsSt) {
		this.rawRsSt = rawRsSt;
	}

	/**
	 * @return the chg260
	 */
	public double getChg260() {
		return chg260;
	}

	/**
	 * @param chg260
	 *          the chg260 to set
	 */
	public void setChg260(double chg260) {
		this.chg260 = chg260;
	}

}
