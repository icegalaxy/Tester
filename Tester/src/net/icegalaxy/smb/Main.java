package net.icegalaxy.smb;

import java.io.IOException;

public class Main
{

	public static void main(String[] args)
	{
		Tester test = null;
		try
		{
			test = new Tester();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.go();

	}

}
