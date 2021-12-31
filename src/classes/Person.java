package classes;

public class Person {
	private String _name;
	private String _surname;
	private String _birth;
	private Boolean _sex;
	private float salary;
	
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
	public Boolean get_sex() {
		return _sex;
	}
	public void set_sex(Boolean _sex) {
		this._sex = _sex;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
}
