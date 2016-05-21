// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DrinkOfTheGods implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DrinkOfTheGods()
	{
		ID = 38;
		effect = 10.0;
		eventID = 274;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Drink of the Gods";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "Its more than just a simple drink";
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