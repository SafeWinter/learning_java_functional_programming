package ch7.ex4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo10_Strategy_OOP {
	
	public static void main(String[] args) {
		Task tasks[] = {
			new Task("Quick",25), 
			new Task("Longest",200), 
	        new Task("Shortest",2), 
	        new Task("Slow",35)
		};
		
		Tasks ts = new Tasks();
		ts.setTasks(Arrays.asList(tasks));
		
		ts.setStrategy(new STFStrategy());
		System.out.println(ts.getNextTask());
		
		ts.setStrategy(new LTFStrategy());
		System.out.println(ts.getNextTask());
		
		ts.setStrategy(new FCFSStrategy());
		System.out.println(ts.getNextTask());
	}
}

/**
 * first-come-first-serve strategy
 */
class FCFSStrategy implements SchedulingStrategy {

	@Override
	public Task nextTask(List<Task> tasks) {
		return tasks.get(0);
	}

}

/**
 * longest-task-first strategy
 */
class LTFStrategy implements SchedulingStrategy {

	@Override
	public Task nextTask(List<Task> tasks) {
		Task longest = tasks.get(0);
		for (Task task : tasks) {
			if(longest.getDuration() < task.getDuration()) {
				longest = task;
			}
		}
		return longest;
	}

}

/**
 * shortest-task-first strategy
 */
class STFStrategy implements SchedulingStrategy {

	@Override
	public Task nextTask(List<Task> tasks) {
		Task shortest = tasks.get(0);
		for (Task task : tasks) {
			if(shortest.getDuration() > task.getDuration()) {
				shortest = task;
			}
		}
		return shortest;
	}

}


class Tasks {

	private List<Task> tasks;
	private SchedulingStrategy strategy;
	
	public Tasks() {
		this.tasks = new ArrayList<>();
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public void setStrategy(SchedulingStrategy strategy) {
		this.strategy = strategy;
	}
	
	// Conventional implementation
	public Task getNextTask() {
		return strategy.nextTask(tasks);
	}
}

interface SchedulingStrategy {
	public Task nextTask(List<Task> tasks);
}