// Brad Howard
// OCP weapon prefix

package weaponset;

import interfaces.IWeapon;

public class Godly extends PrefixSystem
{
	private int prefixID = 6;
	private double effectBoost = 777.777;
	
	public Godly(IWeapon weapon)
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
		return "Godly " + weapon.getName();
	}

	public int getEventID()
	{
		return 1 + weapon.getEventID();
	}

	public String getAttackType()
	{
		return "Godly + " + weapon.getAttackType() + " + boosters + ??? = profit";
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
		return (int)(weapon.getDurability() + effectBoost);
	}

	public double getWeight()
	{
		return weapon.getWeight() / 7.7;
	}

	public double getValue()
	{
		return weapon.getValue() * effectBoost * 11;
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
		return (int)(weapon.getAttack() * effectBoost);
	}
	
	public int getPFLimit()
	{
		return 1 - weapon.getPFLimit();
	}

}
