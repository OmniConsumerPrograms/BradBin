// Brad Howard
// OCP equipment prefix

package equipmentset;

import Interfaces.IEquipment;

public class Warding extends PrefixSystem
{
	private int prefixID = 1;
	private double effectBoost = 40.0;
	
	public Warding(IEquipment equipment)
	{
		super.equipment = equipment;
	}
	
	public int getID()
	{
		return equipment.getID();
	}

	public String getName()
	{
		return "Warding " + equipment.getName();
	}

	public String getType()
	{
		return equipment.getType() + ", now with wards";
	}

	public int getEventID()
	{
		return prefixID + equipment.getEventID();
	}

	public int getDurability()
	{
		return (int)(equipment.getDurability() + (effectBoost / 10));
	}

	public double getWeight()
	{
		return equipment.getWeight() * (1 + (effectBoost / 100));
	}

	public void setTier(int tier)
	{
		equipment.setTier(tier);
	}

	public int getTier()
	{
		return equipment.getTier();
	}

	public int getPhysicalDefense()
	{
		return (int)(equipment.getPhysicalDefense() * (1 + (effectBoost / 100)));
	}

	public int getMagicalDefense()
	{
		return equipment.getMagicalDefense();
	}
	
	public int getSpeed()
	{
		return equipment.getSpeed();
	}

	public double getValue()
	{
		return equipment.getValue() * (1 + (effectBoost / 100));
	}

	public int getPFLimit()
	{
		return 1 - equipment.getPFLimit();
	}
}
