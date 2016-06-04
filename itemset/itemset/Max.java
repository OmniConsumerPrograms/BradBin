// Brad Howard
// OCP item object

package itemset;

import interfaces.IItem;

public class Max extends PrefixSystem
{
	private int prefixID = 3;
	private double effectBoost = 10.0;
	
	public Max(IItem item)
	{
		super.item = item;
	}
	
	public int getPrefixID()
	{
		return prefixID;
	}
	
	public String getType()
	{
		return "Item";
	}
	
	public int getID()
	{
		return prefixID + item.getID();
	}
	
	public double getEffect()
	{
		return effectBoost * item.getEffect();
	}
	
	public String getName()
	{
		return "Max " + item.getName();
	}
	
	public int getEventID()
	{
		return 1 + item.getEventID();
	}
	
	public String getEffectType()
	{
		return item.getEffectType() + " to the MAX!";
	}
	
	public int getPFLimit()
	{
		return 1 - item.getPFLimit();
	}
}