// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class EndEvent implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 000;
	
	public EndEvent(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.check();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
