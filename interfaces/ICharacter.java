// OCP
// Character Interface

package interfaces;

public interface ICharacter
{
	public String getName();
	
	public void setName(String name);
	
	public int getHPMax();
	
	public void setHPMax(int hp);
	
	public int getHP();
	
	public void setHP(int hp);
	
	public int getAttackMin();
	
	public void setAttackMin(int attackMin);
	
	public int getAttackMax();
	
	public void setAttackMax(int attackMax);
	
	public int getSpeed();
	
	public void setSpeed(int speed);
	
	public int getPhyDefense();
	
	public void setPhyDefense(int phyDefense);
	
	public int getMagDefense();
	
	public void setMagDefense(int magDefense);
	
	public int getAccuracy();
	
	public void setAccuracy(int accuracy);
	
	public boolean isAlive();
	
	public String charString();
	
	public void attack(ICharacter incomingCharacter, int choiceInput);
	
	public boolean validAttackChoice(int x);
}
