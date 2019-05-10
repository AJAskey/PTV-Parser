
package net.ajaskey.market.tools.fred;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

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
public class DataSeries {

	public static enum AggregationMethodType {
		AVG, SUM, EOP
	}

	public static enum FileType {
		XML, JSON, TXT, XLS
	}

	public static enum OrderType {
		ASC, DESC
	}

	/*
	lin = Levels (No transformation)
	chg = Change
	ch1 = Change from Year Ago
	pch = Percent Change
	pc1 = Percent Change from Year Ago
	pca = Compounded Annual Rate of Change
	cch = Continuously Compounded Rate of Change
	cca = Continuously Compounded Annual Rate of Change
	log = Natural Log
	 */
	public static enum ResponseType {
		LIN, CHG, CH1, PCH, PC1, PCA, CCH, CCA, LOG
	}

	/**
	 * net.ajaskey.market.tools.fred.main
	 *
	 * @param args
	 */
	public static void main(final String[] args) {

		final DataSeries ds = new DataSeries("AMTMUO");

		if (ds.isValid()) {

			ds.setAggType(AggregationMethodType.EOP);
			//ds.setOrder(OrderType.DESC);
			ds.setRespType(ResponseType.LIN);
			final List<DataValues> dvList = ds.getValues(1.0, true, false);

			for (final DataValues d : dvList) {
				System.out.println(d.getDate() + "  " + d.getValue());
			}

			System.out.println(ds);

		}
	}

	private String								name;
	private AggregationMethodType	aggType;
	private FileType							fileType;
	private OrderType							order;
	private ResponseType					respType;
	private int										limit;

	private int	offset;
	private int	respKnt;

	private String												period;
	private final DocumentBuilderFactory	dbFactory	= DocumentBuilderFactory.newInstance();

	private DocumentBuilder	dBuilder	= null;
	private DateTime				dtOne;

