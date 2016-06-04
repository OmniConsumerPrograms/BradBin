// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class AddEquipment implements IEvent
{
	private Gamemaster GM;
	private int eventID = 680;
	
	public AddEquipment(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.addEquipment();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
