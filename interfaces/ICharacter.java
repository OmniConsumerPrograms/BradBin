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
	
	public int getSPMax();
	
	public void setSPMax(int sp);
	
	public int getSP();
	
	public void setSP(int sp);
	
	public int getAttackMin();
	
	public void setAttackMin(int attackMin);
	
	public int getAttackMax();
	
	public void setAttackMax(int attackMax);
	
	public int getHealMin();
	
	public void setHealMin(int healMin);
	
	public int getHealMax();
	
	public void setHealMax(int healMax);
	
	public int getSpeed();
	
	public void setSpeed(int speed);
	
	public int getPhyDefense();
	
	public void setPhyDefense(int phyDefense);
	
	public int getMagDefense();
	
	public void setMagDefense(int magDefense);
	
	public double getAccuracy();
	
	public void setXP(int xp);
	
	public int getXP();
	
	public void setAccuracy(double accuracy);
	
	public boolean isAlive();
	
	public String charString();
	
	public void attack(ICharacter incomingCharacter, int choiceInput);
	
	public void heal(ICharacter healer, int choiceInput);
	
	public boolean validAttackChoice(int x);
	
	public int getStatus();
	
	public void setStatus(int eID);
	
	public int getSkillListSize();
	
	public int getHealListSize();
}