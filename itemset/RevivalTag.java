// Brad Howard
// OCP Revival tag

package itemset;

public class RevivalTag implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 1;
	
	public RevivalTag()
	{
		ID = 13;
		effect = 25.0;
		eventID = 50;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Revival Tag";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "restoring HP/MP";
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