package net.ajaskey.market.tools.options;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author aja
 *
 */
public class OptionsProcessor {

	private static final boolean DEBUG = false;

	private static final double P = 0.2316419;
	private static final double B1 = 0.319381530;
	private static final double B2 = -0.356563782;
	private static final double B3 = 1.781477937;
	private static final double B4 = -1.821255978;
	private static final double B5 = 1.330274429;

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) throws ParseException {

		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse("20191231"));

		DataItem di = new DataItem(DataItem.ACALL, 2850.0, 2475.0, c, 0.01, 0.19);
		System.out.println(di.price);

		double p = di.getPutPrice(1700.0, "20190621", .35);
		System.out.println(p);

		// double y = getDeltaYears(c);
		//
		// double price = getCallPrice(2850.0, 2475.0, 0.01, y, 0.19);
		//
		// System.out.println(y);
		// System.out.println(price);
		//
		// price = getPutPrice(2850.0, 2475.0, 0.01, y, 0.19);
		// System.out.println(price);

	}

	/**
	 * 
	 * @param cprice
	 *            Current Price
	 * @param sprice
	 *            Strike Price
	 * @param rate
	 *            Low Risk Interest Rate
	 * @param years
	 *            Years until expiration
	 * @param iv
	 *            Implied Volitility
	 * @return Calculated Call Price
	 */
	public static double getCallPrice(double cprice, double sprice, double rate, double years, double iv) {

		if (DEBUG) {

			System.out.println("\nGetCallPrice ");
			System.out.println("\tcprice = " + cprice);
			System.out.println("\tsprice = " + sprice);
			System.out.println("\trate   = " + rate);
			System.out.println("\tyears  = " + years);
			System.out.println("\tiv     = " + iv);
		}

		double price = 0.0;
		double cd1 = cumulativeDistribution(d1(cprice, sprice, rate, years, iv));
		double cd2 = cumulativeDistribution(d2(cprice, sprice, rate, years, iv));
		price = cprice * cd1 - sprice * Math.exp(-rate * years) * cd2;

		if (DEBUG) {
			System.out.println("\tcd1   = " + cd1);
			System.out.println("\tcd2   = " + cd2);
			System.out.println("\tprice = " + price);
		}

		return price;
	}

	/**
	 * 
	 * @param cprice
	 *            Current Price
	 * @param sprice
	 *            Strike Price
	 * @param rate
	 *            Low Risk Interest Rate
	 * @param years
	 *            Years until expiration
	 * @param iv
	 *            Implied Volitility
	 * @return Calculated Put Price
	 */
	public static double getPutPrice(double cprice, double sprice, double rate, double years, double iv) {

		if (DEBUG) {

			System.out.println("\nGetCallPrice ");
			System.out.println("\tcprice = " + cprice);
			System.out.println("\tsprice = " + sprice);
			System.out.println("\trate   = " + rate);
			System.out.println("\tyears  = " + years);
			System.out.println("\tiv     = " + iv);
		}

		double price = 0.0;
		double cd1 = cumulativeDistribution(-d1(cprice, sprice, rate, years, iv));
		double cd2 = cumulativeDistribution(-d2(cprice, sprice, rate, years, iv));

		price = sprice * Math.exp(-rate * years) * cd2 - cprice * cd1;

		if (DEBUG) {

			System.out.println("\tcd1   = " + cd1);
			System.out.println("\tcd2   = " + cd2);
			System.out.println("\tprice = " + price);
		}

		return price;
	}

	/**
	 * 
	 * @param cprice
	 *            Current Price
	 * @param sprice
	 *            Strike Price
	 * @param rate
	 *            Low Risk Interest Rate
	 * @param years
	 *            Years until expiration
	 * @param iv
	 *            Implied Volitility
	 * @return d1 from Black-Scholes equation
	 */
	private static double d1(double cprice, double sprice, double rate, double years, double iv) {

		double p1 = Math.log(cprice / sprice) + (rate + Math.pow(iv, 2) / 2) * years;
		double p2 = iv * Math.sqrt(years);

		// if (DEBUG) {
		// //
		// System.out.println(" d1 ");
		// // System.out.println("\tcprice = " + cprice);
		// // System.out.println("\tsprice = " + sprice);
		// // System.out.println("\trate = " + rate);
		// // System.out.println("\tyears = " + years);
		// // System.out.println("\tiv = " + iv);
		// //
		// System.out.println("\tp1 = " + p1);
		// System.out.println("\tp2 = " + p2);
		// }

		return p1 / p2;
	}

	/**
	 * 
	 * @param cprice
	 *            Current Price
	 * @param sprice
	 *            Strike Price
	 * @param rate
	 *            Low Risk Interest Rate
	 * @param years
	 *            Years until expiration
	 * @param iv
	 *            Implied Volitility
	 * @return d2 from Black-Scholes equation
	 */
	private static double d2(double cprice, double sprice, double rate, double years, double iv) {
		return d1(cprice, sprice, rate, years, iv) - iv * Math.sqrt(years);
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	private static double cumulativeDistribution(double num) {

		double t = 1 / (1 + P * Math.abs(num));
		double t1 = B1 * Math.pow(t, 1);
		double t2 = B2 * Math.pow(t, 2);
		double t3 = B3 * Math.pow(t, 3);
		double t4 = B4 * Math.pow(t, 4);
		double t5 = B5 * Math.pow(t, 5);
		double b = t1 + t2 + t3 + t4 + t5;

		double sndist = standardNormalDistribution(num);
		double dist = 1 - (sndist * b);

		double ret = dist;
		if (num < 0) {
			ret = 1.0 - dist;
		}

		return ret;
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	private static double standardNormalDistribution(double num) {

		double p1 = Math.exp(-0.5 * Math.pow(num, 2));
		double p2 = Math.sqrt(2 * Math.PI);
		return p1 / p2;
	}

	/**
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static long getDeltaDays(Calendar c1, Calendar c2) {
		return (c2.getTime().getTime() - c1.getTime().getTime()) / 86400000;
	}

	public static long getDeltaDays(Calendar c2) {
		Calendar c1 = Calendar.getInstance();
		return (c2.getTime().getTime() - c1.getTime().getTime()) / 86400000;
	}

	/**
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static double getDeltaYears(Calendar c1, Calendar c2) {
		return (double) getDeltaDays(c1, c2) / 365.0;
	}

	public static double getDeltaYears(Calendar c2) {
		Calendar c1 = Calendar.getInstance();
		return (double) getDeltaDays(c1, c2) / 365.0;
	}
}
