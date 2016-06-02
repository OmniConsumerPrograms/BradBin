// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class StartEvent implements IEvent
{
	private Gamemaster GM;
	private int eventID = 800;
	
	public StartEvent(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.runStartUp();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
