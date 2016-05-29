package characterset;

import java.util.*;
import interfaces.IManager;
import interfaces.IAttack;

public class AttackManager implements IManager<IAttack>
{
	private ArrayList<IAttack> attackList;
	
	public AttackManager()
	{
		attackList = new ArrayList<IAttack>();
	}
	
	public int size()
	{
		return attackList.size();
	}
	
	public void set(IAttack attack)
	{
		attackList.add(attack);
	}
	
	public IAttack get(int ID)
	{
		return attackList.get(ID);
	}
	
	public IAttack remove(int ID)
	{
		return attackList.remove(ID);
	}
	
	public void replace(IAttack attack, int ID)
	{
		attackList.set(ID, attack);
	}
	
	public boolean has(IAttack attack)
	{
		return attackList.contains(attack);
	}
	
	public int indexOf(IAttack attack)
	{
		return attackList.indexOf(attack);
	}
}
