package systemset;

import characterset.Battle;
import characterset.HeroGenerator;
import characterset.Party;
import characterset.PartyManager;
import interfaces.IBattle;
import interfaces.IParty;

//OCP
//Party Tester 

@SuppressWarnings("unused")
public class dungeonTester 
{
	public static void main(String[] args)
	{
		
		//PM.set(hero);
		
		
		IParty heroes = new Party();
		HeroGenerator heroGen = new HeroGenerator();
		heroes = heroGen.chooseHeroes();
		heroes.partyString();
		
		PartyManager PM = new PartyManager(heroes.size());
	
		//Here 
		
		//for(int i = 0; i < 2; i++)
		//{
			Battle battle = new Battle(heroes, new Gamemaster());
			int j = 1;
			int k = battle.runBattle(j);
			System.out.println(k);
			heroes.partyString();
		//}

		for( int i = 0; i < heroes.size(); i++)
		{
			heroes.getChar(i).charString();
		}
		
		PartySaveManager PSM = new PartySaveManager( heroes );
		PSM.printParty(heroes);
		
	}
	
}
