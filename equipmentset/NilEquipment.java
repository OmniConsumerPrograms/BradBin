// Brad Howard
// OCP Equipment

package equipmentset;

import interfaces.IEquipment;

public class NilEquipment implements IEquipment
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
	
	public NilEquipment(int tier)
	{
		ID = 0;
		eventID = 736;
		speed = 0;
		weight = 0;
		value = 0;
		physicalDefense = 0;
		magicalDefense = 0;
		durability = 0;
		this.tier = tier;
		pfLimit = 0;
	}
	
	public String getType()
	{
		return "Equipment";
	}
	
	public String getName()
	{
		return "";
	}
	
	public String getEquipmentType()
	{
		return "Nil Equipment";
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
