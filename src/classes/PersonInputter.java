package classes;

import java.util.Scanner;

public class PersonInputter {
	public Person input()
	{
		Scanner t_keyboard = new Scanner(System.in);
		System.out.print("\nName: ");
		String name = t_keyboard.nextLine();
		
		System.out.print("\nSurname: ");
		String surname = t_keyboard.nextLine();
		
		System.out.print("\nBirth (YYYY-MM-DD): ");
		String birth = t_keyboard.nextLine();
		
		System.out.print("\nSex (0-female, 1-male): ");
		int sex = t_keyboard.nextInt();
		
		System.out.print("\nSalary: ");
		int salary = t_keyboard.nextInt();

		return new Person(name, surname, birth, sex, salary);
	}
}
