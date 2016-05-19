// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class BuildItemError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 816;
	
	public BuildItemError(ProtoGamemaster PGM)
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
