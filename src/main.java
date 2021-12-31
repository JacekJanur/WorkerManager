
import classes.DatabaseConnection;

public class main
{
	public static void main(String[] args) throws ClassNotFoundException {
        DatabaseConnection DBC = new DatabaseConnection();
        DBC.openConnection();
        DBC.closeConnection();
    }
}