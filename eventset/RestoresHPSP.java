// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class RestoresHPSP implements IEvent
{
	private Gamemaster GM;
	private int eventID = 120;
	
	public RestoresHPSP(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.restoresHPSP();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
