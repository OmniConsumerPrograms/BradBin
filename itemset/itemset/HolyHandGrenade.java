// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class HolyHandGrenade implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public HolyHandGrenade()
	{
		ID = 39;
		effect = 1.0;
		eventID = 540;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Holy Hand Grenade of Antioch";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "O LORD, bless this Thy hand grenade that with it Thou mayest blow Thine enemies to tiny bits, in Thy mercy";
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