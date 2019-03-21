
package net.ajaskey.market.tools.options;

import java.text.ParseException;
import java.util.Calendar;

import net.ajaskey.market.misc.Utils;

public class DataItem {

	// Expiration Date Calls Last Sale Net Bid Ask Vol IV Delta Gamma Open Int
	// Strike Puts Last Sale Net Bid Ask Vol IV Delta Gamma Open Int

	final static int	APUT	= 1;
	final static int	ACALL	= 2;

	final static String NL = "\n";

	/**
	 *
	 * @param fld
	 * @return
	 */
	public static DataItem setCall(String fld[]) {

		final DataItem di = new DataItem(fld, ACALL);
		return di;
	}

	/**
	 *
	 * @param fld
	 * @return
	 */
	public static DataItem setPut(String fld[]) {

		final DataItem di = new DataItem(fld, APUT);
		return di;
	}

	String	id;
	double	last;
	double	net;
	double	bid;
	double	ask;
	int			volume;

	double	iv;
	double	oi;

	double	delta;
	double	gamma;
	double	theta;
	double	rho;
	double	vega;

	double	strike;
	double	priceOfUnderlying;

	double	rate;
	double	yrs;

	int dataType;

	Calendar expiry;
	Calendar sellDate;

	double price;

	/**
	 *
	 * @param pctype
	 * @param currentPrice
	 * @param strike
	 * @param expiration
	 * @param rate
	 * @param iv
	 */
	public DataItem(int pctype, double currentPrice, double strike, Calendar expiration, double rate, double iv, Calendar selldate) {

		this.dataType = pctype;
		this.strike = strike;
		this.priceOfUnderlying = currentPrice;
		this.expiry = expiration;
		this.rate = rate;
		this.iv = iv;

		this.id = "";
		this.net = 0.0;
		this.bid = 0.0;
		this.ask = 0.0;
		this.last = 0.0;
		this.volume = 0;
		this.oi = 0.0;
		this.yrs = 0.0;
		this.sellDate = selldate;

		this.delta = 0.0;
		this.gamma = 0.0;
		this.theta = 0.0;
		this.rho = 0.0;
		this.vega = 0.0;

		this.yrs = OptionsProcessor.getDeltaYears(this.sellDate, this.expiry);

		OptionsProcessor.setGreeks(this);

		if (pctype == ACALL) {
			this.price = OptionsProcessor.getCallPrice(this.priceOfUnderlying, this.strike, this.rate, this.yrs, this.iv);
		} else if (pctype == APUT) {
			this.price = OptionsProcessor.getPutPrice(this.priceOfUnderlying, this.strike, this.rate, this.yrs, this.iv);
		}
	}

	/**
	 *
	 * @param fld
	 * @param putcalltype
	 */
	private DataItem(String fld[], int putcalltype) {

		int ptr = 0;
		this.id = fld[ptr++].trim();
		this.last = Double.parseDouble(fld[ptr++].trim());
		this.net = Double.parseDouble(fld[ptr++].trim());
		this.bid = Double.parseDouble(fld[ptr++].trim());
		this.ask = Double.parseDouble(fld[ptr++].trim());
		this.volume = Integer.parseInt(fld[ptr++].trim());
		this.iv = Double.parseDouble(fld[ptr++].trim());
		this.delta = Double.parseDouble(fld[ptr++].trim());
		this.gamma = Double.parseDouble(fld[ptr++].trim());
		this.oi = Double.parseDouble(fld[ptr++].trim());
		this.dataType = putcalltype;
	}

	/**
	 *
	 * @param currentPrice
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public double getCallPrice(double currentPrice, String date, double ivnew) throws ParseException {

		double price = 0.0;
		try {
			final Calendar c = Calendar.getInstance();
			c.setTime(OptionsProcessor.sdf.parse(date));
			final double years = OptionsProcessor.getDeltaYears(c, this.expiry);

			double ivcall = this.iv;
			if (ivnew > 0.0) {
				ivcall = ivnew;
			}

			price = OptionsProcessor.getCallPrice(currentPrice, this.strike, this.rate, years, ivcall);

		} catch (final Exception e) {
			price = -1.0;
		}
		return price;
	}

	/**
	 *
	 * @param currentPrice
	 * @param date
	 * @param ivnew
	 * @return
	 * @throws ParseException
	 */
	public DataItem getPutPrice(double currentPrice, String date, double ivnew) {

		double price = 0.0;
		DataItem retDi = null;

		try {

			final Calendar c = Calendar.getInstance();
			c.setTime(OptionsProcessor.sdf.parse(date));
			final double years = OptionsProcessor.getDeltaYears(c, this.expiry);

			double ivput = this.iv;
			if (ivnew > 0.0) {
				ivput = ivnew;
			}

			retDi = new DataItem(this.dataType, currentPrice, this.strike, this.expiry, this.rate, ivput, c);

			//price = OptionsProcessor.getPutPrice(currentPrice, this.strike, this.rate, years, ivput);

		} catch (final Exception e) {
			price = -1.0;
		}
		return retDi;
	}

	@Override
	public String toString() {

		String ret = "";
		if (this.dataType == ACALL) {
			ret = "CALL ->" + NL;
		} else if (this.dataType == APUT) {
			ret = "PUT ->" + NL;
		} else {
			ret = "Unknown ->" + NL;
		}

		double days = 365.0 * this.yrs;

		ret += String.format("\tExpiry : %s%n", Utils.sdf2.format(this.expiry.getTime()));
		ret += String.format("\tiv     : %9.4f%n", this.iv);
		ret += String.format("\tdelta  : %9.4f%n", this.delta);
		ret += String.format("\tgamma  : %9.4f%n", this.gamma);
		ret += String.format("\ttheta  : %9.4f%n", this.theta);
		ret += String.format("\trho    : %9.4f%n", this.rho);
		ret += String.format("\tvega   : %9.4f%n", this.vega);
		
		ret += String.format("%n\tPrice of Underlying : %9.4f%n", this.priceOfUnderlying);
		ret += String.format("\tYears to Expiry     : %9.2f (%d days)%n", this.yrs, (int) days);
		ret += String.format("\tSell Date           : %s%n", Utils.sdf2.format(this.sellDate.getTime()));
		ret += String.format("\tPrice               : %9.2f%n", this.price);

//		ret += String.format("%n\tid     : %s%n", this.id);
//		ret += String.format("\tlast   : %.2f%n", this.last);
//		ret += String.format("\tnet    : %.2f%n", this.net);
//		ret += String.format("\tbid    : %.2f%n", this.bid);
//		ret += String.format("\task    : %.2f%n", this.ask);
//		ret += String.format("\tvol    : %d%n", this.volume);

		return ret;
	}
}
