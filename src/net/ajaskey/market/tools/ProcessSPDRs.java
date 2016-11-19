
package net.ajaskey.market.tools;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.tools.helpers.WebGet;

public class ProcessSPDRs {

	// private static String sDummy =
	// ",\"SPDR\",\"0.0%\",\"0.0\",\"0.0\",\"0.0%\",\"1 M\",\"0.0 - 1.0\",";
	// private static String header = "\"Symbol\",\"Company Name\",\"Index
	// Weight\",\"Last\",\"Change\",\"%Change\",\"Volume\",\"52 Week Range\",";
	// private static PrintWriter pwAll;

	/**
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		ProcessSPDRs.processSpdr("xlb");
		ProcessSPDRs.processSpdr("xle");
		ProcessSPDRs.processSpdr("xlf");
		ProcessSPDRs.processSpdr("xli");
		ProcessSPDRs.processSpdr("xlk");
		ProcessSPDRs.processSpdr("xlp");
		ProcessSPDRs.processSpdr("xlu");
		ProcessSPDRs.processSpdr("xlv");
		ProcessSPDRs.processSpdr("xly");
		// processSpdr("xlfs");
		ProcessSPDRs.processSpdr("xlre");

		System.out.println("Done.");
	}

	// https://www.spdrs.com/site-content/xls/DIA_All_Holdings.xls?fund=DIA&docname=All+Holdings&onyx_code1=1286&onyx_code2=1506

	/**
	 *
	 * @param spdr
	 * @throws FileNotFoundException
	 */
	private static void processSpdr(String spdr) throws FileNotFoundException {

		System.out.println("Processing " + spdr);

		try (PrintWriter pwComp = new PrintWriter("lists\\" + spdr.toLowerCase() + "-components.csv")) {

			List<String> resp = new ArrayList<>();

			resp = WebGet
			    .getSPDR("http://www.sectorspdr.com/sectorspdr/IDCO.Client.Spdrs.Holdings/Export/ExportCsv?symbol=" + spdr);

			if (resp.size() > 2) {

				int knt = 0;
				for (final String s : resp) {

					if (knt > 1) {
						final String str[] = s.split(",");
						pwComp.println(str[0].replaceAll("\"", ""));
					}
					knt++;
				}
			}
		}
	}

}
