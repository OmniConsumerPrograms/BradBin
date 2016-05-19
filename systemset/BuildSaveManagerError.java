// Brad Howard
// OCP Event

package systemset;

import Interfaces.IEvent;

public class BuildSaveManagerError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 886;
	
	public BuildSaveManagerError(ProtoGamemaster PGM)
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
