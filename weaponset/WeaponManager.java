// Brad Howard
// OCP Weapon Manager

package weaponset;

import java.util.*;

public class WeaponManager implements IManager<IWeapon>
{
	private ArrayList<IWeapon> itemList;
	
	public WeaponManager()
	{
		itemList = new ArrayList<IWeapon>();
	}
	
	public void set(IWeapon weapon)
	{
		itemList.add(weapon);
	}
	
	public IWeapon get(int ID)
	{
		return itemList.get(ID);
	}
	
	public boolean has(IWeapon item)
	{
		if(itemList.contains(item))
			return true;
		
		return false;
	}
	
	public int indexOf(IWeapon item)
	{
		return itemList.indexOf(item);
	}
}
