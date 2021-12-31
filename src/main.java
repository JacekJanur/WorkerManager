
import classes.DatabaseConnection;
import classes.DatabaseScheme;

public class main
{
	public static void main(String[] args) throws ClassNotFoundException {
        DatabaseConnection DBC = new DatabaseConnection();
        DBC.openConnection();
        
        DatabaseScheme DBSch = new DatabaseScheme(DBC);
        DBSch.createScheme();
        
        DBC.closeConnection();
    }
}