// OCP
// Hero interface

package interfaces;

public interface IHero extends ICharacter
{
	public void level3Attack();
	
	public void level6Attack();
	
	public void level9Attack();
	
	public int getXP();
	
	public void setXP(int xp);
	
	public void levelUP(IHero hero);
	
	public String charString();
	
	public void attackListString();
}