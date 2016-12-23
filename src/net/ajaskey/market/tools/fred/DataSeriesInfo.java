
package net.ajaskey.market.tools.fred;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

	public final static SimpleDateFormat	sdf				= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private String												name;
	private String												title;
	private String												frequency;
	private String												units;
	private String												seasonalAdjustment;
	private Calendar											lastUpdate;
	private int														timeOffset;

	private final DocumentBuilderFactory	dbFactory	= DocumentBuilderFactory.newInstance();
	private DocumentBuilder								dBuilder	= null;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataSeriesInfo(String seriesName) {

		this.setName(seriesName);

		final String url = "https://api.stlouisfed.org/fred/series?series_id=" + this.name + "&api_key=" + ApiKey.get();

		String resp;
		try {
			this.dBuilder = this.dbFactory.newDocumentBuilder();

			resp = Utils.getFromUrl(url);

			//System.out.println(resp + Utils.NL);

			final Document doc = this.dBuilder.parse(new InputSource(new StringReader(resp)));

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

				}
			}
		} catch (final Exception e) {
			this.setName("");
			e.printStackTrace();
		}
	}

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		final DataSeriesInfo dsi = new DataSeriesInfo("PCE");
		System.out.println(dsi);

	}

	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return this.frequency;
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
	 * @param seasonalAdjusted
	 *          the seasonalAdjusted to set
	 */
	public void setSeasonalAdjustment(String adjustment) {
		this.seasonalAdjustment = adjustment;
	}

	@Override
	public String toString() {
		String ret = "";
		ret += "Name          : " + this.name + Utils.NL;
		ret += "  Title       : " + this.title + Utils.NL;
		ret += "  Frequency   : " + this.frequency + Utils.NL;
		ret += "  Units       : " + this.units + Utils.NL;
		ret += "  Adjustment  : " + this.seasonalAdjustment + Utils.NL;
		ret += "  Last Update : " + sdf.format(this.lastUpdate.getTime()) + "  " + timeOffset;
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

		lastUpdate = Calendar.getInstance();

		try {
			int idx = attribute.lastIndexOf("-");
			String dt = attribute.substring(0, idx);
			Date d = sdf.parse(dt);
			lastUpdate.setTime(d);

			String os = attribute.substring(idx + 1);
			timeOffset = Integer.parseInt(os);
		} catch (ParseException e) {
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
		String filtered = title.replaceAll("[^\\x00-\\x7F]", " ");
		this.title = filtered.trim();
	}

	/**
	 * @param units
	 *          the units to set
	 */
	private void setUnits(String units) {
		this.units = units;
	}

}
