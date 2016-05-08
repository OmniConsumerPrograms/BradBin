// Brad Howard
// OCP item object

package itemset;

public class Mid extends PrefixSystem
{
	private int prefixID = 1;
	private double effectBoost = 2.0;
	
	public Mid(IItem item)
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
		return "Mid " + item.getName();
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