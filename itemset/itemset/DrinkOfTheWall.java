// Brad Howard
// OCP Item

package itemset;

import interfaces.IItem;

public class DrinkOfTheWall implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 0;
	
	public DrinkOfTheWall()
	{
		ID = 27;
		effect = 5.0;
		eventID = 210;
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
		return "Drink of the Wall";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "Making Dungeon great again";
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