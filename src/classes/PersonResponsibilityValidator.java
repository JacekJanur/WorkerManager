package classes;

import java.sql.Connection;


public class PersonResponsibilityValidator {
	public static boolean check(Connection connection, int id_person, int id_resp) 
	{
		if(PersonResponsibilityExist.check(connection, id_person, id_resp) && PersonExist.check(connection, id_person))
		{
			return true;
		}
		else {
			return false;
		}
	}
}
