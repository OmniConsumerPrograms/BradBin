// Brad Howard
// OCP weapon Generator

package weaponset;

import java.io.*;
import java.util.*;
import interfaces.IItemGenerator;
import interfaces.IManager;
import interfaces.IWeapon;

public class WeaponGenerator implements IItemGenerator<IWeapon>
{
	private IManager<IWeapon> WM;
	private IWeapon weapon;
	private int prefixNumber = 9;
	
	public WeaponGenerator()
	{
		WM = new WeaponManager();
	}
	
	public WeaponGenerator(IManager<IWeapon> WM)
	{
		this.WM = WM;
	}
	
	public int build()
	{
		Scanner in = null;
		File input = new File("weaponList.txt");
		weapon = null;
		int inputData = 0;
		
		try
		{
			in = new Scanner(input);
		}
		catch(IOException ioe)
		{
			return 826;
		}
		
		while(in.hasNext())
		{
			inputData = in.nextInt();
			weapon = makeWeapon(inputData);
			addWeapon(weapon);
		}
		
		in.close();
		return 830;
	}

	private void addWeapon(IWeapon weapon)
	{
		if(!WM.has(weapon))
			WM.set(weapon);
	}

	private IWeapon makeWeapon(int ID)
	{
		IWeapon weapon;
		
		switch(ID)
		{
			case 1:
				weapon = new ButterKnife(1);
				break;
			case 2:
				weapon = new NerfBat(1);
				break;
			case 3:
				weapon = new NerfLance(1);
				break;
			case 4:
				weapon = new NerfGun(1);
				break;
			case 5:
				weapon = new ShortSword(1);
				break;
			case 6:
				weapon = new Spear(1);
				break;
			case 7:
				weapon = new CrossBow(1);
				break;
			case 8:
				weapon = new Dagger(1);
				break;
			case 9:
				weapon = new ThrowingKnife(1);
				break;
			case 10:
				weapon = new ShortBow(1);
				break;
			case 11:
				weapon = new Staff(1);
				break;
			case 12:
				weapon = new LeadPipe(1);
				break;
			case 13:
				weapon = new Machete(1);
				break;
			case 14:
				weapon = new LongBow(1);
				break;
			case 15:
				weapon = new Halberd(1);
				break;
			case 16:
				weapon = new Javelin(1);
				break;
			case 17:
				weapon = new Hammer(1);
				break;
			case 18:
				weapon = new Mace(1);
				break;
			case 19:
				weapon = new Lance(1);
				break;
			case 20:
				weapon = new Katana(1);
				break;
			case 21:
				weapon = new Arquebus(1);
				break;
			case 22:
				weapon = new MagicStaff(1);
				break;
			case 23:
				weapon = new Blunderbuss(1);
				break;
			case 24:
				weapon = new Claymore(1);
				break;
			case 25:
				weapon = new Excalibur(1);
				break;
			case 26:
				weapon = new Gungnir(1);
				break;
			case 27:
				weapon = new SpearOfLonginus(1);
				break;
			case 28:
				weapon = new BowOfDestiny(1);
				break;
			case 29:
				weapon = new EggBlaster(1);
				break;
			case 30:
				weapon = new PlasteelSword(1);
				break;
			case 31:
				weapon = new Rifle(1);
				break;
			case 32:
				weapon = new Pistol(1);
				break;
			case 33:
				weapon = new GoldenGun(1);
				break;
			case 34:
				weapon = new RocketLauncher(1);
				break;
			case 35:
				weapon = new PhasePlasmaRifle(1);
				break;
			case 36:
				weapon = new ChargedParticleSword(1);
				break;
			case 37:
				weapon = new RailGun(1);
				break;
			case 38:
				weapon = new PhasePlasmaCutter(1);
				break;
			case 39:
				weapon = new AntiMatterCannon(1);
				break;
			case 40:
				weapon = new OmotaniumBlaster(1);
				break;
			default:
				weapon = new ButterKnife(99);
				break;
		}
		
		return weapon;
	}
	
	public void levelUp(IWeapon weapon, int tier)
	{
		weapon.setTier(tier);
	}
	
	public IWeapon fix(IWeapon weapon)
	{
		if(weapon.getName().contains("Busted"))
		{
			int ID = weapon.getID();
			int tier = weapon.getTier();
			weapon = makeWeapon(ID);
			if(tier != 1)
				levelUp(weapon, tier);
		}
		return weapon;
	}
	
	public IWeapon getRandomPrefix(IWeapon weapon)
	{
		if(weapon.getPFLimit() == 0)
			return weapon;
		
		Random r = new Random();
		int rID = r.nextInt(prefixNumber);
		
		switch(rID)
		{
			case 0:
				weapon = new Busted(weapon);
				break;
			case 1:
				weapon = new Dull(weapon);
				break;
			case 2:
				weapon = new Awesome(weapon);
				break;
			case 3:
				weapon = new Godly(weapon);
				break;
			case 4:
				weapon = new Awful(weapon);
				break;
			case 5:
				weapon = new Furious(weapon);
				break;
			case 6:
				weapon = new Light(weapon);
				break;
			case 7:
				weapon = new Heavy(weapon);
				break;
			case 8:
				weapon = new Legendary(weapon);
				break;
			default:
				weapon = new Busted(weapon);
				break;
		}
		
		return weapon;
	}
}