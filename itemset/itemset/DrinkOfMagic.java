// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DrinkOfMagic implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DrinkOfMagic()
	{
		ID = 36;
		effect = 5.0;
		eventID = 150;
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
		return "Drink of Magic";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "Just the right stuff when you are short in magic";
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