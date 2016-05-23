package systemset;

import java.util.*;
import interfaces.IManager;
import interfaces.IBin;

@SuppressWarnings("rawtypes")
public class InventoryManager implements IManager<IBin>
{
	private ArrayList<IBin> inventory;
	
	public InventoryManager()
	{
		inventory = new ArrayList<IBin>();
	}
	
	public int size()
	{
		return inventory.size();
	}
	
	public void set(IBin object)
	{
		inventory.add(object);
	}
	
	public IBin get(int ID)
	{
		return inventory.get(ID);
	}
	
	public boolean has(IBin object)
	{
		if(inventory.contains(object))
			return true;
		
		return false;
	}
	
	public int indexOf(IBin object)
	{
		return inventory.indexOf(object);
	}
}
