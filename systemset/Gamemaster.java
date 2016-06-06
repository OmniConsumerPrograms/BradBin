// Brad Howard
// OCP Prototype Gamemaster

package systemset;

import java.io.File;
import java.io.PrintStream;
import java.util.*;

import characterset.Battle;
import characterset.HeroGenerator;
import characterset.Party;
import characterset.PartyManager;
import characterset.VillainGenerator;
import equipmentset.*;
import eventset.*;
import floorset.*;
import interfaces.*;
import weaponset.*;
import itemset.*;

@SuppressWarnings("rawtypes")
public class Gamemaster
{
	IManager<IEquipment> EM;
	IItemGenerator<IEquipment> EG;
	IManager<IWeapon> WM;
	IItemGenerator<IWeapon> WG;
	IManager<IItem> IM;
	IGenerator IG;
	IManager<IBin> IVM;
	IManager<IMenuSystem> MM;
	IHeroGenerator HG;
	IVillainGenerator VG;
	IManager<IHero> PM;
	SQLManager floorSave;
	IDungeon DM;
	IFloorManager FM;
	IEvent[][][] eventSet;
	IBin<IWeapon> weaponHolder;
	IBin<IEquipment> equipmentHolder;
	IBin<IItem> itemHolder;
	IBin<IHero> heroHolder;
	IBin<ICharacter> targetHolder;
	int groupID;
	int ID;
	int gameMode;
	
	public Gamemaster()
	{
		eventSet = new IEvent[10][10][10];
		weaponHolder = new Holder<IWeapon>();
		equipmentHolder = new Holder<IEquipment>();
		itemHolder = new Holder<IItem>();
		heroHolder = new Holder<IHero>();
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
		
		eventSet[1][0][0] = new RestoresHP(this);
		eventSet[1][0][1] = new RestoresHP(this);
		eventSet[1][1][0] = new AddHP(this);
		eventSet[1][1][1] = new AddHP(this);
		eventSet[1][2][0] = new RestoresHPSP(this);
		eventSet[1][2][1] = new RestoresHPSP(this);
		eventSet[1][3][0] = new AddHPSP(this);
		eventSet[1][3][1] = new AddHPSP(this);
		eventSet[1][4][0] = new RestoresSP(this);
		eventSet[1][4][1] = new RestoresSP(this);
		eventSet[1][5][0] = new AddSP(this);
		eventSet[1][5][1] = new AddSP(this);
		eventSet[2][0][0] = new BoostAttack(this);
		eventSet[2][1][0] = new BoostDefence(this);
		eventSet[2][4][0] = new BoostMagicDefence(this);
		eventSet[2][5][0] = new BoostSpeed(this);
		eventSet[2][6][0] = new BoostAccuracy(this);
		eventSet[2][7][0] = new BoostAll(this);
		eventSet[4][8][0] = new CausesKO(this);
		eventSet[4][8][8] = new CausesKOOverride(this);
		eventSet[5][0][0] = new BattleEscape(this);
		eventSet[5][4][0] = new BattleWon(this);
		eventSet[5][5][0] = new BattleLost(this);
		eventSet[5][6][0] = new BattleForceEnd(this);
		eventSet[6][0][0] = new FixDurability(this);
		eventSet[6][0][6] = new FixDurabilityError(this);
		eventSet[6][1][0] = new AddPrefix(this);
		eventSet[6][1][6] = new AddPrefixError(this);
		eventSet[6][1][8] = new AddPrefixOverride(this);
		eventSet[6][6][0] = new AddItem(this);
		eventSet[6][7][0] = new AddWeapon(this);
		eventSet[6][8][0] = new AddEquipment(this);
		eventSet[7][0][0] = new ItemDrop(this);
		eventSet[7][0][6] = new ItemDropError(this);
		eventSet[7][1][0] = new ItemBoxAction(this);
		eventSet[7][2][0] = new UserAddedItem(this);
		eventSet[7][3][0] = new ItemUsed(this);
		eventSet[7][3][3] = new Equip(this);
		eventSet[7][3][4] = new Unequip(this);
		eventSet[7][3][5] = new ItemDiscard(this);
		eventSet[7][3][6] = new ItemError(this);
		eventSet[7][8][0] = new CureKO(this);
		eventSet[7][8][1] = new CureKO(this);
		
		for(int index = 0; index < buildSet.length; index++)
		{
			eventSet[8][index + 1][0] = buildSet[index];
			eventSet[8][index + 1][6] = buildErrorSet[index];
		}

		eventSet[8][0][0] = new StartEvent(this);
		eventSet[8][9][9] = new EndEvent(this);
		eventSet[9][0][0] = new RunAdventureLoop(this);
		eventSet[9][0][1] = new SaveGame(this);
		eventSet[9][0][2] = new LoadGame(this);
		eventSet[9][0][6] = new RunAdventureLoopError(this);
		eventSet[9][0][9] = new EndEvent(this);
		eventSet[9][1][0] = new RunBattleLoop(this);
		eventSet[9][1][6] = new RunBattleLoopError(this);
		eventSet[9][1][9] = new EndBattle(this);
		eventSet[9][3][0] = new RandomEncounter(this);
		eventSet[9][5][0] = new BossEncounter(this);
		eventSet[9][6][0] = new RunPauseMenu(this);
		eventSet[9][7][0] = new RunInventoryMenu(this);
		eventSet[9][9][0] = new EndGame(this);
		eventSet[9][9][1] = new SaveAndQuit(this);
	}
	
