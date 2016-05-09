// Brad Howard
// OCP Weapon Cross Bow

package weaponset;

public class CrossBow implements IWeapon
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
	
	public CrossBow(int tier)
	{
		ID = 7;
		range = 'L';
		eventID = 300;
		this.tier = tier;
		attack = (int)(6 + (2 - (1 / Math.log(tier + 1))));
		durability = 12;
		speed = (int)(50.0 * (2 - (1 / Math.log(tier + 1))));
		accuracy = 60.0;
		weight = 6;
		value = 20 * tier;
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
		return "Cross Bow";
	}
	
	public String getAttackType()
	{
		return "Thuuack!";
	}

	public int getID()
	{
		return ID;
	}
}
