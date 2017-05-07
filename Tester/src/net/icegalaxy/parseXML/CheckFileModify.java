package net.icegalaxy.parseXML;

import java.io.File;
import java.text.SimpleDateFormat;


public class CheckFileModify
{

	 public static void main(String[] args)
	    {
		File file = new File("FHIdata.xml");

		System.out.println("Before Format : " + file.lastModified());

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		System.out.println("After Format : " + sdf.format(file.lastModified()));
	    }

}