	public void check()
	{
		System.out.println("Run is ok");
	}
	
	public int getGameMode()
	{
		return gameMode;
	}
	
	public void setGameMode(int eID)
	{
		gameMode = eID;
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
		gameMode = 900;
		Scanner input = new Scanner(System.in);
		String inputData = "";
		
		while(gameMode == 900)
		{
			DM.printMaze(DM.getFloorNo());
			System.out.println("1: Move Up    2: Move Down    3: Move Left    4: Move Right");
			System.out.println("P: Pause           I: Inventory               D: Item Drop");
			System.out.println("A: Add an Item     R: Get a random prefix     K: autoKO");
			inputData = input.nextLine();
				
			if(inputData.matches("[1-4]"))
			{
				DM.move(Integer.parseInt(inputData));
				
				if(DM.randomCounter() <= 1)
					callEvent(930);
				else if(DM.getFloorNo() == 3)
					callEvent(950);
			}
			else if(inputData.equalsIgnoreCase("P"))
				callEvent(960);
			else if(inputData.equalsIgnoreCase("I"))
				callEvent(970);
			else if(inputData.equalsIgnoreCase("D"))
				callEvent(700);
			else if(inputData.equalsIgnoreCase("A"))
				callEvent(720);
			else if(inputData.equalsIgnoreCase("R"))
				callEvent(618);
			else if(inputData.equalsIgnoreCase("K"))
				callEvent(488);
		}
	}
	
	//@SuppressWarnings("resource")
	public void runBattleLoop()
	{
		gameMode = 910;
		IParty temp = new Party();
		IBattle battle;
		//Scanner input = new Scanner(System.in);
		//String inputData = "";
		
		for(int index = 0; index < PM.size(); index++)
			temp.addChar(PM.get(index));
		
		battle = new Battle(temp, this);
		try
		{
			callEvent(battle.runBattle(gameMode));
		}
		catch(Exception e)
		{
			callEvent(916);
		}
		/*
		while(gameMode == 910)
		{
			System.out.println("P: Pause       I: Inventory    D: Item Drop");
			System.out.println("N: autoWin     M: autoLose     K: autoKO");
			System.out.println("E: autoEscape  F: force End Battle");
			inputData = input.nextLine();
			
			if(inputData.equalsIgnoreCase("P"))
				callEvent(960);
			else if(inputData.equalsIgnoreCase("I"))
				callEvent(970);
			else if(inputData.equalsIgnoreCase("D"))
				callEvent(700);
			else if(inputData.equalsIgnoreCase("N"))
				callEvent(540);
			else if(inputData.equalsIgnoreCase("M"))
				callEvent(550);
			else if(inputData.equalsIgnoreCase("K"))
				callEvent(488);
			else if(inputData.equalsIgnoreCase("E"))
				callEvent(500);
			else if(inputData.equalsIgnoreCase("F"))
				callEvent(560);
		}*/
	}
	
