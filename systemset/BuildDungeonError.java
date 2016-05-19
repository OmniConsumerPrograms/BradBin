// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class BuildDungeonError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 866;
	
	public BuildDungeonError(ProtoGamemaster PGM)
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
