// Brad Howard
// OCP Weapon Nerf Bat

package weaponset;

import interfaces.IWeapon;

public class NerfBat implements IWeapon
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
	
	public NerfBat(int tier)
	{
		ID = 2;
		range = 'S';
		eventID = 300;
		this.tier = tier;
		attack = 2;
		durability = 4;
		speed = 25;
		accuracy = 100.0;
		weight = 2;
		value = 8;
		pfLimit = 1;
	}
	
	public String getType()
	{
		return "Weapon";
	}

	public String getName()
	{
		return "Nerf Bat";
	}
	
	public String getAttackType()
	{
		return "Bonk!";
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
