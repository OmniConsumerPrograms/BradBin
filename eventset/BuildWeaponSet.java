// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.ProtoGamemaster;

public class BuildWeaponSet implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 820;
	
	public BuildWeaponSet(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.buildWeaponSet();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}