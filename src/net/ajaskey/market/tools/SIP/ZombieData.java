
package net.ajaskey.market.tools.SIP;

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
public class ZombieData {

	final private static String	NL	= "\n";
	final private static String	TAB	= "\t";

	private static void print(String desc, double val) {

		System.out.printf("%-10s : %f%n", desc, val);
	}

	public double				zIncome;
	public double				zAdjInc;
	public double				zDividend;
	public double				zCash;
	public double				zDebt;
	public double				zNet;
	public double				zScore;
	public double				zAdjScr;
	public boolean			zIsZombie;
	public ZombieStates	zState;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public ZombieData() {

		this.zIncome = 0.0;
		this.zAdjInc = 0.0;
		this.zDividend = 0.0;
		this.zCash = 0.0;
		this.zDebt = 0.0;
		this.zNet = 0.0;
		this.zScore = 0.0;
		this.zAdjScr = 0.0;
		this.zIsZombie = false;
		this.zState = ZombieStates.UNKNOWN;
	}

	/**
	 * net.ajaskey.market.tools.SIP.calc
	 *
	 */
	public void calc(CompanyData cd) {

		this.zCash = this.calcZCash(cd);
		this.zDebt = this.calcZDebt(cd);
		this.zNet = this.zCash - this.zDebt;
		this.zIncome = this.calcZIncome(cd);
		this.zScore = this.calcZScore(cd);

	}

