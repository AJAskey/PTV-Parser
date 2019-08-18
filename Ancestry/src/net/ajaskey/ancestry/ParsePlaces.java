package net.ajaskey.ancestry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.ajaskey.common.ReadTextFile;

public class ParsePlaces {

	public static void main(String[] args) throws IOException {
		File file = new File("d:\\ancestry\\subplaces.csv");
		if (file.exists()) {

			List<String> infile =  ReadTextFile.read(file, true);
			List<String> places =  new ArrayList<>();

			for (String s : infile) {

				int idx = s.indexOf(" in ");
				if (idx > 0) {
					String ss = s.substring(idx + 4).trim();
					if (ss.contains(", USA")) {

						String sss = ss.replace("\"", "");
						// System.out.println(sss);

						String fld[] = sss.split(",");
						//System.out.printf("%s\t%d%n", sss, fld.length);
						if (fld.length == 2) {
							places.add("UNK, UNK, " + sss);
						} else if (fld.length == 3) {
							places.add("UNK, " + sss);
						} else {
							places.add(sss);
						}

					}
				}
			}

			for (String str : places) {
				System.out.println(str);
			}
		}
	}

}
