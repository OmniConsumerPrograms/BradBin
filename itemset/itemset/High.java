// Brad Howard
// OCP item object

package itemset;

import interfaces.IItem;

public class High extends PrefixSystem
{
	private int prefixID = 2;
	private double effectBoost = 5.0;
	
	public High(IItem item)
	{
		super.item = item;
	}
	
	public int getPrefixID()
	{
		return prefixID;
	}
	
	public int getID()
	{
		return prefixID + item.getID();
	}
	
	public String getType()
	{
		return "Item";
	}
	
	public double getEffect()
	{
		return effectBoost * item.getEffect();
	}
	
	public String getName()
	{
		return "High " + item.getName();
	}
	
	public int getEventID()
	{
		return 1 + item.getEventID();
	}
	
	public String getEffectType()
	{
		return "More of " + item.getEffectType();
	}
	
	public int getPFLimit()
	{
		return 1 - item.getPFLimit();
	}
}