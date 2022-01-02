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
        			+ "8: Quit \n");
        	System.out.print("------ \n");
        	System.out.print("Your number: ");
        	
        	int number = Integer.parseInt(keyboard.nextLine());
        	int id_worker;
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
	        		id_worker = Integer.parseInt(keyboard.nextLine());
	        		new PersonDelete(id_worker, new PersonDeleteFromDB(DBC)).delete();
	        		break;
	        	case 6: 
        			ResponsibilityInputter respIN = new ResponsibilityInputter();
        			Responsibility resp = respIN.input();
        			new ResponsibilitySave(resp, new ResponsibilitySaveToDB(DBC)).save();
        			break;
	        	case 7:
	        		System.out.print("Worker id: ");
	        		id_worker = Integer.parseInt(keyboard.nextLine());
	        		System.out.print("Responsibility id: ");
	        		int id_resp = Integer.parseInt(keyboard.nextLine());
	        		new PersonResponsibilitySave(id_worker, id_resp).save(DBC);
	        		break;
	        	case 8: 
        			lo = false;
        			break;
        	}
        	
        	
        }
        
        keyboard.close();
        DBC.closeConnection();
    }
}