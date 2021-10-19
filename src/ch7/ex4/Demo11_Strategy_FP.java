package ch7.ex4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo11_Strategy_FP {
	
	public static void main(String[] args) {
		Comparator<? super Task> compareDuration = Comparator.comparing(Task::getDuration);
		
		FunctionalStrategy longest = 
				t -> t.stream().max(compareDuration).get();
		
		FunctionalStrategy shortest = 
				t -> t.stream().min(compareDuration).get();
		
		FunctionalStrategy firstComeFirstServe = t -> t.get(0);
		
		Task tasks[] = {
			new Task("Quick",25), 
			new Task("Longest",200), 
	        new Task("Shortest",2), 
	        new Task("Slow",35)
		};
		
		FunctionalTasks ts = new FunctionalTasks();
		ts.setTasks(Arrays.asList(tasks));
		
		ts.setStrategy(longest);
		System.out.println(ts.getNextTask());
		
		ts.setStrategy(shortest);
		System.out.println(ts.getNextTask());
		
		ts.setStrategy(firstComeFirstServe);
		System.out.println(ts.getNextTask());
	}
}

class FunctionalTasks {
	private List<Task> tasks;
	private FunctionalStrategy strategy;
	
	public FunctionalTasks() {
		this.tasks = new ArrayList<>();
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public void setStrategy(FunctionalStrategy strategy) {
		this.strategy = strategy;
	}
	
	// Key modification
	public Task getNextTask() {
		return strategy.nextTask(tasks);
	}
}

@FunctionalInterface
interface FunctionalStrategy {
	Task nextTask(List<Task> tasks);
}
