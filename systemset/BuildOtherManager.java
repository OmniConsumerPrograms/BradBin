// Brad Howard
// OCP Event

package systemset;

import Interfaces.IEvent;

public class BuildOtherManager implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 890;
	
	public BuildOtherManager(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.buildOtherManagers();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
