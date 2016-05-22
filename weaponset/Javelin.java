// Brad Howard
// OCP Weapon Cross Bow

package weaponset;

import interfaces.IWeapon;

public class Javelin implements IWeapon
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
	
	public Javelin(int tier)
	{
		ID = 16;
		range = 'M';
		eventID = 300;
		this.tier = tier;
		attack = 15;
		durability = 12;
		speed = 30;
		accuracy = 70.0;
		weight = 6;
		value = 38;
		pfLimit = 1;
	}

	public String getName()
	{
		return "Javelin";
	}
	
	public String getAttackType()
	{
		return "you should try the shot put as well";
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
