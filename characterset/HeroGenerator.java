//OCP
//Hero Generator

package characterset;

import interfaces.IAttack;
import interfaces.IHero;
import interfaces.IHeroGenerator;
import interfaces.IParty;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import characterset.Druid;
import characterset.Hunter;
import characterset.Mage;
import characterset.Paladin;
import characterset.Priest;
import characterset.Rogue;
import characterset.Shaman;
import characterset.Warrior;

@SuppressWarnings("resource")
public class HeroGenerator implements IHeroGenerator
{
	private ArrayList<IHero> heroes;
	
	public HeroGenerator() 
	{
		heroes = new ArrayList<IHero>();
	      
		IHero tempChar;
	      
		tempChar = new Hunter(new ArrayList<IAttack>());
			heroes.add(tempChar);
	      
		tempChar = new Rogue(new ArrayList<IAttack>());
			heroes.add(tempChar);
	      	
		tempChar = new Priest(new ArrayList<IAttack>());
			heroes.add(tempChar);
	      
		tempChar = new Warrior(new ArrayList<IAttack>());
			heroes.add(tempChar);	      
		
		tempChar = new Druid(new ArrayList<IAttack>());
			heroes.add(tempChar);
		
		tempChar = new Paladin(new ArrayList<IAttack>());
			heroes.add(tempChar);
	      
		tempChar = new Mage(new ArrayList<IAttack>());
			heroes.add(tempChar);
		
		tempChar = new Shaman(new ArrayList<IAttack>());
			heroes.add(tempChar);
			
		tempChar = new MuscleWizard(new ArrayList<IAttack>());
			heroes.add(tempChar);
	}     
	
	public void printHero()
	{
		IHero tempChar;
		for (int i = 0; i < heroes.size(); i++)
		{
			tempChar = heroes.get(i);
			System.out.println((i + 1) + ". " + tempChar.charString());
		}   
	}
	 
	public IParty chooseHeroes()
	{  
		int count = 0, partySize = 0;
		boolean done = false;
		Scanner user = new Scanner(System.in);
		IParty heroes = new Party();
	      
		while( done == false )
		{  
			try
			{
				System.out.println( "How many Heroes would you like in your party?" );
	            System.out.println( "You can have 4 to 8 Heroes" );
	            System.out.println( "Party Size: " );   
	            partySize = user.nextInt();
	            if( partySize >= 4 && partySize <= 8 )
	               done = true;
	            else
	               System.out.println( "***Invalid entry, please try again***" );
	         }
	         catch( InputMismatchException o )
	         {
	            System.out.println( "***Invalid entry, please try again***" );
	            user.nextLine();
	         }
		}  
	      
		while( count < partySize )
		{
			System.out.println("Please choose a member for your party:");
			printHero();
			int choice = -1;
			while (done == false && choice < 1 && choice > heroes.size());          
			{
				try 
	            {
					choice = user.nextInt();
	              
					if( choice >= 1 && choice <= 9 )
					{
						done = true;
						count++;
					}
					else
						System.out.println( "***Invalid entry, please try again***" );              
	            } 
	            catch (InputMismatchException e) 
	            {
	            	user.nextLine();     
	            	System.out.println("***Invalid entry, please try again***");
	            }
			}
			
			if (choice == 1) 
			{
				ArrayList<IAttack> skillList = new ArrayList<IAttack>();
				skillList.add(new Melee());
				heroes.addChar(new Hunter(skillList));
			}
			else if (choice == 2)
			{
				ArrayList<IAttack> skillList = new ArrayList<IAttack>();
				skillList.add(new Melee());
	        	 heroes.addChar(new Rogue(skillList));
			}
			else if (choice == 3) 
			{
				ArrayList<IAttack> skillList = new ArrayList<IAttack>();
				skillList.add(new Melee());
				heroes.addChar(new Priest(skillList));
			}
			else if (choice == 4) 
			{
				ArrayList<IAttack> skillList = new ArrayList<IAttack>();
				skillList.add(new Melee());
				heroes.addChar(new Warrior(skillList));   
			}
			else if (choice == 5) 
			{
				ArrayList<IAttack> skillList = new ArrayList<IAttack>();
				skillList.add(new Melee());
				heroes.addChar(new Druid(skillList));
			}
			else if (choice == 6) 
			{
				ArrayList<IAttack> skillList = new ArrayList<IAttack>();
				skillList.add(new Melee());
				heroes.addChar(new Paladin(skillList));
			}
			else if (choice == 7) 
			{
				ArrayList<IAttack> skillList = new ArrayList<IAttack>();
				skillList.add(new Melee());
				heroes.addChar(new Mage(skillList)); 
			}
			else if (choice == 8) 
			{	
				ArrayList<IAttack> skillList = new ArrayList<IAttack>();
				skillList.add(new Melee());
				heroes.addChar(new Shaman(skillList)); 
			}
			else if (choice == 9)
			{
				ArrayList<IAttack> skillList = new ArrayList<IAttack>();
				skillList.add(new Melee());
				heroes.addChar(new MuscleWizard(skillList));
			}
		}      
	      return (IParty) heroes; 
	}

	public IHero getHero(String name)
	{
		ArrayList<IAttack> skillList = new ArrayList<IAttack>();
		skillList.add(new Melee());
		
		if(name.equals("Hunter"))
			return new Hunter(skillList);
		else if(name.equals("Rogue"))
			return new Rogue(skillList);
		else if(name.equals("Priest"))
			return new Priest(skillList);
		else if(name.equals("Warrior"))
			return new Warrior(skillList);
		else if(name.equals("Druid"))
			return new Druid(skillList);
		else if(name.equals("Paladin"))
			return new Paladin(skillList);
		else if(name.equals("Mage"))
			return new Mage(skillList);
		else if(name.equals("Shaman"))
			return new Shaman(skillList);
		else if(name.equals("Muscle Wizard"))
			return new MuscleWizard(skillList);
		
		return new Hunter(skillList);
	}
}
