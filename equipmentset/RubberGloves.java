// Brad Howard
// OCP Equipment

package equipmentset;

import Interfaces.IEquipment;

public class RubberGloves implements IEquipment
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
	
	public RubberGloves(int tier)
	{
		ID = 4;
		eventID = 210;
		speed = 2;
		weight = 2;
		value = 8.0;
		physicalDefense = 3;
		magicalDefense = 8;
		durability = 8;
		this.tier = tier;
		pfLimit = 1;
	}
	
	public String getName()
	{
		return "Rubber Gloves";
	}
	
	public String getType()
	{
		return "Good for more then just cleaning";
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
