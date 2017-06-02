
package net.ajaskey.market.tools.sipro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class...
 *
 * @author ajask_000 <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class SipSectors {

	public static List<DataSet3>	shares	= new ArrayList<>();
	public static List<DataSet3>	sales		= new ArrayList<>();
	public static List<DataSet3>	income	= new ArrayList<>();
	public static List<DataSet3>	cashOps	= new ArrayList<>();
	public static List<DataSet3>	ltDebt	= new ArrayList<>();

	public static List<DataSet3> basicMaterials = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException, IOException {

		SipSectors.readBigFile("SIP-SECTORS.TXT");

		//		processGroup("BasicMaterials");
		//		processGroup("CapitalGoods");
		//		processGroup("ConsumerCyclical");
		//		processGroup("ConsumerNonCyclical");
		//		processGroup("Energy");
		//		processGroup("Financial");
		//		processGroup("Healthcare");
		//		processGroup("Service");
		//		processGroup("Technology");
		//		processGroup("Transportation");

		System.out.println("Done.");

	}

	/**
	 * net.ajaskey.market.tools.sipro.processGroup
	 *
	 * @param string
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void processGroup(String sector) throws FileNotFoundException, IOException {

		System.out.println("Processing " + sector);
		SipSectors.readDataFile(sector);

	}

	/**
	 * net.ajaskey.market.tools.sipro.readBigFile
	 *
	 * @param string
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void readBigFile(String fname) throws FileNotFoundException, IOException {

		final SipCommon sc = new SipCommon("\t", 14);

		try (BufferedReader br = new BufferedReader(new FileReader(new File("data/" + fname)))) {
			String line = "";

			//line = br.readLine(); // read header

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					sc.reset();

					final DataSet3 ds = sc.getData("shares", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION);
					if (ds.sector.equalsIgnoreCase("01  - Basic Materials")) {
						basicMaterials.add(ds);
					}
				}
			}
		}

	}

	/**
	 * net.ajaskey.market.tools.sipro.readDataFile
	 *
	 * @param string
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void readDataFile(String sector) throws FileNotFoundException, IOException {

		final SipCommon sc = new SipCommon("\t", 14);

		try (BufferedReader br = new BufferedReader(new FileReader(new File("data/SIP-" + sector + ".txt")))) {
			String line = "";

			//line = br.readLine(); // read header

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					sc.reset();

					shares.add(sc.getData("shares", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION));
					sales.add(sc.getData("sales", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					income.add(sc.getData("income", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					cashOps.add(sc.getData("cashOps", line, DataSet3.dMode.ACCUMULATION, SipCommon.MILLION));
					ltDebt.add(sc.getData("ltDebt", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION));

				}
			}
		}

		final DataSet3 totShares = DataSet3.sum(shares);
		final DataSet3 totSales = DataSet3.sum(sales);
		final DataSet3 totIncome = DataSet3.sum(income);
		final DataSet3 totCashOps = DataSet3.sum(cashOps);
		final DataSet3 totLtDebt = DataSet3.sum(ltDebt);

		SipData3.write(totShares, sector + " Shares");
		SipData3.write(totSales, sector + " Sales");
		SipData3.write(totIncome, sector + " Income");
		SipData3.write(totCashOps, sector + " CashOps");
		SipData3.write(totLtDebt, sector + " LtDebt");

	}

}
