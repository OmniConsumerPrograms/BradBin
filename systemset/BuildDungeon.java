// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class BuildDungeon implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 860;
	
	public BuildDungeon(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.buildDungeon();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
