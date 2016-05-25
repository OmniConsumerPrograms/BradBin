package systemset;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputSystem implements KeyListener
{
	private ProtoGamemaster PGM;
	
	public KeyInputSystem(ProtoGamemaster PGM)
	{
		this.PGM = PGM;
	}
	
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_P)
			PGM.callEvent(960);
		else if(e.getKeyCode() == KeyEvent.VK_I)
			PGM.callEvent(970);
		else
			PGM.callEvent(909);
	}
   
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_P)
			PGM.callEvent(960);
		else if(e.getKeyCode() == KeyEvent.VK_I)
			PGM.callEvent(970);
		else
			PGM.callEvent(909);
	}
   
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_P)
			PGM.callEvent(960);
		else if(e.getKeyCode() == KeyEvent.VK_I)
			PGM.callEvent(970);
		else
			PGM.callEvent(909);
	}
}
