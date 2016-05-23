// Brad Howard
// OCP Inventory Manager Tester

package systemset;

import interfaces.*;
import equipmentset.*;
import itemset.*;
import weaponset.*;

public class InventoryManTester
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		InventoryManager IM = new InventoryManager();
		IBin<IUsable>[] set = new IBin[5];
		
		set[0] = new Holder<IUsable>();
		set[1] = new Holder<IUsable>();
		set[2] = new Holder<IUsable>();
		set[3] = new Holder<IUsable>();
		set[4] = new Holder<IUsable>();
		
		set[0].place(new ShortSword(1));
		set[1].place(new CrossBow(1));
		set[2].place(new Potion());
		set[3].place(new MagicShirt(1));
		set[4].place(new EggBlaster(5));
		
		for(int i = 0; i < set.length; i++)
		{
			IM.set(set[i]);
		}
		
		for(int i = 0; i < IM.size(); i++)
		{
			IUsable temp = (IUsable)IM.get(i).get();
			
			System.out.println(temp.getName());
		}
	}
}