	private final DataSeriesInfo info;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public DataSeries(final String name) {

		this.setName(name);
		this.setAggType(AggregationMethodType.AVG);
		this.setFileType(FileType.XML);
		this.setLimit(100000);
		this.setOffset(0);
		this.setOrder(OrderType.ASC);
		this.setRespType(ResponseType.LIN);
		this.setRespKnt("0");
		this.dtOne = null;

		this.info = new DataSeriesInfo(name, new DateTime());
		try {
			this.dBuilder = this.dbFactory.newDocumentBuilder();
		} catch (final ParserConfigurationException e) {
			this.dBuilder = null;
			e.printStackTrace();
		}
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.appendEstimates
	 *
	 * @param retList
	 * @param futureChg
	 */
	private void appendEstimates(final List<DataValues> retList, final double futureChg) {

		this.setPeriod(this.info.getFrequency());

		final DateTime dt = new DateTime();
		final DateTime dtLast = new DateTime(retList.get(retList.size() - 1).getDate().getCal());

		final double last = retList.get(retList.size() - 1).getValue();

		int periodKnt = 0;
		int duration = 0;
		if (this.period.contains("daily")) {
			periodKnt = 1;
			duration = DateTime.DATE;
		}
		else if (this.period.contains("weekly")) {
			periodKnt = 7;
			duration = DateTime.DATE;
		}
		else if (this.period.contains("monthly")) {
			periodKnt = 1;
			duration = DateTime.MONTH;
		}
		else {
			periodKnt = 3;
			duration = DateTime.MONTH;
		}

		dtLast.add(duration, periodKnt);

		final double val = last + (last * (futureChg / 100.0));
		final DataValues dv = new DataValues(dtLast, val);
		retList.add(dv);

		final DateTime tmp = new DateTime(dtLast.getCal());
		while (tmp.isLessThan(dt)) {
			final DateTime nCal = new DateTime(tmp.getCal());
			nCal.add(duration, periodKnt);
			final DataValues dv1 = new DataValues(nCal, val);
			retList.add(dv1);
			tmp.set(nCal.getCal().get(DateTime.YEAR), nCal.getCal().get(DateTime.MONTH), nCal.getCal().get(DateTime.DATE));
		}

	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.duplicateLastValue
	 *
	 * @param retList
	 */
	//	private void duplicateLastValue(List<DataValues> retList) {
	//
	//		try {
	//			final String f = this.info.getFrequency().toLowerCase();
	//			if ((f.contains("daily")) || (f.contains("weekly")) || (f.contains("month"))) {
	//				return;
	//			}
	//
	//			final Calendar cal = Calendar.getInstance();
	//			final Calendar calLast = Utils.buildCalendar(retList.get(retList.size() - 1).getDate());
	//			final long mNow = cal.get(Calendar.MONTH);
	//			final long mThen = calLast.get(Calendar.MONTH) + 1;
	//
	//			if (mNow > mThen) {
	//				final double val = retList.get(retList.size() - 1).getValue();
	//				final DataValues dv = new DataValues(cal, val);
	//				retList.add(dv);
	//			}
	//		} catch (final Exception e) {
	//		}
	//
	//	}

	/**
	 * @return the aggType
	 */
	public String getAggType() {

		return "&aggregation_type=" + this.aggType.toString().toLowerCase();
	}

	/**
	 * @return the type
	 */
	public String getFileType() {

		return "&file_type=" + this.fileType.toString().toLowerCase();
	}

	public DataSeriesInfo getInfo() {

		return this.info;
	}

	/**
	 * @return the limit
	 */
	public String getLimit() {

		return "&limit=" + this.limit;
	}

	/**
	 * @return the name
	 */
	public String getName() {

		return this.name;
	}

	/**
	 * @return the offset
	 */
	public String getOffset() {

		return "&offset=" + this.offset;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {

		return "&sort_order=" + this.order.toString().toLowerCase();

	}

	/**
	 * @return the period
	 */
	public String getPeriod() {

		return this.period;
	}

	/**
	 * @return the respKnt
	 */
	public int getRespKnt() {

		return this.respKnt;
	}

	/**
	 * @return the respType
	 */
	public String getRespType() {

		return "&units=" + this.respType.toString().toLowerCase();
	}

	/**
	 *
	 * net.ajaskey.market.tools.fred.getValues
	 *
	 * @param futureChg
	 * @param noZeroValues
	 * @param estimateData
	 * @return
	 */
	public List<DataValues> getValues(final double futureChg, final boolean noZeroValues, final boolean estimateData) {

		final List<DataValues> retList = new ArrayList<>();

		final String url = "https://api.stlouisfed.org/fred/series/observations?series_id=" + this.name + this.getAggType() + this.getFileType()
		    + this.getLimit() + this.getOffset() + this.getOrder() + this.getRespType() + "&api_key=" + ApiKey.get();

		Debug.log(url + "\n");

		String resp;
		try {
			resp = Utils.getFromUrl(url);

			if (resp.length() > 0) {

				final Document doc = this.dBuilder.parse(new InputSource(new StringReader(resp)));

				doc.getDocumentElement().normalize();

				final NodeList nResp = doc.getElementsByTagName("observations");
				for (int knt = 0; knt < nResp.getLength(); knt++) {
					final Node nodeResp = nResp.item(knt);
					if (nodeResp.getNodeType() == Node.ELEMENT_NODE) {
						final Element eElement = (Element) nodeResp;
						this.setRespKnt(eElement.getAttribute("count"));

					}
				}

				final NodeList nList = doc.getElementsByTagName("observation");
				for (int ptr = 0; ptr < nList.getLength(); ptr++) {
					final Node nNode = nList.item(ptr);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						final Element eElement = (Element) nNode;
						final DataValues dv = new DataValues(eElement.getAttribute("date"), eElement.getAttribute("value"));
						final int zeroCheck = (int) (dv.getValue() * 1000.0);
						if ((noZeroValues) && (zeroCheck == 0)) {
							this.respKnt -= 1;
						}
						else {
							//System.out.println(Utils.getString(dv.getDate()));
							retList.add(dv);
							//dv.getValue();
							if (this.dtOne == null) {
								this.dtOne = dv.getDate();
							}
						}
					}
				}
			}
		} catch (IOException | SAXException e) {
			e.printStackTrace();
		}

		if (estimateData) {
			this.appendEstimates(retList, futureChg);
		}
		else {
			//duplicateLastValue(retList);
		}

		return retList;
	}

	public boolean isValid() {

		return (this.dBuilder != null);
	}

	/**
	 * @param aggType
	 *          the aggType to set
	 */
	public void setAggType(final AggregationMethodType aggType) {

		this.aggType = aggType;
	}

	/**
	 * @param type
	 *          the type to set
	 */
	public void setFileType(final FileType type) {

		this.fileType = type;
	}

	/**
	 * @param limit
	 *          the limit to set
	 */
	public void setLimit(final int limit) {

		this.limit = limit;
	}

	/**
	 * @param name
	 *          the name to set
	 */
	private void setName(final String name) {

		this.name = name;
	}

	/**
	 * @param offset
	 *          the offset to set
	 */
	public void setOffset(final int offset) {

		this.offset = offset;
	}

	/**
	 * @param order
	 *          the order to set
	 */
	public void setOrder(final OrderType order) {

		this.order = order;
	}

	/**
	 * @param period
	 *          the period to set
	 */
	public void setPeriod(final String period) {

		this.period = period.toLowerCase();
	}

	/**
	 * @param respKnt
	 *          the respKnt to set
	 */
	public void setRespKnt(final String strRespKnt) {

		try {
			this.respKnt = Integer.parseInt(strRespKnt);
		} catch (final Exception e) {
			this.respKnt = 0;
		}
	}

	/**
	 * @param respType
	 *          the respType to set
	 */
	public void setRespType(final ResponseType respType) {

		this.respType = respType;
	}

	@Override
	public String toString() {

		String ret = "";
		try {
			ret += this.info.toString() + Utils.NL;
			//ret += "Period : " + period + Utils.NL;
			ret += "Count  : " + this.respKnt + Utils.NL;
			ret += "First  : " + this.dtOne;
		} catch (final Exception e) {
			ret = "";
		}
		return ret;
	}

}
