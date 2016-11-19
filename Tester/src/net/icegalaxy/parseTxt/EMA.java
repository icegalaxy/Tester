package net.icegalaxy.parseTxt;

import java.util.ArrayList;

public class EMA
{
	private ArrayList<Double> EMAs;
	private int period;

	public EMA(double previousDayEMA, int period)
	{
		EMAs = new ArrayList<Double>();
		EMAs.add(previousDayEMA);
		this.period = period;
	}

	public void setlatestEMA(double currentPt)
	{
		EMAs.add(getEMA(currentPt));
	}
	
	public double getEMA()
	{
		return EMAs.get(EMAs.size()-1);
	}
	
	public double getPreviousEMA(int noOfPeriodBefore)
	{
		return EMAs.get(EMAs.size() -1 -noOfPeriodBefore);
	}

	private double getEMA(double currentPt)
	{
		double smoothingConstant = (double) 2 / (period + 1);
		return (currentPt - EMAs.get(EMAs.size()-1)) * smoothingConstant + EMAs.get(EMAs.size()-1);
	}

}
