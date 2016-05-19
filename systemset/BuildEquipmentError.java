// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class BuildEquipmentError implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 836;
	
	public BuildEquipmentError(ProtoGamemaster PGM)
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
