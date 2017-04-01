
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

	public static List<DataSet>	sales					= new ArrayList<>();
	public static List<DataSet>	grossIncome		= new ArrayList<>();
	public static List<DataSet>	unusualIncome	= new ArrayList<>();
	public static List<DataSet>	income				= new ArrayList<>();
	public static List<DataSet>	cash					= new ArrayList<>();
	public static List<DataSet>	inventory			= new ArrayList<>();
	public static List<DataSet>	goodwill			= new ArrayList<>();
	public static List<DataSet>	assets				= new ArrayList<>();
	public static List<DataSet>	liabilities		= new ArrayList<>();

	private static SimpleDateFormat	sdf				= new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat	sdfOptuma	= new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws FileNotFoundException, IOException {

		SipData.read("data/SP500-SIP.csv");

	}

	/**
	 * net.ajaskey.market.tools.sipro.main
	 *
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void read(String filename) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			String line = "";

			//line = br.readLine(); // read header

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					final String fld[] = line.split(",");

					final DataSet sale = new DataSet(fld[0], fld, 0);
					sales.add(sale);

					final DataSet gi = new DataSet(fld[0], fld, 8);
					System.out.println(gi);
					grossIncome.add(gi);

					final DataSet ui = new DataSet(fld[0], fld, 16);
					System.out.println(ui);
					unusualIncome.add(ui);

					final DataSet inc = new DataSet(fld[0], fld, 24);
					System.out.println(inc);
					income.add(inc);

					final DataSet dollar = new DataSet(fld[0], fld, 32);
					System.out.println(dollar);
					cash.add(dollar);

					final DataSet inv = new DataSet(fld[0], fld, 40);
					System.out.println(inv);
					inventory.add(inv);

					final DataSet gwill = new DataSet(fld[0], fld, 48);
					System.out.println(gwill);
					goodwill.add(gwill);
					
					final DataSet asset = new DataSet(fld[0], fld, 56);
					System.out.println(asset);
					assets.add(asset);
					
					final DataSet liab = new DataSet(fld[0], fld, 64);
					System.out.println(liab);
					liabilities.add(liab);

				}
			}
		}
		final DataSet totSales = DataSet.sum(sales);

		final DataSet totGI = DataSet.sum(grossIncome);
		System.out.println("GI : \n" + totGI);

		final DataSet totUI = DataSet.sum(unusualIncome);
		System.out.println("UI : \n" + totUI);

		final DataSet net = DataSet.sub(totGI, totUI);
		System.out.println("Net : \n" + net);

		final DataSet totInc = DataSet.sum(income);
		System.out.println("Income : \n" + totInc);

		final DataSet totCash = DataSet.sum(cash);
		System.out.println("Cash : \n" + totCash);

		final DataSet totInventory = DataSet.sum(inventory);
		System.out.println("Inventory : \n" + totInventory);

		final DataSet totGoodwill = DataSet.sum(goodwill);
		System.out.println("Goodwill : \n" + totGoodwill);

		final DataSet totAssets = DataSet.sum(assets);
		System.out.println("Assets : \n" + totAssets);

		final DataSet totAssGW = DataSet.sub(totAssets, totGoodwill);
		System.out.println("Assets : \n" + totAssets);

		final DataSet totLiab = DataSet.sum(liabilities);
		System.out.println("Liabilities : \n" + totLiab);

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

	}

	private static void writeData(DataSet ds, String fname) {

		try (PrintWriter pw = new PrintWriter(OptumaCommon.optumaPath + "\\SIP\\" + fname + ".csv")) {

			final DateSet dates = new DateSet();

			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y7.getTime()), ds.y7);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y6.getTime()), ds.y6);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y5.getTime()), ds.y5);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y4.getTime()), ds.y4);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y3.getTime()), ds.y3);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y2.getTime()), ds.y2);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.y1.getTime()), ds.y1);
			pw.printf("%s,%.2f%n", sdfOptuma.format(dates.ttm.getTime()), ds.ttm);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
