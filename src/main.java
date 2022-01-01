
import java.util.Scanner;

import classes.DatabaseConnection;
import classes.DatabasePrint;
import classes.DatabasePrintPerson;
import classes.DatabasePrintPersonResponsibilities;
import classes.DatabasePrintResponsibilities;
import classes.DatabaseScheme;
import classes.Person;
import classes.PersonPrint;
import classes.PersonPrintToConsole;
import classes.PersonResponsibilitySave;
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
        
//        PersonPrint personP = new PersonPrint(new Person("Jacek", "Janur", "1997-10-05", 1, 4000), new PersonPrintToConsole());
//        personP.print();
//        
//        DatabasePrint DBP = new DatabasePrint(DBC, new DatabasePrintPerson());
//        DBP.print();
        
        new ResponsibilitySave(new Responsibility("Cleaning office"), new ResponsibilitySaveToDB(DBC)).save();
        new ResponsibilitySave(new Responsibility("Cleaning Toilets"), new ResponsibilitySaveToDB(DBC)).save();
        
        new PersonResponsibilitySave(1, 1).save(DBC);
        new PersonResponsibilitySave(1, 2).save(DBC);
        
//        DBP = new DatabasePrint(DBC, new DatabasePrintResponsibilities());
//        DBP.print();
        
//        new DatabasePrint(DBC, new DatabasePrintPersonResponsibilities()).print();
        
        Scanner keyboard = new Scanner(System.in);
        boolean lo = true;
        while(lo)
        {
        	System.out.print("\nSelect number 1-3: \n"
        			+ "1: Show all workers \n"
        			+ "2: Show all responsibilities \n"
        			+ "3: Show workers responsibilities \n"
        			+ "4: Quit \n");
        	System.out.print("Your number: ");
        	int number = keyboard.nextInt();
        	System.out.print("------ \n");
        	switch(number)
        	{
	        	case 1:
	    			new DatabasePrint(DBC, new DatabasePrintPerson()).print();
	    			break;
	        	case 2:
	    			new DatabasePrint(DBC, new DatabasePrintResponsibilities()).print();
	    			break;
	        	case 3:
	        		new DatabasePrint(DBC, new DatabasePrintPersonResponsibilities()).print();
	        		break;
        		case 4: 
        			lo = false;
        			break;
        	}
        	
        	
        }
        
        keyboard.close();
        DBC.closeConnection();
    }
}