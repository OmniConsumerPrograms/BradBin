// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BoostAttack implements IEvent
{
	private Gamemaster GM;
	private int eventID = 200;
	
	public BoostAttack(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.boostAttack();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
