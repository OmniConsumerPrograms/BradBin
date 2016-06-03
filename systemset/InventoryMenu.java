// Brad Howard
// OCP Menus

package systemset;

import interfaces.IEquipment;
import interfaces.IItem;
import interfaces.IMenuSystem;
import interfaces.IUsable;
import interfaces.IWeapon;

import java.util.*;

public class InventoryMenu implements IMenuSystem
{
	private static Scanner userInput;
	private String menuType = "Inventory";
	private Gamemaster GM;
	private int oID = 0;
	private int trip = 0;
	
	public InventoryMenu(Gamemaster GM)
	{
		this.GM = GM;
		userInput = new Scanner(System.in);
	}
	
	public String menuType()
	{
		return menuType;
	}
	
	public int runMenu(Gamemaster P)
	{	
		int menuNumber = 0;
		
		if(P != null)
			this.GM = P;
		
		while(true)
		{
			System.out.println(menuType());
			System.out.println(GM.IVM.toString());
			System.out.println("\n~~~Inventory Menu~~~");
			System.out.println("1: Equip Weapon/Equipment    2: Unequip Weapon/Equipment");
			System.out.println("3: Use Item                  4: discard object");
			System.out.println("5: Get object details        6: Continue game");
			menuNumber = userInput.nextInt();
			
			switch(menuNumber)
			{
				case 1:
					equip();
					break;
				case 2:
					unequip();
					break;
				case 3:
					use();
					break;
				case 4:
					discard();
					break;
				case 5:
					detail();
					break;
				case 6:
					return 909;
			}
		}
	}
	
	private void equip()
	{
		while(trip != 1)
		{
			System.out.println(GM.IVM.toString());
			System.out.println("\nSelect weapon or equipment");
			oID = userInput.nextInt() - 1;
			
			if(oID < 0)
				trip = 1;
			else if(oID >= 0 && oID < GM.IVM.size() && !((IUsable) GM.IVM.get(oID).get()).getType().equals("Item"))
			{
				System.out.println(((IUsable) GM.IVM.get(oID).get()).getName());
				trip = 1;
				
				if(((IUsable) GM.IVM.get(oID).get()).getType().equals("Weapon"))
				{
					GM.weaponHolder.place((IWeapon) GM.IVM.remove(oID).get());
					GM.groupID = 0;
				}
				else
				{
					GM.equipmentHolder.place((IEquipment) GM.IVM.remove(oID).get());
					GM.groupID = 1;
				}
			}
			else
				System.out.println("Trying to equip an Item.");
		}
		trip = 0;
		
		while(trip != 1)
		{
			System.out.println(GM.PM);
			System.out.println("Select party member to equip weapon or equipment");
			oID = userInput.nextInt();
			
			if(oID < 0)
				trip = 1;
			else if(oID >= 0 && oID < GM.PM.size())
			{
				GM.heroHolder.place(GM.PM.get(oID));
				trip = 1;
			}
			else
				System.out.println("That is not a party member.");
		}
		trip = 0;
		
		while(trip != 1 && GM.groupID == 1)
		{
			System.out.println("Select witch equipment slot to place it");
			System.out.println("1: " + GM.heroHolder.get().getEquipment(0).getName() + " 2: " + GM.heroHolder.get().getEquipment(1).getName() + " 3: " + GM.heroHolder.get().getEquipment(2).getName());
			oID = userInput.nextInt();
			
			if(oID < 0)
				trip = 1;
			else if(oID >= 1 && oID < 4)
			{
				GM.ID = oID;
				trip = 1;
			}
			else
				System.out.println("That is not a slot");
		}
		trip = 0;
		
		if(oID >= 0)
			GM.callEvent(733);
	}
	
