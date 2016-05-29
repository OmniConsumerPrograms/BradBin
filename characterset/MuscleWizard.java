// Brad Howard
// OCP extra Hero

package characterset;

import interfaces.ICharacter;
import interfaces.IEquipment;
import interfaces.IHero;
import interfaces.IWeapon;
import weaponset.BareHands;
import java.util.ArrayList;
import interfaces.IAttack;

public class MuscleWizard implements IHero
{
	String name;
	int HPMax;
	int HP;
	int SPMax;
	int SP;
	int attackMin;
	int attackMax;
	int speed;
	int phyDefense;
	int magDefense;
	double accuracy;
	int exp;
	int[] levelTrack;
	int level;
	int levelCap;
	ArrayList<IAttack> skillList;
	IEquipment[] equipmentSet;
	IWeapon weapon;
	
	public MuscleWizard(ArrayList<IAttack> skills)
	{
		name = "Muscle Wizard";
		HPMax = 20;
		HP = HPMax;
		SPMax = 10;
		SP = SPMax;
		attackMax = 10;
		attackMin = 5;
		speed = 2;
		accuracy = 50.0;
		phyDefense = 5;
		magDefense = 5;
		exp = 0;
		level = 1;
		levelCap = 10;
		levelTrack = new int[10];
		skillList = skills;
		equipmentSet = new IEquipment[3];
		weapon = new BareHands(1);
		
		setupEquipmentSet();
		buildLevelTrack();
	}
	
	private void setupEquipmentSet()
	{
		for(int index = 0; index < equipmentSet.length; index++)
			equipmentSet[index] = null;
	}
	
	private void buildLevelTrack()
	{
		for(int index = 0; index < levelTrack.length; index++)
		{
			levelTrack[index] = (index + 1) * 20;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getHPMax()
	{
		return HPMax;
	}
	
	public int getHP()
	{
		return HP;
	}
	
	public int getSPMax()
	{
		return SPMax;
	}
	
	public int getSP()
	{
		return SP;
	}
	
	public int getAttackMin()
	{
		return attackMin;
	}
	
	public int getAttackMax()
	{
		return attackMax;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public int getPhyDefense()
	{
		return phyDefense;
	}
	
	public int getMagDefense()
	{
		return magDefense;
	}
	
	public double getAccuracy()
	{
		return accuracy;
	}
	
	public boolean isAlive()
	{
		return HP != 0;
	}
	
	public String charString()
	{
		return name + " : " + HP + ":HP";
	}
	
	@Override
	public String toString()
	{
		String s = "";
		
		s += name + "\n";
		s += level + " lv\n";
		s += HP + "/" + HPMax + "HP\n";
		s += "Stats\nAttack: " + attackMax + "-" + attackMin + "\n";
		s += "Speed: " + speed + " - Accuracy: " + accuracy + "\n";
		s += "Phycal Defense: " + phyDefense + " - Magical Defense: " + magDefense + "\n";
		
		return s;
	}
	
	public void attack(ICharacter incomingCharacter, int choiceInput)
	{
		skillList.get(choiceInput).toAttack(this, incomingCharacter);
	}
	
	public boolean validAttackChoice(int x)
	{
		return true;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void levelCheck()
	{
		if(exp >= levelTrack[level])
			levelUp();
	}
	
	public void setLevelCap(int levelCap)
	{
		this.levelCap = levelCap;
	}
	
	public int getLevelCap()
	{
		return levelCap;
	}
	
	public void levelUp()
	{
		level++;
		
		setHPMax(HPMax * level);
		setHP(HP * level);
		setAccuracy(accuracy * (1 + 1 / ((double)level)));
		setAttackMax((int)(attackMax * (1 + 1 / ((double)level))));
		setAttackMin((int)(attackMin * (1 + 1 / ((double)level))));
		setPhyDefense((int)(phyDefense * (1 + 1 / ((double)level))));
		setMagDefense((int)(magDefense * (1 + 1 / ((double)level))));
		
		switch(level)
		{
			case 3:
				level3Attack();
				break;
			case 6:
				level6Attack();
				break;
			case 9:
				level9Attack();
				break;
			case 10:
				level10Attack();
				break;
		}
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setHPMax(int hp)
	{
		HPMax = hp;
	}
	
	public void setHP(int hp)
	{
		HP = hp;
	}
	
	public void setSPMax(int sp)
	{
		SPMax = sp;
	}
	
	public void setSP(int sp)
	{
		SP = sp;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public void setAttackMax(int max)
	{
		attackMax = max;
	}
	
	public void setAttackMin(int min)
	{
		attackMin = min;
	}
	
	public void setAccuracy(double acc)
	{
		accuracy = acc;
	}
	
	public void setMagDefense(int mag)
	{
		magDefense = mag;
	}
	
	public void setPhyDefense(int phy)
	{
		phyDefense = phy;
	}
	
	public void level3Attack()
	{
		skillList.add(new Fist());
	}
	
	public void level6Attack()
	{
		skillList.add(new MegaFist());
	}
	
	public void level9Attack()
	{
		skillList.add(new HyperFist());
	}
	
	public void level10Attack()
	{
		skillList.add(new ORA());
	}
	
	public int getXP()
	{
		return exp;
	}
	
	public void setXP(int xp)
	{
		exp = xp;
	}
	
	public void attackListString()
	{
		for(IAttack a : skillList)
			System.out.println(a);
	}
}
