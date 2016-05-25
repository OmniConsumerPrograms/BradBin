// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class RunPauseMenu implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 960;
	
	public RunPauseMenu(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.runPauseMenu();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
