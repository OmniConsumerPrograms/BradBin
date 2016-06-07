// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class RunStartMenu implements IEvent
{
	private Gamemaster GM;
	private int eventID = 920;
	
	public RunStartMenu(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.runStartMenu();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
