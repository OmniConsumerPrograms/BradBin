// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class ItemUsed implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 730;
	
	public ItemUsed(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.itemUsed();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
