package classes;

import interfaces.IPersonSave;

public class PersonSave{
	
	private Person _person;
	private IPersonSave _personSave;
	
	public PersonSave(Person person, IPersonSave personSave)
	{
		this._person = person;
		this._personSave = personSave;
	}
	
	public void Save()
	{
		this._personSave.Save(this._person);
	}
}
