package classes;

import interfaces.IPersonResponsibilityDelete;

public class PersonResponsibilityDelete{
	private int _id_person;
	private int _id_responsibility;
	private IPersonResponsibilityDelete _PRD;
	
	public PersonResponsibilityDelete(int id_person, int id_responsibility, IPersonResponsibilityDelete PRD)
	{
		this._id_person = id_person;
		this._id_responsibility = id_responsibility;
		this._PRD = PRD;
	}
	
	public void delete()
	{
		this._PRD.delete(this._id_person, this._id_responsibility);
	}
	
}
