// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class AddHP implements IEvent
{
	private Gamemaster GM;
	private int eventID = 110;
	
	public AddHP(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.addHP();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
