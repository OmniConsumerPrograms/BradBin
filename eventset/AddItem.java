// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class AddItem implements IEvent
{
	private Gamemaster GM;
	private int eventID = 660;
	
	public AddItem(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.addItem();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
