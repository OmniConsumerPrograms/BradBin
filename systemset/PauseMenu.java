// Brad Howard
// OCP Menus

package systemset;

import interfaces.IMenuSystem;
import java.util.*;

public class PauseMenu implements IMenuSystem
{
	private static Scanner userInput;
	private String menuType = "Pause";
	private ProtoGamemaster PGM;
	
	public PauseMenu(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
		userInput = new Scanner(System.in);
	}
	
	public String menuType()
	{
		return menuType;
	}
	
	public int runMenu(ProtoGamemaster P)
	{	
		int menuNumber = 0;
				
		if(P != null)
			this.PGM = P;
		
		while(true)
		{
			System.out.println(menuType());
			System.out.println("1: Access Inventory    2: Load game             3: Save game and continue");
			System.out.println("4: Save game and quit  5: Quit with out saving  6: Continue game");
			menuNumber = userInput.nextInt();
			
			switch(menuNumber)
			{
				case 1:
					PGM.callEvent(970);
					break;
				case 2:
					PGM.callEvent(902);
					return 909;
				case 3:
					PGM.callEvent(901);
					return 909;
				case 4:
					PGM.callEvent(991);
					break;
				case 5:
					PGM.callEvent(990);
					break;
				case 6:
					return 909;
			}
		}
	}
}