	private void unequip()
	{
		while(trip != 1)
		{
			System.out.println(GM.PM);
			System.out.println("Select party member to unequip weapon or equipment");
			oID = userInput.nextInt();
			
			if(oID < 0)
				trip = 1;
			else if(oID >= 0 && oID < GM.PM.size())
			{
				GM.heroHolder.place(GM.PM.get(oID));
				trip = 1;
			}
			else
				System.out.println("That is not a Party member.");
		}
		trip = 0;
		
		while(trip != 1)
		{
			System.out.println("What is it that you want to unquip?\n1: Weapon\n2: Equipment");
			oID = userInput.nextInt();
			
			if(oID <= 0)
				trip = 1;
			else if(oID == 1)
			{
				GM.groupID = 0;
				trip = 1;
			}
			else if(oID == 2)
			{
				GM.groupID = 1;
				trip = 1;
			}
			else
				System.out.println("What is that? I do not think that is such a thing.");
		}
		trip = 0;
		
		while(trip != 1 && GM.groupID == 1)
		{
			System.out.println("Select witch equipment slot to place it");
			System.out.println("1: " + GM.heroHolder.get().getEquipment(0).getName() + " 2: " + GM.heroHolder.get().getEquipment(1).getName() + " 3: " + GM.heroHolder.get().getEquipment(2).getName());
			oID = userInput.nextInt();
			
			if(oID < 0)
				trip = 1;
			else if(oID >= 1 && oID < 4)
			{
				GM.ID = oID;
				trip = 1;
			}
			else
				System.out.println("That is not a slot");
		}
		trip = 0;
		
		if(oID >= 0)
			GM.callEvent(734);
	}
	
	private void use()
	{
		while(trip != 1)
		{
			System.out.println(GM.IVM.toString());
			System.out.println("Select item");
			oID = userInput.nextInt() - 1;
			
			if(oID < 0)
				trip = 1;
			else if(oID >= 0 && oID < GM.IVM.size() && ((IUsable) GM.IVM.get(oID).get()).getType().equals("Item"))
			{
				System.out.println(((IUsable) GM.IVM.get(oID).get()).getName());
				trip = 1;
			}
			else
				System.out.println("Trying to use an equipment and weapon.");
		}
		trip = 0;
		if(oID >= 0)
		{
			GM.itemHolder.place((IItem) GM.IVM.get(oID).get());
			GM.ID = oID;
			GM.groupID = 2;
			GM.callEvent(730);
		}
	}
	
	private void discard()
	{
		while(trip != 1)
		{
			System.out.println(GM.IVM.toString());
			System.out.println("Select weapon, equipment, or Item to be discard");
			oID = userInput.nextInt() - 1;
			
			if(oID < 0)
				trip = 1;
			else if(oID >= 0 && oID < GM.IVM.size())
			{
				System.out.println(((IUsable) GM.IVM.get(oID).get()).getName());
				trip = 1;
			}
			else
				System.out.println("Trying to discard some thing you don't have");
		}
		trip = 0;
		if(oID >= 0 && oID < GM.IVM.size())
		{
			GM.ID = oID;
			GM.callEvent(735);
		}
	}
	
	private void detail()
	{
		while(trip != 1)
		{
			System.out.println(GM.IVM.toString());
			System.out.println("Select weapon, equipment, or Item to be looked at");
			oID = userInput.nextInt() - 1;
			
			if(oID < 0)
				trip = 1;
			else if(oID >= 0 && oID < GM.IVM.size())
			{
				String temp = ((IUsable) GM.IVM.get(oID).get()).getType();
				if(temp.equals("Weapon"))
				{
					WeaponData getter = new WeaponData();
					System.out.println(getter.getData((IWeapon) GM.IVM.get(oID).get()));
				}
				else if(temp.equals("Equipment"))
				{
					EquipmentData getter = new EquipmentData();
					System.out.println(getter.getData((IEquipment) GM.IVM.get(oID).get()));
				}
				else // Item
				{
					ItemData getter = new ItemData();
					System.out.println(getter.getData((IItem) GM.IVM.get(oID).get()));
				}
				trip = 1;
			}
			else
				System.out.println("Trying to look at some thing that is not there.");
		}
		trip = 0;
	}
}
