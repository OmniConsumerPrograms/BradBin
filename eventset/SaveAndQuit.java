// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class SaveAndQuit implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 991;
	
	public SaveAndQuit(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.save();
		PGM.exit();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
