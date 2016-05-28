// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class Unequip implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 734;
	
	public Unequip(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.unequip();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
