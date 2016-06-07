// Brad Howard
// OCP Menus

package systemset;

import java.util.InputMismatchException;
import java.util.Scanner;
import interfaces.IMenuSystem;

public class StartMenu implements IMenuSystem
{

	private static Scanner userInput;
	private String menuType = "Start";
	private Gamemaster GM;
	
	public StartMenu(Gamemaster GM)
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
		
		while(GM.getGameMode() == 800)
		{
			System.out.println(menuType());
			System.out.println("An OCP game, by Brad Howard, David Hinchman, and Vu Nguyen");
			System.out.println("Welcome to Dungeon Adventure");
			System.out.println("1: New game\n2: Load game\n3: Exit");
			try
			{
				menuNumber = userInput.nextInt();
			}
			catch(InputMismatchException ime)
			{
				return 806;
			}
			
			switch(menuNumber)
			{
				case 1:
					while(GM.difficulty == -1)
					{
						System.out.println("What difficulty level?\n1: Green\n2: Pro\n3: Master");
						try
						{
							GM.setGameDifficulty(userInput.nextInt());
						}
						catch(InputMismatchException ime)
						{
							return 806;
						}
					}
					GM.callEvent(70);
					GM.callEvent(900);
					break;
				case 2:
					GM.callEvent(902);
					GM.callEvent(900);
					break;
				case 3:
					GM.callEvent(990);
					break;
			}
		}
		
		return 909;
	}
}
