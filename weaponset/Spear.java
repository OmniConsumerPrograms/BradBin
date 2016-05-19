// Brad Howard
// OCP Weapon Spear

package weaponset;

import interfaces.IWeapon;

public class Spear implements IWeapon
{
	private int ID;
	private int eventID;
	private char range;
	private int speed;
	private double accuracy;
	private int durability;
	private double weight;
	private double value;
	private int tier;
	private int attack;
	private int pfLimit;
	
	public Spear(int tier)
	{
		ID = 6;
		range = 'M';
		eventID = 300;
		this.tier = tier;
		attack = 6;
		durability = 4;
		speed = 15;
		accuracy = 75.0;
		weight = 6;
		value = 24;
		pfLimit = 1;
	}
	
	public String getName()
	{
		return "Spear";
	}
	
	public String getAttackType()
	{
		return "SPEARED!";
	}

	public int getAttack()
	{
		return (int)(attack * (2 - (1 / (double)tier)));
	}
	
	public int getSpeed()
	{
		return (int)(speed * (2 - (1 / (double)tier)));
	}
	
	public void setTier(int tier)
	{
		this.tier = tier;
	}
	
	public int getTier()
	{
		return tier;
	}
	
	public int getPFLimit()
	{
		return pfLimit;
	}
	
	public char getRange()
	{
		return range;
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public int getDurability()
	{
		return durability;
	}
	
	public double getAccuracy()
	{
		return accuracy;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getValue()
	{
		return value * tier;
	}

	public int getID()
	{
		return ID;
	}
}
