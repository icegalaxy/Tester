package net.icegalaxy.parseTxt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseCSV
{

	public static void main(String[] args)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File("/Users/IceGalaxy/Desktop/stair.csv"));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		sc.useDelimiter("\r\n");
		
		ArrayList<String> lines = new ArrayList<String>();
		
		sc.next();
		
		while(sc.hasNext())
			lines.add(sc.next());
		
		for (int i=0; i<lines.size(); i++)
		{
			Scanner sc2 = new Scanner(lines.get(i));
			sc2.useDelimiter(",");
			sc2.next();
			System.out.println(sc2.nextInt());
			sc2.next();
		}
		
//		sc.useDelimiter(",");
//		sc.nextLine();
//		
//		while (sc.hasNextLine())
//		{
//			sc.next();
//			System.out.println(sc.next());
//			System.out.println(sc.next());
//			System.out.println(sc.next());
//			sc.next();
//			sc.next();
//		}

	}

}
