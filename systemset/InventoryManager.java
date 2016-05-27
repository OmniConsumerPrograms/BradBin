package systemset;

import java.util.*;
import interfaces.IManager;
import interfaces.IUsable;
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
	
	public IBin remove(int ID)
	{		
		return inventory.remove(ID);
	}
	
	public void replace(IBin object, int ID)
	{
		inventory.set(ID, object);
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
	
	@Override
	public String toString()
	{
		String s = "";
		int l = 1;
		
		for(int index = 0; index < inventory.size(); index++)
		{
			if(l % 3 != 0)
				s += l + ": " + ((IUsable) inventory.get(index).get()).getName() + " : ";
			else
				s += l + ": " + ((IUsable) inventory.get(index).get()).getName() + "\n";
			l++;
		}
		
		return s;
	}
}
