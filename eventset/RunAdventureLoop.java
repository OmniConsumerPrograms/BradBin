// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class RunAdventureLoop implements IEvent
{
	private Gamemaster GM;
	private int eventID = 900;
	
	public RunAdventureLoop(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.runAdventureLoop();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
