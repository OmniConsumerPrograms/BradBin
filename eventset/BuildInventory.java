// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class BuildInventory implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 870;
	
	public BuildInventory(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.buildInventory();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
