// Brad Howard
// OCP equipment prefix

package equipmentset;

import interfaces.IEquipment;

public class Arcane extends PrefixSystem
{
	private int prefixID = 1;
	private double effectBoost = 40.0;
	
	public Arcane(IEquipment equipment)
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
		return "Arcane " + equipment.getName();
	}

	public String getEquipmentType()
	{
		return equipment.getEquipmentType() + " with a side of Arcane";
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
		return equipment.getWeight() * (1 - (effectBoost / 100));
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
		return equipment.getPhysicalDefense();
	}

	public int getMagicalDefense()
	{
		return (int)(equipment.getMagicalDefense() * (1 + (effectBoost / 100)));
	}
	
	public int getSpeed()
	{
		return (int)(equipment.getSpeed() *  (1 + (effectBoost / 100)));
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
