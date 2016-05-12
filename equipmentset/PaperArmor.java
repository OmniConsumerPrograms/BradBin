// Brad Howard
// OCP Equipment

package equipmentset;

public class PaperArmor implements IEquipment
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
	
	public PaperArmor(int tier)
	{
		ID = 1;
		eventID = 210;
		speed = 1;
		weight = 2;
		value = 5.0;
		physicalDefense = 3;
		magicalDefense = 2;
		durability = 5;
		this.tier = tier;
		pfLimit = 1;
	}
	
	public String getName()
	{
		return "Paper Armor";
	}
	
	public String getType()
	{
		return "It can stop a pencil";
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
