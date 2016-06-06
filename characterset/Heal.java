//OCP
//Heal

package characterset;

import interfaces.ICharacter;
import interfaces.IHeal;
import interfaces.IParty;

import java.util.Scanner;
import java.util.Random;

@SuppressWarnings({"resource", "unused"})
public class Heal implements IHeal
{
	private int ID;
	private int eventID;
	private int skillCost;
	private String name;
	private char range;
	
	public Heal()
	{
		ID = 1;
		eventID = 330;
		name = "Heal";
		skillCost = 2;
		range = 'Q';
	}
	
	@Override
	public String getHealName() 
	{
		return this.name;
	}

	@Override
	public void setHealName(String healName) 
	{
		this.name = healName;
	}

	@Override
	public char getRange() 
	{
		return this.range;
	}

	@Override
	public int getID() 
	{
		return this.ID;
	}

	@Override
	public int getEventID() 
	{
		return this.eventID;
	}

	@Override
	public int getSkillCost() 
	{
		return this.skillCost;
	}

	@Override
	public void toHeal(ICharacter hero, ICharacter healThisGuy) 
	{
		int healAmt, curHP;
		Random gen = new Random();
		Scanner user = new Scanner(System.in);

		healAmt = Math.abs(gen.nextInt(hero.getHealMax()) - hero.getHealMin()) + 1 + hero.getHealMin();

		curHP = healThisGuy.getHP();
		healThisGuy.setHP(curHP + healAmt);
	
		System.out.println("Your " + getHealName() + " healed your " + healThisGuy.getName() + " for " + healAmt + "hp");
		System.out.println(healThisGuy.getName() + " now has " + healThisGuy.getHP() + "hp");
	
		hero.setSP(hero.getSP()- this.getSkillCost());
		/*
		int healAmt, curHP;
		Random gen = new Random();
		Scanner user = new Scanner(System.in);

		healAmt = Math.abs(gen.nextInt(hero.getHealMax()) - hero.getHealMin()) + 1 + hero.getHealMin();

		curHP = healThisGuy.getHP();
		healThisGuy.setHP(curHP + healAmt);
	
		System.out.println("Your " + getHealName() + " healed your " + healThisGuy.getName() + " for " + healAmt + "hp");
		System.out.println(healThisGuy.getName() + " now has " + healThisGuy.getHP() + "hp");
		*/
		
		
		
	}
}