
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

	public static int			zKnt	= 0;
	public static String	zStr	= "";

	public static double	arKnob						= 0.95;
	public static double	inventoryKnob			= 0.95;
	public static double	stAssetsKnob			= 0.98;
	public static double	ltAssetsKnob			= 0.15;
	public static double	stInvestmentsKnob	= 0.99;
	public static double	ltInvestmentsKnob	= 0.85;
	public static double	gwKnob						= 0.10;

	//	private static void print(String desc, double val) {
	//		System.out.printf("%-10s : %f%n", desc, val);
	//	}

	public double				zIncome;
	public double				unusualExpenses;
	public double				zAdjInc;
	public double				zDividend;
	public double				zCash;
	public double				zDebt;
	public double				zNet;
	public double				zScore;
	public double				zAdjScr;
	public double				zKeepItRunning;
	public boolean			zIsZombie;
	public ZombieStates	zState;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public ZombieData() {

		this.zIncome = 0.0;
		this.unusualExpenses = 0.0;
		this.zAdjInc = 0.0;
		this.zDividend = 0.0;
		this.zCash = 0.0;
		this.zDebt = 0.0;
		this.zNet = 0.0;
		this.zScore = 0.0;
		this.zAdjScr = 0.0;
		this.zKeepItRunning = 0.0;
		this.zIsZombie = false;
		this.zState = ZombieStates.UNKNOWN;
	}

	/**
	 * net.ajaskey.market.tools.SIP.calc
	 *
	 */
	public void calc(CompanyData cd) {

		if (cd.ticker.equalsIgnoreCase("QTNT")) {
			//System.out.println(this);
		}

		this.zCash = this.calcZCash(cd);
		this.zDebt = this.calcZDebt(cd);
		this.zNet = this.zCash - this.zDebt;
		this.zIncome = this.calcZIncome(cd);
		this.calcZScore(cd);

		if (this.zIsZombie && (this.zAdjScr < 4.0)) {
			//zStr += " $" + cd.ticker;
			zStr += " " + cd.ticker;
			int len = zStr.length();
			int m = len % 100;
			if ((len > 100) && (m < 6)) {
				zStr += NL;
			}
			zKnt++;
			System.out.printf("%-8s\t%25s\t%d%n", cd.ticker, cd.sector, cd.numEmp);
		}

	}

	/**
	 * net.ajaskey.market.tools.SIP.calcZCash
	 *
	 * @param cd
	 * @return
	 */
	public double calcZCash(CompanyData cd) {

		final double ret = cd.bsd.cash.getMostRecent() + (cd.bsd.acctReceiveable.getMostRecent() * arKnob)
		    + (cd.bsd.stInvestments.getMostRecent() * stInvestmentsKnob)
		    + (cd.bsd.otherAssets.getMostRecent() * stAssetsKnob) + (cd.bsd.inventory.getMostRecent() * inventoryKnob)
		    + (cd.bsd.ltInvestments.getMostRecent() * ltInvestmentsKnob)
		    + (cd.bsd.otherLtAssets.getMostRecent() * ltAssetsKnob) + (cd.bsd.goodwill.getMostRecent() * gwKnob);
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

		if (cd.ticker.equalsIgnoreCase("NI")) {
			System.out.println(this);
		}

		double ret = cd.id.pretaxIncome.q1 + cd.id.pretaxIncome.q2 + cd.id.pretaxIncome.q3 + cd.id.pretaxIncome.q4
		    + cd.id.unusualIncome.q1 + cd.id.unusualIncome.q2 + cd.id.unusualIncome.q3 + cd.id.unusualIncome.q4;

		if (cd.id.pretaxIncome.q1 == 0.0) ret += cd.id.pretaxIncome.q5 + cd.id.unusualIncome.q5;
		final double avg = ret / 4.0;
		this.zDividend = cd.id.dividend.q1 * cd.shares.getMostRecent();
		ret = avg; // - this.zDividend;
		return ret;
	}

	/**
	 * net.ajaskey.market.tools.SIP.calcZScore
	 *
	 * @param cd
	 * @return
	 */
	public void calcZScore(CompanyData cd) {

		if (cd.ticker.equalsIgnoreCase("CAKE")) {
			System.out.println(this);
		}
		
		if (cd.currentRatio > 0.95) {
			this.zScore = 55.0;
			this.zAdjScr = this.zScore;
			return;
		}

		this.zAdjInc = this.zIncome + this.zDividend;

		if (cd.sector.equalsIgnoreCase("Financials")) {
			this.zScore = 123.456;
			return;
		}

		//Case both net and income positive
		if ((this.zNet > 0.0) && (this.zIncome > 0.0)) {
			this.zState = ZombieStates.PNET_PINC;
			this.zIsZombie = false;
			this.zKeepItRunning = this.zIncome + (this.zDebt / 8.0);
			this.zScore = 100.0;
			this.zAdjScr = 100.0;
		}

		//Case both net and income are negative
		else if ((this.zNet < 0.0) && (this.zIncome < 0.0)) {

			this.zKeepItRunning = Math.abs(this.zAdjInc) + (this.zDebt / 8.0);
			if (this.zKeepItRunning != 0.0) this.zAdjScr = Math.abs(this.zCash / this.zKeepItRunning);

			this.zState = ZombieStates.NNET_NINC;
			this.zScore = this.zAdjScr;
			this.zIsZombie = true;

			if (this.zAdjInc > 0.0) {
				if (this.zAdjScr > 8.0) {
					this.zState = ZombieStates.NNET_NINC_DIVCUT;
					this.zIsZombie = false;
				}
			} else {
				//this.zAdjScr = 0.0;
			}
		}

		//Case net is positive and income is negative
		else if ((this.zNet > 0.0) && (this.zIncome < 0.0)) {

			this.zKeepItRunning = Math.abs(this.zIncome) + (this.zDebt / 8.0);
			if (this.zKeepItRunning != 0.0) this.zScore = Math.abs(this.zCash / this.zKeepItRunning);

			this.zState = ZombieStates.PNET_NINC;
			//System.out.printf("%s\t%s%n%s%n", cd.ticker, cd.sector, this.toString());

			//Cash funds at least 8 quarters
			if (this.zScore >= 8.0) {
				this.zState = ZombieStates.PNET_NINC_ENUFCASH;
				this.zIsZombie = false;
				this.zAdjScr = this.zScore;
			}

			//Cash funds less than 8 quarters but can use dividend
			else if ((this.zScore < 8.0) && (this.zDividend > 0.0)) {

				//System.out.printf("%s\t%s%n%s%n", cd.ticker, cd.sector, this.toString());

				this.zIsZombie = true;

				this.zKeepItRunning = Math.abs(this.zAdjInc) + (this.zDebt / 8.0);
				if (this.zKeepItRunning != 0.0) this.zAdjScr = Math.abs(this.zCash / this.zKeepItRunning);

				if (this.zAdjScr > 8.0) {
					this.zState = ZombieStates.PNET_NINC_DIVCUT;
					this.zIsZombie = false;
				}
			}

			//Cash funds less than 8 quarters with no dividend
			else {
				this.zIsZombie = true;
				this.zAdjScr = this.zScore;
				//System.out.printf("%s\t%s%n%s%n", cd.ticker, cd.sector, this.toString());
			}
		}

		//Case net is negative and income is positive
		else if ((this.zNet < 0.0) && (this.zIncome > 0.0)) {

			this.zKeepItRunning = this.zDebt / 8.0;
			//zScore = number of Qs zcash plus half income to pay off St debt
			this.zScore = (this.zCash + (this.zIncome * 0.5)) / this.zKeepItRunning;

			if (this.zScore <= 8.0) {
				this.zState = ZombieStates.NNET_PINC_ENUFINCOME;
				this.zIsZombie = false;
				this.zAdjScr = this.zScore;

			} else {

				this.zAdjScr = (this.zCash + (this.zAdjInc * 0.25)) / this.zKeepItRunning;

				if (this.zAdjScr > 8.0) {
					this.zState = ZombieStates.NNET_PINC;
					this.zIsZombie = true;
				} else {
					this.zState = ZombieStates.NNET_PINC_DIVCUT;
					this.zIsZombie = false;
				}
			}
		}
	}

	public String zStatus() {

		String ret = "";

		if (this.zScore == 123.456) {
			return ret;
		}

		switch (this.zState) {
			case NNET_PINC_DIVCUT:
				ret += TAB + String.format("Can pay off debt in %.2f quarters by reducing the dividend with existing cash and quarterly income.", this.zAdjScr);
				break;
			case NNET_NINC:
				ret += TAB + String.format("Can only survive for %.2f quarters with existing cash reserves.", this.zAdjScr);
				break;
			case NNET_NINC_DIVCUT:
				ret += TAB + String.format("Can pay off debt in %.2f quarters by reducing the dividend.", this.zAdjScr);
				break;
			case NNET_PINC:
				if (!this.zIsZombie) {
					final String s = String.format("\tCan pay of debt in %.2f quarters.", Math.abs(this.zAdjScr));
					ret += s;
				} else {
					final String s = String.format("\tWill take %.2f quarters to pay off current debt with quarterly income.",
					    Math.abs(this.zAdjScr));
					ret += s;
				}
				break;
			case PNET_NINC:
				final String s = String.format("\tOnly enough cash to continue operations for %.2f quarters.",
				    Math.abs(this.zAdjScr));
				ret += s;
				break;
			case PNET_NINC_DIVCUT:
				ret += TAB + String.format("Can survive for %.2f quarters by reducing the dividend.", this.zAdjScr);
				break;
			case PNET_NINC_ENUFCASH:
				ret += TAB + String.format("Can survive for %.2f quarters using cash reserves.", this.zScore);
				break;
			case PNET_PINC:
				break;
			case UNKNOWN:
				break;
			case NNET_PINC_ENUFINCOME:
				ret += TAB
				    + String.format("Will payoff existing ST debt in %.2f quarters using existing cash and quarterly income.", this.zScore);
				break;
			default:
				break;

		}
		return ret;
	}

	/**
	 *
	 * net.ajaskey.market.tools.SIP.report
	 *
	 * @param ticker
	 * @param sector
	 * @return
	 */
	public String report(String ticker, String sector) {

		String ret = "";

		if (sector.equalsIgnoreCase("Financials")) return ret;

		if (!this.zIsZombie) return ret;

		System.out.printf("%-6s\t%s%n", ticker, sector);
		//		zStr += " $" + ticker;
		//		int len = zStr.length();
		//		int m = len % 200;
		//		if ((len > 100) && (m < 6)) {
		//			zStr += NL;
		//		}
		//		zKnt++;

		switch (this.zState) {
			case PNET_PINC:
				break;
			default:
				ret = ticker + NL;
				ret += this.toString();
				break;
		}

		ret += zStatus();

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
		ret += TAB + "Zombie Adj Income : " + QuarterlyData.fmt(this.zAdjInc) + NL;
		ret += TAB + "Zombie Dividend   : " + QuarterlyData.fmt(this.zDividend) + NL;
		ret += TAB + "Zombie Adj Score  : " + QuarterlyData.fmt(this.zAdjScr) + NL;
		ret += TAB + "Operations Cost   : " + QuarterlyData.fmt(this.zKeepItRunning) + NL;
		ret += TAB + "Zombie State      : " + this.zState + NL;
		if (this.zIsZombie) ret += TAB + "Is ZOMBIE!" + NL;
		return ret;
	}
}
