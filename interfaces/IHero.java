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
	
	public void setEquipment(IEquipment equipment, int index);
	
	public IEquipment getEquipment(int index);
	
	public void setWeapon(IWeapon weapon);
	
	public IWeapon getWeapon();
}