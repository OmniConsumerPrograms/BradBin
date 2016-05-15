// Brad Howard
// OCP Event

package systemset;

public class BuildItemManager implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 810;
	
	public BuildItemManager(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.buildItemSet();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
