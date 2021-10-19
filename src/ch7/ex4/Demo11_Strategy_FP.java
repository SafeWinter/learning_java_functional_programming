package ch7.ex4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo11_Strategy_FP {
	
	public static void main(String[] args) {
		
		Task tasks[] = {
			new Task("Quick",25), 
			new Task("Longest",200), 
	        new Task("Shortest",2), 
	        new Task("Slow",35)
		};
		
		FunctionalTasks ts = new FunctionalTasks();
		ts.setTasks(Arrays.asList(tasks));
		
		Comparator<? super Task> compareDuration = Comparator.comparing(Task::getDuration);
		
		// longest-task-first strategy
		FunctionalStrategy longest = tlist -> tlist.stream().max(compareDuration).get();
		ts.setStrategy(longest);
		System.out.println(ts.getNextTask());
		
		// shortest-task-first strategy
		FunctionalStrategy shortest = tlist -> tlist.stream().min(compareDuration).get();
		ts.setStrategy(shortest);
		System.out.println(ts.getNextTask());
		
		// first-come-first-serve strategy
		FunctionalStrategy fcfs = tlist -> tlist.get(0);
		ts.setStrategy(fcfs);
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
