package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonInputterValidatorBirth {
	public static String tryBirth() {
			 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String birth = null;
		  
		boolean wrong = true;
		while(wrong)
		{
			try 
			{
				birth = main.keyboard.nextLine();
				df.parse(birth);
				wrong = false;
			}
			catch (ParseException e) { 
				System.out.print("Wrong date! Try again: ");
			}
		}

		return birth;
		
	}
}
