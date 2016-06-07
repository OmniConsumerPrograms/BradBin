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
		if(ID >= 0 && ID < size())
			return itemList.get(ID);
		
		return new NilEquipment(1);
	}
	
	public IEquipment remove(int ID)
	{
		return itemList.remove(ID);
	}
	
	public IEquipment replace(IEquipment item, int ID)
	{
		return itemList.set(ID, item);
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
