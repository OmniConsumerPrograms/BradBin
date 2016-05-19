// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class BuildCharacterSet implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 840;
	
	public BuildCharacterSet(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.buildCharacterSet();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
