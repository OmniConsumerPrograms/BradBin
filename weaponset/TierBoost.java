// Brad Howard
// OCP weapon prefix

package weaponset;

public class TierBoost extends PrefixSystem
{
	private int prefixID = 0;
	private int tier;
	
	public TierBoost(IWeapon weapon, int tier)
	{
		super.weapon = weapon;
		this.tier = tier;
	}

	public int getID()
	{
		return prefixID + weapon.getID();
	}

	public String getName()
	{
		return weapon.getName();
	}

	public int getEventID()
	{
		return weapon.getEventID();
	}

	public String getAttackType()
	{
		return weapon.getAttackType();
	}

	public char getRange()
	{
		return weapon.getRange();
	}

	public int getSpeed()
	{
		return (int)(weapon.getSpeed() + (5 - (1 / Math.log(tier + 1))));
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
		return tier * weapon.getValue();
	}

	public int getTier()
	{
		return tier + weapon.getTier();
	}

	public int getAttack()
	{
		return (int)(weapon.getAttack() != 0 ? weapon.getAttack() + (5 - (1 / Math.log(tier + 1))) : 0);
	}
	
	public int getPFLimit()
	{
		return weapon.getPFLimit();
	}

}
