// Brad Howard
// OCP Save interface

package interfaces;

import java.io.IOException;

import systemset.Gamemaster;

public interface ISave
{
	public void load(Gamemaster GM) throws IOException;
	
	public void save(Gamemaster GM) throws IOException;
}
