package systemset;

import java.util.*;
import interfaces.IManager;
import interfaces.IUsable;
import interfaces.IBin;

@SuppressWarnings("rawtypes")
public class InventoryManager implements IManager<IBin>
{
	private ArrayList<IBin> inventory;
	private int capacity = 20;
	
	public InventoryManager()
	{
		inventory = new ArrayList<IBin>(capacity);
	}
	
	public int size()
	{
		return inventory.size();
	}
	
	@SuppressWarnings("resource")
	public void set(IBin object)
	{
		Scanner userIn = new Scanner(System.in);
		int userSelection = 0;
		
		if(size() < capacity)
		{
			inventory.add(object);
			System.out.println(((IUsable) object.get()).getName() + ": Has been placed in Inventory");
		}
		else
		{
			System.out.println("Inventory is at capacity\nDo you want to replace an Item with this one?");
			System.out.println("0: " + ((IUsable) object.get()).getName());
			
			for(int index = 0; index < size(); index++)
				System.out.println((index + 1) + ": " + ((IUsable) inventory.get(index).get()).getName());
			
			System.out.print("selection: ");
			userSelection = userIn.nextInt() - 1;
			
			if(userSelection == -1)
				System.out.println("Item " + ((IUsable) object.get()).getName() + " was discarded");
			else
			{
				IBin temp = replace(object, userSelection);
				System.out.println(((IUsable) object.get()).getName() + " has replace " + ((IUsable) temp.get()).getName());
			}
		}
	}
	
	public IBin get(int ID)
	{
		return inventory.get(ID);
	}
	
	public IBin remove(int ID)
	{		
		return inventory.remove(ID);
	}
	
	public IBin replace(IBin object, int ID)
	{
		return inventory.set(ID, object);
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
		
		System.out.println("Capacity: " + size() + "/" + capacity);
		
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
