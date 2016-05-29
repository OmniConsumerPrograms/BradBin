package systemset;

import interfaces.IGetData;
import interfaces.IEquipment;

public class EquipmentData implements IGetData<IEquipment>
{
	public String getData(IEquipment equipment)
	{
		String s = "";
		
		s += equipment.getName() + "\n";
		s += equipment.getEquipmentType() + "\n";
		s += "Level: " + equipment.getTier() + "\n";
		s += "Physical Defense: " + equipment.getPhysicalDefense() + " : Magical Defense: " + equipment.getMagicalDefense() + "\n";
		s += "Speed: " + equipment.getSpeed() + " : Durability: " + equipment.getDurability() + "\n";
		s += "Weight: " + equipment.getWeight() + " : Value: " + equipment.getValue() + "\n";
		
		return s;
	}
}
