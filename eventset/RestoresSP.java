// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class RestoresSP implements IEvent
{
	private Gamemaster GM;
	private int eventID = 140;
	
	public RestoresSP(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.restoresSP();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
