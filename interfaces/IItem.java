// Brad Howard
// OCP item object

package interfaces;

public interface IItem extends IUsable
{
	public int getID();
	
	public String getName();
	
	public int getEventID();
	
	public String getEffectType();
	
	public double getEffect();
	
	public int getPFLimit();
}