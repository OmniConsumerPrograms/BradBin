
package characterset;

import interfaces.ICharacter;
import interfaces.IParty;

import java.util.*;

public class VillainTurn extends BattleTurn 
{
	protected Random randomGenerator = new Random();
   
	public int chooseAttack(ICharacter currentAttacker)
	{
		int choice;
		do 
		{
			choice = randomGenerator.nextInt(currentAttacker.getSkillListSize());
		}
		while (currentAttacker.validAttackChoice(choice) == false); 
		//return choice;      
		return 0;
	}	
   
	public int chooseEnemy(IParty defenders)
	{
		return randomGenerator.nextInt(defenders.size());
 
	}
   
	public void checkDefenderLife(ICharacter currentAttacker, IParty defenders, ICharacter currentDefender, int currentDefendersPos)
	{
		if (currentDefender.isAlive() == false) 
		{
			System.out.println(currentDefender.getName() + " was killed!\n");     
			defenders.removeChar(currentDefendersPos);                  
		}
   	}

   	public int chooseHeal(ICharacter hero) 
   	{
   		return 0;
   	}

	@Override
	int chooseAlly(IParty heroes) {
		// TODO Auto-generated method stub
		return 0;
	}   
}