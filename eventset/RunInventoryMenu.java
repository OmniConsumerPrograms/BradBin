// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class RunInventoryMenu implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 970;
	
	public RunInventoryMenu(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.runInventoryMenu();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
