// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BattleForceEnd implements IEvent
{
	private Gamemaster GM;
	private int eventID = 560;
	
	public BattleForceEnd(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.battleForceEnd();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}