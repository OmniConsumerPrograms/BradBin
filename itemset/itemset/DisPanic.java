// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DisPanic implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DisPanic()
	{
		ID = 23;
		effect = 1.0;
		eventID = 760;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Dis-Panic";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "No need to panic, I got this";
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