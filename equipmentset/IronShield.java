// Brad Howard
// OCP Equipment

package equipmentset;

import interfaces.IEquipment;

public class IronShield implements IEquipment
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
	
	public IronShield(int tier)
	{
		ID = 11;
		eventID = 210;
		speed = 1;
		weight = 12;
		value = 48.0;
		physicalDefense = 22;
		magicalDefense = 10;
		durability = 20;
		this.tier = tier;
		pfLimit = 1;
	}
	
	public String getType()
	{
		return "Equipment";
	}
	
	public String getName()
	{
		return "Iron Shield";
	}
	
	public String getEquipmentType()
	{
		return "Shield of Iron and Iron of Shields";
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
