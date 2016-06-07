package characterset;

import interfaces.ICharacter;
import interfaces.IHero;
import interfaces.IParty;
import interfaces.IVillain;
import systemset.Gamemaster;

import java.util.*;

@SuppressWarnings({"resource", "unused"})
public class HeroTurn extends BattleTurn
{
	protected Random randomGenerator = new Random();
	
	public HeroTurn(Gamemaster GM)
	{
		super(GM);
	}
	
	public int chooseAttack(ICharacter curAttacker)
   	{
   		int choice = -1;
   		boolean done = false;
   		IHero hero = (IHero)curAttacker;
		Scanner user = new Scanner(System.in);
   		
   		System.out.println("\nChoose an attack: ");
   		hero.attackListString();      
   		
   		do 
   		{
   			try 
   			{
   				choice = user.nextInt() - 1;
   			} 
   			catch (InputMismatchException e) 
   			{
   				user.nextLine();
   				System.out.println("\nPlease enter a number from the list to choose an attack.");
   			}
   		}
   		while (curAttacker.validAttackChoice(choice) == false); 
      
   		return choice;
   	}
   	
   	public int chooseHeal( ICharacter curAttacker )
   	{
   		int choice = -1;
   		boolean done = false;
   		IHero hero = (IHero)curAttacker;
   		Scanner user = new Scanner(System.in);
   		
   		System.out.println("\nChoose a heal: ");
   		hero.healListString();      
      
   		do 
   		{
   			try 
   			{
   				choice = user.nextInt() - 1;
   			} 
   			catch (InputMismatchException e) 
   			{
   				user.nextLine();
   				System.out.println("\nPlease enter a number from the list to choose an attack.");
   			}
   		}
   		while (curAttacker.validAttackChoice(choice) == false); 
      
   		return choice;
   	}
   	
   public int chooseEnemy(IParty enemies)
   {
	  int choice = -1;
      Scanner user = new Scanner(System.in);      
      do 
      {
         System.out.println("\nWho would you like to attack?");
         enemies.partyString();
               
         try 
         {
   		  choice = user.nextInt();
         } catch (InputMismatchException e) 
         {
            user.nextLine();
            
            System.out.println("\nPlease enter a number from the list of bad guys.");
         }
      }
      while (choice < 1 || choice > enemies.size());
            
      return choice - 1;
   }

   public int chooseAlly(IParty allies)
   {
	  int choice = -1;
      Scanner user = new Scanner(System.in);      
      do 
      {
         System.out.println("\nWho would you like to heal?");
         allies.partyString();
               
         try 
         {
   		  choice = user.nextInt();
         } catch (InputMismatchException e) 
         {
            user.nextLine();
            
            System.out.println("\nPlease enter a number from the list of heroes.");
         }
      }
      while (choice < 1 || choice > allies.size());
            
      return choice - 1;
   }
   
   public int menu(ICharacter hero)
   {
	   int choice = 0;
	   boolean done = false;
	   Scanner user = new Scanner(System.in);
	         
	   while (done == false && choice < 1 && choice > 3);          
	   {
		   System.out.println("\n" + hero.getName() + "s turn. Make a selection");    
		   System.out.println("1. Attack  \n2. Heal \n3. Use Item  \n4. Party Stats\n5. Pause");
		   try 
		   {
			   choice = user.nextInt();
			   if( choice >= 1 && choice <= 5 )
				   ;//done = true;
			   else
				   System.out.println( "***Invalid entry, please try again***" );              
		   } 
		   catch (InputMismatchException e) 
		   {
			   System.out.println("***Invalid entry, please try again***");
		   }
	   }
	   return choice;
   }
   
   public void checkDefenderLife(ICharacter currentAttacker, IParty defenders, ICharacter currentDefender, int currentDefendersPos)
   {
      if (currentDefender.isAlive() == false) 
      {
         System.out.println("\n" + currentAttacker.getName() + " defeated " + currentDefender.getName() + "!\n");          
         IVillain defender = (IVillain)currentDefender;
         int gainedXP = defender.getXP();         
         IHero attacker = (IHero)currentAttacker;         
         attacker.setXP(attacker.getXP() +gainedXP); 
         System.out.println();
         attacker.levelUp();          
         defenders.removeChar(currentDefendersPos);                           
      }  
   }  
}