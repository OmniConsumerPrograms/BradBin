// Brad Howard
// OCP Item Manager

package itemset;

import java.util.*;

import interfaces.IItem;
import interfaces.IManager;

public class ItemManager implements IManager<IItem>
{
	private ArrayList<IItem> itemList;
	
	public ItemManager()
	{
		itemList = new ArrayList<IItem>();
	}
	
	public int size()
	{
		return itemList.size();
	}
	
	public void set(IItem item)
	{
		itemList.add(item);
	}
	
	public IItem get(int ID)
	{
		return itemList.get(ID);
	}
	
	public boolean has(IItem item)
	{
		if(itemList.contains(item))
			return true;
		
		return false;
	}
	
	public int indexOf(IItem item)
	{
		return itemList.indexOf(item);
	}
}