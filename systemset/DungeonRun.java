package systemset;

import java.sql.SQLException;

import floorset.DungeonTester;

public class DungeonRun
{
	public static void main(String[] args)
	{
		try
		{
			DungeonTester.startGame();
		}
		catch(SQLException sql)
		{
			System.out.println("SQL error");
		}
		catch(Exception e)
		{
			System.out.println("Errors");
		}
	}
}
