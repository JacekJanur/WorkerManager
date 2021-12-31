package classes;

import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseScheme {
	private DatabaseConnection _DBC;
	
	public DatabaseScheme(DatabaseConnection DBC)
	{
		this._DBC = DBC;
	}
	
	public void createScheme() {
		Connection connection = this._DBC.getConnection();	
		Statement statement;
		try {
			statement = connection.createStatement();
			
	        statement.setQueryTimeout(30);  // set timeout to 30 sec.
	        statement.executeUpdate("drop table if exists person");
	        statement.executeUpdate("create table person (id integer, name string)");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
