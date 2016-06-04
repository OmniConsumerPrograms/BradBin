// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BoostAll implements IEvent
{
	private Gamemaster GM;
	private int eventID = 270;
	
	public BoostAll(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.boostAll();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
