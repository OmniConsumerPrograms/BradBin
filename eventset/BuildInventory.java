// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildInventory implements IEvent
{
	private Gamemaster GM;
	private int eventID = 870;
	
	public BuildInventory(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.buildInventory();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
