// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildItemManager implements IEvent
{
	private Gamemaster GM;
	private int eventID = 810;
	
	public BuildItemManager(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.buildItemSet();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
