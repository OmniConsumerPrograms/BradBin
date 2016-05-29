// Brad Howard
// OCP Weapon ButterKnife

package weaponset;

import interfaces.IWeapon;

public class BareHands implements IWeapon
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
	
	public BareHands(int tier)
	{
		ID = 0;
		range = 'S';
		eventID = 300;
		this.tier = tier;
		attack = 0;
		durability = 100;
		speed = 0;
		accuracy = 100.0;
		weight = 0;
		value = 0;
		pfLimit = 0;
	}
	
	public String getType()
	{
		return "Weapon";
	}

	public String getName()
	{
		return "Bare Hands";
	}
	
	public String getAttackType()
	{
		return "Only a fool trusts his life to a weapon!";
	}

	public int getAttack()
	{
		return attack;
	}
	
	public int getSpeed()
	{
		return speed;
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