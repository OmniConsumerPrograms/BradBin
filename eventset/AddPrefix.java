// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class AddPrefix implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 610;
	
	public AddPrefix(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.addPrefix();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}