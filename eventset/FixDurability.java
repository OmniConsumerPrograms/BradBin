// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class FixDurability implements IEvent
{
	private Gamemaster GM;
	private int eventID = 600;
	
	public FixDurability(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.fixDurability();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
