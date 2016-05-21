// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class ItemDropError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 706;
	
	public ItemDropError(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.error(706);
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
