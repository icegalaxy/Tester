package csvHandling;

import java.util.ArrayList;

public class CSVHandler
{

	public static void main(String[] args)
	{
		Stair s1 = new Stair();
		Stair s2 = new Stair();
		
		ArrayList<Stair> sts = new ArrayList<Stair>();
		
		sts.add(s1);
		sts.add(s2);
		
		CSVWriter csvw = new CSVWriter(sts, "stair.csv");
		csvw.writeToCSV();
	}

}
