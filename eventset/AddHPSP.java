// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class AddHPSP implements IEvent
{
	private Gamemaster GM;
	private int eventID = 130;
	
	public AddHPSP(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.addHPSP();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
