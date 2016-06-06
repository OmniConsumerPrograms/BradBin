package characterset;

import interfaces.ICharacter;
import interfaces.IParty;
import systemset.Gamemaster;

@SuppressWarnings("unused")
public abstract class BattleTurn 
{
	private Gamemaster GM;
	
	public BattleTurn(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	abstract int chooseAttack(ICharacter hero);
	abstract int chooseHeal(ICharacter hero);
	abstract int chooseEnemy(IParty villains);
	abstract int chooseAlly(IParty heroes);
	abstract void checkDefenderLife(ICharacter currentAttacker, IParty defenders, ICharacter currentDefender, int defendersPos);
	
	final boolean executeTurn(IParty attackers, IParty defenders) 
	{
		int menuChoice = -1;
		int attackersPos = attackers.getTurn();
		int defendersPos = defenders.getTurn();
      
		ICharacter currentAttacker = attackers.getChar(attackersPos);
      
		menuChoice = menu(currentAttacker);
            
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
			
			int i;
			for(i = 0; i < 2; i++)
			{
				int choice = chooseHeal(currentAttacker);
				System.out.println(choice);
				int curAttackersPos = chooseAlly(attackers);
				System.out.println(curAttackersPos);
				ICharacter currentDefender = attackers.getChar(curAttackersPos);
				executeHeal( currentAttacker, currentDefender, choice);
			}
		}
		
		if( menuChoice == 3)
		{
			GM.callEvent(970);
	         
			if(GM.getGameMode() == 910)
				menuChoice = menu(currentAttacker);
			else
				return true;
		}
		
		while (menuChoice == 4) 
		{
			System.out.println("Your Heroes: ");
			attackers.partyString();
         
			System.out.println("The Villains: ");
			defenders.partyString();
         
			if(GM.getGameMode() == 910)
				menuChoice = menu(currentAttacker);
			else
				return true;
		}
		
		if( menuChoice == 5)
		{
			GM.callEvent(960);
			menuChoice = menu(currentAttacker);
		}
          
		advanceTurnOrder(attackers, defenders);
      	return false;
	}

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