// Brad Howard
// OCP Elixir

package itemset;

import interfaces.IItem;

public class Elixir implements IItem
{
	private int ID;
	private double effect;
	private int eventID;
	private int prefixLimit = 1;
	
	public Elixir()
	{
		ID = 5;
		effect = 10.0;
		eventID = 140;
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
		return "Elixir";
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public String getEffectType()
	{
		return "A drink of the Soul";
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