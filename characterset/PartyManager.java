// Brad Howard
// OCP Party Manager

package characterset;

import java.util.*;
import interfaces.IHero;
import interfaces.IManager;

public class PartyManager implements IManager<IHero>
{
	private ArrayList<IHero> party;
	private int partyLimit = 4;
	
	public PartyManager()
	{
		party = new ArrayList<IHero>(4);
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
		
		if(partyLimit < size())
			party.add(hero);
		else
		{
			System.out.println("You are at your party limit, chose some one to dismiss");
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
	
	public void replace(IHero hero, int index)
	{
		party.set(index, hero);
	}
	
	public int indexOf(IHero hero)
	{
		return party.indexOf(hero);
	}
	
	public boolean has(IHero hero)
	{
		return party.contains(hero);
	}
}
