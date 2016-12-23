
package net.ajaskey.market.tools;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.tools.helpers.WebGet;

public class ProcessIshares {

	/** Home Builders */
	static private String ITB = "https://www.ishares.com/us/products/239512/ishares-us-home-construction-etf/1467271812596.ajax?fileType=csv&fileName=ITB_holdings&dataType=fund";

	/** Semiconductors */
	static private String SOXX = "https://www.ishares.com/us/products/239705/ishares-phlx-semiconductor-etf/1467271812596.ajax?fileType=csv&fileName=SOXX_holdings&dataType=fund";

	/** Consumer Services */
	static private String IYC = "https://www.ishares.com/us/products/239506/ishares-us-consumer-services-etf/1467271812596.ajax?fileType=csv&fileName=IYC_holdings&dataType=fund";

	/** Consumer Goods */
	static private String IYK = "https://www.ishares.com/us/products/239505/ishares-us-consumer-goods-etf/1467271812596.ajax?fileType=csv&fileName=IYK_holdings&dataType=fund";

	/** Financial Services */
	static private String IYG = "https://www.ishares.com/us/products/239509/ishares-us-financial-services-etf/1467271812596.ajax?fileType=csv&fileName=IYG_holdings&dataType=fund";

	/** Regional Banks */
	static private String IAT = "https://www.ishares.com/us/products/239521/ishares-us-regional-banks-etf/1467271812596.ajax?fileType=csv&fileName=IAT_holdings&dataType=fund";

	/** Insurance */
	static private String IAK = "https://www.ishares.com/us/products/239515/ishares-us-insurance-etf/1467271812596.ajax?fileType=csv&fileName=IAK_holdings&dataType=fund";

	/** Brokers Dealers */
	static private String IAI = "https://www.ishares.com/us/products/239504/ishares-us-brokerdealers-etf/1467271812596.ajax?fileType=csv&fileName=IAI_holdings&dataType=fund";

	/** Health Care */
	static private String IYH = "https://www.ishares.com/us/products/239511/ishares-us-healthcare-etf/1467271812596.ajax?fileType=csv&fileName=IYH_holdings&dataType=fund";

	/** Medical Devices */
	static private String IHI = "https://www.ishares.com/us/products/239516/ishares-us-medical-devices-etf/1467271812596.ajax?fileType=csv&fileName=IHI_holdings&dataType=fund";

	/** Health Care Providers */
	static private String IHF = "https://www.ishares.com/us/products/239510/ishares-us-healthcare-providers-etf/1467271812596.ajax?fileType=csv&fileName=IHF_holdings&dataType=fund";

	/** Biotech */
	static private String IBB = "https://www.ishares.com/us/products/239699/ishares-nasdaq-biotechnology-etf/1467271812596.ajax?fileType=csv&fileName=IBB_holdings&dataType=fund";

	/** Pharmaceuticals */
	static private String IHE = "https://www.ishares.com/us/products/239519/ishares-us-pharmaceuticals-etf/1467271812596.ajax?fileType=csv&fileName=IHE_holdings&dataType=fund";

	/** Industrials */
	static private String IYJ = "https://www.ishares.com/us/products/239514/ishares-us-industrials-etf/1467271812596.ajax?fileType=csv&fileName=IYJ_holdings&dataType=fund";

	/** Aerospace Defense */
	static private String ITA = "https://www.ishares.com/us/products/239502/ishares-us-aerospace-defense-etf/1467271812596.ajax?fileType=csv&fileName=ITA_holdings&dataType=fund";

	/** Transportation */
	static private String IYT = "https://www.ishares.com/us/products/239501/ishares-transportation-average-etf/1467271812596.ajax?fileType=csv&fileName=IYT_holdings&dataType=fund";

	/** Oil and Gas Exploration */
	static private String IEO = "https://www.ishares.com/us/products/239517/ishares-us-oil-gas-exploration-production-etf/1467271812596.ajax?fileType=csv&fileName=IEO_holdings&dataType=fund";

	/** Oil Equipment and Services */
	static private String IEZ = "https://www.ishares.com/us/products/239518/ishares-us-oil-equipment-services-etf/1467271812596.ajax?fileType=csv&fileName=IEZ_holdings&dataType=fund";

	/** American Natural Resources */
	static private String IGE = "https://www.ishares.com/us/products/239768/ishares-north-american-natural-resources-etf/1467271812596.ajax?fileType=csv&fileName=IGE_holdings&dataType=fund";

	/** Global Timber and Forestry */
	static private String WOOD = "https://www.ishares.com/us/products/239752/ishares-global-timber-forestry-etf/1467271812596.ajax?fileType=csv&fileName=WOOD_holdings&dataType=fund";

	/** Global Gold Miners */
	static private String RING = "https://www.ishares.com/us/products/239654/ishares-msci-global-gold-miners-etf/1467271812596.ajax?fileType=csv&fileName=RING_holdings&dataType=fund";

	/** Global Metal Miners */
	static private String PICK = "https://www.ishares.com/us/products/239655/ishares-msci-global-metals-mining-producers-etf/1467271812596.ajax?fileType=csv&fileName=PICK_holdings&dataType=fund";

