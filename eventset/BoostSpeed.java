// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BoostSpeed implements IEvent
{
	private Gamemaster GM;
	private int eventID = 250;
	
	public BoostSpeed(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.boostSpeed();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
