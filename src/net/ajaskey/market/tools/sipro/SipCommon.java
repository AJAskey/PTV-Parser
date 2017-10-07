
package net.ajaskey.market.tools.sipro;

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
public class SipCommon {

	public final static double	THOUSAND	= 1e3;
	public final static double	MILLION		= 1e6;
	public final static double	BILLION		= 1e9;

	private int						ptr;
	private final int			INC;
	private final String	splitChar;

	/**
	 * This method serves as a constructor for the class.
	 *
	 */
	public SipCommon(String ch, int inc, int ver) {
		this.reset();
		this.INC = inc;
		this.splitChar = ch;
	}

	public DataSet3 getData(String name, String line, DataSet3.dMode mode, double scaler) {

		final String fld[] = line.replace("\"", "").split(this.splitChar);

		final DataSet3 ds = new DataSet3(name, fld[0], fld[1], fld, this.ptr, mode);
		final DataSet3 dsRet = DataSet3.scale(ds, scaler);
		//System.out.println(dsRet);
		this.ptr += this.INC;
		return dsRet;
	}

	public DataSet4 getData4(String name, String line, DataSet4.dMode mode, double scaler) {

		final String fld[] = line.replace("\"", "").split(this.splitChar);

		final DataSet4 ds = new DataSet4(fld[1], name, fld[0], fld, this.ptr, mode);
		final DataSet4 dsRet = DataSet4.scale(ds, scaler);
		//System.out.println(dsRet);
		this.ptr += this.INC;
		return dsRet;
	}

	public void reset() {

		this.ptr = 1;
	}

}
