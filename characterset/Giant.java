//OCP 
//Giant

package characterset;

import interfaces.ICharacter;
import interfaces.IEquipment;
import interfaces.IVillain;
import interfaces.IWeapon;
import weaponset.BareHands;

import java.util.ArrayList;

import equipmentset.NilEquipment;
import interfaces.IAttack;

public class Giant implements IVillain
{
	private String name;
	private int status;
	private int HPMax;
	private int HP;
	private int SPMax;
	private int SP;
	private int attackMin;
	private int attackMax;
	private int speed;
	private int phyDefense;
	private int magDefense;
	private double accuracy;
	private int exp;
	private int[] levelTrack;
	private int level;
	int levelCap;
	private ArrayList<IAttack> skillList;
	private IEquipment[] equipmentSet;
	private IWeapon weapon;
	
	public Giant(ArrayList<IAttack> skills)
	{
		name = "Giant";
		status = 000;
		HPMax = 150;
		HP = HPMax;
		SPMax = 100;
		SP = SPMax;
		attackMax = 25;
		attackMin = 20;
		speed = 2;
		accuracy = 50.0;
		phyDefense = 20;
		magDefense = 5;
		exp = 0;
		level = 1;
		levelCap = 12;
		levelTrack = new int[levelCap];
		skillList = skills;
		equipmentSet = new IEquipment[3];
		weapon = new BareHands(1);
		
		setupEquipmentSet();
		buildLevelTrack();
	}
	
	public int getStatus()
	{
		return status;
	}
	
	public void setStatus(int eID)
	{
		status = eID;
	}
	
	private void setupEquipmentSet()
	{
		for(int index = 0; index < equipmentSet.length; index++)
			equipmentSet[index] = new NilEquipment(1);
	}
	
	private void buildLevelTrack()
	{
		for(int index = 0; index < levelTrack.length; index++)
		{
			levelTrack[index] = (index + 1) * 20;
		}
	}
	
	public void setWeapon(IWeapon weapon)
	{
		this.weapon = weapon;
	}
	
	public IWeapon getWeapon()
	{
		return weapon;
	}
	
	public IWeapon replaceWeapon(IWeapon weapon)
	{
		IWeapon temp = this.weapon;
		this.weapon = weapon;
		return temp;
	}
	
	public void setEquipment(IEquipment equipment, int index)
	{
		if(index >= 0 && index < 3)
			equipmentSet[index] = equipment;
		else
			System.out.println("Error 736");
	}
	
	public IEquipment getEquipment(int index)
	{
		if(index >= 0 && index < 3)
			return equipmentSet[index];
		
		return new NilEquipment(1);
	}
	
	public IEquipment replaceEquipment(IEquipment equipment, int index)
	{
		IEquipment temp = equipmentSet[index];
		equipmentSet[index] = equipment;
		return temp;
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
		return attackMin + weapon.getAttack();
	}
	
	public int getAttackMax()
	{
		return attackMax + weapon.getAttack();
	}
	
	public int getSpeed()
	{
		return speed + weapon.getSpeed() + equipmentSet[0].getSpeed() + equipmentSet[1].getSpeed() + equipmentSet[2].getSpeed();
	}
	
	public int getPhyDefense()
	{
		return phyDefense + equipmentSet[0].getPhysicalDefense() + equipmentSet[1].getPhysicalDefense() + equipmentSet[2].getPhysicalDefense();
	}
	
	public int getMagDefense()
	{
		return magDefense + equipmentSet[0].getMagicalDefense() + equipmentSet[1].getMagicalDefense() + equipmentSet[2].getMagicalDefense();
	}
	
	public double getAccuracy()
	{
		return accuracy + weapon.getAccuracy();
	}
	
	public boolean isAlive()
	{
		if( this.HP > 0)
			return true;
		return false;
	}
	
	public String charString()
	{
		return name + " : " + HP + "/" + HPMax + ":HP : " + SP + "/" + SPMax + ":SP";
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
			case 4:
				level4Attack();
				break;
			case 8:
				level8Attack();
				break;
			case 12:
				level12Attack();
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
		if( hp > this.getHPMax() )
			this.HP = this.getHPMax();
		else
			this.HP = hp;
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
	
	public void level4Attack()
	{
		skillList.add(new CrushingBlow());
	}
	
	public void level8Attack()
	{
		skillList.add(new Execute());
	}
	
	public void level12Attack()
	{
		skillList.add(new Whirlwind());
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
			System.out.println(a.getAttackName());
	}
	
	public String skillListToString()
	{
		String s = "";
		
		for(IAttack a : skillList)
			s = a.getAttackName();
		
		return s;
	}

	@Override
	public int getHealMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHealMin(int healMin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHealMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHealMax(int healMax) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getSkillListSize() {
		return this.skillList.size();
	}

	@Override
	public int getHealListSize() 
	{
		return 0;
	}

	@Override
	public void heal(ICharacter healer, int choiceInput) {
		// TODO Auto-generated method stub
		
	}
}