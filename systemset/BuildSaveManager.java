// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class BuildSaveManager implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 880;
	
	public BuildSaveManager(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.buildSaveManager();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
