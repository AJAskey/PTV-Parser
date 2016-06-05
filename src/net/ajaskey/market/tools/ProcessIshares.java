package net.ajaskey.market.tools;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ProcessIshares {

	/** Home Builders */
	static private String ITB = "https://www.ishares.com/us/products/239512/ishares-us-home-construction-etf/1449138789749.ajax?fileType=csv&fileName=ITB_holdings&dataType=fund";

	/** Semiconductors */
	static private String SOXX = "https://www.ishares.com/us/products/239705/ishares-phlx-semiconductor-etf/1449138789749.ajax?fileType=csv&fileName=SOXX_holdings&dataType=fund";

	/** Consumer Services */
	static private String IYC = "https://www.ishares.com/us/products/239506/ishares-us-consumer-services-etf/1449138789749.ajax?fileType=csv&fileName=IYC_holdings&dataType=fund";

	/** Consumer Goods */
	static private String IYK = "https://www.ishares.com/us/products/239505/ishares-us-consumer-goods-etf/1449138789749.ajax?fileType=csv&fileName=IYK_holdings&dataType=fund";

	
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
		}else if (iShare.contains("IYK")) {
			url = IYK;
		} else {
			System.out.println("Invalid Ishare value : " + iShare);
			return;
		}
		
		List<String> resp = new ArrayList<>();
		resp = WebGet.getIshares(url);
		for (String s : resp) {
			if ((s.compareToIgnoreCase("USD") != 0) && (s.compareToIgnoreCase("BLKFDS") != 0))
			System.out.println(s);
		}
		System.out.println(resp.size());
		

	}
	
	public static void main(String[] args) throws FileNotFoundException {
		processIshare("ITB");
		processIshare("SOXX");
		processIshare("IYC");
		processIshare("IYK");
		processIshare("JYK");

	}

}
