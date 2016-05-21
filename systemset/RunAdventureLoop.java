// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class RunAdventureLoop implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 900;
	
	public RunAdventureLoop(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.runAdventureLoop();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
