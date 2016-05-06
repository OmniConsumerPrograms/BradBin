// Brad Howard
// OCP Weapon Interface

package weaponset;

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
	
	public int getTier();
	
	public int getAttack();
	
	public int getPFLimit();
}