	public void battleWon()
	{
		gameMode = 900;
		System.out.println("Battle Won");
		callEvent(700);
	}
	
	@SuppressWarnings("resource")
	public void battleLost()
	{
		gameMode = 990;
		Scanner userIn = new Scanner(System.in);
		int input = 0;
		
		System.out.println("The party was lost, all is dark...");
		System.out.println("~ Game Over ~");
		
		while(gameMode == 990)
		{
			System.out.println("\n1: New Game\n2: Quit Game\n3: Load Game");
			input = userIn.nextInt();
			
			switch(input)
			{
				case 1:
					callEvent(800);
					break;
				case 2:
					callEvent(990);
					break;
				case 3:
					callEvent(902);
					callEvent(919);
					break;
			}
		}
	}
	
	public void battleEscape()
	{
		Random r = new Random();
		
		if(r.nextInt(10) <= 2)
		{
			System.out.println("Your party has escape the battle");
			callEvent(919);
		}
		else
			System.out.println("You stumble...");
	}
	
	public void battleForceEnd()
	{
		System.out.println("You just open the bottle with the black hole, the enemy party was sucked in.");
		callEvent(919);
	}
	
	public void exit()
	{
		System.out.println("Exiting system");
		System.exit(0);
	}
	
	public void equip()
	{
		if(groupID == 0)
		{
			if(heroHolder.get().getWeapon().getID() == 0)
				heroHolder.get().setWeapon(weaponHolder.get());
			else
			{
				Holder<IWeapon> temp = new Holder<IWeapon>(heroHolder.get().replaceWeapon(weaponHolder.get()));
				IVM.set(temp);
			}
		}
		else if(groupID == 1)
		{
			if(heroHolder.get().getEquipment(ID - 1).getID() == 0)
				heroHolder.get().setEquipment(equipmentHolder.get(), ID - 1);
			else
			{
				Holder<IEquipment> temp  = new Holder<IEquipment>(heroHolder.get().replaceEquipment(equipmentHolder.get(), ID - 1));
				IVM.set(temp);
			}
		}
		else
			callEvent(736);
	}
	
	public void unequip()
	{
		if(groupID == 0)
			IVM.set(new Holder<IWeapon>(heroHolder.get().replaceWeapon(new BareHands(1))));
		else if(groupID == 1)
			IVM.set(new Holder<IEquipment>(heroHolder.get().replaceEquipment(new NilEquipment(1), ID - 1)));
		else
			callEvent(736);
	}
	
	public void itemUsed()
	{
		System.out.println(((IUsable) IVM.get(ID).get()).getName() + " was used");
		callEvent(itemHolder.get().getEventID());
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
		int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
					   11, 12, 13, 14, 15, 16 ,17 ,18 ,19, 20,
					   25, 27, 28, 29, 30, 31, 35, 36, 37, 38,
					   39, 40};
		
