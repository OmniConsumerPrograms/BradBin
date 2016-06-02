// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class ItemDiscard implements IEvent
{
	private Gamemaster GM;
	private int eventID = 735;
	
	public ItemDiscard(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.itemDiscard();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
