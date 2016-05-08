// Brad Howard
// OCP IManager

package weaponset;

public interface IManager<T>
{
	public void set(T t);
	
	public T get(int ID);
	
	public boolean has(T t);
	
	public int indexOf(T t);
}