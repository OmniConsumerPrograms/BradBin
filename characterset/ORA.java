package characterset;

import java.util.Random;

import interfaces.IAttack;
import interfaces.ICharacter;

public class ORA implements IAttack
{
	private int ID;
	private int eventID;
	private int skillCost;
	private String name;
	private char range;
	
	public ORA()
	{
		ID = 3;
		eventID = 330;
		name = "ORA ORA ORA";
		skillCost = 16;
		range = 'Q';
	}
	
	public String getAttackName()
	{
		return name;
	}

	public void setAttackName(String attackName)
	{
		name = attackName;
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public char getRange()
	{
		return range;
	}
	
	public int getSkillCost()
	{
		return skillCost;
	}

	public void toAttack(ICharacter hero, ICharacter villain)
	{
		int damage;
		Random r = new Random();
		boolean test = validAttack(hero, r);
		
		if(test)
		{
			damage = (hero.getAttackMin() + r.nextInt(hero.getAttackMax())) * 5;
			villain.setHP(villain.getHP() - damage);
			
			System.out.println(hero.getName() + "'s " + getAttackName() + " hit " + villain.getName() + " for " + damage + "hp.");
			System.out.println(villain.getName() + " has " + villain.getHP() + "hp.");
		}
		else
		{
			System.out.println(hero.getName() + " missed!");
			System.out.println(villain.getName() + " has " + villain.getHP() + "hp.");
		}
	}

	public boolean validAttack(ICharacter hero, Random gen)
	{
		boolean test = false;
		double hit = Math.abs(gen.nextDouble()) % (100) + 1;
		
		if(hit <= hero.getAccuracy())
			test = true;
		
		return test;
	}
}