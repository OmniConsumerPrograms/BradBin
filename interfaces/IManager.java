// Brad Howard
// OCP IManager

package interfaces;

public interface IManager<T>
{
	public void set(T t);
	
	public T get(int ID);
	
	public T remove(int ID);
	
	public void replace(T t, int ID);
	
	public boolean has(T t);
	
	public int indexOf(T t);
	
	public int size();
}