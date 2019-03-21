
package net.ajaskey.market.tools.options;

import java.util.Calendar;

public class OptionsData {

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final Calendar ed = Calendar.getInstance();
		ed.set(2019, Calendar.DECEMBER, 15);
		final OptionsData od = new OptionsData(10.0, 12.0, 0.01, 0.15, ed);
		System.out.println(od);
	}

	private final double	currentPriceOfUnderlying;
	private final double	strikePrice;
	private final double	interestRate;
	private final double	volatility;

	private final Calendar	expiry;
	private final double		yearsToExpiry;

	private final long daysToExpiry;

	private double delta;

	private double theta;

	private double rho;

	private double gamma;

	private double vega;

	/**
	 *
	 * @param cprice
	 * @param sprice
	 * @param intrate
	 * @param iv
	 * @param exp
	 */
	public OptionsData(double cprice, double sprice, double intrate, double iv, Calendar exp) {

		this.currentPriceOfUnderlying = cprice;
		this.strikePrice = sprice;
		this.interestRate = intrate;
		this.volatility = iv;
		this.expiry = Calendar.getInstance();
		this.expiry.setTime(exp.getTime());

		this.daysToExpiry = this.getDeltaDays(Calendar.getInstance(), this.expiry);
		this.yearsToExpiry = this.getDeltaYears(Calendar.getInstance(), this.expiry);

	}

	public double getCurrentPriceOfUnderlying() {

		return this.currentPriceOfUnderlying;
	}

	public long getDaysToExpiry() {

		return this.daysToExpiry;
	}

	public double getDelta() {

		return this.delta;
	}

	private long getDeltaDays(Calendar c1, Calendar c2) {

		return (c2.getTime().getTime() - c1.getTime().getTime()) / 86400000;
	}

	private double getDeltaYears(Calendar c1, Calendar c2) {

		return this.getDeltaDays(c1, c2) / 365.0;
	}

	public Calendar getExpiry() {

		return this.expiry;
	}

	public double getGamma() {

		return this.gamma;
	}

	public double getInterestRate() {

		return this.interestRate;
	}

	public double getRho() {

		return this.rho;
	}

	public double getStrikePrice() {

		return this.strikePrice;
	}

	public double getTheta() {

		return this.theta;
	}

	public double getTimeToExpire() {

		return this.yearsToExpiry;
	}

	public double getVega() {

		return this.vega;
	}

	public double getVolatility() {

		return this.volatility;
	}

	@Override
	public String toString() {

		final String ret = String.format("years : %.2f%ndays  : %d", this.yearsToExpiry, this.daysToExpiry);
		return ret;
	}

}
