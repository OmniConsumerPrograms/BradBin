// Brad Howard
// OCP Floor Manager interface

package interfaces;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IFloorManager
{
	public int[][] readFloor(String floorFileName) throws FileNotFoundException;
	
	public String printFloor(int[][] floor);
	
	public ArrayList<IFloor> getFloorList();
	
	public IFloor getFloorByID(int floorID);
	
	public ArrayList<IFloor> getMazeList();
}
