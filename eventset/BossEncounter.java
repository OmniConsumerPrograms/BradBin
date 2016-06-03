// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BossEncounter implements IEvent
{
	private Gamemaster GM;
	private int eventID = 930;
	
	public BossEncounter(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.bossEncounter();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
