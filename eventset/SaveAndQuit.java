// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class SaveAndQuit implements IEvent
{
	private Gamemaster GM;
	private int eventID = 991;
	
	public SaveAndQuit(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.save();
		GM.exit();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
