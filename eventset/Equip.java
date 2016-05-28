// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class Equip implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 733;
	
	public Equip(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.equip();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
