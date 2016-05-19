// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class BuildInventoryError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 876;
	
	public BuildInventoryError(ProtoGamemaster PGM)
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
