// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class RestoresHP implements IEvent
{
	private Gamemaster GM;
	private int eventID = 100;
	
	public RestoresHP(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.restoresHP();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
