package classes;

import interfaces.IPersonPrint;

public class PersonPrintToConsole implements IPersonPrint{
	public void print(Person person)
	{
		String toPrint = String.format("Name: %s \n"
				+ "Surname: %s \n"
				+ "Birth data: %s\n"
				+ "Sex: %d\n"
				+ "Salary: %d\n", person.get_name(), person.get_surname(),
        		person.get_birth(), person.get_sex(), person.get_salary());
		System.out.print(toPrint);
	}
}
