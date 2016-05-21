// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DrinkOfTheRealm implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DrinkOfTheRealm()
	{
		ID = 29;
		effect = 5.0;
		eventID = 244;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Drink of the Realm";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "The Realm is forever";
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