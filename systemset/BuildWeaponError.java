// Brad Howard
// OCP Event

package systemset;

import Interfaces.IEvent;

public class BuildWeaponError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 826;
	
	public BuildWeaponError(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.error(eventID);
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
