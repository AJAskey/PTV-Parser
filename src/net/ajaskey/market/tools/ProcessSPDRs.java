
package net.ajaskey.market.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.market.tools.helpers.WebGet;

public class ProcessSPDRs {

	/**
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		ProcessSPDRs.processSpdr("xlb");
		ProcessSPDRs.processSpdr("xle");
		ProcessSPDRs.processSpdr("xlf");
		ProcessSPDRs.processSpdr("xli");
		ProcessSPDRs.processSpdr("xlk");
		ProcessSPDRs.processSpdr("xlp");
		ProcessSPDRs.processSpdr("xlu");
		ProcessSPDRs.processSpdr("xlv");
		ProcessSPDRs.processSpdr("xly");
		ProcessSPDRs.processSpdr("xlre");

		System.out.println("Done.");
	}

	/**
	 *
	 * @param spdr
	 * @throws FileNotFoundException
	 */
	private static void processSpdr(String spdr) throws FileNotFoundException {

		System.out.println("Processing " + spdr);

		final String outdir = "c:\\data\\MA\\Lists\\";
		try (PrintWriter pwComp = new PrintWriter("lists\\" + spdr.toLowerCase() + "-components.csv");
		    PrintWriter pwList = new PrintWriter(outdir + spdr.toLowerCase() + "-components.csv")) {

			List<String> resp = new ArrayList<>();

			resp = WebGet
			    .getSPDR("http://www.sectorspdr.com/sectorspdr/IDCO.Client.Spdrs.Holdings/Export/ExportCsv?symbol=" + spdr);

			if (resp.size() > 2) {

				int knt = 0;
				for (final String s : resp) {

					if (knt > 1) {
						final String str[] = s.split(",");
						String ss = str[0].replaceAll("\"", "");
						pwComp.println(ss);
						if (knt < 26) pwList.println(ss);
					}
					knt++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Continuing...");
		}
	}

}
