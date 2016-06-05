// Brad Howard
// OCP dungeon interface

package interfaces;

public interface IDungeon
{
	public void restoreDungeon() throws Exception; // resume
	
	public int randomCounter();
	
	public void printMaze(int floor);
	
	public void move(int choice);
	
	public void saveDungeon() throws Exception;
	
	public void buildMaze();
	
	public int getFloorNo();
	
	public void setFloorNo(int floorNo);
}
