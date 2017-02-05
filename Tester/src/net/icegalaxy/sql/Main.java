package net.icegalaxy.sql;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{

		// to remove duplicated table first
		ArrayList<String> tables = new ArrayList<String>();
		SQLite sql = new SQLite("AutoTrade");

		try
		{
			DatabaseMetaData md = sql.conn.getMetaData();
			String[] types =
			{ "TABLE" };
			ResultSet rs = md.getTables(null, null, "%", types);
			while (rs.next())
			{
				tables.add(rs.getString(3));
			}
			sql.conn.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		

		SQLite sql2 = new SQLite("AutoTradeTest");

		try
		{
			DatabaseMetaData md = sql2.conn.getMetaData();
			String[] types =
			{ "TABLE" };
			ResultSet rs = md.getTables(null, null, "%", types);
			while (rs.next())
			{
				String table = rs.getString(3);
				for (int i = 0; i < tables.size(); i++)
				{
					if (tables.get(i).equals(table))
					{
						tables.remove(i);
						break;
					}
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// copy tables

		sql2.attachDB("AutoTrade");

		for (int i = 0; i < tables.size(); i++)
		{

			String copyTable = tables.get(i);

			try
			{
				sql2.createTable(copyTable);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			sql2.copyTable(copyTable);
		}
	}
}
