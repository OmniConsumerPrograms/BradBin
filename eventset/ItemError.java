// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class ItemError implements IEvent
{
	private Gamemaster GM;
	private int eventID = 736;
	
	public ItemError(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.error(eventID);
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
