// Brad Howard
// OCP Equipment

package equipmentset;

import interfaces.IEquipment;

public class PhasedCloak implements IEquipment
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
	
	public PhasedCloak(int tier)
	{
		ID = 29;
		eventID = 210;
		speed = 6;
		weight = 8;
		value = 700.0;
		physicalDefense = 50;
		magicalDefense = 90;
		durability = 50;
		this.tier = tier;
		pfLimit = 1;
	}
	
	public String getType()
	{
		return "Equipment";
	}
	
	public String getName()
	{
		return "Phased Cloak";
	}
	
	public String getEquipmentType()
	{
		return "Where are you?";
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
