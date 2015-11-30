package net.ajaskey.market.ta;

import java.util.Calendar;

import net.ajaskey.market.ta.methods.TaMethods;

/**
 * This class...
 *
 * @author Andy Askey
 *         <p>
 *         PTV-Parser Copyright (c) 2015, Andy Askey. All rights reserved.
 *         </p>
 *         <p>
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 *
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software.
 *         </p>
 *         
 *         <p>
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *         </p>
 *
 */
public class DerivedData {
	
	public Double								sma23;
	public Double								smaPerc23;
	public TrendType							sma23Trend;
	public Double								sma65;
	public Double								smaPerc65;
	public TrendType							sma65Trend;
	public Double								sma130;
	public Double								smaPerc130;
	public TrendType							sma130Trend;
	public Double								sma260;
	public Double								smaPerc260;
	public TrendType							sma260Trend;
	public double[]							openData;
	public double[]							highData;
	public double[]							lowData;
	public double[]							closeData;
	public double[]							volumeData;
	public double[]							trueHighData;
	public double[]							trueLowData;
	public double[]							typicalPriceData;
	public Calendar[]						dateData;
	public double								currentPrice;
	public double								avgVol65;
	public double								avgVol20;
	public double								chg;
	public double								chg23;
	public double								chg65;
	public double								chg130;
	public double								chg260;
	public double								low260;
	public double								high260;
	public double								rsRaw;
	public double								rsStRaw;
	public double								atr23;
	public double								adx;
	public double								diPlus;
	public double								diMinus;
	public double								atrPercent23;
	public double								mfi23;
	public double								mfi65;
	public double								mfi130;
	public double								mfi14;
	public double								priceInRng260;
	public double								priceOffHigh260;
	public double								priceOffLow260;
	public double								lr260;
	public double								lrAngle260;
	public double								lrInt260;
	public double								lrSlope260;
	public double								rsi14;
	public final TaMethods				taMethods	= new TaMethods();
	/** 
	 * net.ajaskey.market.ta.getDaysOfData
	 *
	 * @return
	 */
	public int getDaysOfData() {
		// TODO Auto-generated method stub
		return 0;
	}

}
