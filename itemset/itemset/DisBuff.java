// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DisBuff implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DisBuff()
	{
		ID = 34;
		effect = 1.0;
		eventID = 530;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Dis-Buff";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "I didn't sign off on those buffs";
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