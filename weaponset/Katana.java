// Brad Howard
// OCP Weapon Cross Bow

package weaponset;

import interfaces.IWeapon;

public class Katana implements IWeapon
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
	
	public Katana(int tier)
	{
		ID = 20;
		range = 'S';
		eventID = 300;
		this.tier = tier;
		attack = 25;
		durability = 22;
		speed = 40;
		accuracy = 100.0;
		weight = 7;
		value = 48;
		pfLimit = 1;
	}

	public String getName()
	{
		return "Katana";
	}
	
	public String getAttackType()
	{
		return "The spirit of the Samurai is with you";
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
