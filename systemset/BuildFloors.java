// Brad Howard
// OCP Event

package systemset;

import Interfaces.IEvent;

public class BuildFloors implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 850;
	
	public BuildFloors(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.buildFloors();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
