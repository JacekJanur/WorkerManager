package classes;

public class ParseIntValidator {
	public static Integer tryParse(String text) {
		  try {
		    return Integer.parseInt(text);
		  } catch (NumberFormatException e) {
		    return 0;
		  }
		}
}
