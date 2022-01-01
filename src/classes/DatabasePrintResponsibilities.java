package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import interfaces.IDatabasePrint;

public class DatabasePrintResponsibilities implements IDatabasePrint {
	@Override
	public void print(DatabaseConnection DBC) {
		String sql = "SELECT * FROM responsibilities";
		Connection connection = DBC.getConnection();	
		Statement stmt;
		try {
			stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
		    // loop through the result set
		    while (rs.next()) {
		    	System.out.println(rs.getInt("id_person") +  "\t" + 
	                              rs.getString("responsibility"));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
