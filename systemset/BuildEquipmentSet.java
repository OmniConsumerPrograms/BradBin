// Brad Howard
// OCP Event

package systemset;

public class BuildEquipmentSet implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 830;
	
	public BuildEquipmentSet(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.buildEquipmentSet();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
