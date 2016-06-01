// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class StartEvent implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 800;
	
	public StartEvent(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.runStartUp();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
