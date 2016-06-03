// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class ItemBoxAction implements IEvent
{
	private Gamemaster GM;
	private int eventID = 710;
	
	public ItemBoxAction(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.itemBoxAction();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
