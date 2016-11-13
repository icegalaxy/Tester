package net.icegalaxy.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.sqlite.SQLiteConfig;

public class SQLite
{

	private String DBName;
	private String tableName;
	private String fieldString;
	private String scrDBName;
	public Statement stmt;
	public Connection conn;

	public SQLite(String DBName)
	{
		this.DBName = DBName;
		try
		{
			connectToAccessDB();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	private void connectToAccessDB() throws SQLException
	{

		SQLiteConfig config = new SQLiteConfig();

		config.setSharedCache(true);
		config.enableRecursiveTriggers(true);

		conn = DriverManager.getConnection("jdbc:sqlite:" + DBName + ".sqlite");
		stmt = conn.createStatement();
		System.out.println("Connected to DB");

	}

	public void attachDB(String scrDBName)
	{
		this.scrDBName = scrDBName;
		String query = "attach \'" + scrDBName + ".sqlite\' as DB2";

		try
		{
			stmt.executeUpdate(query);
		} catch (SQLException e)
		{
			System.out.println("Fail to attache DB");
			System.out.println(query);
			e.printStackTrace();
			return;
		}

		System.out.println("Attached DB: " + scrDBName);
	}

	public void copyTable(String tableName)
	{
		String query = "insert into " + tableName + " select * from DB2." + tableName;
		
		try
		{
			stmt.executeUpdate(query);
		} catch (SQLException e)
		{
			System.out.println("Fail to copy table");
			System.out.println(query);
			e.printStackTrace();
			return;
		}

		System.out.println("Copied Table: " + tableName);

	}

	public void createTable(String tableName)
	{

		this.tableName = tableName;

		String query = "CREATE TABLE " + tableName + "(MyIndex integer, "
				+ "TradeTime time, " + "Deal float, " + "Change float, "
				+ "TotalQuantity float, " + "BidQuantity integer, "
				+ "Bid float, Ask float, " + "AskQuantity integer)";

		try
		{
			stmt.executeUpdate(query);
		} catch (SQLException e)
		{
			System.out.println("Fail to create table");
			System.out.println(query);
			e.printStackTrace();
			return;
		}

		System.out.println("Created Table: " + tableName);
	}

	public void insertData(String valuesSeparatedByComma)
	{

		ArrayList<String> values = new ArrayList<String>();
		Scanner scr = new Scanner(valuesSeparatedByComma);
		scr.useDelimiter(",");
		while (scr.hasNext())
		{
			values.add(scr.next().trim());
		}

		StringBuffer query = new StringBuffer("INSERT INTO " + this.tableName + " VALUES(");

		for (int i = 0; i < values.size(); i++)
		{

			if (i != values.size() - 1)
				query.append(quote(values.get(i)) + ",");
			else
				query.append(quote(values.get(i)) + ");");
		}

		try
		{
			stmt.executeUpdate(query.toString());
		} catch (SQLException e)
		{
			System.out.println("Fail to insert data");
			e.printStackTrace();
		}
	}

	public void close()
	{
		try
		{
			stmt.close();
			conn.close();
			System.out.println("Disconnected From DataBase:" + DBName);
		} catch (SQLException e)
		{
			System.out.println("Fail to Dissconnect");
			e.printStackTrace();
		}
	}

	private String quote(String point)
	{
		return ("'" + point + "'");
	}
}
