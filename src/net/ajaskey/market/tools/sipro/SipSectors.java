
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

	public static List<SipSectorData>	technology			= new ArrayList<>();
	public static List<SipSectorData>	transportation	= new ArrayList<>();
	public static List<SipSectorData>	services				= new ArrayList<>();
	public static List<SipSectorData>	healthcare			= new ArrayList<>();
	public static List<SipSectorData>	cyclical				= new ArrayList<>();
	public static List<SipSectorData>	noncyclical			= new ArrayList<>();
	public static List<SipSectorData>	financial				= new ArrayList<>();
	public static List<SipSectorData>	utilities				= new ArrayList<>();
	public static List<SipSectorData>	basicMaterials	= new ArrayList<>();
	public static List<SipSectorData>	energy					= new ArrayList<>();
	public static List<SipSectorData>	capitalGoods		= new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException, IOException {

		final String dataFile = "SP500-SECTORS.TXT";

		technology = SipSectors.readBigFile(dataFile, SipSectorData.technologyStr);
		transportation = SipSectors.readBigFile(dataFile, SipSectorData.transportationStr);
		services = SipSectors.readBigFile(dataFile, SipSectorData.servicesStr);
		basicMaterials = SipSectors.readBigFile(dataFile, SipSectorData.basicMaterialsStr);
		capitalGoods = SipSectors.readBigFile(dataFile, SipSectorData.capitalGoodsStr);
		cyclical = SipSectors.readBigFile(dataFile, SipSectorData.consumerCyclicalStr);
		noncyclical = SipSectors.readBigFile(dataFile, SipSectorData.consumerNonCyclicalStr);
		financial = SipSectors.readBigFile(dataFile, SipSectorData.financialStr);
		utilities = SipSectors.readBigFile(dataFile, SipSectorData.utilitiesStr);
		energy = SipSectors.readBigFile(dataFile, SipSectorData.energyStr);
		healthcare = SipSectors.readBigFile(dataFile, SipSectorData.healthcareStr);

		//System.out.println(healthcare);
		//System.out.println(healthcare.size());
		SipSectors.write(SipSectorData.technologyStr, technology);
		SipSectors.write(SipSectorData.transportationStr, transportation);
		SipSectors.write(SipSectorData.servicesStr, services);
		SipSectors.write(SipSectorData.basicMaterialsStr, basicMaterials);
		SipSectors.write(SipSectorData.capitalGoodsStr, capitalGoods);
		SipSectors.write(SipSectorData.consumerCyclicalStr, cyclical);
		SipSectors.write(SipSectorData.consumerNonCyclicalStr, noncyclical);
		SipSectors.write(SipSectorData.financialStr, financial);
		SipSectors.write(SipSectorData.utilitiesStr, utilities);
		SipSectors.write(SipSectorData.energyStr, energy);
		SipSectors.write(SipSectorData.healthcareStr, healthcare);

		System.out.println("Done.");

	}

	/**
	 * net.ajaskey.market.tools.sipro.readBigFile
	 *
	 * @param sector
	 *
	 * @param string
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static List<SipSectorData> readBigFile(String fname, String sector)
	    throws FileNotFoundException, IOException {

		final SipCommon sc = new SipCommon("\t", 14, 3);

		final List<SipSectorData> dsRet = new ArrayList<>();
		final List<String> sectorStr = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(new File("data/" + fname)))) {
			String line = "";

			//line = br.readLine(); // read header

			while (line != null) {
				line = br.readLine();
				if ((line != null) && (line.length() > 0)) {

					if (line.contains(sector)) {
						sectorStr.add(line);

						final SipSectorData ssd = new SipSectorData();

						sc.reset();

						ssd.shares = sc.getData("shares", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION);
						ssd.sales = sc.getData("sales", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION);
						ssd.income = sc.getData("income", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION);
						ssd.cashOps = sc.getData("cashOps", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION);
						ssd.ltDebt = sc.getData("ltDebt", line, DataSet3.dMode.SEQUENTIAL, SipCommon.MILLION);
						dsRet.add(ssd);
						//System.out.println(ssd);
					}
				}
			}
		}
		return dsRet;
	}

	/**
	 * net.ajaskey.market.tools.sipro.setOutfilename
	 *
	 * @param sector
	 * @return
	 */
	private static String setOutfilename(DataSet3 ds) {

		/*
		public static final String	basicMaterialsStr			= "01  - Basic Materials";
		public static final String	capitalGoodsStr				= "02  - Capital Goods";
		public static final String	consumerCyclicalStr		= "04  - Consumer Cyclical";
		public static final String	consumerNonCyclicalStr	= "05  - Consumer Non-Cyclical";
		public static final String	energyStr						= "06  - Energy";
		public static final String	financialStr					= "07  - Financial";
		public static final String	healthcareStr					= "08  - Health Care";
		public static final String	servicesStr						= "09  - Services";
		public static final String	technologyStr					= "10  - Technology";
		public static final String	transportationStr			= "11  - Transportation";
		public static final String	utilitiesStr					= "12  - Utilities";
		*/
		String retStr = "";
		if (ds.sector.equalsIgnoreCase(SipSectorData.basicMaterialsStr)) {
			retStr = "BasicMaterials";
		} else if (ds.sector.equalsIgnoreCase(SipSectorData.capitalGoodsStr)) {
			retStr = "CapitalGoods";
		} else if (ds.sector.equalsIgnoreCase(SipSectorData.consumerCyclicalStr)) {
			retStr = "ConsumerCyclical";
		} else if (ds.sector.equalsIgnoreCase(SipSectorData.consumerNonCyclicalStr)) {
			retStr = "ConsumerNonCyclical";
		} else if (ds.sector.equalsIgnoreCase(SipSectorData.energyStr)) {
			retStr = "Energy";
		} else if (ds.sector.equalsIgnoreCase(SipSectorData.financialStr)) {
			retStr = "Financials";
		} else if (ds.sector.equalsIgnoreCase(SipSectorData.healthcareStr)) {
			retStr = "Healthcare";
		} else if (ds.sector.equalsIgnoreCase(SipSectorData.servicesStr)) {
			retStr = "Services";
		} else if (ds.sector.equalsIgnoreCase(SipSectorData.technologyStr)) {
			retStr = "Technology";
		} else if (ds.sector.equalsIgnoreCase(SipSectorData.transportationStr)) {
			retStr = "Transportation";
		} else if (ds.sector.equalsIgnoreCase(SipSectorData.utilitiesStr)) {
			retStr = "Utilities";
		}
		return "SIP_SP500_" + retStr + "-" + ds.name;
	}

	/**
	 * net.ajaskey.market.tools.sipro.write
	 *
	 * @param technologystr
	 * @param technology2
	 * @throws FileNotFoundException
	 */
	private static void write(String technologystr, List<SipSectorData> sector) throws FileNotFoundException {

		final List<DataSet3> shares = new ArrayList<>();
		final List<DataSet3> sales = new ArrayList<>();
		final List<DataSet3> income = new ArrayList<>();
		final List<DataSet3> cashOps = new ArrayList<>();
		final List<DataSet3> ltDebt = new ArrayList<>();

		for (final SipSectorData ssd : sector) {
			shares.add(ssd.shares);
			sales.add(ssd.sales);
			income.add(ssd.income);
			cashOps.add(ssd.cashOps);
			ltDebt.add(ssd.ltDebt);
		}

		final DataSet3 totShares = DataSet3.sum(shares);
		final DataSet3 totSales = DataSet3.sum(sales);
		final DataSet3 totIncome = DataSet3.sum(income);
		final DataSet3 totCashOps = DataSet3.sum(cashOps);
		final DataSet3 totLtDebt = DataSet3.sum(ltDebt);

		SipData3.write(totShares, SipSectors.setOutfilename(totShares));
		SipData3.write(totSales, SipSectors.setOutfilename(totSales));
		SipData3.write(totIncome, SipSectors.setOutfilename(totIncome));
		SipData3.write(totCashOps, SipSectors.setOutfilename(totCashOps));
		SipData3.write(totLtDebt, SipSectors.setOutfilename(totLtDebt));

	}

}
