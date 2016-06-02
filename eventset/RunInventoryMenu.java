// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class RunInventoryMenu implements IEvent
{
	private Gamemaster GM;
	private int eventID = 970;
	
	public RunInventoryMenu(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.runInventoryMenu();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
