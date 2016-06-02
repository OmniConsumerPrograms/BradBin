// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildOtherManager implements IEvent
{
	private Gamemaster GM;
	private int eventID = 890;
	
	public BuildOtherManager(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.buildOtherManagers();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
