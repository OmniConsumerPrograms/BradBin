// Brad Howard
// OCP Event

package systemset;

import Interfaces.IEvent;

public class BuildCharacterError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 846;
	
	public BuildCharacterError(ProtoGamemaster PGM)
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
