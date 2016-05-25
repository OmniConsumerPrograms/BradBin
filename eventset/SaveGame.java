// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class SaveGame implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 901;
	
	public SaveGame(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.save();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
