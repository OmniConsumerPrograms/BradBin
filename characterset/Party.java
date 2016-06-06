//OCP
//Party

package characterset;

import interfaces.ICharacter;
import interfaces.IParty;

import java.util.*;

public class Party implements IParty
{
	private int turn;
	private boolean active; 
	private ArrayList<ICharacter> party;
	
	public Party() 
	{
		this.setTurn(0);
		this.setActive(true);
		this.setParty(new ArrayList<ICharacter>());
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public void turnPlusPlus()
	{
		this.turn++;
	}	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ArrayList<ICharacter> getParty() {
		return party;
	}

	public void setParty(ArrayList<ICharacter> party) {
		this.party = party;
	}
	
	public ICharacter getChar(int i)
	{
		return this.party.get(i);
	}
	
	public void addChar(ICharacter theChar)
	{
		this.party.add(theChar);
	}
	
	public void removeChar(int i)
	{
		this.party.remove(i);
	}
	
	public int size()
	{
		return this.party.size();
	}
	
	public void partyString()
	{
		int i;
		ICharacter cur;
		
		for( i = 0; i < size(); i++)
		{
			cur = getChar(i);
			System.out.println((i+1) +  ". " + cur.charString() );
		}
	}
}
