package classes;

import java.util.Scanner;



public class main
{
	static final Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException{
        DatabaseConnection DBC = new DatabaseConnection();
        DBC.openConnection();
        
        DatabaseScheme DBSch = new DatabaseScheme(DBC);
        DBSch.createScheme();
           
        PersonSave personS = new PersonSave(new Person("Jacek", "Janur", "1997-10-05", 1, 4000), new PersonSaveToDB(DBC));
        personS.Save();
        
        
        new ResponsibilitySave(new Responsibility("Cleaning office"), new ResponsibilitySaveToDB(DBC)).save();
        new ResponsibilitySave(new Responsibility("Cleaning Toilets"), new ResponsibilitySaveToDB(DBC)).save();
        
        new PersonResponsibilitySave(1, 1).save(DBC);
        new PersonResponsibilitySave(1, 2).save(DBC);
        
        boolean lo = true;
        while(lo)
        {
        	System.out.print("\nSelect number 1-3: \n"
        			+ "1: Show all workers \n"
        			+ "2: Show all responsibilities \n"
        			+ "3: Show workers responsibilities \n"
        			+ "4: Add worker \n"
        			+ "5: Delete worker \n"
        			+ "6: Add responsibility \n"
        			+ "7: Add responsibility to worker \n"
        			+ "8: Delete responsibility from worker \n"
        			+ "9: Quit \n");
        	System.out.print("------ \n");
        	System.out.print("Your number: ");
        	
        	int number = ParseIntValidator.tryParse(keyboard.nextLine());
        	int id_worker;
        	int id_resp;
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
	        		PersonInputter personIN = new PersonInputter();
	        		Person newPerson = personIN.input();
	        		new PersonSave(newPerson, new PersonSaveToDB(DBC)).Save();
	        		break;
	        	case 5:
	        		System.out.print("Worker to delete id: ");
	        		id_worker = ParseIntValidator.tryParse(keyboard.nextLine());
	        		new PersonDelete(id_worker, new PersonDeleteFromDB(DBC)).delete();
	        		break;
	        	case 6: 
        			ResponsibilityInputter respIN = new ResponsibilityInputter();
        			Responsibility resp = respIN.input();
        			new ResponsibilitySave(resp, new ResponsibilitySaveToDB(DBC)).save();
        			break;
	        	case 7:
	        		System.out.print("Worker id: ");
	        		id_worker = ParseIntValidator.tryParse(keyboard.nextLine());
	        		System.out.print("Responsibility id: ");
	        		id_resp = ParseIntValidator.tryParse(keyboard.nextLine());
	        		new PersonResponsibilitySave(id_worker, id_resp).save(DBC);
	        		break;
	        	case 8:
	        		System.out.print("Worker id: ");
	        		id_worker = ParseIntValidator.tryParse(keyboard.nextLine());
	        		System.out.print("Responsibility id: ");
	        		id_resp = ParseIntValidator.tryParse(keyboard.nextLine());
	        		new PersonResponsibilityDelete(id_worker, id_resp, new PersonResponsibilityDeleteFromDB(DBC)).delete();
	        		break;
	        	case 9: 
        			lo = false;
        			break;
        	}
        	
        	
        }
        
        keyboard.close();
        DBC.closeConnection();
    }
}