// Brad Howard
// OCP equipment Generator

package equipmentset;

import java.io.*;
import java.util.*;
import interfaces.IItemGenerator;
import interfaces.IEquipment;
import interfaces.IManager;

public class EquipmentGenerator implements IItemGenerator<IEquipment>
{
	private IManager<IEquipment> EM;
	private IEquipment equipment;
	private int prefixNumber = 9;
	
	public EquipmentGenerator()
	{
		EM = new EquipmentManager();
	}
	
	public EquipmentGenerator(IManager<IEquipment> EM)
	{
		this.EM = EM;
	}
	
	public int build()
	{
		Scanner in = null;
		File input = new File("equipmentList.txt");
		equipment = null;
		int inputData = 0;
		
		try
		{
			in = new Scanner(input);
		}
		catch(IOException ioe)
		{
			return 836;
		}
		
		while(in.hasNext())
		{
			inputData = in.nextInt();
			equipment = makeEquipment(inputData);
			addEquipment(equipment);
		}
		
		in.close();
		return 840;
	}

	private void addEquipment(IEquipment equipment)
	{
		if(!EM.has(equipment))
			EM.set(equipment);
	}

	private IEquipment makeEquipment(int ID)
	{
		IEquipment equipment;
		
		switch(ID)
		{
			case 1:
				equipment = new PaperArmor(1);
				break;
			case 2:
				equipment = new MagicShirt(1);
				break;
			case 3:
				equipment = new PotLid(1);
				break;
			case 4:
				equipment = new RubberGloves(1);
				break;
			case 5:
				equipment = new GoldenRing(1);
				break;
			case 6:
				equipment = new HardHat(1);
				break;
			case 7:
				equipment = new WoodenShield(1);
				break;
			case 8:
				equipment = new TinHelmet(1);
				break;
			case 9:
				equipment = new Chainmail(1);
				break;
			case 10:
				equipment = new IronGauntlet(1);
				break;
			case 11:
				equipment = new IronShield(1);
				break;
			case 12:
				equipment = new IronChestPlate(1);
				break;
			case 13:
				equipment = new MagicalVest(1);
				break;
			case 14:
				equipment = new Scalemail(1);
				break;
			case 15:
				equipment = new GreatHelm(1);
				break;
			case 16:
				equipment = new KiteShield(1);
				break;
			case 17:
				equipment = new Dragonmail(1);
				break;
			case 18:
				equipment = new Platemail(1);
				break;
			case 19:
				equipment = new SteelChestPlate(1);
				break;
			case 20:
				equipment = new LargeShield(1);
				break;
			case 21:
				equipment = new MythrilChestPlate(1);
				break;
			case 22:
				equipment = new MythrilSheild(1);
				break;
			case 23:
				equipment = new SpectreVest(1);
				break;
			case 24:
				equipment = new SpectreCloak(1);
				break;
			case 25:
				equipment = new PlasteelArmor(1);
				break;
			case 26:
				equipment = new PlasteelShield(1);
				break;
			case 27:
				equipment = new PlasmaShield(1);
				break;
			case 28:
				equipment = new NeutroniumArmor(1);
				break;
			case 29:
				equipment = new PhasedCloak(1);
				break;
			case 30:
				equipment = new OmotaniumPDS(1);
				break;
			default:
				equipment = new PaperArmor(99);
				break;
		}
		
		return equipment;
	}
	
	public void levelUp(IEquipment equipment, int tier)
	{
		equipment.setTier(tier);
	}
	
	public IEquipment fix(IEquipment equipment)
	{
		if(equipment.getName().contains("Busted"))
		{
			int ID = equipment.getID();
			int tier = equipment.getTier();
			equipment = makeEquipment(ID);
			if(tier != 1)
				levelUp(equipment, tier);
		}
		return equipment;
	}
	
	public IEquipment getRandomPrefix(IEquipment equipment)
	{
		if(equipment.getPFLimit() == 0)
			return equipment;
		
		Random r = new Random();
		int rID = r.nextInt(prefixNumber) + 1;
		
		return getPrefix(equipment, rID);
	}
	
	public IEquipment getPrefix(IEquipment equipment, int ID)
	{
		if(equipment.getPFLimit() == 0)
			return equipment;
		
		switch(ID)
		{
			case 1:
				equipment = new Arcane(equipment);
				break;
			case 2:
				equipment = new Armored(equipment);
				break;
			case 3:
				equipment = new Enchanted(equipment);
				break;
			case 4:
				equipment = new Guarding(equipment);
				break;
			case 5:
				equipment = new Hard(equipment);
				break;
			case 6:
				equipment = new Heavy(equipment);
				break;
			case 7:
				equipment = new Light(equipment);
				break;
			case 8:
				equipment = new Magical(equipment);
				break;
			case 9:
				equipment = new Spiritual(equipment);
				break;
			case 10:
				equipment = new Warding(equipment);
				break;
			default:
				equipment = new Arcane(equipment);
				break;
		}
		
		return equipment;
	}
}