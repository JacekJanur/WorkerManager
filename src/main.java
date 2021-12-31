
import classes.DatabaseConnection;
import classes.DatabaseScheme;
import classes.Person;
import classes.PersonSave;
import classes.PersonSaveToDB;

public class main
{
	public static void main(String[] args) throws ClassNotFoundException{
        DatabaseConnection DBC = new DatabaseConnection();
        DBC.openConnection();
        
        DatabaseScheme DBSch = new DatabaseScheme(DBC);
        DBSch.createScheme();
        
        Person person = new Person("Jacek", "Janur", "1997-10-05", 1, 4000);
        
        PersonSave personS = new PersonSave(person, new PersonSaveToDB(DBC));
        personS.Save();
        
        DBC.closeConnection();
    }
}