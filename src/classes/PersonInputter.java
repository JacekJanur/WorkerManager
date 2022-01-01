package classes;


public class PersonInputter {
	public Person input()
	{
		//Scanner keyboard = new Scanner(System.in);
		System.out.print("\nName: ");
		String name = main.keyboard.nextLine();
		System.out.print("\nSurname: ");
		String surname = main.keyboard.nextLine();
		
		System.out.print("\nBirth (YYYY-MM-DD): ");
		String birth = main.keyboard.nextLine();
		
		System.out.print("\nSex (0-female, 1-male): ");
		int sex = main.keyboard.nextInt();
		
		System.out.print("\nSalary: ");
		int salary = main.keyboard.nextInt();
		return new Person(name, surname, birth, sex, salary);
	}
}
