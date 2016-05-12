// Brad Howard
// OCP Equipment

package equipmentset;

public class MagicShirt implements IEquipment
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
	
	public MagicShirt(int tier)
	{
		ID = 2;
		eventID = 210;
		speed = 4;
		weight = 1;
		value = 5.0;
		physicalDefense = 2;
		magicalDefense = 4;
		durability = 8;
		this.tier = tier;
		pfLimit = 1;
	}
	
	public String getName()
	{
		return "Magic Shirt";
	}
	
	public String getType()
	{
		return "Does more than a Shirt";
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
		return (int)(physicalDefense * (2 - (1 / Math.log(tier + 1))));
	}
	
	public int getMagicalDefense()
	{
		return (int)(magicalDefense * (2 - (1 / Math.log(tier + 1))));
	}
	
	public int getSpeed()
	{
		return (int)(speed * (2 - (1 / Math.log(tier + 1))));
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
