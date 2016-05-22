// Brad Howard
// OCP Weapon Cross Bow

package weaponset;

import interfaces.IWeapon;

public class Staff implements IWeapon
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
	
	public Staff(int tier)
	{
		ID = 11;
		range = 'S';
		eventID = 300;
		this.tier = tier;
		attack = 7;
		durability = 8;
		speed = 15;
		accuracy = 90.0;
		weight = 3;
		value = 18;
		pfLimit = 1;
	}

	public String getName()
	{
		return "Staff";
	}
	
	public String getAttackType()
	{
		return "Useful for many things, not just for magic";
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
