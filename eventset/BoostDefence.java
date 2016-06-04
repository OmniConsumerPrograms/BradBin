// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BoostDefence implements IEvent
{
	private Gamemaster GM;
	private int eventID = 210;
	
	public BoostDefence(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.boostDefence();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
