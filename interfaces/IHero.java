// OCP
// Hero interface

package interfaces;

public interface IHero extends ICharacter, ILevel
{
	public void level4Attack();
	
	public void level8Attack();
	
	public void level12Attack();
	
	public int getXP();
	
	public void setXP(int xp);
	
	public String charString();
	
	public void attackListString();
	
	public void healListString();
	
	public String skillListToString();
	
	public void setEquipment(IEquipment equipment, int index);
	
	public IEquipment getEquipment(int index);
	
	public IEquipment replaceEquipment(IEquipment equipment, int index);
	
	public void setWeapon(IWeapon weapon);
	
	public IWeapon getWeapon();
	
	public IWeapon replaceWeapon(IWeapon weapon);
}