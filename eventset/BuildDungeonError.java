// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildDungeonError implements IEvent
{
	private Gamemaster GM;
	private int eventID = 866;
	
	public BuildDungeonError(Gamemaster GM)
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
