
import classes.DatabaseConnection;
import classes.DatabasePrint;
import classes.DatabasePrintPerson;
import classes.DatabaseScheme;
import classes.Person;
import classes.PersonPrint;
import classes.PersonPrintToConsole;
import classes.PersonSave;
import classes.PersonSaveToDB;
import classes.Responsibility;
import classes.ResponsibilitySave;
import classes.ResponsibilitySaveToDB;

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
        
        DatabasePrint DBP = new DatabasePrint(DBC, new DatabasePrintPerson());
        DBP.print();
        
        ResponsibilitySave resS = new ResponsibilitySave(new Responsibility("Cleaning office"), new ResponsibilitySaveToDB(DBC));
        resS.save();
        
        
        DBC.closeConnection();
    }
}