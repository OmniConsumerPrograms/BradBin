// Brad Howard
// OCP Party Manager

package characterset;

import java.util.*;
import interfaces.IHero;
import interfaces.IManager;
import systemset.CharacterData;

public class PartyManager implements IManager<IHero>
{
	private ArrayList<IHero> party; 
	private int partyLimit;
	
	public PartyManager(int size)
	{
		party = new ArrayList<IHero>(partyLimit);
		partyLimit = size;
	}
	
	public int size()
	{
		return party.size();
	}
	
	@SuppressWarnings("resource")
	public void set(IHero hero)
	{
		Scanner userIn = new Scanner(System.in);
		int partyMemberNumber = 0;
		
		if(partyLimit > size())
			party.add(hero);
		else
		{
			System.out.println("You are at your party limit, chose someone to dismiss");
			for(int index = 0; index < size(); index++)
				System.out.println(index + ": Name " + party.get(index).getName());
			System.out.print("chose: ");
			partyMemberNumber = userIn.nextInt();
			
			replace(hero, partyMemberNumber);
		}
	}
	
	public IHero get(int index)
	{
		return party.get(index);
	}
	
	public IHero remove(int index)
	{
		return party.remove(index);
	}
	
	public IHero replace(IHero hero, int index)
	{
		return party.set(index, hero);
	}
	
	public int indexOf(IHero hero)
	{
		return party.indexOf(hero);
	}
	
	public boolean has(IHero hero)
	{
		return party.contains(hero);
	}
	
	@Override
	public String toString()
	{
		String s = "";
		CharacterData getter = new CharacterData();
		
		for(int index = 0; index < size(); index++)
		{
			System.out.println("Party member: " + index);
			System.out.println(getter.getData(party.get(index)));
			System.out.println("~~~");
		}
		
		return s;
	}
}
