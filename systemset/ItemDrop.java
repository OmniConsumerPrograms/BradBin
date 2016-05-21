// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

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
