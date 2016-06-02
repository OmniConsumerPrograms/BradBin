package systemset;

import interfaces.IGetData;
import interfaces.IHero;

public class CharacterData implements IGetData<IHero>
{
	public String getData(IHero hero)
	{
		String s = "";
				
		s += hero.getName() + "\n";
		s += "Status: " + (hero.getStatus() == 050 ? "KO" : "Normal") + "\n";
		s += "Level: " + hero.getLevel() + "\n";
		s += "HP: " + hero.getHP() + "/" + hero.getHPMax() + "\n";
		s += "SP: " + hero.getSP() + "/" + hero.getSPMax() + "\n";
		s += "Attack: " + hero.getAttackMax() + "-" + hero.getAttackMin() + "\n";
		s += "Physical Defense: " + hero.getPhyDefense() + " : Magical Defense: " + hero.getMagDefense() + "\n";
		s += "Speed: " + hero.getSpeed() +  " : Accuracy: " + hero.getAccuracy() + "\n";
		s += "Weapon: " + hero.getWeapon().getName() + "\n";
		s += "Equipment: " + hero.getEquipment(0).getName() + " : " + hero.getEquipment(1).getName()  + " : " + hero.getEquipment(2).getName()  + "\n";
		s += "Skills: \n" + hero.skillListToString() + "\n";
		
		return s;
	}
}
