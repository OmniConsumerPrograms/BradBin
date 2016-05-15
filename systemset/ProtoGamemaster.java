// Brad Howard
// OCP Prototype Gamemaster

package systemset;

import equipmentset.*;
import weaponset.*;
import itemset.*;

public class ProtoGamemaster
{
	EquipmentManager EM;
	EquipmentGenerator EG;
	WeaponManager WM;
	WeaponGenerator WG;
	ItemManager IM;
	ItemGenerator IG;
	IEvent[][][] eventSet;
	
	public ProtoGamemaster()
	{
		eventSet = new IEvent[10][10][10];
		buildEventSet();
	}
	
	public void callEvent(int eid)
	{
		int errorCode = eid % 10;
		eid /= 10;
		int individual = eid % 10;
		eid /= 10;
		int group = eid % 10;
		
		eventSet[group][individual][errorCode].run();
	}
	
	public void buildEventSet()
	{
		IEvent[] tempSet = {new BuildItemSet(this), new BuildWeaponSet(this), new BuildEquipmentSet(this), new EndEvent(this)};
		IEvent[] errorSet = {new BuildItemError(this), new BuildWeaponError(this), new BuildEquipmentError(this), new EndEvent(this)};
		
		for(int index = 0; index < tempSet.length; index++)
		{
			eventSet[8][index + 1][0] = tempSet[index];
			eventSet[8][index + 1][6] = errorSet[index];
		}
	}
	
	public void check()
	{
		System.out.println("Run is ok");
	}
	
	public void error(int id)
	{
		System.out.println("Error code: " + id);
	}
	
	public void runStartUp()
	{
		callEvent(810);
	}
	
	public void buildItemSet()
	{
		IM = new ItemManager();
		IG = new ItemGenerator(IM);
		callEvent(IG.build());
	}
	
	public void buildWeaponSet()
	{
		WM = new WeaponManager();
		WG = new WeaponGenerator(WM);
		callEvent(WG.build());
	}
	
	public void buildEquipmentSet()
	{
		EM = new EquipmentManager();
		EG = new EquipmentGenerator(EM);
		callEvent(EG.build());
	}
}
