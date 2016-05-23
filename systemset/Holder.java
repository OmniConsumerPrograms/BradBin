package systemset;

import interfaces.IBin;

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
	
	public void place(T t)
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
