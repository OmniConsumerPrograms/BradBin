// Brad Howard
// OCP equipment Generator

package equipmentset;

import java.io.*;
import java.util.*;

public class EquipmentGenerator
{
	private IManager<IEquipment> EM;
	private IEquipment equipment;
	private int prefixNumber = 9;
	
	public EquipmentGenerator()
	{
		EM = new EquipmentManager();
	}
	
	public EquipmentGenerator(EquipmentManager EM)
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
			default:
				equipment = new PaperArmor(99);
				break;
		}
		
		return equipment;
	}
	
	public void levelEquipmentUp(IEquipment equipment, int tier)
	{
		equipment.setTier(tier);
	}
	
	public IEquipment fixEquipment(IEquipment equipment)
	{
		if(equipment.getName().contains("Busted"))
		{
			int ID = equipment.getID();
			int tier = equipment.getTier();
			equipment = makeEquipment(ID);
			if(tier != 1)
				levelEquipmentUp(equipment, tier);
		}
		return equipment;
	}
	
	public IEquipment getRandomPrefix(IEquipment equipment)
	{
		if(equipment.getPFLimit() == 0)
			return equipment;
		
		Random r = new Random();
		int rID = r.nextInt(prefixNumber);
		
		switch(rID)
		{
			case 0:
				equipment = new Hard(equipment);
				break;
			case 1:
				equipment = new Guarding(equipment);
				break;
			case 2:
				equipment = new Armored(equipment);
				break;
			case 3:
				equipment = new Warding(equipment);
				break;
			case 4:
				equipment = new Light(equipment);
				break;
			case 5:
				equipment = new Heavy(equipment);
				break;
			case 6:
				equipment = new Spiritual(equipment);
				break;
			case 7:
				equipment = new Magical(equipment);
				break;
			case 8:
				equipment = new Enchanted(equipment);
				break;
			default:
				equipment = new Arcane(equipment);
				break;
		}
		
		return equipment;
	}
}