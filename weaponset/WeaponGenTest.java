package weaponset;

public class WeaponGenTest
{
	public static void main(String[] args)
	{
		WeaponManager WM = new WeaponManager();
		WeaponGenerator WG = new WeaponGenerator(WM);
		int eventID = 000;
      
		eventID = WG.build();
      
		WM.set(WG.getRandomPrefix(WM.get(1)));
		WM.set(WG.getRandomPrefix(WM.get(1)));
		WM.set(WG.getRandomPrefix(WM.get(2)));
		WM.set(WG.getRandomPrefix(WM.get(2)));
		WM.set(WG.getRandomPrefix(WM.get(3)));
		WM.set(WG.getRandomPrefix(WM.get(3)));
		
      if(eventID == 820)
      {
		 for(int index = 0; index < 11; index++)
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
