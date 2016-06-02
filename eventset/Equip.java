// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class Equip implements IEvent
{
	private Gamemaster GM;
	private int eventID = 733;
	
	public Equip(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.equip();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
