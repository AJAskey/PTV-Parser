
package net.ajaskey.market.tools.options;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.ajaskey.market.misc.Utils;

/**
 *
 * @author aja
 *
 */
public class OptionsProcessor {

	private static final boolean DEBUG = false;

	private static final double	P		= 0.2316419;
	private static final double	B1	= 0.319381530;
	private static final double	B2	= -0.356563782;
	private static final double	B3	= 1.781477937;
	private static final double	B4	= -1.821255978;
	private static final double	B5	= 1.330274429;

	private final static double p2 = Math.sqrt(2.0 * Math.PI);

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 
	 * net.ajaskey.market.tools.options.CalcTimeSeries
	 *
	 * @param openDi
	 * @param days
	 * @param priceRange
	 * @param ivRange
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public static void CalcTimeSeries(DataItem openDi, int days, double priceRange, double ivRange, String filename)
	    throws FileNotFoundException {

		double chgPerDay = priceRange / (double) days;
		double ivPerDay = ivRange / (double) days;

		Calendar sellit = Calendar.getInstance();
		double iv = openDi.iv;
		double cp = openDi.stockPrice;

		try (PrintWriter pw = new PrintWriter(filename)) {

			for (int i = 0; i < days; i++) {

				sellit.add(Calendar.DATE, 1);

				DataItem di = null;

				if (openDi.dataType == DataItem.ACALL) {

					di = openDi.getCallPrice(cp, OptionsProcessor.sdf.format(sellit.getTime()), iv);
					cp += chgPerDay;

				} else if (openDi.dataType == DataItem.APUT) {

					di = openDi.getPutPrice(cp, OptionsProcessor.sdf.format(sellit.getTime()), iv);
					cp -= chgPerDay;
				}
				iv += ivPerDay;

				if (di != null) pw.println(di);

			}
		}

	}

	/**
	 *
	 * @param num
	 * @return
	 */
	private static double cumulativeDistribution(double num) {

		final double t = 1.0 / (1.0 + (P * Math.abs(num)));
		final double t1 = B1 * Math.pow(t, 1.0);
		final double t2 = B2 * Math.pow(t, 2.0);
		final double t3 = B3 * Math.pow(t, 3.0);
		final double t4 = B4 * Math.pow(t, 4.0);
		final double t5 = B5 * Math.pow(t, 5.0);
		final double b = t1 + t2 + t3 + t4 + t5;

		final double stdNormDist = OptionsProcessor.standardNormalDistribution(num);
		final double dist = 1.0 - (stdNormDist * b);

		double ret = dist;
		if (num < 0) {
			ret = 1.0 - dist;
		}

		return ret;
	}

