
package net.ajaskey.market.tools;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProcessIshares {

	/** Home Builders */
	static private String	ITB		= "https://www.ishares.com/us/products/239512/ishares-us-home-construction-etf/1449138789749.ajax?fileType=csv&fileName=ITB_holdings&dataType=fund";

	/** Semiconductors */
	static private String	SOXX	= "https://www.ishares.com/us/products/239705/ishares-phlx-semiconductor-etf/1449138789749.ajax?fileType=csv&fileName=SOXX_holdings&dataType=fund";

	/** Consumer Services */
	static private String	IYC		= "https://www.ishares.com/us/products/239506/ishares-us-consumer-services-etf/1449138789749.ajax?fileType=csv&fileName=IYC_holdings&dataType=fund";

	/** Consumer Goods */
	static private String	IYK		= "https://www.ishares.com/us/products/239505/ishares-us-consumer-goods-etf/1449138789749.ajax?fileType=csv&fileName=IYK_holdings&dataType=fund";

	/** Financial Services */
	static private String	IYG		= "https://www.ishares.com/us/products/239509/ishares-us-financial-services-etf/1449138789749.ajax?fileType=csv&fileName=IYG_holdings&dataType=fund";

	/** Regional Banks */
	static private String	IAT		= "https://www.ishares.com/us/products/239521/ishares-us-regional-banks-etf/1449138789749.ajax?fileType=csv&fileName=IAT_holdings&dataType=fund";

	/** Insurance */
	static private String	IAK		= "https://www.ishares.com/us/products/239515/ishares-us-insurance-etf/1449138789749.ajax?fileType=csv&fileName=IAK_holdings&dataType=fund";

	/** Health Care */
	static private String	IYH		= "https://www.ishares.com/us/products/239511/ishares-us-healthcare-etf/1449138789749.ajax?fileType=csv&fileName=IYH_holdings&dataType=fund";

	/** Medical Devices */
	static private String	IHI		= "https://www.ishares.com/us/products/239516/ishares-us-medical-devices-etf/1449138789749.ajax?fileType=csv&fileName=IHI_holdings&dataType=fund";

	/** Health Care Providers */
	static private String	IHF		= "https://www.ishares.com/us/products/239510/ishares-us-healthcare-providers-etf/1449138789749.ajax?fileType=csv&fileName=IHF_holdings&dataType=fund";

	/** Pharmaceuticals */
	static private String	IHE		= "https://www.ishares.com/us/products/239519/ishares-us-pharmaceuticals-etf/1449138789749.ajax?fileType=csv&fileName=IHE_holdings&dataType=fund";

	/** Industrials */
	static private String	IYJ		= "https://www.ishares.com/us/products/239514/ishares-us-industrials-etf/1449138789749.ajax?fileType=csv&fileName=IYJ_holdings&dataType=fund";

	/** Aerospace Defense */
	static private String	ITA		= "https://www.ishares.com/us/products/239502/ishares-us-aerospace-defense-etf/1449138789749.ajax?fileType=csv&fileName=ITA_holdings&dataType=fund";

	/** Transportation */
	static private String	IYT		= "https://www.ishares.com/us/products/239501/ishares-transportation-average-etf/1449138789749.ajax?fileType=csv&fileName=IYT_holdings&dataType=fund";

	// static private String = "";

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
		} else if (iShare.contains("IYH")) {
			url = IYH;
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
		}

		else {
			System.out.println("Invalid Ishare value : " + iShare);
			return;
		}

		try (PrintWriter pw = new PrintWriter("lists\\" + iShare.toLowerCase() + "-components.csv")) {

			List<String> resp = new ArrayList<>();
			resp = WebGet.getIshares(url);
			for (String s : resp) {
				if ((s.compareToIgnoreCase("USD") != 0) && (s.compareToIgnoreCase("BLKFDS") != 0)) {
					System.out.println(s);
					pw.println(s);
				}
			}
			System.out.println(resp.size());

		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		processIshare("ITB");
		processIshare("SOXX");
		processIshare("IYC");
		processIshare("IYK");
		processIshare("IYG");

		processIshare("IAT");
		processIshare("IAK");
		processIshare("IYH");
		processIshare("IHI");
		processIshare("IHF");
		processIshare("IHE");

		processIshare("IYJ");
		processIshare("ITA");
		processIshare("IYT");

	}

}
