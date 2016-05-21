package weaponset;

import interfaces.IWeapon;
import interfaces.IManager;
import interfaces.IItemGenerator;

public class WeaponGenTest
{
	public static void main(String[] args)
	{
		IManager<IWeapon> WM = new WeaponManager();
		IItemGenerator<IWeapon> WG = new WeaponGenerator(WM);
		int eventID = 000;
      
		eventID = WG.build();
		System.out.println(WM.size());
		WM.set(WG.getRandomPrefix(WM.get(1)));
		WM.set(WG.getRandomPrefix(WM.get(2)));
		WM.set(WG.getRandomPrefix(WM.get(3)));
		WM.set(WG.getRandomPrefix(WM.get(4)));
		WM.set(WG.getRandomPrefix(WM.get(5)));
		WM.set(WG.getRandomPrefix(WM.get(6)));
		WG.levelUp(WM.get(2), 3);
		WG.levelUp(WM.get(3), 4);
		WG.levelUp(WM.get(4), 5);
		WG.levelUp(WM.get(5), 8);
		WG.levelUp(WM.get(6), 20);
		WM.set(WG.getRandomPrefix(WM.get(12)));
		WG.levelUp(WM.get(6), 20);
		WG.levelUp(WM.get(10), 40);
		
      if(eventID == 830)
      {
		 for(int index = 0; index < WM.size(); index++)
         {
            System.out.println("ID: " + WM.get(index).getID());
			System.out.println("EvID: " + WM.get(index).getEventID());
			System.out.println("Name: " + WM.get(index).getName());
			System.out.println("Attack Type: " + WM.get(index).getAttackType());
			System.out.println("Attack: " + WM.get(index).getAttack());
			System.out.println("Range: " + WM.get(index).getRange());
			System.out.println("Speed: " + WM.get(index).getSpeed());
			System.out.println("Accuracy: " + WM.get(index).getAccuracy());
			System.out.println("Weight: " + WM.get(index).getWeight());
			System.out.println("Durability: " + WM.get(index).getDurability());
			System.out.println("Value: " + WM.get(index).getValue());
			System.out.println("Tier: " + WM.get(index).getTier());
			System.out.println("PF Limit: " + WM.get(index).getPFLimit());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
     }
		 System.out.println("Fixing");
		 int limit = WM.size();
		 for(int index = 1; index < limit; index++)
		 {
			 WM.set(WG.fix(WM.get(index)));
		 }
		 System.out.println("After Fixing");
		 for(int index = 1; index < WM.size(); index++)
         {
            System.out.println("ID: " + WM.get(index).getID());
			System.out.println("EvID: " + WM.get(index).getEventID());
			System.out.println("Name: " + WM.get(index).getName());
			System.out.println("Attack Type: " + WM.get(index).getAttackType());
			System.out.println("Attack: " + WM.get(index).getAttack());
			System.out.println("Range: " + WM.get(index).getRange());
			System.out.println("Speed: " + WM.get(index).getSpeed());
			System.out.println("Accuracy: " + WM.get(index).getAccuracy());
			System.out.println("Weight: " + WM.get(index).getWeight());
			System.out.println("Durability: " + WM.get(index).getDurability());
			System.out.println("Value: " + WM.get(index).getValue());
			System.out.println("Tier: " + WM.get(index).getTier());
			System.out.println("PF Limit: " + WM.get(index).getPFLimit());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
     }
  }
  else
     System.out.println("826 error");
	}
}
