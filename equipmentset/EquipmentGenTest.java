// Brad Howard
// OCP equipment generator tester

package equipmentset;

import interfaces.IManager;
import interfaces.IEquipment;
import interfaces.IItemGenerator;

public class EquipmentGenTest
{
	public static void main(String[] args)
	{
		IManager<IEquipment> EM = new EquipmentManager();
		IItemGenerator<IEquipment> EG = new EquipmentGenerator(EM);
		int eventID = 000;
		
		eventID = EG.build();
		
		if(eventID == 840)
		{
			EG.levelUp(EM.get(1), 50);
			EG.levelUp(EM.get(2), 60);
			EG.levelUp(EM.get(3), 70);
			EG.levelUp(EM.get(4), 80);
			EG.levelUp(EM.get(5), 100);
			EM.set(EG.getRandomPrefix(EM.get(1)));
			EM.set(EG.getRandomPrefix(EM.get(2)));
			EM.set(EG.getRandomPrefix(EM.get(3)));
			EM.set(EG.getRandomPrefix(EM.get(4)));
			EM.set(EG.getRandomPrefix(EM.get(5)));
			EM.set(EG.getRandomPrefix(EM.get(6)));
			EM.set(EG.getRandomPrefix(EM.get(7)));
			EM.set(EG.getRandomPrefix(EM.get(8)));
			EM.set(EG.getRandomPrefix(EM.get(9)));
			EM.set(EG.getRandomPrefix(EM.get(10)));
			EM.set(EG.getRandomPrefix(EM.get(11)));
			EM.set(EG.getRandomPrefix(EM.get(12)));
			
			for(int index = 1; index < EM.size(); index++)
			{
				System.out.println("ID: " + EM.get(index).getID());
				System.out.println("Event ID: " + EM.get(index).getEventID());
				System.out.println("Name: " + EM.get(index).getName());
				System.out.println("Info: " + EM.get(index).getType());
				System.out.println("Physical Defense: " + EM.get(index).getPhysicalDefense());
				System.out.println("Magical Defense: " + EM.get(index).getMagicalDefense());
				System.out.println("Speed: " + EM.get(index).getSpeed());
				System.out.println("Weight: " + EM.get(index).getWeight());
				System.out.println("Durablity: " + EM.get(index).getDurability());
				System.out.println("Tier: " + EM.get(index).getTier());
				System.out.println("PF limit: " + EM.get(index).getPFLimit());
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		}
		else
			System.out.println("836 error");
	}
}
