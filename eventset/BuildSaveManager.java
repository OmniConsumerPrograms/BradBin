// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

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
