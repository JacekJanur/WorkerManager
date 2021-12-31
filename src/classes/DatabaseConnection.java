package classes;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;



public class DatabaseConnection {
	private Connection _connection = null;
	
	public Connection getConnection()
	{
		return this._connection;
	}
	
	public void openConnection() throws ClassNotFoundException {
		// load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        try
        {
            // create a database connection
            this._connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
	  }
	
	public void closeConnection() {
		try
        {
            if(this._connection != null)
            	this._connection.close();
        }
        catch(SQLException e)
        {
            // connection close failed.
            System.err.println(e);
        }
	}
}
