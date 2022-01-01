package classes;

import interfaces.IDatabasePrint;

public class DatabasePrint {

	private DatabaseConnection _DBC;
	private IDatabasePrint _databasePrint;
	
	public DatabasePrint(DatabaseConnection DBC, IDatabasePrint databasePrint)
	{
		this._DBC = DBC;
		this._databasePrint = databasePrint;
	}
	
	public void print()
	{
		this._databasePrint.print(this._DBC);
	}
}
