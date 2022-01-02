package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResponsibilityExist {
	public static boolean check(Connection connection, int id_resp) 
	{
		boolean exist = false;
		String sql = String.format("SELECT * FROM responsibilities "
				+ "WHERE id_responsibility = %d ",
				id_resp);

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
