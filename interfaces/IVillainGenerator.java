// Brad Howard based off of David Henchmen source code
// OCP Villain generator interface

package interfaces;

public interface IVillainGenerator
{
	public IParty generateVillains(int numVillains);
	
	public IVillain pickVillain(int typeVillain);
	
	public void printHero();
}
