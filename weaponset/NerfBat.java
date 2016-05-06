// Brad Howard
// OCP Weapon Nerf Bat

package weaponset;

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
		attack = (int)(2 + (2 - (1 / Math.log(tier))));
		durability = 4;
		speed = (int)(25.0 * (2 - (1 / Math.log(tier))));
		accuracy = 100.0;
		weight = 2;
		pfLimit = 1;
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
		return "Nerf Bat";
	}
	
	public String getAttackType()
	{
		return "Bonk!";
	}

	public int getID()
	{
		return ID;
	}
}
