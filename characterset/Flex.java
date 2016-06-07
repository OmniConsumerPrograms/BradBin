package characterset;

import java.util.Random;

import interfaces.IHeal;
import interfaces.ICharacter;

public class Flex implements IHeal
{
	private int ID;
	private int eventID;
	private int skillCost;
	private String name;
	private char range;
	
	public Flex()
	{
		ID = 1;
		eventID = 330;
		name = "Flex";
		skillCost = 2;
		range = 'Q';
	}
	
	public String getHealName()
	{
		return name;
	}

	public void setHealName(String attackName)
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

	public void toHeal(ICharacter hero, ICharacter healThisGuy)
	{
		int healAmt, curHP;
		Random gen = new Random();

		healAmt = Math.abs(gen.nextInt(hero.getHealMax()) - hero.getHealMin()) + 1 + hero.getHealMin();

		curHP = healThisGuy.getHP();
		curHP += healAmt;
		
		if(curHP > healThisGuy.getHPMax())
			healThisGuy.setHP(healThisGuy.getHPMax());
		else
			healThisGuy.setHP(curHP);
	
		System.out.println("Your " + getHealName() + " healed your " + healThisGuy.getName() + " for " + healAmt + "hp");
		System.out.println(healThisGuy.getName() + " now has " + healThisGuy.getHP() + "hp");
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
