// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DrinkOfTheBody implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DrinkOfTheBody()
	{
		ID = 37;
		effect = 15.0;
		eventID = 120;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Drink of the Body";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "Just two a day and you too can be a buff as me";
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