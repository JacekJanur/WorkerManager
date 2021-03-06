package classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import interfaces.IPersonDelete;

public class PersonDeleteFromDB implements IPersonDelete {

	private DatabaseConnection _DBC;
	
	public PersonDeleteFromDB(DatabaseConnection DBC)
	{
		this._DBC = DBC;
	}
	
	@Override
	public void delete(int id_person) {
		String sql = "DELETE FROM PERSONS WHERE id_person = "+id_person;
		Connection connection = this._DBC.getConnection();	
		
		if(PersonExist.check(connection, id_person))
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
			System.out.print("\nNo worker in DB with id: "+id_person+"\n");
		}

	}

}
