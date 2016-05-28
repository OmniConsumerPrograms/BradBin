//OCP
//Attack Interface

package interfaces;

import java.util.Random;

public interface IAttack {
	
	abstract String getAttackName();
	
	abstract void setAttackName(String attackName);

	abstract void toAttack(ICharacter hero, ICharacter villain);
	
	abstract boolean validAttack(ICharacter hero, Random gen);
}