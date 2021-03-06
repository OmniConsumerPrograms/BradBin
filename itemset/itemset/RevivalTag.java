// Brad Howard
// OCP Revival tag

package itemset;

import interfaces.IItem;

public class RevivalTag implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 1;
	
	public RevivalTag()
	{
		ID = 13;
		effect = 10.0;
		eventID = 780;
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
		return "Revival Tag";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "Remove before life";
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