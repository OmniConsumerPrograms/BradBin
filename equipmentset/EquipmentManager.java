// Brad Howard
// OCP Weapon Manager

package equipmentset;

import java.util.*;

import interfaces.IEquipment;
import interfaces.IManager;

public class EquipmentManager implements IManager<IEquipment>
{
	private ArrayList<IEquipment> itemList;
	
	public EquipmentManager()
	{
		itemList = new ArrayList<IEquipment>();
	}
	
	public int size()
	{
		return itemList.size();
	}
	
	public void set(IEquipment weapon)
	{
		itemList.add(weapon);
	}
	
	public IEquipment get(int ID)
	{
		return itemList.get(ID);
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
