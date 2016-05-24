// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class FixDurability implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 600;
	
	public FixDurability(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.fixDurability();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
