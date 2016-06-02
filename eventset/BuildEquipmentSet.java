// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class BuildEquipmentSet implements IEvent
{
	private Gamemaster GM;
	private int eventID = 830;
	
	public BuildEquipmentSet(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.buildEquipmentSet();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
