package classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import interfaces.IResponsibilitySave;

public class ResponsibilitySaveToDB implements IResponsibilitySave {

	private DatabaseConnection _DBC;	
	
	public ResponsibilitySaveToDB(DatabaseConnection DBC)
	{
		this._DBC = DBC;
	}
	
	@Override
	public void save(Responsibility responsibility) {
		Connection connection = this._DBC.getConnection();	
		Statement statement;
		try {
			statement = connection.createStatement();
			
	        statement.setQueryTimeout(30);  // set timeout to 30 sec.
	        String query = String.format("insert into responsibilities(responsibility) "
	        		+ "values('%s')", responsibility.get_text());
	        statement.executeUpdate(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
