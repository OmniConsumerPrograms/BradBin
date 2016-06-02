// Brad Howard
// OCP Event

package eventset;

import interfaces.IEvent;
import systemset.Gamemaster;

public class SaveGame implements IEvent
{
	private Gamemaster GM;
	private int eventID = 901;
	
	public SaveGame(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void run()
	{
		GM.save();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
