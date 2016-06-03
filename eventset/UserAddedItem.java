// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class UserAddedItem implements IEvent
{
	private Gamemaster GM;
	private int eventID = 720;
	
	public UserAddedItem(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.userAddedItem();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
