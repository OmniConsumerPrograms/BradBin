package characterset;

import interfaces.ICharacter;
import interfaces.IParty;

public abstract class BattleTurn 
{
	abstract int chooseAttack(ICharacter hero);
	abstract int chooseHeal(ICharacter hero);
	abstract int chooseEnemy(IParty villains);
	abstract int chooseAlly(IParty heroes);
	abstract void checkDefenderLife(ICharacter currentAttacker, IParty defenders, ICharacter currentDefender, int defendersPos);
	
	final boolean executeTurn(IParty attackers, IParty defenders) 
	{
		int attackersPos = attackers.getTurn();
		int defendersPos = defenders.getTurn();
      
		ICharacter currentAttacker = attackers.getChar(attackersPos);
      
		int menuChoice = menu(currentAttacker);
            
		if (menuChoice == 1) 
		{
			int choice = chooseAttack(currentAttacker);
			int currentDefendersPos = chooseEnemy(defenders);
			ICharacter currentDefender = defenders.getChar(currentDefendersPos);
			executeAttack(currentAttacker, currentDefender, choice);
			checkDefenderLife(currentAttacker, defenders, currentDefender, currentDefendersPos);  
		}
		
		if(menuChoice == 2)
		{
			int choice = chooseHeal(currentAttacker);
			int curAttackersPos = chooseAlly(attackers);
			ICharacter currentDefender = attackers.getChar(curAttackersPos);
			executeHeal( currentAttacker, currentDefender, choice);
			
		}
		
		
		while (menuChoice == 4) 
		{
			System.out.println("Your Heroes: ");
			attackers.partyString();
         
			System.out.println("The Villains: ");
			defenders.partyString();
         
			menuChoice = menu(currentAttacker);
		}    
          
		advanceTurnOrder(attackers, defenders);
      	return false;
	}
/*   
	private int chooseAlly(IParty attackers) {
		// TODO Auto-generated method stub
		return 0;
	}
	private void executeHeal(ICharacter currentAttacker	ICharacter currentDefender, int choice) {
		// TODO Auto-generated method stub
		
	}
*/
	public int menu(ICharacter currentAttacker) 
	{
		int i = 1;
		System.out.println(currentAttacker.getName() + " is attacking!");  
		return i;
	}   
   
	public void executeAttack(ICharacter currentAttacker, ICharacter currentDefender, int choice) 
	{
		currentAttacker.attack(currentDefender, choice);
	}
	
	public void executeHeal(ICharacter curHealer, ICharacter curHealee, int choice)
	{	
		curHealer.heal(curHealer, choice);
	}

	public void advanceTurnOrder(IParty attackers, IParty defenders) 
	{
		attackers.turnPlusPlus();
		if (attackers.getTurn() >= attackers.size()) 
			attackers.setTurn(0);      
		if (defenders.getTurn() >= defenders.size()) 
			defenders.setTurn(0);
	}
}