package systemset;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputSystem implements KeyListener
{
	private Gamemaster GM;
	
	public KeyInputSystem(Gamemaster GM)
	{
		this.GM = GM;
	}
	
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_P)
			GM.callEvent(960);
		else if(e.getKeyCode() == KeyEvent.VK_I)
			GM.callEvent(970);
		else
			GM.callEvent(909);
	}
   
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_P)
			GM.callEvent(960);
		else if(e.getKeyCode() == KeyEvent.VK_I)
			GM.callEvent(970);
		else
			GM.callEvent(909);
	}
   
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_P)
			GM.callEvent(960);
		else if(e.getKeyCode() == KeyEvent.VK_I)
			GM.callEvent(970);
		else
			GM.callEvent(909);
	}
}
