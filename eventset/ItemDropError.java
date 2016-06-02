// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class ItemDropError implements IEvent
{
	private Gamemaster GM;
	private int eventID = 706;
	
	public ItemDropError(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.error(706);
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
