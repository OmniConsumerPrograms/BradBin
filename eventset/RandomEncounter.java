// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class RandomEncounter implements IEvent
{
	private Gamemaster GM;
	private int eventID = 930;
	
	public RandomEncounter(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.randomEncounter();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
