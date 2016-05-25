// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class LoadGame implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 902;
	
	public LoadGame(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.load();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
