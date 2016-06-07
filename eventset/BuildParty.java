// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildParty implements IEvent
{
	private Gamemaster GM;
	private int eventID = 070;
	
	public BuildParty(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.buildParty();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
