//OCP
//Attack Interface

package interfaces;

import java.util.Random;

public interface IHeal 
{
	public String getHealName();
	
	public void setHealName(String healName);
	
	public char getRange();
	
	public int getID();
	
	public int getEventID();
	
	public int getSkillCost();

	public void toHeal(ICharacter hero, ICharacter villain);
}