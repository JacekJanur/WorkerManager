package classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import interfaces.IPersonResponsibilityDelete;

public class PersonResponsibilityDeleteFromDB implements IPersonResponsibilityDelete{

	private DatabaseConnection _DBC;
	
	public PersonResponsibilityDeleteFromDB(DatabaseConnection DBC)
	{
		this._DBC = DBC;
	}
	
	@Override
	public void delete(int id_person, int id_responsibility) {
		String sql = "DELETE FROM persons_responsibilities WHERE id_person = "+id_person+" and id_responsibility = "+id_responsibility;
		Connection connection = this._DBC.getConnection();	
		
		if(PersonResponsibilityExist.check(connection, id_person, id_responsibility))
		{
			Statement stmt;
			try {
				stmt = connection.createStatement();
		        stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.print("\nWrong data\n");
		}
		
	}

}
