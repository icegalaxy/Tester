package net.icegalaxy.sql;

public class Main
{
	public static void main(String[] args)
	{

		SQLite sql = new SQLite("AutoTradeTest");
		sql.attachDB("AutoTrade");

		String copyTable = "HSF161028";

		try
		{
			sql.createTable(copyTable);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		sql.copyTable(copyTable);

	}
}
