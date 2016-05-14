// Brad Howard
// OCP Equipment

package equipmentset;

public class IronGauntlet implements IEquipment
{
	private int ID;
	private int eventID;
	private int speed;
	private double weight;
	private double value;
	private int tier;
	private int physicalDefense;
	private int magicalDefense;
	private int durability;
	private int pfLimit;
	
	public IronGauntlet(int tier)
	{
		ID = 10;
		eventID = 210;
		speed = 2;
		weight = 7;
		value = 42.0;
		physicalDefense = 16;
		magicalDefense = 8;
		durability = 18;
		this.tier = tier;
		pfLimit = 1;
	}
	
	public String getName()
	{
		return "Iron Gauntlet";
	}
	
	public String getType()
	{
		return "Check your HP as you go";
	}
	
	public int getID()
	{
		return ID;
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public int getDurability()
	{
		return durability;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public void setTier(int tier)
	{
		this.tier = tier;
	}
	
	public int getTier()
	{
		return tier;
	}
	
	public int getPhysicalDefense()
	{
		return (int)(physicalDefense * (2 - (1 / (double)tier)));
	}
	
	public int getMagicalDefense()
	{
		return (int)(magicalDefense * (2 - (1 / (double)tier)));
	}
	
	public int getSpeed()
	{
		return (int)(speed * (2 - (1 / (double)tier)));
	}
		
	public double getValue()
	{
		return value * tier;
	}
	
	public int getPFLimit()
	{
		return pfLimit;
	}
}
