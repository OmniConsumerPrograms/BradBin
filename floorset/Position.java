package floorset;

import interfaces.IPosition;

public class Position implements IPosition
{
	private int x;
	private int y;
	
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getRow()
	{
		return x;
	}
	
	public void setRow(int x)
	{
		this.x = x;
	}
	
	public int getCol()
	{
		return y;
	}
	
	public void setCol(int y)
	{
		this.y = y;
	}
}
