package systemset;

import java.util.*;

public class SaveLoadManager 
{
	protected ArrayList<String> savedGames;
	
	public SaveLoadManager() 
	{
		savedGames = new ArrayList<String>();
	}

	public ArrayList<String> getSaveManager() {
		return savedGames;
	}

	public void setSaveManager(ArrayList<String> saveManager) {
		this.savedGames= saveManager;
	}

}
