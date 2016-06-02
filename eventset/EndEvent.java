// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class EndEvent implements IEvent
{
	private Gamemaster GM;
	private int eventID = 000;
	
	public EndEvent(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.check();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
