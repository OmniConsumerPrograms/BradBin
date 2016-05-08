// Brad Howard
// OCP item object

package itemset;

public class High extends PrefixSystem
{
	private int prefixID = 2;
	private double effectBoost = 5.0;
	
	public High(IItem item)
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
		return "High " + item.getName();
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