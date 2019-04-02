package src.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {

	String name;
	String id;
	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	Integer rank;
	Double Salary;

	public String getName() {
		return name;
	}

	public Employee(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Employee() {

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

	public String toString() {
		return this.getId() + " " + this.getName() + " " + this.getRank();
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Employee employee = new Employee();
		Employee employee2 = new Employee();
		employee.setName("John");
		employee.setId("Smith");
		employee.setRank(1234);
		try {
			// Serializing 'a'
			FileOutputStream fos = new FileOutputStream("xyz.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employee);

			// De-serializing 'a'
			FileInputStream fis = new FileInputStream("xyz.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			employee2 = (Employee) ois.readObject();// down-casting object

			System.out.println(employee2.toString());
			oos.close();
			ois.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

}
