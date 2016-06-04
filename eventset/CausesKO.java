// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class CausesKO implements IEvent
{
	private Gamemaster GM;
	private int eventID = 480;
	
	public CausesKO(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.causesKO();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
