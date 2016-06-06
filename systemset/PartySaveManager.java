package systemset;

import interfaces.IEquipment;
import interfaces.IHeal;
import interfaces.IParty;

import java.util.*;
import java.io.*;

import weaponset.BareHands;
import characterset.Heal;

@SuppressWarnings({"resource", "unused"})
public class PartySaveManager extends SaveLoadManager
{
	private IParty heroes; 	
	
	public PartySaveManager(IParty heroes) 
	{
		this.setHeroes(heroes);
	}
	
	//String name, int hpMax, int attackMin, int attackMax, int speed, int phyDefense, int magDefense, int accuracy, int level
	public void printParty( IParty heroes )
	{
		int i;
		PrintWriter fout;
		fout = openFout( heroes );
		System.out.println("printParty before for");
		
		fout.println( heroes.size() );
		
		for( i = 0; i < heroes.size(); i++)
		{
			fout.println(heroes.getChar(i).getName());
			fout.println(heroes.getChar(i).getStatus());
			fout.println(heroes.getChar(i).getHPMax());
			fout.println(heroes.getChar(i).getHP());
			fout.println(heroes.getChar(i).getAttackMin());
			fout.println(heroes.getChar(i).getAttackMax());
			fout.println(heroes.getChar(i).getHealMin());
			fout.println(heroes.getChar(i).getHealMax());
			fout.println(heroes.getChar(i).getSpeed());
			fout.println(heroes.getChar(i).getAccuracy());
			fout.println(heroes.getChar(i).getPhyDefense());
			fout.println(heroes.getChar(i).getMagDefense());
			//fout.println(heroes.getChar(i).getXP());
			//fout.println(heroes.getChar(i).)
			
			/*

		accuracy = 60.0;
		phyDefense = 13;
		magDefense = 13;
		exp = 0;
		level = 1;
		levelCap = 12;
		levelTrack = new int[levelCap];
		skillList = skills;
		
		healList = new ArrayList<IHeal>();
		healList.add(new Heal());
		
		equipmentSet = new IEquipment[3];
		weapon = new BareHands(1);
		
		setupEquipmentSet();
		buildLevelTrack();
			 */
			
		}
		fout.close();
	}
	
	public PrintWriter openFout( IParty heroes )
	{
		PrintWriter fout = null;
		boolean done = false;
		String foutName;
		Scanner user = new Scanner(System.in);
		System.out.println("openFout before while");
		while( done == false )
		{
			System.out.println("Enter file name for saving the game: ");
			foutName = user.nextLine();
			
			try
			{
				fout = new PrintWriter( foutName );
				savedGames.add(foutName);
				done = true;
			}
			catch( FileNotFoundException e)
			{
				System.out.println("Could not open " + foutName);
				System.out.println("Try again");
			}
			
		}
		return fout;
	}

	public IParty getHeroes() {
		return heroes;
	}

	public void setHeroes(IParty heroes) {
		this.heroes = heroes;
	}
	
	
	
	

}
