// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class AddPrefixOverride implements IEvent
{
	private Gamemaster GM;
	private int eventID = 616;
	
	public AddPrefixOverride(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.addPrefixOverride();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
