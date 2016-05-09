// Brad Howard
// OCP weapon prefix

package weaponset;

public class Busted extends PrefixSystem
{
	private int prefixID = 1;
	private double effectBoost = -100.0;
	
	public Busted(IWeapon weapon)
	{
		super.weapon = weapon;
	}

	public int getID()
	{
		return weapon.getID();
	}

	public String getName()
	{
		return "Busted " + weapon.getName();
	}

	public int getEventID()
	{
		return prefixID + weapon.getEventID();
	}

	public String getAttackType()
	{
		return "Its no used";
	}

	public char getRange()
	{
		return weapon.getRange();
	}

	public int getSpeed()
	{
		return weapon.getSpeed();
	}

	public double getAccuracy()
	{
		return weapon.getAccuracy();
	}

	public int getDurability()
	{
		return weapon.getDurability() * 0;
	}

	public double getWeight()
	{
		return weapon.getWeight();
	}

	public double getValue()
	{
		return weapon.getValue() * ((100.0 + (effectBoost / 2.0)) / 100);
	}

	public int getTier()
	{
		return weapon.getTier();
	}

	public int getAttack()
	{
		return weapon.getAttack() * 0;
	}
	
	public int getPFLimit()
	{
		return 1 - weapon.getPFLimit();
	}

}
