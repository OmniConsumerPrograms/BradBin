// Brad Howard
// OCP Equipment Interface

package equipmentset;

public interface IEquipment
{
	public int getID();
	
	public String getName();
	
	public String getType();
	
	public int getEventID();
	
	public int getDurability();
	
	public double getWeight();
	
	public void setTier(int tier);
	
	public int getTier();
	
	public int getSpeed();
	
	public int getPhysicalDefense();
	
	public int getMagicalDefense();
		
	public double getValue();
	
	public int getPFLimit();
}
