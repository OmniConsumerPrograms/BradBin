// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DisRage implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DisRage()
	{
		ID = 22;
		effect = 1.0;
		eventID = 750;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Dis-Rage";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "Cools tempers and hot coco";
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