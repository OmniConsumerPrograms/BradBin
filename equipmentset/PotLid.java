// Brad Howard
// OCP Equipment

package equipmentset;

public class PotLid implements IEquipment
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
	
	public PotLid(int tier)
	{
		ID = 3;
		eventID = 210;
		speed = 1;
		weight = 5;
		value = 10.0;
		physicalDefense = 6;
		magicalDefense = 2;
		durability = 8;
		this.tier = tier;
		pfLimit = 1;
	}
	
	public String getName()
	{
		return "Pot Lid";
	}
	
	public String getType()
	{
		return "Came from a large pot of stuff";
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