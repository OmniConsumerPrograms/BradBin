// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildItemSet implements IEvent
{
	private Gamemaster GM;
	private int eventID = 810;
	
	public BuildItemSet(Gamemaster GM)
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
