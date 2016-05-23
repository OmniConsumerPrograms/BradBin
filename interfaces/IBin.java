package interfaces;

public interface IBin<T>
{
	public void place(T t);
	
	public T get();
	
	public void check();
}
