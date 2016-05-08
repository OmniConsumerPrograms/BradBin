// Brad Howard
// OCP item object

package itemset;

public interface IItem
{
	public int getID();
	
	public String getName();
	
	public int getEventID();
	
	public String getEffectType();
	
	public double getEffect();
	
	public int getPFLimit();
}