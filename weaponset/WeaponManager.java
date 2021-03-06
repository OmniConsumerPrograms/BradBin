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
		if(ID >= 0 && ID < size())
			return itemList.get(ID);
		
		return new BareHands(1);
	}
	
	public IWeapon remove(int ID)
	{
		return itemList.remove(ID);
	}
	
	public IWeapon replace(IWeapon item, int ID)
	{
		return itemList.set(ID, item);
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
