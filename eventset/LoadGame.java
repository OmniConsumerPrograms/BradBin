// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class LoadGame implements IEvent
{
	private Gamemaster GM;
	private int eventID = 902;
	
	public LoadGame(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.load();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
