package classes;

public class Person {
	private String _name;
	private String _surname;
	private String _birth;
	private int _sex;
	private int _salary;
	
	
	public Person(String name, String surname, String birth, int sex, int salary)
	{
		this._name = name;
		this._birth = birth;
		this._salary = salary;
		this._sex = sex;
		this._surname = surname;
	}
	
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_surname() {
		return _surname;
	}
	public void set_surname(String _surname) {
		this._surname = _surname;
	}
	public String get_birth() {
		return _birth;
	}
	public void set_birth(String _birth) {
		this._birth = _birth;
	}
	public int get_sex() {
		return _sex;
	}
	public void set_sex(int _sex) {
		this._sex = _sex;
	}
	public int get_salary() {
		return _salary;
	}
	public void set_salary(int salary) {
		this._salary = salary;
	}
}
