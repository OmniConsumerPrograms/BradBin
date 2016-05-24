// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class FixDurabilityError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 606;
	
	public FixDurabilityError(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.error(eventID);
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
