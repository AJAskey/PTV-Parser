package net.ajaskey.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadTextFile {

	/**
	 * 
	 * @param fname
	 * @param ignoreBlanks
	 * @return
	 */
	public static List<String> read(String fname, boolean ignoreBlanks) {
		File f = new File(fname);
		return read(f, ignoreBlanks);
	}

	/**
	 * 
	 * @param fname
	 * @param ignoreBlanks
	 * @return
	 */
	public static List<String> read(File file, boolean ignoreBlanks) {
		List<String> ret = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String s;
			while ((s = br.readLine()) != null) {
				if (ignoreBlanks) {
					if (s.trim().length() > 0) {
						ret.add(s);
					}
				} else {
					ret.add(s);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
