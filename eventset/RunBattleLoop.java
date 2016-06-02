// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class RunBattleLoop implements IEvent
{
	private Gamemaster GM;
	private int eventID = 910;
	
	public RunBattleLoop(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.runBattleLoop();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
