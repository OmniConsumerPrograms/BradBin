// Brad Howard
// OCP Menus

package systemset;

import interfaces.IItem;
import interfaces.IMenuSystem;
import interfaces.IUsable;

import java.util.*;

public class InventoryMenu implements IMenuSystem
{
	private static Scanner userInput;
	private String menuType = "Inventory";
	private ProtoGamemaster PGM;
	
	public InventoryMenu(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
		userInput = new Scanner(System.in);
	}
	
	public String menuType()
	{
		return menuType;
	}
	
	public int runMenu(ProtoGamemaster P)
	{	
		int menuNumber = 0;
		int oID = 0;
		int trip = 0;
		
		if(P != null)
			this.PGM = P;
		
		while(true)
		{
			System.out.println(menuType());
			System.out.println(PGM.IVM.toString());
			System.out.println("1: Equip Weapon/Equipment    2: Unequip Weapon/Equipment");
			System.out.println("3: Use Item                  4: discard object");
			System.out.println("5: Continue game");
			menuNumber = userInput.nextInt();
			
			switch(menuNumber)
			{
				case 1:
					while(trip != 1)
					{
						System.out.println(PGM.IVM.toString());
						System.out.println("Select weapon or equipment");
						oID = userInput.nextInt() - 1;
						
						if(oID < 0)
							trip = 1;
						else if(oID >= 0 && oID < PGM.IVM.size() && !((IUsable) PGM.IVM.get(oID).get()).getType().equals("Item"))
						{
							System.out.println(((IUsable) PGM.IVM.get(oID).get()).getName());
							trip = 1;
						}
						else
							System.out.println("Trying to equip an Item.");
					}
					trip = 0;
					if(oID >= 0)
						PGM.callEvent(733);
					break;
				case 2:
					while(trip != 1)
					{
						System.out.println(PGM.IVM.toString());
						System.out.println("Select weapon or equipment");
						oID = userInput.nextInt() - 1;
						
						if(oID < 0)
							trip = 1;
						else if(oID >= 0 && oID < PGM.IVM.size() && !((IUsable) PGM.IVM.get(oID).get()).getType().equals("Item"))
						{
							System.out.println(((IUsable) PGM.IVM.get(oID).get()).getName());
							trip = 1;
						}
						else
							System.out.println("Trying to unequip an Item.");
					}
					trip = 0;
					if(oID >= 0)
						PGM.callEvent(734);
					break;
				case 3:
					while(trip != 1)
					{
						System.out.println(PGM.IVM.toString());
						System.out.println("Select weapon or equipment");
						oID = userInput.nextInt() - 1;
						
						if(oID < 0)
							trip = 1;
						else if(oID >= 0 && oID < PGM.IVM.size() && ((IUsable) PGM.IVM.get(oID).get()).getType().equals("Item"))
						{
							System.out.println(((IUsable) PGM.IVM.get(oID).get()).getName());
							trip = 1;
						}
						else
							System.out.println("Trying to use an equipment and weapon.");
					}
					trip = 0;
					if(oID >= 0)
					{
						PGM.itemHolder.place((IItem) PGM.IVM.get(oID).get());
						PGM.ID = oID;
						PGM.groupID = 2;
						PGM.callEvent(730);
					}
					break;
				case 4:
					while(trip != 1)
					{
						System.out.println(PGM.IVM.toString());
						System.out.println("Select weapon, equipment, or Item to be discard");
						oID = userInput.nextInt() - 1;
						
						if(oID < 0)
							trip = 1;
						else if(oID >= 0 && oID < PGM.IVM.size())
						{
							System.out.println(((IUsable) PGM.IVM.get(oID).get()).getName());
							trip = 1;
						}
						else
							System.out.println("Trying to discard some thing you don't have");
					}
					trip = 0;
					if(oID >= 0 && oID < PGM.IVM.size())
					{
						PGM.ID = oID;
						PGM.callEvent(735);
					}
					break;
				case 5:
					return 909;
			}
		}
	}
}
