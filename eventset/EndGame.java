// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class EndGame implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 990;
	
	public EndGame(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.exit();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
