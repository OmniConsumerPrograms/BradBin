// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class BuildFloorsError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 856;
	
	public BuildFloorsError(ProtoGamemaster PGM)
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
