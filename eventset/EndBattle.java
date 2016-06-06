// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class EndBattle implements IEvent
{
	private Gamemaster GM;
	private int eventID = 919;
	
	public EndBattle(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.setGameMode(900);
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
