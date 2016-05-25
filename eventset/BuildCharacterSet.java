// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

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
