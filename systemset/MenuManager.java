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

	public boolean has(IMenuSystem t)
	{
		return menuSet.contains(t);
	}

	public int indexOf(IMenuSystem t)
	{
		return menuSet.indexOf(t);
	}
}
