// Brad Howard
// OCP Menu Systems

package interfaces;

import systemset.ProtoGamemaster;

public interface IMenuSystem
{
	public String menuType();
	
	public int runMenu(ProtoGamemaster PGM);
}
