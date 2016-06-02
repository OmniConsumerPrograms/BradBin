// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildSaveManager implements IEvent
{
	private Gamemaster GM;
	private int eventID = 880;
	
	public BuildSaveManager(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.buildSaveManager();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
