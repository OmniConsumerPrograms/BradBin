// Brad Howard
// OCP item object

package itemset;

public class Low extends PrefixSystem
{
	private int prefixID = 0;
	private double effectBoost = 1.0;
	
	public Low(IItem item)
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
		return "Low " + item.getName();
	}
	
	public int getEventID()
	{
		return 0 + item.getEventID();
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