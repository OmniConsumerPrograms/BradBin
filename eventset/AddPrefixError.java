// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class AddPrefixError implements IEvent
{
	private Gamemaster GM;
	private int eventID = 616;
	
	public AddPrefixError(Gamemaster GM)
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
