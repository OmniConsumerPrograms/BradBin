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
		attack = (int)(1 + (2 - (1 / Math.log(tier))));
		durability = 6;
		speed = (int)(75.0 * (2 - (1 / Math.log(tier))));
		accuracy = 60.0;
		weight = 4;
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
		return "Nerf Gun";
	}
	
	public String getAttackType()
	{
		return "PingZoooomStick, right in eye!";
	}

	public int getID()
	{
		return ID;
	}
}
