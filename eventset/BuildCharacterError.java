// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildCharacterError implements IEvent
{
	private Gamemaster GM;
	private int eventID = 846;
	
	public BuildCharacterError(Gamemaster GM)
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
