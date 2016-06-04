// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BoostAccuracy implements IEvent
{
	private Gamemaster GM;
	private int eventID = 260;
	
	public BoostAccuracy(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.boostAccuracy();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
