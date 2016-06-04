// Brad Howard
// OCP Prefix System

package weaponset;

import interfaces.IPrefix;
import interfaces.IWeapon;

public abstract class PrefixSystem implements IWeapon, IPrefix
{
	protected IWeapon weapon;
}