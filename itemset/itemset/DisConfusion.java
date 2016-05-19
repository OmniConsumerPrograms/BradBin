// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DisConfusion implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DisConfusion()
	{
		ID = 24;
		effect = 1.0;
		eventID = 770;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Dis-Confusion";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "I didn't see stars, they where ducks!";
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