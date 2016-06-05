package net.ajaskey.market.tools;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProcessSPDRs {

	//private static String sDummy = ",\"SPDR\",\"0.0%\",\"0.0\",\"0.0\",\"0.0%\",\"1 M\",\"0.0 - 1.0\",";
	//private static String header = "\"Symbol\",\"Company Name\",\"Index Weight\",\"Last\",\"Change\",\"%Change\",\"Volume\",\"52 Week Range\",";
	//private static PrintWriter pwAll;

	/**
	 * 
	 * @param spdr
	 * @throws FileNotFoundException
	 */
	private static void processSpdr(String spdr) throws FileNotFoundException {

		System.out.println("Processing " + spdr);

		try (PrintWriter pwComp = new PrintWriter("lists\\" + spdr.toLowerCase() + "-components.csv")) {

			List<String> resp = new ArrayList<>();
			resp = WebGet.getSPDR(
					"http://www.sectorspdr.com/sectorspdr/IDCO.Client.Spdrs.Holdings/Export/ExportCsv?symbol=" + spdr);

			if (resp.size() > 2) {

				//try (PrintWriter pw = new PrintWriter("out\\" + spdr.toLowerCase() + "-holdings.csv")) {

					//pw.println(header);
					int knt = 0;
					for (String s : resp) {
						//if ((knt > 1) && (knt < 12)) {
							//if (knt == 2) {
								//pw.println("\"" + spdr.toUpperCase() + "\"" + sDummy);
								//pwAll.println("\"" + spdr.toUpperCase() + "\"" + sDummy);
							//}
							//pw.println(s);
							//if (knt < 7) {
							//	pwAll.println(s);
							//}
						//}
						if (knt > 1) {
							String str[] = s.split(",");
							pwComp.println(str[0].replaceAll("\"", ""));
						}
						knt++;
					//}

				}
			}
		}
	}

	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		//pwAll = new PrintWriter("out\\spdr-holdings.csv");
		//pwAll.println(header);

		processSpdr("xlb");
		processSpdr("xle");
		processSpdr("xlf");
		processSpdr("xli");
		processSpdr("xlk");
		processSpdr("xlp");
		processSpdr("xlu");
		processSpdr("xlv");
		processSpdr("xly");
		// processSpdr("xlfs");
		processSpdr("xlre");

		//pwAll.close();

	}

}
