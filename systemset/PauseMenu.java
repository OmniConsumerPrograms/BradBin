// Brad Howard
// OCP Menus

package systemset;

import interfaces.IMenuSystem;
import java.util.*;

public class PauseMenu implements IMenuSystem
{
	private static Scanner userInput;
	private String menuType = "Pause";
	private Gamemaster GM;
	
	public PauseMenu(Gamemaster GM)
	{
		this.GM = GM;
		userInput = new Scanner(System.in);
	}
	
	public String menuType()
	{
		return menuType;
	}
	
	public int runMenu(Gamemaster P)
	{	
		int menuNumber = 0;
				
		if(P != null)
			this.GM = P;
		if(GM.getGameMode() == 900)
		{
			while(true)
			{
				System.out.println(menuType());
				System.out.println("1: Access Inventory    2: Load game             3: Save game and continue");
				System.out.println("4: Save game and quit  5: Quit with out saving  6: Rest game");
				System.out.println("7: Check party         8: Continue game");
				menuNumber = userInput.nextInt();
				
				switch(menuNumber)
				{
					case 1:
						GM.callEvent(970);
						break;
					case 2:
						GM.callEvent(902);
						return 909;
					case 3:
						GM.callEvent(901);
						return 909;
					case 4:
						GM.callEvent(991);
						break;
					case 5:
						GM.callEvent(990);
						break;
					case 6:
						String temp = "";
						System.out.println("Are you sure you want to restart game? (Y/N)");
						userInput.next();
						temp = userInput.next();
						if(temp.equalsIgnoreCase("y"))
						{	
							GM.callEvent(800);
							break;
						}
						else
							break;
					case 7:
						System.out.println(GM.PM);
						break;
					case 8:
						return 909;
				}
			}
		}
		else if(GM.getGameMode() == 910)
		{
			while(true)
			{
				System.out.println(menuType());
				System.out.println("1: Access Inventory      2: Load game");
				System.out.println("3: Quit with out saving  4: Rest game");
				System.out.println("5: Check party           6: Continue game");
				menuNumber = userInput.nextInt();
				
				switch(menuNumber)
				{
					case 1:
						GM.callEvent(970);
						break;
					case 2:
						GM.callEvent(902);
						return 909;
					case 3:
						GM.callEvent(990);
						break;
					case 4:
						String temp = "";
						System.out.println("Are you sure you want to restart game? (Y/N)");
						userInput.next();
						temp = userInput.next();
						if(temp.equalsIgnoreCase("y"))
						{	
							GM.callEvent(800);
							break;
						}
						else
							break;
					case 5:
						System.out.println(GM.PM);
						break;
					case 6:
						return 909;
				}
			}
		}
		return 906;
	}
}
