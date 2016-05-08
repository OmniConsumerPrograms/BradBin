// Brad Howard
// OCP Item Generator

package itemset;

import java.io.*;
import java.util.*;

public class ItemGenerator
{
	private IManager<IItem> IM;
	private IItem item;
	
	public ItemGenerator()
	{
		IM = new ItemManager();
	}
	
	public ItemGenerator(ItemManager IM)
	{
		this.IM = IM;
	}
	
	public int build()
	{
		Scanner in = null;
		File input = new File("itemList.txt");
		item = null;
		int inputData = 0;
		
		try
		{
			in = new Scanner(input);
		}
		catch(IOException ioe)
		{
			return 816;
		}
		
		while(in.hasNext())
		{
			inputData = in.nextInt();
			item = makeItem(inputData);
			addItem(item);
		}
		
		in.close();
		return 810;
	}
	
	private void addItem(IItem item)
	{
		if(!IM.has(item))
			IM.set(item);
	}
	
	private IItem makeItem(int in)
	{
		IItem item;
		
		switch(in)
		{
			case 1:
				item = new Potion();
				item = new Low(item);
				break;
			case 2:
				item = new Potion();
				item = new Mid(item);
				break;
			case 3:
				item = new Potion();
				item = new High(item);
				break;
			case 4:
				item = new Potion();
				item = new Max(item);
				break;
			case 5:
				item = new Elixir();
				item = new Low(item);
				break;
			case 6:
				item = new Elixir();
				item = new Mid(item);
				break;
			case 7:
				item = new Elixir();
				item = new High(item);
				break;
			case 8:
				item = new Elixir();
				item = new Max(item);
				break;
			case 9:
				item = new MedKit();
				item = new Low(item);
				break;
			case 10:
				item = new MedKit();
				item = new Mid(item);
				break;
			case 11:
				item = new MedKit();
				item = new High(item);
				break;
			case 12:
				item = new MedKit();
				item = new Max(item);
				break;
			case 13:
				item = new RevivalTag();
				item = new Low(item);
				break;
			case 14:
				item = new RevivalTag();
				item = new Mid(item);
				break;
			case 15:
				item = new RevivalTag();
				item = new High(item);
				break;
			case 16:
				item = new RevivalTag();
				item = new Max(item);
				break;
			default:
				item = new Potion();
				break;
		}
		
		return item;
	}
}
