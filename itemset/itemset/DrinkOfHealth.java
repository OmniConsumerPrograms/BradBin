// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DrinkOfHealth implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DrinkOfHealth()
	{
		ID = 35;
		effect = 10.0;
		eventID = 110;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Drink of Health";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "Who needs pills when you got this stuff";
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