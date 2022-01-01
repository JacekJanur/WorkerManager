package classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonResponsibilitySave {
	private int _id_person;
	private int _id_responsibility;
	
	public PersonResponsibilitySave(int id_person, int id_responsibility)
	{
		this._id_person = id_person;
		this._id_responsibility = id_responsibility;
	}
	
	public void save(DatabaseConnection DBC)
	{
		Connection connection = DBC.getConnection();	
		Statement statement;
		try {
			statement = connection.createStatement();
			
	        statement.setQueryTimeout(30);  // set timeout to 30 sec.
	        String query = String.format("insert into persons_responsibilities(id_person, id_responsibility) "
	        		+ "values('%d', "
	        		+ "'%d')", this._id_person, this._id_responsibility);
	        statement.executeUpdate(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
