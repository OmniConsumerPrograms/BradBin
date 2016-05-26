// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class SmokeBomb implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public SmokeBomb()
	{
		ID = 31;
		effect = 1.0;
		eventID = 500;
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
		return "Smoke Bomb";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "No Ninja is complete with out a smoke bomb";
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