	/**
	 *
	 * @param cprice
	 *          Current Price
	 * @param sprice
	 *          Strike Price
	 * @param rate
	 *          Low Risk Interest Rate
	 * @param years
	 *          Years until expiration
	 * @param iv
	 *          Implied Volitility
	 * @return d1 from Black-Scholes equation
	 */
	private static double d1(double cprice, double sprice, double rate, double years, double iv) {

		final double p1 = Math.log(cprice / sprice) + ((rate + (Math.pow(iv, 2) / 2)) * years);
		final double p2 = iv * Math.sqrt(years);

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
	 *          Current Price
	 * @param sprice
	 *          Strike Price
	 * @param rate
	 *          Low Risk Interest Rate
	 * @param years
	 *          Years until expiration
	 * @param iv
	 *          Implied Volitility
	 * @return d2 from Black-Scholes equation
	 */
	private static double d2(double cprice, double sprice, double rate, double years, double iv) {

		return OptionsProcessor.d1(cprice, sprice, rate, years, iv) - (iv * Math.sqrt(years));
	}

	/**
	 *
	 * @param cprice
	 *          Current Price
	 * @param sprice
	 *          Strike Price
	 * @param rate
	 *          Low Risk Interest Rate
	 * @param years
	 *          Years until expiration
	 * @param iv
	 *          Implied Volatility
	 * @return Calculated Call Price
	 */
	public static double getCallPrice(double cprice, double sprice, double rate, double years, double iv) {

		double price = 0.0;

		try {
			if (DEBUG) {

				System.out.println("\nGetCallPrice ");
				System.out.println("\tcprice = " + cprice);
				System.out.println("\tsprice = " + sprice);
				System.out.println("\trate   = " + rate);
				System.out.println("\tyears  = " + years);
				System.out.println("\tiv     = " + iv);
			}

			final double cd1 = OptionsProcessor.cumulativeDistribution(OptionsProcessor.d1(cprice, sprice, rate, years, iv));
			final double cd2 = OptionsProcessor.cumulativeDistribution(OptionsProcessor.d2(cprice, sprice, rate, years, iv));
			price = (cprice * cd1) - (sprice * Math.exp(-rate * years) * cd2);

			if (DEBUG) {
				System.out.println("\tcd1   = " + cd1);
				System.out.println("\tcd2   = " + cd2);
				System.out.println("\tprice = " + price);
			}
		} catch (final Exception e) {
			price = -1.0;
			e.printStackTrace();
		}

		return price;
	}

	public static long getDeltaDays(Calendar c2) {

		final Calendar c1 = Calendar.getInstance();
		return (c2.getTime().getTime() - c1.getTime().getTime()) / 86400000;
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

	public static double getDeltaYears(Calendar c2) {

		final Calendar c1 = Calendar.getInstance();
		return OptionsProcessor.getDeltaDays(c1, c2) / 365.0;
	}

	/**
	 *
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static double getDeltaYears(Calendar c1, Calendar c2) {

		return OptionsProcessor.getDeltaDays(c1, c2) / 365.0;
	}

	/**
	 *
	 * @param cprice
	 *          Current Price
	 * @param sprice
	 *          Strike Price
	 * @param rate
	 *          Low Risk Interest Rate
	 * @param years
	 *          Years until expiration
	 * @param iv
	 *          Implied Volatility
	 * @return Calculated Put Price
	 */
	public static double getPutPrice(double cprice, double sprice, double rate, double years, double iv) {

		double price = 0.0;

		try {
			if (DEBUG) {

				System.out.println("\nGetCallPrice ");
				System.out.println("\tcprice = " + cprice);
				System.out.println("\tsprice = " + sprice);
				System.out.println("\trate   = " + rate);
				System.out.println("\tyears  = " + years);
				System.out.println("\tiv     = " + iv);
			}

			final double cd1 = OptionsProcessor.cumulativeDistribution(-OptionsProcessor.d1(cprice, sprice, rate, years, iv));
			final double cd2 = OptionsProcessor.cumulativeDistribution(-OptionsProcessor.d2(cprice, sprice, rate, years, iv));

			price = (sprice * Math.exp(-rate * years) * cd2) - (cprice * cd1);

			if (DEBUG) {

				System.out.println("\tcd1   = " + cd1);
				System.out.println("\tcd2   = " + cd2);
				System.out.println("\tprice = " + price);
			}
		} catch (final Exception e) {
			price = -1.0;
			e.printStackTrace();
		}

		return price;
	}

	/**
	 *
	 * net.ajaskey.market.tools.options.main
	 *
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		final Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse("20191231"));

		final DataItem di = new DataItem(DataItem.ACALL, 2850.0, 2475.0, c, 0.01, 0.19, Calendar.getInstance());
		System.out.println(di);

		//final double p = di.getPutPrice(1700.0, "20190621", .35);
		//System.out.println(p);

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
	 * net.ajaskey.market.tools.options.greeks
	 *
	 * @param di
	 */
	public static void setGreeks(DataItem di) {

		try {
			final double d1 = OptionsProcessor.d1(di.stockPrice, di.strike, di.rate, di.yrs, di.iv);
			final double d2 = OptionsProcessor.d2(di.stockPrice, di.strike, di.rate, di.yrs, di.iv);

			final double sd1 = OptionsProcessor.standardNormalDistribution(d1);
			final double cd1 = OptionsProcessor.cumulativeDistribution(d1);

			final double thetaLeft = -(di.strike * sd1 * di.iv) / (2.0 * Math.sqrt(di.yrs));

			if (di.dataType == DataItem.ACALL) {

				final double cd2 = OptionsProcessor.cumulativeDistribution(d2);

				di.delta = cd1;

				final double thetaRight = di.rate * di.strike * Math.exp(-di.rate * di.yrs) * cd2;
				di.theta = (thetaLeft - thetaRight) / 100.0;

				di.rho = di.strike * di.yrs * Math.exp(-di.rate * di.yrs) * cd2;

			} else if (di.dataType == DataItem.APUT) {

				final double pcd2 = OptionsProcessor.cumulativeDistribution(-d2);

				di.delta = cd1 - 1.0;

				final double thetaRight = di.rate * di.strike * Math.exp(-di.rate * di.yrs) * pcd2;
				di.theta = (thetaLeft + thetaRight) / 100.0;

				di.rho = -di.strike * di.yrs * Math.exp(-di.rate * di.yrs) * pcd2;

			}

			di.gamma = sd1 / (di.strike * di.iv * Math.sqrt(di.yrs));

			di.vega = di.strike * sd1 * Math.sqrt(di.yrs) / 100.0;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @param num
	 * @return
	 */
	private static double standardNormalDistribution(double num) {

		final double p1 = Math.exp(-0.5 * Math.pow(num, 2.0));
		return p1 / p2;
	}
}
