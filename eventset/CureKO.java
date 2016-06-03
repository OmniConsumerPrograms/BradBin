// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class CureKO implements IEvent
{
	private Gamemaster GM;
	private int eventID = 780;
	
	public CureKO(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.cureKO();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
