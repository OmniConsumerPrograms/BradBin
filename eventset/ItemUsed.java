// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class ItemUsed implements IEvent
{
	private Gamemaster GM;
	private int eventID = 730;
	
	public ItemUsed(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.itemUsed();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
