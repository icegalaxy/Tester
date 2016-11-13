package net.icegalaxy.parseWeb;

public class Main
{
	public static void main(String[] args)
	{
		HTMLParser etnet = new HTMLParser("http://www.etnet.com.hk/www/tc/futures/index.php?subtype=HSI&month=201611&tab=interval#tab"); 
		try
		{
			System.out.println("Open: " + etnet.parseETNetOpen());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Continue");
	}
}
