package net.icegalaxy.parseXML;

public class Main
{

	public static void main(String[] args)
	{
		XMLReader xml = new XMLReader("170203");
//		xml.updateNode("open", "apple");
		xml.findOHLC();
		System.out.println("P.High: " + xml.position);
		System.out.println("StopEarn: " + xml.stopEarn);
		System.out.println("CutLoss: " + xml.cutLoss);
		
		
		System.out.println("Test Array");
		OHLC a = new OHLC();
		a.position = 5;
		System.out.println("a before: " + a.position);
		
		OHLC[] array = new OHLC[1];
		array[0] = a;		
		array[0].position = 6;
		
		System.out.println("Array 0: " + array[0].position);
		System.out.println("a after: " + a.position);

	}

}
