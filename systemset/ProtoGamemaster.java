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
		IEvent[] buildSet = {new BuildItemSet(this), 
							 new BuildWeaponSet(this),
							 new BuildEquipmentSet(this),
							 new BuildCharacterSet(this),
							 new BuildFloors(this),
							 new BuildDungeon(this),
							 new BuildInventory(this),
							 new BuildSaveManager(this),
							 new BuildOtherManager(this)};
		
		IEvent[] buildErrorSet = {new BuildItemError(this),
								  new BuildWeaponError(this),
								  new BuildEquipmentError(this),
								  new BuildCharacterError(this),
								  new BuildFloorsError(this),
								  new BuildDungeonError(this),
								  new BuildInventoryError(this),
								  new BuildSaveManagerError(this),
								  new BuildOtherManagerError(this)};
		
		for(int index = 0; index < buildSet.length; index++)
		{
			eventSet[8][index + 1][0] = buildSet[index];
			eventSet[8][index + 1][6] = buildErrorSet[index];
		}
		
		eventSet[9][0][0] = new EndEvent(this);
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
	
	public void buildCharacterSet()
	{
		callEvent(850);
	}
	
	public void buildFloors()
	{
		callEvent(860);
	}
	
	public void buildDungeon()
	{
		callEvent(870);
	}
	
	public void buildInventory()
	{
		callEvent(880);
	}
	
	public void buildSaveManager()
	{
		callEvent(890);
	}
	
	public void buildOtherManagers()
	{
		callEvent(900);
	}
}
