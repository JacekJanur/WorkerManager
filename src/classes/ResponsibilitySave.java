package classes;

import interfaces.IResponsibilitySave;

public class ResponsibilitySave {

	private Responsibility _responsibility;
	private IResponsibilitySave _responsibilitySave;
	
	public ResponsibilitySave(Responsibility responsibility, IResponsibilitySave responsibilitySave)
	{
		this._responsibilitySave = responsibilitySave;
		this._responsibility = responsibility;
	}
	
	public void save()
	{
		this._responsibilitySave.save(this._responsibility);
	}
}
