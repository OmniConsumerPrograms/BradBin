// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BattleLost implements IEvent
{
	private Gamemaster GM;
	private int eventID = 550;
	
	public BattleLost(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.battleLost();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}