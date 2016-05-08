// Brad Howard
// OCP potion

package itemset;

public class Potion implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 1;
	
	public Potion()
	{
		ID = 1;
		effect = 10.0;
		eventID = 100;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Potion";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "Healing HP";
	}
	
	public double getEffect()
	{
		return effect;
	}
	
	public int getPFLimit()
	{
		return prefixLimit;
	}
} 