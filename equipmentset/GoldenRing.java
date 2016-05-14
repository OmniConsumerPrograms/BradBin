// Brad Howard
// OCP Equipment

package equipmentset;

public class GoldenRing implements IEquipment
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
	
	public GoldenRing(int tier)
	{
		ID = 5;
		eventID = 210;
		speed = 2;
		weight = 2;
		value = 12.0;
		physicalDefense = 4;
		magicalDefense = 10;
		durability = 10;
		this.tier = tier;
		pfLimit = 1;
	}
	
	public String getName()
	{
		return "Golden Ring";
	}
	
	public String getType()
	{
		return "No it will not make you invisible";
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