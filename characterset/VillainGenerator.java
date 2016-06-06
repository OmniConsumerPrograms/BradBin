//OCP
//Villain Generator

package characterset;

import interfaces.IAttack;
import interfaces.IParty;
import interfaces.IVillain;

import java.util.*;

import characterset.Banshee;
import characterset.Barbarian;
import characterset.Demon;
import characterset.Dragon;
import characterset.Giant;
import characterset.Ogre;
import characterset.Warlock;
import characterset.Yeti;

public class VillainGenerator 
{
	private ArrayList<IVillain> villains;
	
	public VillainGenerator() 
	{
		villains = new ArrayList<IVillain>();
	      
		IVillain tempChar;
		
		tempChar = new Yeti(null);
		villains.add(tempChar);
		
		tempChar = new Ogre(null);
		villains.add(tempChar); 
	      		
		tempChar = new Banshee(null);
		villains.add(tempChar);
		
		tempChar = new Warlock(null);
		villains.add(tempChar);
	
		tempChar = new Barbarian(null);
		villains.add(tempChar);
		
		tempChar = new Demon(null);
		villains.add(tempChar);
		
		tempChar = new Giant(null);
		villains.add(tempChar);
		
		tempChar = new Dragon(null);
		villains.add(tempChar);
	}
	
	public IParty generateVillains(int numVillains)
	{
		int i, tempVillain;
		IParty villainsParty = new Party();
		Random gen = new Random();
		
		for(i = 0; i < numVillains; i++)
		{	
			tempVillain = gen.nextInt(100) + 1;
			IVillain vil = pickVillain( tempVillain );
			
			villainsParty.addChar(vil);
		}
		return villainsParty;
	}
	
	public IVillain pickVillain(int typeVillain)
	{
		ArrayList<IAttack> skillList = new ArrayList<IAttack>();
		skillList.add(new Melee());
		
		IVillain villain = null;
		
		if(typeVillain <= 25)
			villain = new Yeti(skillList);
		else if(typeVillain > 25 && typeVillain <= 45)
			villain = new Ogre(skillList);
		else if(typeVillain > 45 && typeVillain <= 60)
			villain = new Banshee(skillList);
		else if(typeVillain > 60 && typeVillain <= 70)
			villain = new Warlock(skillList);
		else if(typeVillain > 70 && typeVillain <= 80)
			villain = new Barbarian(skillList);
		else if(typeVillain > 80 && typeVillain <= 85)
			villain = new Demon(skillList);
		else if(typeVillain > 85 && typeVillain <= 90)
			villain = new Giant(skillList);
		else
			villain = new Dragon(skillList);
		
		return villain;
	}
	
	public void printHero()
	{
		IVillain tempChar;
		for (int i = 0; i < villains.size(); i++)
		{
			tempChar = villains.get(i);
			System.out.println((i + 1) + ". " + tempChar.charString());
		}   
	}

}
