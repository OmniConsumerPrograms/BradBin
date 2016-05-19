// Brad Howard
// OCP Weapon Short Sword

package weaponset;

import Interfaces.IWeapon;

public class ShortSword implements IWeapon
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
	
	public ShortSword(int tier)
	{
		ID = 5;
		range = 'S';
		eventID = 300;
		this.tier = tier;
		attack = 6;
		durability = 10;
		speed = 20;
		accuracy = 100.0;
		weight = 4;
		value = 25;
		pfLimit = 1;
	}
	
	public String getName()
	{
		return "Short Sword";
	}
	
	public String getAttackType()
	{
		return "Its Sharp as broken arrow";
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
