// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BoostMagicDefence implements IEvent
{
	private Gamemaster GM;
	private int eventID = 240;
	
	public BoostMagicDefence(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.boostMagicDefence();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
