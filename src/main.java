
import classes.DatabaseConnection;
import classes.DatabaseScheme;
import classes.Person;
import classes.PersonPrint;
import classes.PersonPrintToConsole;
import classes.PersonSave;
import classes.PersonSaveToDB;

public class main
{
	public static void main(String[] args) throws ClassNotFoundException{
        DatabaseConnection DBC = new DatabaseConnection();
        DBC.openConnection();
        
        DatabaseScheme DBSch = new DatabaseScheme(DBC);
        DBSch.createScheme();
           
        PersonSave personS = new PersonSave(new Person("Jacek", "Janur", "1997-10-05", 1, 4000), new PersonSaveToDB(DBC));
        personS.Save();
        
        PersonPrint personP = new PersonPrint(new Person("Jacek", "Janur", "1997-10-05", 1, 4000), new PersonPrintToConsole());
        personP.print();
        
        DBC.closeConnection();
    }
}