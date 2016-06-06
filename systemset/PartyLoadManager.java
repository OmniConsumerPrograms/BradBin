package systemset;

import java.util.*;
import characterset.Party;
import java.io.*;

@SuppressWarnings({"resource", "unused"})
public class PartyLoadManager extends SaveLoadManager
{
	private Party heroes;
	
	public PartyLoadManager() 
	{
	
	}
	
	public Party loadHeroes()
	{
		int i;
		Scanner user = new Scanner(System.in);
		
		System.out.println("Here is the list of saved games:");
		if(savedGames.size() == 0)
			System.out.println("OH NO! There are no saved games!");
		else
		{
			for(i = 0; i < savedGames.size(); i++)
			{
				System.out.println((i+1) + ". " + savedGames.get(i) );
			}
		}
		
		return null;//for now
	}

}
