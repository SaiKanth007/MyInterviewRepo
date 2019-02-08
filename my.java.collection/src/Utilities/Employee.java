package src.Utilities;

public class Employee {

	String name;
	String id;
	Integer rank;
	public String getName() {
		return name;
	}
	public Employee(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public Employee(String name, String id, Integer rank) {
		super();
		this.name = name;
		this.id = id;
		this.rank = rank;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
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
