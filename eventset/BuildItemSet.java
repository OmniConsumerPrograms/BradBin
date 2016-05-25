// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class BuildItemSet implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 810;
	
	public BuildItemSet(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.buildItemSet();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
