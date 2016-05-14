// Brad Howard
// OCP Weapon Nerf Gun

package weaponset;

public class NerfGun implements IWeapon
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
	
	public NerfGun(int tier)
	{
		ID = 4;
		range = 'L';
		eventID = 300;
		this.tier = tier;
		attack = 1;
		durability = 6;
		speed = 75;
		accuracy = 60.0;
		weight = 4;
		value = 10;
		pfLimit = 1;
	}

	public String getName()
	{
		return "Nerf Gun";
	}
	
	public String getAttackType()
	{
		return "PingZoooomStick, owww my eye!";
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
