package ch6.ex1;

public class Customer {
	
	private int id;
	private String name;
	
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", name=" + name + '}';
	}
}
