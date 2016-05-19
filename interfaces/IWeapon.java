// Brad Howard
// OCP Weapon Interface

package interfaces;

public interface IWeapon
{
	public int getID();
	
	public String getName();
	
	public int getEventID();
	
	public String getAttackType();
	
	public char getRange();
	
	public int getSpeed();
	
	public double getAccuracy();
	
	public int getDurability();
	
	public double getWeight();
	
	public double getValue();
	
	public void setTier(int tier);
	
	public int getTier();
	
	public int getAttack();
	
	public int getPFLimit();
}