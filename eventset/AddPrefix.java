// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class AddPrefix implements IEvent
{
	private Gamemaster GM;
	private int eventID = 610;
	
	public AddPrefix(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.addPrefix();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
