// Brad Howard
// OCP weapon prefix

package weaponset;

import interfaces.IWeapon;

public class Awful extends PrefixSystem
{
	private int prefixID = 2;
	private double effectBoost = -5.0;
	
	public Awful(IWeapon weapon)
	{
		super.weapon = weapon;
	}
	
	public String getType()
	{
		return "Weapon";
	}
	
	public int getPrefixID()
	{
		return prefixID;
	}

	public int getID()
	{
		return weapon.getID();
	}

	public String getName()
	{
		return "Awful " + weapon.getName();
	}

	public int getEventID()
	{
		return 1 + weapon.getEventID();
	}

	public String getAttackType()
	{
		return "Less than " + weapon.getAttackType();
	}

	public char getRange()
	{
		return weapon.getRange();
	}

	public int getSpeed()
	{
		return (int)(weapon.getSpeed() * (1 + (effectBoost / 100)));
	}

	public double getAccuracy()
	{
		return (int)(weapon.getAccuracy() * (1 + (effectBoost / 100)));
	}

	public int getDurability()
	{
		return (int)(weapon.getDurability() + (effectBoost / 10));
	}

	public double getWeight()
	{
		return weapon.getWeight();
	}

	public double getValue()
	{
		return weapon.getValue() * (1 + (effectBoost / 100));
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
		return (int)(weapon.getAttack() * (1 + (effectBoost / 100)));
	}
	
	public int getPFLimit()
	{
		return 1 - weapon.getPFLimit();
	}

}
