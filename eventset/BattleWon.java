// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BattleWon implements IEvent
{
	private Gamemaster GM;
	private int eventID = 540;
	
	public BattleWon(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.battleWon();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}