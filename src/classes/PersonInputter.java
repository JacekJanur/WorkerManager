package classes;

import interfaces.IInputter;

public class PersonInputter implements IInputter<Person>{
	public Person input()
	{
		System.out.print("\nName: ");
		String name = main.keyboard.nextLine();
		System.out.print("\nSurname: ");
		String surname = main.keyboard.nextLine();
		
		System.out.print("\nBirth (YYYY-MM-DD): ");
		String birth = main.keyboard.nextLine();
		
		System.out.print("\nSex (0-female, 1-male): ");
		int sex = Integer.parseInt(main.keyboard.nextLine());
		
		System.out.print("\nSalary: ");
		int salary = Integer.parseInt(main.keyboard.nextLine());
		return new Person(name, surname, birth, sex, salary);
	}
}
