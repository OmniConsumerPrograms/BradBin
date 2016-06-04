// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class AddWeapon implements IEvent
{
	private Gamemaster GM;
	private int eventID = 670;
	
	public AddWeapon(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.addWeapon();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
