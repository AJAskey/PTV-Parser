
package net.ajaskey.market.tools.sipro;

import java.lang.reflect.Field;

/**
 * This class...
 *
 * @author ajask <p> PTV-Parser Copyright (c) 2015, Andy Askey. All rights
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
public class SipSectorData {

	public static final String	basicMaterialsStr				= "01  - Basic Materials";
	public static final String	capitalGoodsStr					= "02  - Capital Goods";
	public static final String	consumerCyclicalStr			= "04  - Consumer Cyclical";
	public static final String	consumerNonCyclicalStr	= "05  - Consumer Non-Cyclical";
	public static final String	energyStr								= "06  - Energy";

	public static final String	financialStr			= "07  - Financial";
	public static final String	healthcareStr			= "08  - Health Care";
	public static final String	servicesStr				= "09  - Services";
	public static final String	technologyStr			= "10  - Technology";
	public static final String	transportationStr	= "11  - Transportation";
	public static final String	utilitiesStr			= "12  - Utilities";
	public DataSet3							shares						= new DataSet3("shares");
	public DataSet3							sales							= new DataSet3("sales");
	public DataSet3							income						= new DataSet3("income");
	public DataSet3							cashOps						= new DataSet3("cashOps");
	public DataSet3							ltDebt						= new DataSet3("ltDebt");

	//	public void add(List<SipSectorData> list, DataSet3 ds) {
	//		list.shares.add(ds);
	//
	//		if (sector.equalsIgnoreCase("01  - Basic Materials")) {
	//			basicMaterials.
	//		} else if (sector.equalsIgnoreCase("02  - Capital Goods")) {
	//			capitalgoods.add(ds);
	//		} else if (sector.equalsIgnoreCase("04  - Consumer Cyclical")) {
	//			cyclical.add(ds);
	//		} else if (sector.equalsIgnoreCase("05  - Consumer Non-Cyclical")) {
	//			noncyclical.add(ds);
	//		} else if (sector.equalsIgnoreCase("06  - Energy")) {
	//			energy.add(ds);
	//		} else if (sector.equalsIgnoreCase("07  - Financial")) {
	//			financial.add(ds);
	//		} else if (sector.equalsIgnoreCase("08  - Health Care")) {
	//			healthcare.add(ds);
	//		} else if (sector.equalsIgnoreCase("09  - Services")) {
	//			services.add(ds);
	//		} else if (sector.equalsIgnoreCase("10  - Technology")) {
	//			technology.add(ds);
	//		} else if (sector.equalsIgnoreCase("11  - Transportation")) {
	//			transportation.add(ds);
	//		} else if (sector.equalsIgnoreCase("12  - Utilities")) {
	//			utilities.add(ds);
	//		}
	//	}

	@Override
	public String toString() {

		final StringBuilder result = new StringBuilder();
		final String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" Object {");
		result.append(newLine);

		final Field[] fields = this.getClass().getDeclaredFields();

		for (final Field field : fields) {
			if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
				result.append("  ");
				try {
					result.append(field.getName());
					result.append(": ");
					// requires access to private field:
					result.append(field.get(this));
				} catch (final IllegalAccessException ex) {
					System.out.println(ex);
				}
				result.append(newLine);
			}
		}
		result.append("}");

		return result.toString();
	}
}
