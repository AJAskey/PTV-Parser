package net.ajaskey.market.tools.options;

import java.util.Calendar;

public class OptionsData {

	private double currentPriceOfUnderlying;
	private double strikePrice;
	private double interestRate;
	private double volatility;
	private Calendar expiry;

	private	double yearsToExpiry;
	private	long daysToExpiry;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar ed = Calendar.getInstance();
		ed.set(2019, Calendar.DECEMBER, 15);
		OptionsData od = new OptionsData(10.0, 12.0, 0.01, 0.15, ed);
		System.out.println(od);
	}

	private long getDeltaDays(Calendar c1, Calendar c2) {
		return (c2.getTime().getTime() - c1.getTime().getTime()) / 86400000;
	}

	private double getDeltaYears(Calendar c1, Calendar c2) {
		return (double) getDeltaDays(c1, c2) / 365.0;
	}

	/**
	 * 
	 * @param cprice
	 * @param sprice
	 * @param intrate
	 * @param iv
	 * @param exp
	 */
	public OptionsData(double cprice, double sprice, double intrate, double iv, Calendar exp) {
		currentPriceOfUnderlying = cprice;
		strikePrice = sprice;
		interestRate = intrate;
		volatility = iv;
		expiry = Calendar.getInstance();
		expiry.setTime(exp.getTime());

		this.daysToExpiry = getDeltaDays(Calendar.getInstance(), expiry);
		this.yearsToExpiry = getDeltaYears(Calendar.getInstance(), expiry);


	}

	@Override
	public String toString() {
		String ret = String.format("years : %.2f%ndays  : %d" , this.yearsToExpiry, this.daysToExpiry);
		return ret;
	}

	public double getCurrentPriceOfUnderlying() {
		return currentPriceOfUnderlying;
	}

	public double getStrikePrice() {
		return strikePrice;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public double getVolatility() {
		return volatility;
	}

	public Calendar getExpiry() {
		return expiry;
	}

	public double getTimeToExpire() {
		return yearsToExpiry;
	}

	public double getDelta() {
		return delta;
	}

	public double getTheta() {
		return theta;
	}

	public double getRho() {
		return rho;
	}

	public double getGamma() {
		return gamma;
	}

	public double getVega() {
		return vega;
	}

	public long getDaysToExpiry() {
		return daysToExpiry;
	}


	private double delta;
	private double theta;
	private double rho;
	private double gamma;
	private double vega;

}
