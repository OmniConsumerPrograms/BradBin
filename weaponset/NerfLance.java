// Brad Howard
// OCP Weapon Nerf Lance

package weaponset;

public class NerfLance implements IWeapon
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
	
	public NerfLance(int tier)
	{
		ID = 3;
		range = 'M';
		eventID = 300;
		this.tier = tier;
		attack = (int)(2 + (2 - (1 / Math.log(tier + 1))));
		durability = 4;
		speed = (int)(25.0 * (2 - (1 / Math.log(tier + 1))));
		accuracy = 80.0;
		weight = 3;
		value = 9 * tier;
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
		return "Nerf Lance";
	}
	
	public String getAttackType()
	{
		return "Frrrrrromp!";
	}

	public int getID()
	{
		return ID;
	}
}
