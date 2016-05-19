// Brad Howard
// OCP Event

package systemset;

import Interfaces.IEvent;

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
