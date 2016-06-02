// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildWeaponSet implements IEvent
{
	private Gamemaster GM;
	private int eventID = 820;
	
	public BuildWeaponSet(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.buildWeaponSet();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
