// Brad Howard
// OCP Prefix System

package equipmentset;

import interfaces.IEquipment;
import interfaces.IPrefix;

public abstract class PrefixSystem implements IEquipment, IPrefix
{
	protected IEquipment equipment;
}