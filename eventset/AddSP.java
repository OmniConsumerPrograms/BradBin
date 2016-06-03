// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class AddSP implements IEvent
{
	private Gamemaster GM;
	private int eventID = 150;
	
	public AddSP(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.addSP();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
