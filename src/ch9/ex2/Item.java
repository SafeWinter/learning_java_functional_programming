package ch9.ex2;

public class Item {
	private String name;
	private String description;
	
	// normal getters & setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// functional setters
	public Item name(String name) {
		this.name = name;
		return this;
	}
	public Item description(String description) {
		this.description = description;
		return this;
	}
	
	@Override
	public String toString() {
		return String.format("Item : %s, Description: %s", this.name, this.description);
	}
	
	
}
