package characterset;

import interfaces.IBattle;
import interfaces.ICharacter;
import interfaces.IParty;
import systemset.Gamemaster;

import java.util.*;

import characterset.Party;
import characterset.VillainGenerator;

@SuppressWarnings("unused")
public class Battle implements IBattle
{
	protected IParty heroes;
	protected IParty villains;
	protected VillainGenerator VG = new VillainGenerator();
	protected Random randomGenerator = new Random();
	protected Gamemaster GM;
      
	public Battle(IParty heroes, Gamemaster GM)
	{
		this.heroes = heroes;
		this.villains = VG.generateVillains(heroes.size());
		this.GM = GM;
	}
//			int					int type
	public int runBattle(int type)
	{
		System.out.println("You have encountered ");
		this.villains.partyString();
		
		boolean done = false;
      
		while (checkPartiesAlive() && done == false && GM.getGameMode() == 910) 
		{
			int currGoodPos = heroes.getTurn();
			int currBadPos = villains.getTurn();
         
			ICharacter currentHero = heroes.getChar(currGoodPos);
			ICharacter currentVillain = villains.getChar(currBadPos);
         
			HeroTurn turnHero = new HeroTurn(GM);
			VillainTurn turnVillain = new VillainTurn(GM);
         
			if (currentHero.getSpeed() >= currentVillain.getSpeed() && GM.getGameMode() == 910) 
			{
				done = turnHero.executeTurn(heroes, villains); 
            
				if (checkPartiesAlive() && done == false ) 
				{                
					turnVillain.executeTurn(villains, heroes);
				}
				else 
				{
					return 540;
				}   
                              
			}     
			else if(GM.getGameMode() == 910)
			{                    
				turnVillain.executeTurn(villains, heroes);

				if (checkPartiesAlive()) 
				{                   
					done = turnHero.executeTurn(heroes, villains);
				}
           
				else 
				{
					return 550;
				} 
            
			}
		}      
		//printResult();
        //return 1;
		return 909;
		
        
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
			int i;
			for(i = 0; i < heroes.size(); i++)
			{
				heroes.getChar(i).setSP(heroes.getChar(i).getSPMax());
			}
		}
		if (heroes.size() <= 0) 
		{ 
			System.out.println("Your party has been defeated! It is a sad day\n"); 
		}   	
	}

}