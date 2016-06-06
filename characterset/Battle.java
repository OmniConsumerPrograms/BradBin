package characterset;

import interfaces.IBattle;
import interfaces.ICharacter;
import interfaces.IParty;

import java.util.*;

import characterset.Party;
import characterset.VillainGenerator;

public abstract class Battle implements IBattle
{
	protected IParty heroes;
	protected IParty villains;
	protected VillainGenerator VG = new VillainGenerator();
	protected Random randomGenerator = new Random();
      
	public Battle(IParty heroes)
	{
		this.heroes = heroes;
		this.villains = VG.generateVillains(heroes.size());
	}
//			int					int type
	public boolean runBattle()
	{
		System.out.println("You have encountered ");
		this.villains.partyString();
		
		boolean done = false;
      
		while (checkPartiesAlive() && done == false) 
		{
			int currGoodPos = heroes.getTurn();
			int currBadPos = villains.getTurn();
         
			ICharacter currentHero = heroes.getChar(currGoodPos);
			ICharacter currentVillain = villains.getChar(currBadPos);
         
			HeroTurn turnHero = new HeroTurn();
			VillainTurn turnVillain = new VillainTurn();
         
			if (currentHero.getSpeed() >= currentVillain.getSpeed()) 
			{
				done = turnHero.executeTurn(heroes, villains); 
            
				if (checkPartiesAlive() && done == false ) 
				{                
					turnVillain.executeTurn(villains, heroes);
				}
				else 
				{
					break;
				}   
                              
			}     
			else 
			{                    
				turnVillain.executeTurn(villains, heroes);

				if (checkPartiesAlive()) 
				{                   
					done = turnHero.executeTurn(heroes, villains);
				}
           
				else 
				{
					break;
				} 
            
			}
		}      
		printResult();
        //return 1;
		return done;
		
        
	}
	
	public boolean checkPartiesAlive() 
	{
		return heroes.size() > 0 && villains.size() > 0;  
	}
   
	public void printResult() 
	{
		if(villains.size() <= 0)
		{
			System.out.println("Your party has survived! Good work!\n");
		}
		if (heroes.size() <= 0) 
		{ 
			System.out.println("Your party has been defeated! It is a sad day\n"); 
		}   	
	}

}