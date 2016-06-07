package interfaces;

public interface IHeroGenerator
{
	public void printHero();
	
	public IParty chooseHeroes();
	
	public IHero getHero(String name);
}
