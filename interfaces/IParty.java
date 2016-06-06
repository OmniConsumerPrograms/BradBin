//OCP
//IParty

package interfaces;

//import Character;

import java.util.ArrayList;

public interface IParty 
{
	public int getTurn();
	
	public void setTurn(int turn);
	
	public void turnPlusPlus();
	
	public boolean isActive();

	public void setActive(boolean active);
	
	public ArrayList<ICharacter> getParty();
	
	public void setParty(ArrayList<ICharacter> party);
	
	public ICharacter getChar(int i);
	
	public void addChar(ICharacter theChar);
	
	public void removeChar(int i);
	
	public int size();
	
	public void partyString();
}
