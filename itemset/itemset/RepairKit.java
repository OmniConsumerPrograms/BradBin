// Brad Howard
// OCP Elixir

package itemset;

import interfaces.IItem;

public class RepairKit implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 1;
	
	public RepairKit()
	{
		ID = 17;
		effect = 10.0;
		eventID = 600;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Repair Kit";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "A good set of spare parts";
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