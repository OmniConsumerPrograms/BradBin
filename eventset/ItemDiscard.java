// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class ItemDiscard implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 735;
	
	public ItemDiscard(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.itemDiscard();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
