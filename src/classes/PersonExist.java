package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonExist {
	public static boolean check(Connection connection, int id_person) 
	{
		boolean exist = false;
		String sql = String.format("SELECT * FROM persons "
				+ "WHERE id_person = %d ",
				id_person);

		Statement stmt;
		try {
			stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
		    // loop through the result set
		    while (rs.next()) {
		    	exist= true;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exist;
	}
}
