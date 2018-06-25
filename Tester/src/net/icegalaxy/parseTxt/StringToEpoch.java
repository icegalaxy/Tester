package net.icegalaxy.parseTxt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToEpoch {

	public static void main(String[] args) {
		
		String dateTime = "2018/06/05/15/23/01";
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
		Date date = null;
		try {
			date = df.parse(dateTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long epoch = date.getTime();
		System.out.println(epoch); // 1055545912454
		
		
		

	}

}
