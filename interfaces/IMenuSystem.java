// Brad Howard
// OCP Menu Systems

package interfaces;

import systemset.Gamemaster;

public interface IMenuSystem
{
	public String menuType();
	
	public int runMenu(Gamemaster GM);
}
