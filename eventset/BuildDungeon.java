// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildDungeon implements IEvent
{
	private Gamemaster GM;
	private int eventID = 860;
	
	public BuildDungeon(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.buildDungeon();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
