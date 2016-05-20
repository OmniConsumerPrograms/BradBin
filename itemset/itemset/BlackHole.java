// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class BlackHole implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public BlackHole()
	{
		ID = 40;
		effect = 1.0;
		eventID = 560;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Black hole in a bottle";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "This is what you get when you divide by 0";
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