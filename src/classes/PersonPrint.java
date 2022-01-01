package classes;

import interfaces.IPersonPrint;

public class PersonPrint {

	private Person _person;
	private IPersonPrint _personPrint;
	
	public PersonPrint(Person person, IPersonPrint personPrint)
	{
		this._person = person;
		this._personPrint = personPrint;
	}
	
	public void print()
	{
		this._personPrint.print(this._person);
	}
}
