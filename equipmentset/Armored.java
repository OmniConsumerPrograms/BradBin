// Brad Howard
// OCP equipment prefix

package equipmentset;

import interfaces.IEquipment;

public class Armored extends PrefixSystem
{
	private int prefixID = 2;
	private double effectBoost = 30.0;
	
	public Armored(IEquipment equipment)
	{
		super.equipment = equipment;
	}
	
	public String getType()
	{
		return "Equipment";
	}
	
	public int getPrefixID()
	{
		return prefixID;
	}
	
	public int getID()
	{
		return equipment.getID();
	}

	public String getName()
	{
		return "Armored " + equipment.getName();
	}

	public String getEquipmentType()
	{
		return equipment.getEquipmentType() + " with more armor";
	}

	public int getEventID()
	{
		return 1 + equipment.getEventID();
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
