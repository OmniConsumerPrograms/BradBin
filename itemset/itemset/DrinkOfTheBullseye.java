// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DrinkOfTheBullseye implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DrinkOfTheBullseye()
	{
		ID = 30;
		effect = 5.0;
		eventID = 264;
	}
	
	public String getType()
	{
		return "Item";
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Drink of the Bullseye";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "Bullseye never miss";
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