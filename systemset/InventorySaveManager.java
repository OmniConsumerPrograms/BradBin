// Brad Howard
// OCP Inventory Save Manager

package systemset;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import interfaces.IEquipment;
import interfaces.IItem;
import interfaces.IPrefix;
import interfaces.ISave;
import interfaces.IUsable;
import interfaces.IWeapon;

public class InventorySaveManager implements ISave
{
	private PrintStream out;
	private Scanner in;

	public void load(Gamemaster GM) throws IOException
	{
		in = new Scanner(new File("InventorySave.txt"));
		String s = "";
		
		while(in.hasNextLine())
		{
			s = in.nextLine();
			String[] temp = s.split(" : ");
			
			if(temp[0].equals("Item"))
			{
				GM.itemHolder.place(GM.IM.get(Integer.parseInt(temp[1]) - 1));
				GM.IVM.set(new Holder<IItem>(GM.itemHolder.get()));
			}
			else if(temp[0].equals("Equipment"))
			{
				GM.equipmentHolder.place(GM.EM.get(Integer.parseInt(temp[1]) - 1));
				
				if(temp.length == 3)
					GM.equipmentHolder.place(GM.EG.getPrefix(GM.equipmentHolder.get(), Integer.parseInt(temp[2])));
				
				GM.IVM.set(new Holder<IEquipment>(GM.equipmentHolder.get()));
			}
			else if(temp[0].equals("Weapon"))
			{
				GM.weaponHolder.place(GM.WM.get(Integer.parseInt(temp[1]) - 1));
				
				if(temp.length == 3)
					GM.weaponHolder.place(GM.WG.getPrefix(GM.weaponHolder.get(), Integer.parseInt(temp[2])));
				
				GM.IVM.set(new Holder<IWeapon>(GM.weaponHolder.get()));
			}
			else
				GM.callEvent(906);
		}
	}

	public void save(Gamemaster GM) throws IOException
	{
		out = new PrintStream(new File("InventorySave.txt"));
		String s = "";
		
		for(int index = 0; index < GM.IVM.size(); index++)
		{
			s += ((IUsable) GM.IVM.get(index).get()).getType() + " : ";
			s += ((IUsable) GM.IVM.get(index).get()).getID();
			
			if(((IUsable)GM.IVM.get(index).get()).getEventID() % 10 == 1)
				s += " : " + ((IPrefix) GM.IVM.get(index).get()).getPrefixID();
			
			out.println(s);
			s = "";
		}
		
		out.close();
	}
}
