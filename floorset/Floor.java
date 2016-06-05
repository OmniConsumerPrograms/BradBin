// Vu Nguyen, Reworked by Brad Howard
// OCP Floor object

package floorset;

import interfaces.IFloor;

public class Floor implements IFloor
{
	private int floorID;
	private int[][] floor;
	
	public Floor(int floorID, int[][] floor) 
	{
		this.floorID = floorID;
		this.floor = floor;
	}

	public int getFloorID() 
	{
		return floorID;
	}

	public void setFloorID(int floorID) 
	{
		this.floorID = floorID;
	}

	public int[][] getFloor() 
	{
		return floor;
	}

	public void setFloor(int[][] floor) 
	{
		this.floor = floor;
	}
	
	@Override
	public String toString()
	{
		String s="";
		for(int i = 1; i< floor.length-1; i++)
		{
			for(int j = 1; j < floor[i].length-1; j++)
			{
				
				s += ((char)floor[i][j] +" ");
			}
		
			s += "\n";
		}
		return s;
	}
}
