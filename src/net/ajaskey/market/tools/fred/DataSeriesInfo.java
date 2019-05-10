
package net.ajaskey.market.tools.fred;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import net.ajaskey.market.misc.DateTime;
import net.ajaskey.market.misc.Debug;
import net.ajaskey.market.misc.Utils;

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
public class DataSeriesInfo {

	public final static SimpleDateFormat	sdf		= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat	sdf2	= new SimpleDateFormat("yyyy-MM-dd");

	private final static DocumentBuilderFactory	dbFactory	= DocumentBuilderFactory.newInstance();
	private static DocumentBuilder							dBuilder	= null;

	public static List<DataSeriesInfo> getDataSeriesNames() {

		final List<DataSeriesInfo> dList = new ArrayList<>();

		String url = "https://api.stlouisfed.org/fred/series/updates?offset=1000&api_key=fde45f7af492501c0b2200e7f0814540";

		int offset = 0;
		while (offset < 52000) {

			url = String.format("%s%d%s", "https://api.stlouisfed.org/fred/series/updates?offset=", offset,
			    "&api_key=fde45f7af492501c0b2200e7f0814540");

			offset += 1000;

			try {
				if (dBuilder == null) {
					dBuilder = dbFactory.newDocumentBuilder();
				}

				final String resp = Utils.getFromUrl(url);

				//Debug.pwDbg.println(resp + Utils.NL);

				final Document doc = dBuilder.parse(new InputSource(new StringReader(resp)));

				doc.getDocumentElement().normalize();

				final NodeList nResp = doc.getElementsByTagName("series");

				for (int knt = 0; knt < nResp.getLength(); knt++) {

					final Node nodeResp = nResp.item(knt);

					if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
						final DataSeriesInfo dsi = new DataSeriesInfo();

						final Element eElement = (Element) nodeResp;
						final String series = eElement.getAttribute("id");
						Debug.log("Series : " + series);

						dsi.setName(series);
						dsi.setTitle(eElement.getAttribute("title"));
						dsi.setFrequency(eElement.getAttribute("frequency"));
						dsi.setSeasonalAdjustment(eElement.getAttribute("seasonal_adjustment_short"));
						dsi.setUnits(eElement.getAttribute("units"));
						dsi.setType("LIN");
						dsi.setLastUpdate(eElement.getAttribute("last_updated"));
						dsi.setLastObservation(eElement.getAttribute("observation_end"));

						dList.add(dsi);
					}
				}
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

		return dList;
	}

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(final String[] args) throws FileNotFoundException {

		Debug.init("out/dsi.dbg");

		final DataSeriesInfo dsi = new DataSeriesInfo("CEU0500000001", new DateTime());

		try (PrintWriter pw = new PrintWriter("out/fred-series.txt")) {
			pw.println("Series\tTitle\tFrequency\tUnits\tSeasonality\tLastUpdate");
			pw.println(dsi.toCsvString());
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<DataSeriesInfo> readSeriesInfo() {

		final List<DataSeriesInfo> dList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("data/fred-series-info.txt"))) {

			String line;
			// Utils.printCalendar(d.getDate());
			while ((line = reader.readLine()) != null) {
				final String str = line.trim();
				if (str.length() > 1) {
					final String s = str.substring(0, 1);
					if (!s.contains("#")) {
						final String fld[] = str.split("\t");
						final DataSeriesInfo dsi = new DataSeriesInfo();
						dsi.name = fld[0].trim().toUpperCase();
						dsi.title = fld[1].trim();
						dsi.units = fld[4].trim();
						dsi.type = DataSeries.ResponseType.valueOf(fld[5].trim());
						dList.add(dsi);
					}
				}

			}
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return dList;
	}

	private String	name;
	private String	title;
	private String	frequency;

	private String	units;
	private String	seasonalAdjustment;

	private DataSeries.ResponseType type;

	private DateTime	lastUpdate;
	private DateTime	lastObservation;
	private DateTime	fileDt;

	private int timeOffset;

	private String response;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataSeriesInfo() {

		this.response = "";
		this.name = "";
		this.title = "";
		this.frequency = "";
		this.units = "";
		this.seasonalAdjustment = "";
		this.lastObservation = null;
		this.lastUpdate = null;
		this.fileDt = null;
		this.timeOffset = 0;
		this.type = DataSeries.ResponseType.LIN;
	}

	public DataSeriesInfo(final String fld[]) {

		final int len = fld.length;
		this.response = "";
		if (len > 1) {
			this.name = fld[0].trim();
			this.title = fld[1].trim();
			this.frequency = fld[3].trim();
			this.units = fld[4].trim();
			this.setType(fld[5].trim());
			this.lastObservation = null;
			this.lastUpdate = null;
			this.fileDt = null;
			this.seasonalAdjustment = "";
			this.timeOffset = 0;
		}
		else {
			this.name = fld[0];
			this.title = "";
			this.frequency = "";
			this.units = "";
			this.seasonalAdjustment = "";
			this.lastObservation = null;
			this.lastUpdate = null;
			this.fileDt = null;
			this.timeOffset = 0;
			this.type = DataSeries.ResponseType.LIN;
		}
	}

	/**
	 * This method serves as a constructor for the class.
	 * 
	 * @param lastUpdate
	 *
	 */
	public DataSeriesInfo(final String seriesName, DateTime fileDt) {

		this.setName(seriesName);

		final String url = "https://api.stlouisfed.org/fred/series?series_id=" + this.name + "&api_key=" + ApiKey.get();

		String resp;
		try {
			if (dBuilder == null) {
				dBuilder = dbFactory.newDocumentBuilder();
			}

			resp = Utils.getFromUrl(url);

			if (resp.length() < 1) {
				return;
			}

			this.response = resp.trim();
			//Debug.pwDbg.println(resp + Utils.NL);

			final Document doc = dBuilder.parse(new InputSource(new StringReader(resp)));

			doc.getDocumentElement().normalize();

			final NodeList nResp = doc.getElementsByTagName("series");
			for (int knt = 0; knt < nResp.getLength(); knt++) {
				final Node nodeResp = nResp.item(knt);
				if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
					final Element eElement = (Element) nodeResp;

					this.setTitle(eElement.getAttribute("title"));
					this.setFrequency(eElement.getAttribute("frequency"));
					this.setUnits(eElement.getAttribute("units"));
					this.setType("LIN");
					this.setSeasonalAdjustment(eElement.getAttribute("seasonal_adjustment_short"));
					this.setLastUpdate(eElement.getAttribute("last_updated"));
					this.setLastObservation(eElement.getAttribute("observation_end"));
					this.setFileDt(fileDt);
					//Debug.pwDbg.print(this);
				}
			}
		} catch (final Exception e) {
			this.setName("");
			e.printStackTrace();
		}
	}

	/**
	 * @return the frequency
	 */
	public String getFrequency() {

		return this.frequency;
	}

	/**
	 * @return the lastObservation
	 */
	public DateTime getLastObservation() {

		return this.lastObservation;
	}

	/**
	 * @return the lastUpdate
	 */
	public DateTime getLastUpdate() {

		return this.lastUpdate;
	}

	/**
	 * @return the name
	 */
	public String getName() {

		return this.name;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {

		return this.response;
	}

	/**
	 * @return the seasonalAdjusted
	 */
	public String getSeasonalAdjusted() {

		return this.seasonalAdjustment;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {

		return this.title;
	}

	/**
	 * @return the type
	 */
	public DataSeries.ResponseType getType() {

		return this.type;
	}

	/**
	 * @return the units
	 */
	public String getUnits() {

		return this.units;
	}

	/**
	 * @param frequency
	 *          the frequency to set
	 */
	private void setFrequency(final String frequency) {

		this.frequency = frequency;
	}

	/**
	 * @param lastObservation
	 *          the lastObservation to set
	 */
	public void setLastObservation(final String attribute) {

		try {
			final Date d = sdf2.parse(attribute);
			this.lastObservation = new DateTime(d);

		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * net.ajaskey.market.tools.fred.setLastUpdate
	 *
	 * @param attribute
	 */
	private void setLastUpdate(final String attribute) {

		try {
			final int idx = attribute.lastIndexOf("-");
			final String dstr = attribute.substring(0, idx);
			final Date d = sdf.parse(dstr);
			this.lastUpdate = new DateTime(d);

			final String os = attribute.substring(idx + 1);
			this.timeOffset = Integer.parseInt(os);
		} catch (final ParseException e) {
			e.printStackTrace();
		}

	}

	private void setLastUpdate(final DateTime dt) {

		this.lastUpdate.set(dt);
	}

	/**
	 * @param name
	 *          the name to set
	 */
	private void setName(final String name) {

		this.name = name;
	}

	/**
	 * @param seasonalAdjusted
	 *          the seasonalAdjusted to set
	 */
	public void setSeasonalAdjustment(final String adjustment) {

		this.seasonalAdjustment = adjustment;
	}

	/**
	 * @param title
	 *          the title to set
	 */
	private void setTitle(final String title) {

		final String filtered = title.replaceAll("[^\\x00-\\x7F]", " ");
		this.title = filtered.trim();
	}

	/**
	 * @param type
	 *          the type to set
	 */
	public void setType(final String type) {

		try {
			this.type = DataSeries.ResponseType.valueOf(type);
		} catch (final Exception e) {
			this.type = DataSeries.ResponseType.LIN;
		}
	}

	/**
	 * @param units
	 *          the units to set
	 */
	public void setUnits(final String units) {

		this.units = units;
	}

	public String toCsvString() {

		final String ret = this.name + Utils.TAB + this.title + Utils.TAB + this.frequency + Utils.TAB + this.units + Utils.TAB
		    + this.seasonalAdjustment + Utils.TAB + this.lastUpdate;
		return ret;
	}

	@Override
	public String toString() {

		String ret = Utils.NL + this.response + Utils.NL;
		ret += "Name               : " + this.name + Utils.NL;
		ret += "  Title            : " + this.title + Utils.NL;
		ret += "  Frequency        : " + this.frequency + Utils.NL;
		ret += "  Units            : " + this.units + Utils.NL;
		ret += "  Adjustment       : " + this.seasonalAdjustment + Utils.NL;
		ret += "  Type             : " + this.type + Utils.NL;
		if (this.lastUpdate != null) {
			ret += "  Last Update      : " + this.lastUpdate + "  " + this.timeOffset + Utils.NL;
		}
		if (this.lastObservation != null) {
			ret += "  Last Observation : " + this.lastObservation + Utils.NL;
		}
		if (this.fileDt != null) {
			ret += "  File Date        : " + this.fileDt;
		}
		return ret;
	}

	/**
	 * @return the fileDt
	 */
	public DateTime getFileDt() {

		return fileDt;
	}

	/**
	 * @param fileDt
	 *          the fileDt to set
	 */
	public void setFileDt(DateTime fileDt) {

		this.fileDt = fileDt;
	}

}
