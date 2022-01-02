package classes;


public class PersonInputterValidatorSex {
	public static int trySex() {
		 
		int sex = -1;
		  
		boolean wrong = true;
		while(wrong)
		{
			try 
			{
				sex = Integer.parseInt(main.keyboard.nextLine());
				if(sex == 0 || sex ==1)
				{
					wrong = false;
				}
				else{
					throw new Exception("");
				}
			}
			catch (Exception e) { 
				System.out.print("Wrong sex! Only 1 or 0, try again: ");
			}
		}

		return sex;
		
	}
}
