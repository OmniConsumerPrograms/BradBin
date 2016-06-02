// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class ItemDrop implements IEvent
{
	private Gamemaster GM;
	private int eventID = 700;
	
	public ItemDrop(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.itemDrop();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
