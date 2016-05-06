// Brad Howard
// OCP Weapon ButterKnife

package weaponset;

public class ButterKnife implements IWeapon
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
	
	public ButterKnife(int tier)
	{
		ID = 1;
		range = 'S';
		eventID = 305;
		this.tier = tier;
		attack = 1;
		durability = 3;
		speed = (int)(50.0 * (2 - (1 / Math.log(tier))));;
		accuracy = 100.0;
		weight = 1;
		pfLimit = 0;
	}

	public int getAttack()
	{
		return attack;
	}
	
	public int getTier()
	{
		return tier;
	}
	
	public int getPFLimit()
	{
		return pfLimit;
	}
	
	public int getSpeed()
	{
		return speed;
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
		return value;
	}
	
	public String getName()
	{
		return "Butter Knife";
	}
	
	public String getAttackType()
	{
		return "Use for Random effect!";
	}

	public int getID()
	{
		return ID;
	}
}