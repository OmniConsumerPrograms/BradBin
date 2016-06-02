// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildFloors implements IEvent
{
	private Gamemaster GM;
	private int eventID = 850;
	
	public BuildFloors(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.buildFloors();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
