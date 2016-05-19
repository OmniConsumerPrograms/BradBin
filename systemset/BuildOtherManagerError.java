// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class BuildOtherManagerError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 896;
	
	public BuildOtherManagerError(ProtoGamemaster PGM)
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
