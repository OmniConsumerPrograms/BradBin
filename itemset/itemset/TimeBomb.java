// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class TimeBomb implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public TimeBomb()
	{
		ID = 32;
		effect = 1.0;
		eventID = 510;
	}
	
	public String getType()
	{
		return "Item";
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Time Bomb";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "It's time to stop!";
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