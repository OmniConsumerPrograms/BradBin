// Brad Howard
// OCP SQL Save System interface

package interfaces;

import java.sql.SQLException;

public interface ISQLSaveSystem
{
	public void openDatabase() throws Exception;
	
	public void createTable(String tableName) throws SQLException;
	
	public void insertTable(String mazeList, String currentFloor,String position) throws SQLException;
	
	public void selectTable() throws SQLException;
}
