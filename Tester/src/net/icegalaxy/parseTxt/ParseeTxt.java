package net.icegalaxy.parseTxt;

public class ParseeTxt
{

	static EMA m1_250;
	
	public static void main(String[] args)
	{
		parseSPRecord sp = new parseSPRecord("HSIX6_20161119-m1.txt");
		sp.parseOHLC();
		
		for (int i=0; i<sp.getTime().size(); i++)
		{
			if (i==0)
			{
				m1_250 = new EMA(sp.getClose().get(i),250);
				continue;
			}
			
			m1_250.setlatestEMA(sp.getClose().get(i));
			System.out.println((double) Math.round(m1_250.getEMA()*100)/100);
			
		}

	}

}
