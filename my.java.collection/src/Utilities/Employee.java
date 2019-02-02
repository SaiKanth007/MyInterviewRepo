package src.Utilities;

public class Employee {

	String name;
	String id;
	public String getName() {
		return name;
	}
	public Employee(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
