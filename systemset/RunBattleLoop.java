// Brad Howard
// OCP Event

package systemset;

import interfaces.IEvent;

public class RunBattleLoop implements IEvent
{
	private ProtoGamemaster PGM;
	private int eventID = 910;
	
	public RunBattleLoop(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void run()
	{
		PGM.runBattleLoop();
	}
	
	public int getEventID()
	{
		return eventID;
	}
}