	/** SP500 */
	static private String IVV = "https://www.ishares.com/us/products/239726/ishares-core-sp-500-etf/1467271812596.ajax?fileType=csv&fileName=IVV_holdings&dataType=fund";

	/** SP400 */
	static private String IJH = "https://www.ishares.com/us/products/239763/ishares-core-sp-midcap-etf/1467271812596.ajax?fileType=csv&fileName=IJH_holdings&dataType=fund";

	/** SP600 */
	static private String IJR = "https://www.ishares.com/us/products/239774/ishares-core-sp-smallcap-etf/1467271812596.ajax?fileType=csv&fileName=IJR_holdings&dataType=fund";

	/**
	 *
	 * net.ajaskey.market.tools.isValid
	 *
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {

		if (ProcessIshares.isNumber(s)) {
			return false;
		}

		int idx = s.indexOf(".");
		if (idx > 0) {
			return false;
		}

		idx = s.indexOf(" ");
		if (idx > 0) {
			return false;
		}

		if (s.matches(".*\\d.*")) {
			return false;
		}

		return true;
	}

	/**
	 *
	 * net.ajaskey.market.tools.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		ProcessIshares.processIshare("ITB");
		ProcessIshares.processIshare("SOXX");
		ProcessIshares.processIshare("IYC");
		ProcessIshares.processIshare("IYK");
		ProcessIshares.processIshare("IYG");

		ProcessIshares.processIshare("IAT");
		ProcessIshares.processIshare("IAK");
		ProcessIshares.processIshare("IAI");

		ProcessIshares.processIshare("IBB");
		ProcessIshares.processIshare("IYH");
		ProcessIshares.processIshare("IHI");
		ProcessIshares.processIshare("IHF");
		ProcessIshares.processIshare("IHE");

		ProcessIshares.processIshare("IYJ");
		ProcessIshares.processIshare("ITA");
		ProcessIshares.processIshare("IYT");

		ProcessIshares.processIshare("IEO");
		ProcessIshares.processIshare("IEZ");

		ProcessIshares.processIshare("IVV");
		ProcessIshares.processIshare("IJH");
		ProcessIshares.processIshare("IJR");

		ProcessIshares.processIshare("IGE");
		ProcessIshares.processIshare("WOOD");
		ProcessIshares.processIshare("RING");
		ProcessIshares.processIshare("PICK");

		System.out.println("Done.");

	}

	/**
	 *
	 * net.ajaskey.market.tools.isNumber
	 *
	 * @param s
	 * @return
	 */
	private static boolean isNumber(String s) {

		try {
			Long.parseLong(s);
			return true;
		} catch (final Exception e) {
			return false;
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.processIshare
	 *
	 * @param iShare
	 * @throws FileNotFoundException
	 */
	private static void processIshare(String iShare) throws FileNotFoundException {

		String url = null;

		if (iShare.contains("ITB")) {
			url = ITB;
		} else if (iShare.contains("SOXX")) {
			url = SOXX;
		} else if (iShare.contains("IYC")) {
			url = IYC;
		} else if (iShare.contains("IYK")) {
			url = IYK;
		} else if (iShare.contains("IYG")) {
			url = IYG;
		} else if (iShare.contains("IAT")) {
			url = IAT;
		} else if (iShare.contains("IAK")) {
			url = IAK;
		} else if (iShare.contains("IAI")) {
			url = IAI;
		} else if (iShare.contains("IYH")) {
			url = IYH;
		} else if (iShare.contains("IBB")) {
			url = IBB;
		} else if (iShare.contains("IHI")) {
			url = IHI;
		} else if (iShare.contains("IHF")) {
			url = IHF;
		} else if (iShare.contains("IHE")) {
			url = IHE;
		} else if (iShare.contains("IYJ")) {
			url = IYJ;
		} else if (iShare.contains("ITA")) {
			url = ITA;
		} else if (iShare.contains("IYT")) {
			url = IYT;
		} else if (iShare.contains("IEO")) {
			url = IEO;
		} else if (iShare.contains("IEZ")) {
			url = IEZ;
		} else if (iShare.contains("IGE")) {
			url = IGE;
		} else if (iShare.contains("WOOD")) {
			url = WOOD;
		} else if (iShare.contains("RING")) {
			url = RING;
		} else if (iShare.contains("PICK")) {
			url = PICK;
		} else if (iShare.contains("IVV")) {
			url = IVV;
		} else if (iShare.contains("IJH")) {
			url = IJH;
		} else if (iShare.contains("IJR")) {
			url = IJR;
		}

		else {
			System.out.println("Invalid Ishare value : " + iShare);
			return;
		}

		try (PrintWriter pw = new PrintWriter("lists\\" + iShare.toLowerCase() + "-components.csv")) {

			List<String> resp = new ArrayList<>();
			resp = WebGet.getIshares(url);
			if (resp != null) {
				for (final String s : resp) {
					if ((s.compareToIgnoreCase("USD") != 0) && (s.compareToIgnoreCase("BLKFDS") != 0)
					    && (ProcessIshares.isValid(s))) {
						// System.out.println(s);
						pw.println(s);
					}
				}
				System.out.println("Processed " + iShare + " : " + resp.size());
			} else {
				System.out.println("Error processing " + iShare);
			}
		}

	}

}
