package classes;

import interfaces.IPersonDelete;

public class PersonDelete {
	private int _id_person;
	private IPersonDelete _IPD;
	
	public PersonDelete(int id_person, IPersonDelete IPD)
	{
		this._id_person = id_person;
		this._IPD = IPD;
	}
	
	public void delete()
	{
		this._IPD.delete(this._id_person);
	}
}
