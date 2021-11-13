package ch9.ex2;

public class Direction {

	private String direction;
	private String location;
	
	// normal getters & setters
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	// functional setters
	public Direction direction(String direction) {
		this.direction = direction;
		return this;
	}
	public Direction location(String location) {
		this.location = location;
		return this;
	}
	
	// constructors
	public Direction(String direction, String location) {
		super();
		this.direction = direction;
		this.location = location;
	}
	public Direction() {
		this("", "");
	}
}
