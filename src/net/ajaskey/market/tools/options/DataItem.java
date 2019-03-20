package net.ajaskey.market.tools.options;

import java.text.ParseException;
import java.util.Calendar;

public class DataItem {

	// Expiration Date Calls Last Sale Net Bid Ask Vol IV Delta Gamma Open Int
	// Strike Puts Last Sale Net Bid Ask Vol IV Delta Gamma Open Int

	final static int APUT = 1;
	final static int ACALL = 2;

	final static String NL = "\n";

	String id;
	double last;
	double net;
	double bid;
	double ask;
	double volume;
	double iv;
	double oi;

	double delta;
	double gamma;
	double theta;
	double rho;

	double strike;
	double priceOfUnderlying;

	double rate;
	double yrs;

	int dataType;
	Calendar expiry;

	double price;

	public DataItem klone(DataItem di) {
		DataItem diret = null;
		try {
			diret = (DataItem) di.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		return diret;
	}

	/**
	 * 
	 * @param pctype
	 * @param currentPrice
	 * @param strike
	 * @param expiration
	 * @param rate
	 * @param iv
	 */
	public DataItem(int pctype, double currentPrice, double strike, Calendar expiration, double rate, double iv) {

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
		this.volume = 0.0;
		this.oi = 0.0;
		this.yrs = 0.0;

		this.delta = 0.0;
		this.gamma = 0.0;
		this.theta = 0.0;
		this.rho = 0.0;

		this.yrs = OptionsProcessor.getDeltaYears(expiration);

		if (pctype == ACALL) {
			this.price = OptionsProcessor.getCallPrice(this.priceOfUnderlying, this.strike, this.rate, yrs, this.iv);
		} else if (pctype == APUT) {
			this.price = OptionsProcessor.getPutPrice(this.priceOfUnderlying, this.strike, this.rate, yrs, this.iv);
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
		this.volume = Double.parseDouble(fld[ptr++].trim());
		this.iv = Double.parseDouble(fld[ptr++].trim());
		this.delta = Double.parseDouble(fld[ptr++].trim());
		this.gamma = Double.parseDouble(fld[ptr++].trim());
		this.oi = Double.parseDouble(fld[ptr++].trim());
		this.dataType = putcalltype;
	}

	/**
	 * 
	 * @param fld
	 * @return
	 */
	public static DataItem setCall(String fld[]) {
		DataItem di = new DataItem(fld, ACALL);
		return di;
	}

	/**
	 * 
	 * @param fld
	 * @return
	 */
	public static DataItem setPut(String fld[]) {
		DataItem di = new DataItem(fld, APUT);
		return di;
	}

	/**
	 * 
	 * @param currentPrice
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public double getCallPrice(double currentPrice, String date) throws ParseException {
		double price = 0.0;
		Calendar c = Calendar.getInstance();
		c.setTime(OptionsProcessor.sdf.parse(date));
		double years = OptionsProcessor.getDeltaYears(c, this.expiry);

		price = OptionsProcessor.getCallPrice(currentPrice, this.strike, this.rate, years, this.iv);
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
	public double getPutPrice(double currentPrice, String date, double ivnew) throws ParseException {
		double price = 0.0;
		Calendar c = Calendar.getInstance();
		c.setTime(OptionsProcessor.sdf.parse(date));
		double years = OptionsProcessor.getDeltaYears(c, this.expiry);

		double ivput = this.iv;
		if (ivnew > 0.0) {
			ivput = ivnew;
		}

		price = OptionsProcessor.getPutPrice(currentPrice, this.strike, this.rate, years, ivput);
		return price;
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

		ret += String.format("\tPrice : %s%n", this.price);
		ret += String.format("\tYears : %s%n", this.yrs);

		ret += String.format("%n\tid    : %s%n", this.id);
		ret += String.format("\tlast  : %.2f%n", this.last);
		ret += String.format("\tnet   : %.2f%n", this.net);
		ret += String.format("\tbid   : %.2f%n", this.bid);
		ret += String.format("\task   : %.2f%n", this.ask);
		ret += String.format("\tvol   : %d%n", (int) this.volume);
		ret += String.format("\tiv    : %7.4f%n", this.iv);
		ret += String.format("\tdelta : %7.4f%n", this.delta);
		ret += String.format("\tgamma : %7.4f%n", this.gamma);

		return ret;
	}
}
