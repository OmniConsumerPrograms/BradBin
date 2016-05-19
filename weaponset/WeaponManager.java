// Brad Howard
// OCP Weapon Manager

package weaponset;

import java.util.*;

import interfaces.IManager;
import interfaces.IWeapon;

public class WeaponManager implements IManager<IWeapon>
{
	private ArrayList<IWeapon> itemList;
	
	public WeaponManager()
	{
		itemList = new ArrayList<IWeapon>();
	}
	
	public int size()
	{
		return itemList.size() + 1;
	}
	
	public void set(IWeapon weapon)
	{
		itemList.add(weapon);
	}
	
	public IWeapon get(int ID)
	{
		return itemList.get(ID - 1);
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
