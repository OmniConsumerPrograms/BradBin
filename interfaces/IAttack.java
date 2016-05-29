//OCP
//Attack Interface

package interfaces;

import java.util.Random;

public interface IAttack 
{
	
	public String getAttackName();
	
	public void setAttackName(String attackName);
	
	public char getRange();
	
	public int getID();
	
	public int getEventID();
	
	public int getSkillCost();

	public void toAttack(ICharacter hero, ICharacter villain);
	
	public boolean validAttack(ICharacter hero, Random gen);
}