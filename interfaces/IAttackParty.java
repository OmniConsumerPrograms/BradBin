//OCP
//AttackParty Interface

package interfaces;

import java.util.Random;

public interface IAttackParty
{
	
	public String getAttackName();
	
	public void setAttackName(String attackName);
	
	public char getRange();
	
	public int getID();
	
	public int getEventID();
	
	public int getSkillCost();
	
	public boolean validAttack(ICharacter hero, Random gen);
}