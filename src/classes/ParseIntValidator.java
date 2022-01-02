package classes;

public class ParseIntValidator {
	public static Integer tryParse(String text) {
		int i;  
		try {
				i = Integer.parseInt(text);
				if(i<= 0)
				{
					return 0;
				}
				return i;
		  } catch (NumberFormatException e) {
			  	return 0;
		  }
		}
}
