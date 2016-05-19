// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DrinkOfTheMind implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DrinkOfTheMind()
	{
		ID = 26;
		effect = 5.0;
		eventID = 230;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return "Drink of the Mind";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "E = Mc^2, or Magic something";
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