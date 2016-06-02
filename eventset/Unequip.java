// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class Unequip implements IEvent
{
	private Gamemaster GM;
	private int eventID = 734;
	
	public Unequip(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.unequip();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
