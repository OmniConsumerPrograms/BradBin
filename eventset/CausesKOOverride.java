// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class CausesKOOverride implements IEvent
{
	private Gamemaster GM;
	private int eventID = 488;
	
	public CausesKOOverride(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.causesKOOverride();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