	/**
	 * net.ajaskey.market.tools.SIP.calcZCash
	 *
	 * @param cd
	 * @return
	 */
	public double calcZCash(CompanyData cd) {

		final double ret = cd.bsd.cash.getMostRecent() + cd.bsd.acctReceiveable.getMostRecent()
		    + cd.bsd.stInvestments.getMostRecent() + cd.bsd.otherAssets.getMostRecent() + cd.bsd.inventory.getMostRecent()
		    + (cd.bsd.ltInvestments.getMostRecent() * 0.85) + (cd.bsd.otherLtAssets.getMostRecent() * 0.25)
		    + (cd.bsd.goodwill.getMostRecent() * 0.10);
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.SIP.calcZDebt
	 *
	 * @param cd
	 * @return
	 */
	public double calcZDebt(CompanyData cd) {

		final double ret = cd.bsd.acctPayable.getMostRecent() + cd.bsd.stDebt.getMostRecent()
		    + cd.bsd.otherCurrLiab.getMostRecent();
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.SIP.calcZIncome
	 *
	 * @param cd
	 * @return
	 */
	public double calcZIncome(CompanyData cd) {

		double ret = cd.id.pretaxIncome.q1 + cd.id.pretaxIncome.q2 + cd.id.pretaxIncome.q3 + cd.id.pretaxIncome.q4;
		if (cd.id.pretaxIncome.q1 == 0.0) ret += cd.id.pretaxIncome.q5;
		final double avg = ret / 4.0;
		this.zDividend = cd.id.dividend.q1 * cd.shares.getMostRecent();
		ret = avg - this.zDividend;
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.SIP.calcZScore
	 *
	 * @param cd
	 * @return
	 */
	public double calcZScore(CompanyData cd) {

		double scr = 999.0;
		if (cd.sector.equalsIgnoreCase("Financials")) scr = 25.0;
		else {

			//System.out.println(cd.ticker);

			//Case both net and income positive
			if ((this.zNet > 0.0) && (this.zIncome > 0.0)) {
				this.zState = ZombieStates.PNET_PINC;
				this.zScore = 100.0;
			}

			//Case both net and income are negative
			else if ((this.zNet < 0.0) && (this.zIncome < 0.0)) {
				if (this.zAdjInc > 0.0) this.zState = ZombieStates.NNET_NINC_DIVCUT;
				else {
					this.zState = ZombieStates.NNET_NINC;
					this.zScore = -100.0;
					this.zIsZombie = true;
				}
			}

			//Case net is positive and income is negative
			else if ((this.zNet > 0.0) && (this.zIncome < 0.0)) {

				this.zState = ZombieStates.PNET_NINC;

				this.zScore = this.zNet / Math.abs(this.zIncome);

				if (this.zScore > 8.0) {
					this.zState = ZombieStates.PNET_NINC_ENUFCASH;
				}

				else if ((this.zScore < 8.0) && (this.zDividend > 0.0)) {

					this.zIsZombie = true;
					this.zAdjInc = this.zIncome + this.zDividend;
					if (Math.abs(this.zAdjInc) > 0.0) {
						this.zAdjScr = this.zNet / this.zAdjInc;

						if (this.zAdjScr > 8.0) {
							this.zState = ZombieStates.PNET_NINC_DIVCUT;
							this.zIsZombie = false;
						}
					}
				} else if (this.zScore < 8.0) {
					this.zIsZombie = true;
				}
			}

			//Case net is negative and income is positive
			else if ((this.zNet < 0.0) && (this.zIncome > 0.0)) {

				this.zScore = this.zNet / this.zIncome;
				this.zState = ZombieStates.NNET_PINC;

				if (this.zScore < -8.0) {
					this.zIsZombie = true;
					this.zAdjInc = this.zIncome + this.zDividend;
					if (Math.abs(this.zAdjInc) > 0.0) {
						this.zAdjScr = Math.abs(this.zNet) / this.zAdjInc;
						if (this.zAdjScr < 8.0) {
							this.zState = ZombieStates.NNET_PINC_DIVCUT;
							this.zIsZombie = false;
						}
					}
				}
			}

			String rpt = this.report("", cd.ticker);
			if (rpt.length() > 0) {
				System.out.println(rpt);
			}
		}

		return scr;

	}

	public String report(String fname, String ticker) {

		String ret = "";
		switch (this.zState) {
			case PNET_PINC:
				break;
			default:
				ret = NL + ticker + NL;
				ret += this.toString();
				break;
		}

		switch (this.zState) {
			case NNET_PINC_DIVCUT:
				ret += TAB + "Can survive for 2 years by reducing the dividend.";
				break;
			case NNET_NINC:
				break;
			case NNET_NINC_DIVCUT:
				ret += TAB + "Can survive for 2 years by reducing the dividend.";
				break;
			case NNET_PINC:
				if (!this.zIsZombie) {
					try {
						String s = String.format("\tCan pay existing current debt in %.2f quarters.", Math.abs(this.zScore));
						ret += s;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
			case PNET_NINC:
				String s = String.format("\tOnly enough cash to pay for %.2f quarters.", Math.abs(this.zScore));
				ret += s;
				break;
			case PNET_NINC_DIVCUT:
				ret += TAB + "Can survive for 2 years by reducing the dividend.";
				break;
			case PNET_NINC_ENUFCASH:
				ret += TAB + "Can survive for 2 years using existing cash reserves.";
				break;
			case PNET_PINC:
				break;
			case UNKNOWN:
				break;
			default:
				break;
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String ret = "";
		ret += TAB + "Zombie Cash       : " + QuarterlyData.fmt(this.zCash) + NL;
		ret += TAB + "Zombie Debt       : " + QuarterlyData.fmt(this.zDebt) + NL;
		ret += TAB + "Zombie Net        : " + QuarterlyData.fmt(this.zNet) + NL;
		ret += TAB + "Zombie Income     : " + QuarterlyData.fmt(this.zIncome) + NL;
		ret += TAB + "Zombie Score      : " + QuarterlyData.fmt(this.zScore) + NL;
		if (this.zScore < 100.0) {
			ret += TAB + "Zombie Adj Income : " + QuarterlyData.fmt(this.zAdjInc) + NL;
			ret += TAB + "Zombie Dividend   : " + QuarterlyData.fmt(this.zDividend) + NL;
			ret += TAB + "Zombie Adj Score  : " + QuarterlyData.fmt(this.zAdjScr) + NL;
		}
		ret += TAB + "Zombie State      : " + this.zState + NL;
		if (this.zIsZombie) {
			ret += TAB + "Is ZOMBIE!" + NL;
		}
		return ret;
	}
}
