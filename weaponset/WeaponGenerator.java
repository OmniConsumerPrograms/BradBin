// Brad Howard
// OCP weapon Generator

package weaponset;

import java.io.*;
import java.util.*;

public class WeaponGenerator
{
	private IManager<IWeapon> WM;
	private IWeapon weapon;
	private int prefixNumber = 4;
	
	public WeaponGenerator()
	{
		WM = new WeaponManager();
	}
	
	public WeaponGenerator(WeaponManager WM)
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
		return 820;
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
			default:
				weapon = new ButterKnife(99);
				break;
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
			default:
				weapon = new Busted(weapon);
				break;
		}
		
		return weapon;
	}
}