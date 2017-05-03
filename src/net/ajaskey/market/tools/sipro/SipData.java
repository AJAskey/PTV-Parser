
package net.ajaskey.market.tools.sipro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.tools.optuma.OptumaCommon;

/**
 * This class...
 *
 * @author aja <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class SipData {

	public static List<DataSet>	sales						= new ArrayList<>();
	public static List<DataSet>	grossIncome			= new ArrayList<>();
	public static List<DataSet>	unusualIncome		= new ArrayList<>();
	public static List<DataSet>	income					= new ArrayList<>();
	public static List<DataSet>	cash						= new ArrayList<>();
	public static List<DataSet>	inventory				= new ArrayList<>();
	public static List<DataSet>	goodwill				= new ArrayList<>();
	public static List<DataSet>	assets					= new ArrayList<>();
	public static List<DataSet>	liabilities			= new ArrayList<>();
	public static List<DataSet>	cashfromops			= new ArrayList<>();
	public static List<DataSet>	shares					= new ArrayList<>();
	public static List<DataSet>	dividends				= new ArrayList<>();
	public static List<DataSet>	divDollar				= new ArrayList<>();
	public static List<DataSet>	bookvalue				= new ArrayList<>();
	public static List<DataSet>	cashfromfin			= new ArrayList<>();
	public static List<DataSet>	equity					= new ArrayList<>();
	public static List<DataSet>	tax							= new ArrayList<>();
	public static List<DataSet>	interest				= new ArrayList<>();
	public static List<DataSet>	accRx						= new ArrayList<>();
	public static List<DataSet>	accPay					= new ArrayList<>();
	public static List<DataSet>	capExpend				= new ArrayList<>();
	public static List<DataSet>	ebit						= new ArrayList<>();
	public static List<DataSet>	prices					= new ArrayList<>();
	public static List<DataSet>	cashfrominvest	= new ArrayList<>();
	public static List<DataSet>	ltdebt					= new ArrayList<>();

	//private static SimpleDateFormat	sdf				= new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sdfOptuma = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		SipData.read("data/SP500-SIP.csv", "SPX");
		//SipData.read("data/NDX-SIP.csv", "NDX");

	}

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void read(String filename, String src) throws FileNotFoundException, IOException {

		int knt = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			String line = "";

			//line = br.readLine(); // read header

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					final String fld[] = line.split(",");

					knt++;
					System.out.println(knt + " : " + fld[0]);

					final DataSet sale = new DataSet("sales", fld[0], fld, 0);
					sales.add(sale);
					//System.out.println(sale);

					final DataSet gi = new DataSet("grossIncome", fld[0], fld, 8);
					//System.out.println(gi);
					grossIncome.add(gi);

					final DataSet ui = new DataSet("unusualIncome", fld[0], fld, 16);
					//System.out.println(ui);
					unusualIncome.add(ui);

					final DataSet inc = new DataSet("income", fld[0], fld, 24);
					//System.out.println(inc);
					income.add(inc);

					final DataSet dollar = new DataSet("cash", fld[0], fld, 32);
					//System.out.println(dollar);
					cash.add(dollar);

					final DataSet inv = new DataSet("inventory", fld[0], fld, 40);
					//System.out.println(inv);
					inventory.add(inv);

					final DataSet gwill = new DataSet("goodwill", fld[0], fld, 48);
					//System.out.println(gwill);
					goodwill.add(gwill);

					final DataSet asset = new DataSet("assets", fld[0], fld, 56);
					//System.out.println(asset);
					assets.add(asset);

					final DataSet liab = new DataSet("liabilities", fld[0], fld, 64);
					//System.out.println(liab);
					liabilities.add(liab);

					final DataSet cfops = new DataSet("cfops", fld[0], fld, 72);
					//System.out.println(cfops);
					cashfromops.add(cfops);

					final DataSet share = new DataSet("shares", fld[0], fld, 80);
					//System.out.println(share);
					shares.add(share);

					final DataSet div = new DataSet("dividends", fld[0], fld, 88);
					//System.out.println(div);
					dividends.add(div);

					final DataSet bv = new DataSet("bookvalue", fld[0], fld, 96);
					//System.out.println(bv);
					bookvalue.add(bv);

					final DataSet cashfin = new DataSet("cashfromfin", fld[0], fld, 104);
					//System.out.println(cashfin);
					cashfromfin.add(cashfin);

					final DataSet eq = new DataSet("equity", fld[0], fld, 112);
					//System.out.println(eq);
					equity.add(eq);

					final DataSet tx = new DataSet("taxes", fld[0], fld, 120);
					//System.out.println(tx);
					tax.add(tx);

					final DataSet intr = new DataSet("interest", fld[0], fld, 128);
					//System.out.println(intr);
					interest.add(intr);

					final DataSet apay = new DataSet("accPay", fld[0], fld, 136);
					//System.out.println(apay);
					accPay.add(apay);
					
					final DataSet arx = new DataSet("accRx", fld[0], fld, 144);
					//System.out.println(arx);
					accRx.add(arx);

					final DataSet capE = new DataSet("CapEx", fld[0], fld, 152);
					//System.out.println(capE);
					capExpend.add(capE);

					final DataSet eb = new DataSet("ebit", fld[0], fld, 160);
					//System.out.println(eb);
					ebit.add(eb);

					final DataSet pr = new DataSet("price", fld[0], fld, 168);
					//System.out.println(pr);
					prices.add(pr);

					final DataSet cashinv = new DataSet("cashfrominvest", fld[0], fld, 176);
					//System.out.println(cashinv);
					cashfrominvest.add(cashinv);

					final DataSet ltd = new DataSet("longtermdevt", fld[0], fld, 184);
					//System.out.println(ltd);
					ltdebt.add(ltd);

				}
			}
		}
		final DataSet totSales = DataSet.sum(sales);

		final DataSet totGI = DataSet.sum(grossIncome);
		//System.out.println("GI : \n" + totGI);

		final DataSet totUI = DataSet.sum(unusualIncome);
		//System.out.println("UI : \n" + totUI);

		final DataSet net = DataSet.sub(totGI, totUI);
		//System.out.println("Net : \n" + net);

		final DataSet totInc = DataSet.sum(income);
		//System.out.println("Income : \n" + totInc);

		final DataSet totCash = DataSet.sum(cash);
		//System.out.println("Cash : \n" + totCash);

		final DataSet totInventory = DataSet.sum(inventory);
		//System.out.println("Inventory : \n" + totInventory);

		final DataSet totGoodwill = DataSet.sum(goodwill);
		//System.out.println("Goodwill : \n" + totGoodwill);

		final DataSet totAssets = DataSet.sum(assets);
		//System.out.println("Assets : \n" + totAssets);

		final DataSet totAssGW = DataSet.sub(totAssets, totGoodwill);
		//System.out.println("Assets : \n" + totAssets);

		final DataSet totLiab = DataSet.sum(liabilities);
		//System.out.println("Liabilities : \n" + totLiab);

		final DataSet totcfops = DataSet.sum(cashfromops);
		//System.out.println("Cash from OPS : \n" + totcfops);

		final DataSet totcffin = DataSet.sum(cashfromfin);
		//System.out.println("Cash from Financing : \n" + totcffin);

		final DataSet totcfinv = DataSet.sum(cashfrominvest);
		//System.out.println("Cash from Investing : \n" + totcfinv);

		final DataSet totDebt = DataSet.sum(ltdebt);
		//System.out.println("LT Debt : \n" + totDebt);

		final DataSet totShares = DataSet.sum(shares);
		//System.out.println("Shares : \n" + totShares);

		for (int i = 0; i < dividends.size(); i++) {
			DataSet ds = DataSet.mult(dividends.get(i), shares.get(i));
			divDollar.add(ds);
		}
		final DataSet totDiv = DataSet.sum(divDollar);
		//System.out.println("Dividends : \n" + totDiv);

		final DataSet totBv = DataSet.sum(bookvalue);
		//System.out.println("Book Value : \n" + totBv);
		DataSet bvDollar = DataSet.mult(totBv, totShares);
		DataSet bvMod = DataSet.sub(bvDollar, totGoodwill);
		DataSet bvScaler = new DataSet(1.0 / 100.0);
		DataSet bvScaled = DataSet.mult(bvMod, bvScaler);

		final DataSet totEq = DataSet.sum(equity);
		//System.out.println("Equity : \n" + totEq);

		final DataSet totTax = DataSet.sum(tax);
		//System.out.println("Taxes : \n" + totTax);

		final DataSet totInt = DataSet.sum(interest);
		//System.out.println("Interest : \n" + totInt);

		final DataSet totAR = DataSet.sum(accRx);
		//System.out.println("Accounts Receivable : \n" + totAR);

		final DataSet totAP = DataSet.sum(accPay);
		//System.out.println("Accounts Payable : \n" + totAP);

		final DataSet totCE = DataSet.sum(capExpend);
		//System.out.println("Cap Expend : \n" + totCE);

		final DataSet totEbit = DataSet.sum(ebit);
		//System.out.println("EBIT : \n" + totEbit);

		double cpyKnt = 1.0 / (double) knt;
		final DataSet totPrice = DataSet.sum(prices);
		DataSet companies = new DataSet(cpyKnt);
		DataSet totAvgPr = DataSet.mult(totPrice, companies);

		//System.out.println("Price : \n" + totPrice);

		if (src.equalsIgnoreCase("SPX")) {
			SipData.writeData(totSales, "SPX Sales");
			SipData.writeData(totGI, "SPX Gross Income");
			SipData.writeData(net, "SPX GrossIncome Minus Unusual Income");
			SipData.writeData(totInc, "SPX Income for EPS");
			SipData.writeData(totCash, "SPX Cash");
			SipData.writeData(totInventory, "SPX Inventory");
			SipData.writeData(totGoodwill, "SPX Goodwill");
			SipData.writeData(totAssets, "SPX Assets");
			SipData.writeData(totAssGW, "SPX Assets Minus Goodwill");
			SipData.writeData(totLiab, "SPX Liabilities");
			SipData.writeData(totcfops, "SPX Cash From Operations");
			SipData.writeData(totcffin, "SPX Cash From Financing");
			SipData.writeData(totcfinv, "SPX Cash From Investing");
			SipData.writeData(totDebt, "SPX Long Term Debt");
			SipData.writeData(totShares, "SPX Shares");
			SipData.writeData(totDiv, "SPX Dividends");
			SipData.writeData(bvScaled, "SPX Book Value");
			SipData.writeData(totEq, "SPX Common Equity");
			SipData.writeData(totTax, "SPX Income Tax Paid");
			SipData.writeData(totInt, "SPX Interest Paid");
			SipData.writeData(totAR, "SPX Accounts Receivable");
			SipData.writeData(totAP, "SPX Accounts Payable");
			SipData.writeData(totCE, "SPX Capital Expenditures");
			SipData.writeData(totEbit, "SPX EBIT");
			SipData.writeData(totAvgPr, "SPX Price");
		} else {
			SipData.writeData(totSales, "NDX Sales");
			SipData.writeData(totGI, "NDX Gross Income");
			SipData.writeData(net, "NDX GrossIncome Minus Unusual Income");
			SipData.writeData(totInc, "NDX Income for EPS");
			SipData.writeData(totCash, "NDX Cash");
			SipData.writeData(totInventory, "NDX Inventory");
			SipData.writeData(totGoodwill, "NDX Goodwill");
			SipData.writeData(totAssets, "NDX Assets");
			SipData.writeData(totAssGW, "NDX Assets Minus Goodwill");
			SipData.writeData(totLiab, "NDX Liabilities");
			SipData.writeData(totcfops, "NDX Cash From Operations");
			SipData.writeData(totShares, "NDX Shares");
		}
	}

	private static void write(PrintWriter pw, DateSet.Quarter q, double val) {

		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q1.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q2.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q3.getTime()), val);
		pw.printf("%s,%.2f%n", sdfOptuma.format(q.q4.getTime()), val);
	}

	private static void writeData(DataSet ds, String fname) {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			final DateSet dates = new DateSet();

			write(pw, dates.y7, ds.y7);
			write(pw, dates.y6, ds.y6);
			write(pw, dates.y5, ds.y5);
			write(pw, dates.y4, ds.y4);
			write(pw, dates.y3, ds.y3);
			write(pw, dates.y2, ds.y2);
			write(pw, dates.y1, ds.y1);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), ds.ttm);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
