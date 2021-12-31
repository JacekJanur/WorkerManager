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
	        statement.executeUpdate("drop table if exists persons");
	        statement.executeUpdate("drop table if exists responsibilities");
	        statement.executeUpdate("drop table if exists persons_responsibilities");
	        statement.executeUpdate("create table persons (id_person integer not null primary key, name string(30), surname string(30), birth date, sex BOOLEAN, salary float)");
	        statement.executeUpdate("create table responsibilities (id_responsibility integer not null primary key, responsibility text)");
	        statement.executeUpdate("create table persons_responsibilities (id_person integer not null, id_responsibility integer not null, "
	        		+ "FOREIGN KEY(id_person) REFERENCES persons(id_person), "
	        		+ "FOREIGN KEY(id_responsibility) REFERENCES responsibilities(id_responsibility))");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
