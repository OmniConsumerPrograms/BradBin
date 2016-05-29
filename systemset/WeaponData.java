package systemset;

import interfaces.IGetData;
import interfaces.IWeapon;

public class WeaponData implements IGetData<IWeapon>
{
	public String getData(IWeapon weapon)
	{
		String s = "";
		
		s += weapon.getName() + "\n";
		s += weapon.getAttackType() + "\n";
		s += "Level: " + weapon.getTier() + "\n";
		s += "Attack: " + weapon.getAttack() + " : Accuracy: " + weapon.getAccuracy() + "\n";
		s += "Speed: " + weapon.getSpeed() + " : Durability: " + weapon.getDurability() + "\n";
		s += "Weight: " + weapon.getWeight() + " : Value: " + weapon.getValue() + "\n";
		
		return s;
	}
}
