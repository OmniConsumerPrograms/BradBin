// OCP
// Level interface

package interfaces;

public interface ILevel
{
	public void setLevel(int level);
	
	public int getLevel();
	
	public void levelCheck(IHero hero);
	
	public void setLevelCap(int levelCap);
	
	public int getLevelCap();
	
	public void levelUp(IHero Hero);
}