		try
		{
			switch(type)
			{
				case 0:
					rID = r.nextInt(items.length);
					System.out.println(type + ":" + items[rID]);
					IVM.set(new Holder<IItem>(IM.get(items[rID])));
					break;
				case 1:
					rID = r.nextInt(WM.size());
					System.out.println(type + ":" + rID);
					System.out.println(WM.get(rID).getName());
					weaponHolder.place(WM.get(rID));
					groupID = 0;
					callEvent(610);
					IVM.set(new Holder<IWeapon>(weaponHolder.get()));
					break;
				case 2:
					rID = r.nextInt(EM.size());
					System.out.println(type + ":" + rID);
					System.out.println(EM.get(rID).getName());
					equipmentHolder.place(EM.get(rID));
					groupID = 1;
					callEvent(610);
					IVM.set(new Holder<IEquipment>(equipmentHolder.get()));
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
	
	public void randomEncounter()
	{
		System.out.println("A random Encounter!");
		callEvent(910);
	}

	public void bossEncounter()
	{
		System.out.println("Its the Boss!");
		callEvent(910);
	}

	@SuppressWarnings("resource")
	public void userAddedItem()
	{
		Scanner userIn = new Scanner(System.in);
		int input;
		
		System.out.println("What type of item do you want?\n1: Item\n2: Weapon\n3: Equipment");
		input = userIn.nextInt();
		
		switch(input)
		{
			case 1:
				callEvent(660);
				break;
			case 2:
				callEvent(670);
				break;
			case 3:
				callEvent(680);
				break;
		}
	}
	
	@SuppressWarnings("resource")
	public void addItem()
	{
		Scanner userIn = new Scanner(System.in);
		int input;
		
		System.out.println("What kind of item do you want?");
		for(int index = 0; index < IM.size(); index++)
			System.out.println(index + ": " + IM.get(index).getName());
		input = userIn.nextInt();
		
		if(input >= 0 && input < IM.size())
		{
			System.out.println(IM.get(input).getName() + " was added to Inventory");
			IVM.set(new Holder<IItem>(IM.get(input)));
		}
		else
			System.out.println("Nope");
	}
	
	@SuppressWarnings("resource")
	public void addWeapon()
	{
		Scanner userIn = new Scanner(System.in);
		int input;
		
		System.out.println("What kind of Weapon do you want?");
		for(int index = 0; index < WM.size(); index++)
			System.out.println(index + ": " + WM.get(index).getName());
		input = userIn.nextInt();
		
		if(input >= 0 && input < WM.size())
		{
			System.out.println(WM.get(input).getName() + " was added to Inventory");
			IVM.set(new Holder<IWeapon>(WM.get(input)));
		}
		else
			System.out.println("Nope");
	}
	
	@SuppressWarnings("resource")
	public void addEquipment()
	{
		Scanner userIn = new Scanner(System.in);
		int input;
		
		System.out.println("What kind of Weapon do you want?");
		for(int index = 0; index < EM.size(); index++)
			System.out.println(index + ": " + EM.get(index).getName());
		input = userIn.nextInt();
		
		if(input >= 0 && input < EM.size())
		{
			System.out.println(EM.get(input).getName() + " was added to Inventory");
			IVM.set(new Holder<IEquipment>(EM.get(input)));
		}
		else
			System.out.println("Nope");
	}
	
	public void boostAttack()
	{
		int attackMaxBoost = heroHolder.get().getAttackMax();
		int attackMinBoost = heroHolder.get().getAttackMin();
		attackMaxBoost += (int)(1.0 + (itemHolder.get().getEffect() / 100.0));
		attackMinBoost += (int)(1.0 + (itemHolder.get().getEffect() / 100.0));
		
		heroHolder.get().setAttackMax(attackMaxBoost);
		heroHolder.get().setAttackMin(attackMinBoost);
	}
	
	public void boostDefence()
	{
		int defenceBoost = heroHolder.get().getPhyDefense();
		
		defenceBoost += (int)(1.0 + (itemHolder.get().getEffect() / 100.0));
		
		heroHolder.get().setPhyDefense(defenceBoost);
	}
	
	public void boostMagicDefence()
	{
		int defenceBoost = heroHolder.get().getMagDefense();
		
		defenceBoost += (int)(1.0 + (itemHolder.get().getEffect() / 100.0));
		
		heroHolder.get().setMagDefense(defenceBoost);
	}
	
	public void boostSpeed()
	{
		int speedBoost = heroHolder.get().getSpeed();
		
		speedBoost += (int)(1.0 + (itemHolder.get().getEffect() / 100.0));
		
		heroHolder.get().setSpeed(speedBoost);
	}
	
	public void boostAccuracy()
	{
		double accuracyBoost = heroHolder.get().getAccuracy();
		
		accuracyBoost += 1.0 + (itemHolder.get().getEffect() / 100.0);
		
		heroHolder.get().setAccuracy(accuracyBoost);
	}
	
	public void boostAll()
	{
		boostAttack();
		boostDefence();
		boostMagicDefence();
		boostSpeed();
		boostAccuracy();
	}

	public void itemBoxAction()
	{
		
	}
	
	public void causesKO()
	{
		heroHolder.get().setStatus(050);
	}
	
	@SuppressWarnings("resource")
	public void causesKOOverride()
	{
		Scanner userIn = new Scanner(System.in);
		int input = 0;
		
		for(int index = 0; index < PM.size(); index++)
			System.out.println(index + ": " + PM.get(index).getName());
		System.out.println("Select a Party member to be autoKO");
		input = userIn.nextInt();
		
		heroHolder.place(PM.get(input));
		heroHolder.get().setHP(0);
		callEvent(480);
	}

	public void cureKO()
	{
		int hp = 0;
		
		if(heroHolder.get().getStatus() == 050)
		{
			heroHolder.get().setStatus(000);
			hp = (int)(heroHolder.get().getHPMax() * (itemHolder.get().getEffect() / 100.0));
			
			if(hp <= heroHolder.get().getHPMax())
				heroHolder.get().setHP(hp);
			else
				heroHolder.get().setHP(heroHolder.get().getHPMax());
		}
		else
			System.out.println("The hero is ok");
	}

	public void restoresHP()
	{
		int hpTotal = heroHolder.get().getHP();
		hpTotal += (int)((double)heroHolder.get().getHPMax() * ((itemHolder.get().getEffect() / 100.0)));
		
		if(hpTotal > heroHolder.get().getHPMax())
			heroHolder.get().setHP(heroHolder.get().getHPMax());
		else
			heroHolder.get().setHP(hpTotal);
	}

	public void addHP()
	{
		int hpBoost = heroHolder.get().getHPMax();
		hpBoost += (int)(1.0 + (itemHolder.get().getEffect() / 100.0));
		
		heroHolder.get().setHPMax(hpBoost);
	}

	public void restoresHPSP()
	{
		restoresHP();
		restoresSP();
	}

	public void addHPSP()
	{
		addHP();
		addSP();
	}

	public void restoresSP()
	{
		int spTotal = heroHolder.get().getSP();
		spTotal += (int)((double)heroHolder.get().getSPMax() * ((itemHolder.get().getEffect() / 100.0)));
		
		if(spTotal > heroHolder.get().getHPMax())
			heroHolder.get().setSP(heroHolder.get().getSPMax());
		else
			heroHolder.get().setSP(spTotal);
	}

	public void addSP()
	{
		int spBoost = heroHolder.get().getSPMax();
		spBoost += (int)(1.0 + (itemHolder.get().getEffect() / 100.0));
		
		heroHolder.get().setSPMax(spBoost);
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
	
	@SuppressWarnings("resource")
	public void addPrefixOverride()
	{
		Scanner userIn = new Scanner(System.in);
		int input = 0;
		
		System.out.println("What type of object is it?\n1: Weapon\n2: Equipment");
		input = userIn.nextInt();
		
		if(input == 1)
		{
			for(int index = 0; index < IVM.size(); index++)
				System.out.println(index + ": " + ((IUsable) IVM.get(index).get()).getName());
			System.out.println("select the weapon to get a prefix");
			input = userIn.nextInt();
			
			if(input >= 0 && input < IVM.size() && ((IUsable) IVM.get(input).get()).getType().equals("Weapon"))
			{
				weaponHolder.place((IWeapon) IVM.get(input).get());
				groupID = 0;
				callEvent(610);
				IVM.replace(weaponHolder, input);
			}
			else
				callEvent(616);
		}
		else if(input == 2)
		{
			for(int index = 0; index < IVM.size(); index++)
				System.out.println(index + ": " + ((IUsable) IVM.get(index).get()).getName());
			System.out.println("select the weapon to get a prefix");
			input = userIn.nextInt();
			
			if(input >= 0 && input < IVM.size() && ((IUsable) IVM.get(input).get()).getType().equals("Equipment"))
			{
				equipmentHolder.place((IEquipment) IVM.get(input).get());
				groupID = 1;
				callEvent(610);
				IVM.replace(equipmentHolder, input);
			}
			else
				callEvent(616);
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
	
	public void save()
	{
		PrintStream out = null;
		String s = "";
		
		try
		{
			out = new PrintStream(new File("InventorySave.txt"));
			DM.saveDungeon();
		}
		catch(Exception e)
		{
			callEvent(906);
		}
		
		for(int index = 0; index < IVM.size(); index++)
		{
			s += ((IUsable) IVM.get(index).get()).getType() + " : ";
			s += ((IUsable) IVM.get(index).get()).getID();
			
			if(((IUsable)IVM.get(index).get()).getEventID() % 10 == 1)
				s += " : " + ((IPrefix) IVM.get(index).get()).getPrefixID();
			
			out.println(s);
			s = "";
		}
		
		out.close();
		callEvent(909);
	}
	
	public void load()
	{
		Scanner in = null;
		String s = "";
		IVM = new InventoryManager();
		
		try
		{
			in = new Scanner(new File("InventorySave.txt"));
			DM.restoreDungeon();
		}
		catch(Exception e)
		{
			callEvent(906);
		}
		
		while(in.hasNextLine())
		{
			s = in.nextLine();
			String[] temp = s.split(" : ");
			
			if(temp[0].equals("Item"))
			{
				itemHolder.place(IM.get(Integer.parseInt(temp[1]) - 1));
				IVM.set(new Holder<IItem>(itemHolder.get()));
			}
			else if(temp[0].equals("Equipment"))
			{
				equipmentHolder.place(EM.get(Integer.parseInt(temp[1]) - 1));
				
				if(temp.length == 3)
					equipmentHolder.place(EG.getPrefix(equipmentHolder.get(), Integer.parseInt(temp[2])));
				
				IVM.set(new Holder<IEquipment>(equipmentHolder.get()));
			}
			else if(temp[0].equals("Weapon"))
			{
				weaponHolder.place(WM.get(Integer.parseInt(temp[1]) - 1));
				
				if(temp.length == 3)
					weaponHolder.place(WG.getPrefix(weaponHolder.get(), Integer.parseInt(temp[2])));
				
				IVM.set(new Holder<IWeapon>(weaponHolder.get()));
			}
			else
				callEvent(906);
		}
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
		HG = new HeroGenerator();
		VG = new VillainGenerator();
		callEvent(850);
	}
	
	public void buildFloors()
	{
		FM = new FloorManager();
		callEvent(860);
	}
	
	public void buildDungeon()
	{
		DM = new DungeonManager();
		callEvent(870);
	}
	
	public void buildInventory()
	{
		IVM = new InventoryManager();
		callEvent(880);
	}
	
	public void buildSaveManager()
	{
		floorSave = new SQLManager();
		
		// Party Save
		callEvent(890);
	}
	
	public void buildOtherManagers()
	{
		// builds Party, Menu, Battle, and any other managers to be
		// Menu
		MM = new MenuManager();
		MM.set(new PauseMenu(this));
		MM.set(new InventoryMenu(this));
		
		// Party
		IParty temp = HG.chooseHeroes();
		PM = new PartyManager(temp.size());
		
		for(int index = 0; index < temp.size(); index++)
			PM.set((IHero) temp.getChar(index));
		
		//End
		callEvent(899);
	}
}
