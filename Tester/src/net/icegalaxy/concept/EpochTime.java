package net.icegalaxy.concept;

import java.time.Instant;

public class EpochTime
{

	public static void main(String[] args)
	{
		Instant in;	

		
		for (int i=0; i<10; i++){
			in = Instant.now();
			long time = in.getEpochSecond();
			System.out.println("Epoch Sec: " + time);
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			

	}

}
