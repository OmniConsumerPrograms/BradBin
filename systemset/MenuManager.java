// Brad Howard
// OCP Menu Manager

package systemset;

import java.util.*;
import interfaces.IManager;
import interfaces.IMenuSystem;

public class MenuManager implements IManager<IMenuSystem>
{
	private ArrayList<IMenuSystem> menuSet;
	
	public MenuManager()
	{
		menuSet = new ArrayList<IMenuSystem>();
	}

	public int size()
	{
		return menuSet.size();
	}	

	public void set(IMenuSystem ms)
	{
		menuSet.add(ms);		
	}

	public IMenuSystem get(int ID)
	{
		return menuSet.get(ID);
	}
	
	public IMenuSystem remove(int ID)
	{
		return menuSet.remove(ID);
	}
	
	public void replace(IMenuSystem ms, int ID)
	{
		menuSet.set(ID, ms);
	}

	public boolean has(IMenuSystem ms)
	{
		return menuSet.contains(ms);
	}

	public int indexOf(IMenuSystem ms)
	{
		return menuSet.indexOf(ms);
	}
}
