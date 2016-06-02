// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildCharacterSet implements IEvent
{
	private Gamemaster GM;
	private int eventID = 840;
	
	public BuildCharacterSet(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.buildCharacterSet();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
