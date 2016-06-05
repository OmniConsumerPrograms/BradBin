// Brad Howard, Sorce code and system from Vu Nguyen
// OCP Dungeon Manager

package floorset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import interfaces.IDungeon;
import interfaces.IFloor;
import systemset.SQLManager;

public class DungeonManager implements IDungeon
{
	private int curFloorNo;
	private Position prevPos;
	private Position curPos;
	private ArrayList<IFloor> mazeList = new ArrayList<IFloor>();
	private FloorManager floorManager = new FloorManager();
	
	public DungeonManager()
	{
		curFloorNo = 1;
		buildMaze();
	}
	
	public int getFloorNo()
	{
		return curFloorNo;
	}
	
	public void setFloorNo(int floorNo)
	{
		curFloorNo = floorNo;
	}
	
	public void restoreDungeon() throws Exception
	{
		curFloorNo = 0;
		mazeList = new ArrayList<IFloor>();
		floorManager = new FloorManager();
		
		SQLManager.openDatabase();
		//SQLManager sqlManager = new SQLManager();
		
		 SQLManager.selectTable();
		
		//int id = rs.getInt("ID");
		String mazeListS = SQLManager.rs.getString("MAZELIST");
        String positionS = SQLManager.rs.getString("POSITION");
        String curentFloorS = SQLManager.rs.getString("CURRENTFLOOR");
        SQLManager.rs.close();
        //SQLManager.c.close();
        curFloorNo = Integer.parseInt(curentFloorS);
        String[] positionArr = positionS.split(" ");
        curPos = new Position(Integer.parseInt(positionArr[0]),Integer.parseInt(positionArr[1]));
        System.out.println(positionS);
        String[] id = mazeListS.split(" ");
		for(int i = 0; i< id.length; i++)
		{
        	mazeList.add(floorManager.getFloorByID(Integer.parseInt(id[i])));
        }
	}
	
	public void printMaze(int floor)
	{
		curFloorNo = floor;
		IFloor curFloor = mazeList.get(curFloorNo-1); //curFloorNo used 1-basex index
		int[][] curFloorMatrix = curFloor.getFloor();
		
		System.out.println("You are at floor: "+ curFloorNo);
		
		if(curPos == null)
		{
			System.out.println("Null");
			for(int i = 1; i < curFloorMatrix.length-1; i++)
			{
				if(curFloorMatrix[1][i] ==  'I')
				{
					curPos = new Position(1,i);
					curFloorMatrix[1][i]= 'P';
					break;
				}
			}
		}
		
		if(prevPos != null)
		{
			curFloor.getFloor()[prevPos.getRow()][prevPos.getCol()] = '.';
		}
		
		curFloor.getFloor()[curPos.getRow()][curPos.getCol()] = 'P';
		System.out.println(curFloor);
	}
	
	public int randomCounter()
	{
		Random rand = new Random();
		return rand.nextInt(10);
	}
	
	public void move(int choice)
	{
		int x = curPos.getRow();
		int y = curPos.getCol();
		prevPos = new Position(x,y);
		int[][] floorPlan = mazeList.get(curFloorNo-1).getFloor();
				
		switch(choice)
		{
			case 1:
				x -= 1;
				break;
			case 2: 
				x += 1;
				break;
			case 3: 
				y -= 1;
				break;
			case 4: 
				y += 1;
				break;
		}
		if(floorPlan[x][y] == 0 || floorPlan[x][y] == '#')
		{
			System.out.println("Invalid Move. Move another direction");
			curPos = prevPos;
		}
		else if(floorPlan[x][y] == 'O')
		{
			if(curFloorNo + 1 <= mazeList.size())
			{
				curFloorNo++;
				curPos = null;
				prevPos = null;
			}
			else
				System.out.println("You are at the end of the dungeon.");
		}
		else
			curPos =  new Position(x,y);
	}
	
	public void saveDungeon() throws Exception
	{
		SQLManager.openDatabase();
		SQLManager.createTable("SAVE");
		String mazeListS = "";
		for(int i = 0; i< mazeList.size();i++){
			mazeListS += (mazeList.get(i).getFloorID()+" ");
		}
		SQLManager.insertTable(mazeListS, curFloorNo+"",curPos.getRow() + " "+curPos.getCol());
	}
	
	public void buildMaze()
	{
		mazeList = floorManager.getMazeList();
		//shuffle list
		Collections.shuffle(mazeList);
	}
}
