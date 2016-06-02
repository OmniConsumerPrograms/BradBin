// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class EndGame implements IEvent
{
	private Gamemaster GM;
	private int eventID = 990;
	
	public EndGame(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.exit();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
