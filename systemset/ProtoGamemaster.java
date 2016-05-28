// Brad Howard
// OCP Prototype Gamemaster

package systemset;

import java.util.*;
import equipmentset.*;
import eventset.*;
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
	InventoryManager IVM;
	MenuManager MM;
	IEvent[][][] eventSet;
	IBin<IWeapon> weaponHolder;
	IBin<IEquipment> equipmentHolder;
	IBin<IItem> itemHolder;
	int groupID;
	int ID;
	
	public ProtoGamemaster()
	{
		eventSet = new IEvent[10][10][10];
		weaponHolder = new Holder<IWeapon>();
		equipmentHolder = new Holder<IEquipment>();
		itemHolder = new Holder<IItem>();
		groupID = -1;
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
		
		eventSet[6][0][0] = new FixDurability(this);
		eventSet[6][0][6] = new FixDurabilityError(this);
		eventSet[6][1][0] = new AddPrefix(this);
		eventSet[6][1][6] = new AddPrefixError(this);
		eventSet[7][0][0] = new ItemDrop(this);
		eventSet[7][0][6] = new ItemDropError(this);
		eventSet[7][3][0] = new ItemUsed(this);
		eventSet[7][3][3] = new Equip(this); // Equip
		eventSet[7][3][4] = new EndEvent(this); // Unequip
		eventSet[7][3][5] = new ItemDiscard(this);
		
		for(int index = 0; index < buildSet.length; index++)
		{
			eventSet[8][index + 1][0] = buildSet[index];
			eventSet[8][index + 1][6] = buildErrorSet[index];
		}

		eventSet[8][9][9] = new EndEvent(this);
		eventSet[9][0][0] = new RunAdventureLoop(this);
		eventSet[9][0][1] = new SaveGame(this);
		eventSet[9][0][2] = new LoadGame(this);
		eventSet[9][0][9] = new EndEvent(this);
		eventSet[9][6][0] = new RunPauseMenu(this);
		eventSet[9][7][0] = new RunInventoryMenu(this);
		eventSet[9][9][0] = new EndGame(this);
		eventSet[9][9][1] = new SaveAndQuit(this);
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
	
	public void runPauseMenu()
	{
		MM.get(0).runMenu(this);
	}
	
	public void runInventoryMenu()
	{
		MM.get(1).runMenu(this);
	}
	
	@SuppressWarnings("resource")
	public void runAdventureLoop()
	{
		Scanner input = new Scanner(System.in);
		String inputData = "";
		
		while(true)
		{
			System.out.println("P: Pause\nI: Inventory\nD: Item Drop");
			inputData = input.nextLine();
						
			if(inputData.equals("P") || inputData.equals("p"))
				callEvent(960);
			else if(inputData.equals("I") || inputData.equals("i"))
				callEvent(970);
			else if(inputData.equals("D") || inputData.equals("d"))
				callEvent(700);
		}
	}
	
	public void exit()
	{
		System.out.println("Exiting system");
		System.exit(0);
	}
	
	public void equip()
	{
		
	}
	
	public void unequip()
	{
		
	}
	
	public void itemUsed()
	{
		System.out.println(((IUsable) IVM.get(ID).get()).getName() + " was used");
		IVM.remove(ID);
	}
	
	public void itemDiscard()
	{
		System.out.println(((IUsable) IVM.get(ID).get()).getName() + " was discarded!");
		IVM.remove(ID);
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
					IVM.set(new Holder<IItem>(IM.get(rID)));
					System.out.println(IM.get(rID).getName() + ": Has been placed in Inventory");
					break;
				case 1:
					rID = r.nextInt(WM.size());
					System.out.println(type + ":" + rID);
					System.out.println(WM.get(rID).getName());
					weaponHolder.place(WM.get(rID));
					groupID = 0;
					callEvent(610);
					IVM.set(weaponHolder);
					System.out.println(weaponHolder.get().getName() + ": Has been placed in Inventory");
					break;
				case 2:
					rID = r.nextInt(EM.size());
					System.out.println(type + ":" + rID);
					System.out.println(EM.get(rID).getName());
					equipmentHolder.place(EM.get(rID));
					groupID = 1;
					callEvent(610);
					IVM.set(equipmentHolder);
					System.out.println(equipmentHolder.get().getName() + ": Has been placed in Inventory");
					break;
				default:
					System.out.println("Random error");
			}
		}
		catch(Exception e)
		{
			callEvent(706);
		}
		groupID = -1;
	}
	
	public void addPrefix()
	{
		if(groupID == 0)
		{
			weaponHolder.place(WG.getRandomPrefix(weaponHolder.get()));
		}
		else if(groupID == 1)
		{
			equipmentHolder.place(EG.getRandomPrefix(equipmentHolder.get()));
		}
		else
			callEvent(616);
	}
	
	public void fixDurability()
	{
		if(groupID == 0)
		{
			weaponHolder.place(WG.fix(weaponHolder.get()));
		}
		else if(groupID == 1)
		{
			equipmentHolder.place(EG.fix(equipmentHolder.get()));
		}
		else
			callEvent(606);
	}
	
	public void runBattleLoop()
	{
		
	}
	
	public void save()
	{
		
	}
	
	public void load()
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
		IVM = new InventoryManager();
		callEvent(880);
	}
	
	public void buildSaveManager()
	{
		// builds SaveManager
		callEvent(890);
	}
	
	public void buildOtherManagers()
	{
		// builds Party, Menu, Battle, and any other managers to be
		MM = new MenuManager();
		MM.set(new PauseMenu(this));
		MM.set(new InventoryMenu(this));
		callEvent(899);
	}
}
