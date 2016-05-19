// Brad Howard
// OCP Item

package itemset;

import Interfaces.IItem;

public class DisPoison implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DisPoison()
	{
		ID = 21;
		effect = 1.0;
		eventID = 740;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Dis-Poison";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "Helps when nothing else will";
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