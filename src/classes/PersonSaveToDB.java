package classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import interfaces.IPersonSave;

public class PersonSaveToDB implements IPersonSave{
	
	private DatabaseConnection _DBC;	
	
	public PersonSaveToDB(DatabaseConnection DBC)
	{
		this._DBC = DBC;
	}
	

	@Override
	public void Save(Person person) {
		Connection connection = this._DBC.getConnection();	
		Statement statement;
		try {
			statement = connection.createStatement();
			
	        statement.setQueryTimeout(30);  // set timeout to 30 sec.
	        String query = String.format("insert into persons(name, surname, birth, sex, salary) "
	        		+ "values('%s', '%s', '%s', %d, %d)", person.get_name(), person.get_surname(),
	        		person.get_birth(), person.get_sex(), person.get_salary());
	        statement.executeUpdate(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
