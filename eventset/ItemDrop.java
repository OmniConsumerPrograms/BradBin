// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class ItemDrop implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 700;
	
	public ItemDrop(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.itemDrop();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
