// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class RunPauseMenu implements IEvent
{
	private Gamemaster GM;
	private int eventID = 960;
	
	public RunPauseMenu(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.runPauseMenu();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
