// Brad Howard
// OCP Item Manager

package itemset;

import java.util.*;

public class ItemManager implements IManager<IItem>
{
	private ArrayList<IItem> itemList;
	
	public ItemManager()
	{
		itemList = new ArrayList<IItem>();
	}
	
	public int size()
	{
		return itemList.size() + 1;
	}
	
	public void set(IItem item)
	{
		itemList.add(item);
	}
	
	public IItem get(int ID)
	{
		return itemList.get(ID - 1);
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