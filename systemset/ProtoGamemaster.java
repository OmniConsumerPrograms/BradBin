// Brad Howard
// OCP Prototype Gamemaster

package systemset;

import java.util.*;
import equipmentset.*;
import interfaces.*;
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
	IBin<IWeapon> weaponHolder;
	IBin<IEquipment> equipmentHolder;
	int prefixSwitch;
	
	public ProtoGamemaster()
	{
		eventSet = new IEvent[10][10][10];
		weaponHolder = new Holder<IWeapon>();
		equipmentHolder = new Holder<IEquipment>();
		prefixSwitch = -1;
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
		
		eventSet[6][1][0] = new AddPrefix(this);
		eventSet[6][1][6] = new AddPrefixError(this);
		eventSet[7][0][0] = new ItemDrop(this);
		eventSet[7][0][6] = new ItemDropError(this);
		
		for(int index = 0; index < buildSet.length; index++)
		{
			eventSet[8][index + 1][0] = buildSet[index];
			eventSet[8][index + 1][6] = buildErrorSet[index];
		}

		eventSet[8][9][9] = new EndEvent(this);
		eventSet[9][0][0] = new RunAdventureLoop(this);
		eventSet[9][0][9] = new EndEvent(this);
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
		callEvent(900);
	}
	
	public void runAdventureLoop()
	{
      int i = 10;
      
		while(i > 0)
		{
			if(i > 0)
         {
				callEvent(700);
         }
         i--;
		}
	}
	
	public void itemDrop()
	{
		Random r = new Random();
		int rID = 0;
		int type = r.nextInt(3);
		try
		{
			switch(type)
			{
				case 0:
					rID = r.nextInt(IM.size());
					System.out.println(type + ":" + rID);
					System.out.println(IM.get(rID).getName());
					break;
				case 1:
					rID = r.nextInt(WM.size());
					System.out.println(type + ":" + rID);
					System.out.println(WM.get(rID).getName());
					weaponHolder.place(WM.get(rID));
					prefixSwitch = 0;
					callEvent(610);
					System.out.println(weaponHolder.get().getName());
					break;
				case 2:
					rID = r.nextInt(EM.size());
					System.out.println(type + ":" + rID);
					System.out.println(EM.get(rID).getName());
					equipmentHolder.place(EM.get(rID));
					prefixSwitch = 1;
					callEvent(610);
					System.out.println(equipmentHolder.get().getName());
					break;
				default:
					System.out.println("Random error");
			}
		}
		catch(Exception e)
		{
			callEvent(706);
		}
		prefixSwitch = -1;
	}
	
	public void addPrefix()
	{
		if(prefixSwitch == 0)
		{
			weaponHolder.place(WG.getRandomPrefix(weaponHolder.get()));
		}
		else if(prefixSwitch == 1)
		{
			equipmentHolder.place(EG.getRandomPrefix(equipmentHolder.get()));
		}
		else
			callEvent(616);
	}
	
	public void runBattleLoop()
	{
		
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
		callEvent(899);
	}
}
