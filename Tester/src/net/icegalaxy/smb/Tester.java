package net.icegalaxy.smb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;



public class Tester
{

	URL website;
	ReadableByteChannel rbc;
	FileOutputStream fos;
	
    
    public Tester() throws IOException{
    	URL website = new URL("http://belhome.myqnapcloud.com/Joe/TradeData/test.txt");
    	rbc = Channels.newChannel(website.openStream());
    	fos = new FileOutputStream("information.html");
    }
    
   
	public void go()
	{
	try
	{
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	} catch (IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
