// Brad Howard
// OCP Weapon Nerf Gun

package weaponset;

import interfaces.IWeapon;

public class EggBlaster implements IWeapon
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
	
	public EggBlaster(int tier)
	{
		ID = 29;
		range = 'L';
		eventID = 300;
		this.tier = tier;
		attack = 42;
		durability = 42;
		speed = 80;
		accuracy = 90.0;
		weight = 8;
		value = 500;
		pfLimit = 1;
	}
	
	public String getType()
	{
		return "Weapon";
	}

	public String getName()
	{
		return "Egg Blaster";
	}
	
	public String getAttackType()
	{
		return "Get a load of this!";
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
