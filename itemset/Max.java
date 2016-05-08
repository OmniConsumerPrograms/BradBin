// Brad Howard
// OCP item object

package itemset;

public class Max extends PrefixSystem
{
	private int prefixID = 3;
	private double effectBoost = 10.0;
	
	public Max(IItem item)
	{
		super.item = item;
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
		return item.getEffectType();
	}
	
	public int getPFLimit()
	{
		return 1 - item.getPFLimit();
	}
}