
package net.ajaskey.market.tools.fred;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

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

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

	private final static DocumentBuilderFactory	dbFactory	= DocumentBuilderFactory.newInstance();
	private static DocumentBuilder							dBuilder	= null;
	private String															name;
	private String															title;
	private String															frequency;
	private String															units;
	private String															seasonalAdjustment;

	private Calendar	lastUpdate;
	private Calendar	lastObservation;
	private int				timeOffset;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataSeriesInfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataSeriesInfo(String seriesName) {

		this.setName(seriesName);

		final String url = "https://api.stlouisfed.org/fred/series?series_id=" + this.name + "&api_key=" + ApiKey.get();

		String resp;
		try {
			if (dBuilder == null) {
				dBuilder = dbFactory.newDocumentBuilder();
			}

			resp = Utils.getFromUrl(url);

			Debug.pwDbg.println(resp + Utils.NL);

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
					this.setSeasonalAdjustment(eElement.getAttribute("seasonal_adjustment_short"));
					this.setLastUpdate(eElement.getAttribute("last_updated"));
					this.setLastObservation(eElement.getAttribute("observation_end"));
					Debug.pwDbg.print(this);
				}
			}
		} catch (final Exception e) {
			this.setName("");
			e.printStackTrace();
		}
	}

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

				Debug.pwDbg.println(resp + Utils.NL);

				final Document doc = dBuilder.parse(new InputSource(new StringReader(resp)));

				doc.getDocumentElement().normalize();

				final NodeList nResp = doc.getElementsByTagName("series");

				for (int knt = 0; knt < nResp.getLength(); knt++) {

					final Node nodeResp = nResp.item(knt);

					if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
						final DataSeriesInfo dsi = new DataSeriesInfo();

						final Element eElement = (Element) nodeResp;
						final String series = eElement.getAttribute("id");
						Debug.pwDbg.println(series);

						dsi.setName(series);
						dsi.setTitle(eElement.getAttribute("title"));
						dsi.setFrequency(eElement.getAttribute("frequency"));
						dsi.setSeasonalAdjustment(eElement.getAttribute("seasonal_adjustment_short"));
						dsi.setUnits(eElement.getAttribute("units"));
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
	 */
	public static void main(String[] args) {

		final List<DataSeriesInfo> outList = DataSeriesInfo.getDataSeriesNames();

		try (PrintWriter pw = new PrintWriter("fred-series.xls")) {
			pw.println("Series\tTitle\tFrequency\tUnits\tSeasonality\tLastUpdate");
			for (final DataSeriesInfo dsi : outList) {
				pw.println(dsi.toCsvString());
			}
		} catch (final FileNotFoundException e) {
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
	public Calendar getLastObservation() {

		return this.lastObservation;
	}

	/**
	 * @return the lastUpdate
	 */
	public Calendar getLastUpdate() {

		return this.lastUpdate;
	}

	/**
	 * @return the name
	 */
	public String getName() {

		return this.name;
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
	 * @return the units
	 */
	public String getUnits() {

		return this.units;
	}

	/**
	 * @param lastObservation
	 *          the lastObservation to set
	 */
	public void setLastObservation(String attribute) {

		this.lastObservation = Calendar.getInstance();

		try {
			//final int idx = attribute.lastIndexOf("-");
			//final String dt = attribute.substring(0, idx);
			final Date d = sdf2.parse(attribute);
			this.lastObservation.setTime(d);

		} catch (final ParseException e) {
			e.printStackTrace();
		}	}

	/**
	 * @param seasonalAdjusted
	 *          the seasonalAdjusted to set
	 */
	public void setSeasonalAdjustment(String adjustment) {

		this.seasonalAdjustment = adjustment;
	}

	public String toCsvString() {

		final String ret = this.name + Utils.TAB + this.title + Utils.TAB + this.frequency + Utils.TAB + this.units
		    + Utils.TAB + this.seasonalAdjustment + Utils.TAB + sdf.format(this.lastUpdate.getTime());
		return ret;
	}

	@Override
	public String toString() {

		String ret = "";
		ret += "Name               : " + this.name + Utils.NL;
		ret += "  Title            : " + this.title + Utils.NL;
		ret += "  Frequency        : " + this.frequency + Utils.NL;
		ret += "  Units            : " + this.units + Utils.NL;
		ret += "  Adjustment       : " + this.seasonalAdjustment + Utils.NL;
		ret += "  Last Update      : " + sdf.format(this.lastUpdate.getTime()) + "  " + this.timeOffset + Utils.NL;
		ret += "  Last Observation : " + sdf2.format(this.lastObservation.getTime()) + Utils.NL;;
		return ret;
	}

	/**
	 * @param frequency
	 *          the frequency to set
	 */
	private void setFrequency(String frequency) {

		this.frequency = frequency;
	}

	/**
	 * net.ajaskey.market.tools.fred.setLastUpdate
	 *
	 * @param attribute
	 */
	private void setLastUpdate(String attribute) {

		this.lastUpdate = Calendar.getInstance();

		try {
			final int idx = attribute.lastIndexOf("-");
			final String dt = attribute.substring(0, idx);
			final Date d = sdf.parse(dt);
			this.lastUpdate.setTime(d);

			final String os = attribute.substring(idx + 1);
			this.timeOffset = Integer.parseInt(os);
		} catch (final ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param name
	 *          the name to set
	 */
	private void setName(String name) {

		this.name = name;
	}

	/**
	 * @param title
	 *          the title to set
	 */
	private void setTitle(String title) {

		final String filtered = title.replaceAll("[^\\x00-\\x7F]", " ");
		this.title = filtered.trim();
	}

	/**
	 * @param units
	 *          the units to set
	 */
	public void setUnits(String units) {

		this.units = units;
	}

}
