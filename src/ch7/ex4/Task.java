package ch7.ex4;

public class Task {
	
	private String name;
	private int duration;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Task() {
		this(null, 0);
	}
	public Task(String name, int duration) {
		super();
		this.name = name;
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Task{" + "name=" + name + ", duration=" + duration + '}';
	}
	
}
