// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BattleEscape implements IEvent
{
	private Gamemaster GM;
	private int eventID = 500;
	
	public BattleEscape(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.battleEscape();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
