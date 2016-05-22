package systemset;

import java.util.IllegalFormatException;

public class Holder<T> implements IBin<T>
{
	private T t;
	
	public Holder()
	{
		t = null;
	}
	
	public Holder(T t)
	{
		this.t = t;
	}
	
	public void place(T t) throws IllegalFormatException
	{
		this.t = t;
	}
	
	public T get()
	{
		return t;
	}
	
	public void check()
	{
		System.out.println(t);
	}
}
