// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DrinkOfThePhoton implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DrinkOfThePhoton()
	{
		ID = 28;
		effect = 5.0;
		eventID = 224;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Drink of the Photon";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "C is what every I want it to be";
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