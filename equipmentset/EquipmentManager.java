// Brad Howard
// OCP Weapon Manager

package equipmentset;

import java.util.*;

import Interfaces.IEquipment;
import Interfaces.IManager;

public class EquipmentManager implements IManager<IEquipment>
{
	private ArrayList<IEquipment> itemList;
	
	public EquipmentManager()
	{
		itemList = new ArrayList<IEquipment>();
	}
	
	public int size()
	{
		return itemList.size() + 1;
	}
	
	public void set(IEquipment weapon)
	{
		itemList.add(weapon);
	}
	
	public IEquipment get(int ID)
	{
		return itemList.get(ID - 1);
	}
	
	public boolean has(IEquipment item)
	{
		if(itemList.contains(item))
			return true;
		
		return false;
	}
	
	public int indexOf(IEquipment item)
	{
		return itemList.indexOf(item);
	}
}
