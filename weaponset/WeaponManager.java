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
		return itemList.size();
	}
	
	public void set(IWeapon weapon)
	{
		itemList.add(weapon);
	}
	
	public IWeapon get(int ID)
	{
		return itemList.get(ID);
	}
	
	public IWeapon remove(int ID)
	{
		return itemList.remove(ID);
	}
	
	public void replace(IWeapon item, int ID)
	{
		itemList.set(ID, item);
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
