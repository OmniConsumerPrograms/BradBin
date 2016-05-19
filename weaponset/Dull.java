// Brad Howard
// OCP weapon prefix

package weaponset;

import interfaces.IWeapon;

public class Dull extends PrefixSystem
{
	private int prefixID = 1;
	private double effectBoost = -10.0;
	
	public Dull(IWeapon weapon)
	{
		super.weapon = weapon;
	}

	public int getID()
	{
		return weapon.getID();
	}

	public String getName()
	{
		return "Dull " + weapon.getName();
	}

	public int getEventID()
	{
		return prefixID + weapon.getEventID();
	}

	public String getAttackType()
	{
		return "a dull " + weapon.getAttackType();
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
		return weapon.getDurability();
	}

	public double getWeight()
	{
		return weapon.getWeight();
	}

	public double getValue()
	{
		return weapon.getValue() * ((100.0 + (effectBoost * 2.0)) / 100);
	}

	public int getTier()
	{
		return weapon.getTier();
	}
	
	public void setTier(int tier)
	{
		weapon.setTier(tier);
	}

	public int getAttack()
	{
		return (int)(weapon.getAttack() * ((100.0 + effectBoost)) / 100);
	}
	
	public int getPFLimit()
	{
		return 1 - weapon.getPFLimit();
	}

}
