// Brad Howard
// OCP Item Generator interface

package interfaces;

public interface IItemGenerator<T> extends IGenerator
{
	public void levelUp(T t, int tier);
	
	public T getRandomPrefix(T t);
	
	public T fix(T t);
}
