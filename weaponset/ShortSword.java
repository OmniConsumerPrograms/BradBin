// Brad Howard
// OCP Weapon Short Sword

package weaponset;

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
		attack = (int)(6 + (2 - (1 / Math.log(tier + 1))));
		durability = 10;
		speed = (int)(20.0 * (2 - (1 / Math.log(tier + 1))));
		accuracy = 100.0;
		weight = 4;
		value = 25 * tier;
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
		return "Short Sword";
	}
	
	public String getAttackType()
	{
		return "Its Sharp as broken arrow";
	}

	public int getID()
	{
		return ID;
	}
}
