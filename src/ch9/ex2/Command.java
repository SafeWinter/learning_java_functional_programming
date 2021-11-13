package ch9.ex2;

import java.util.ArrayList;
import java.util.List;

public class Command {

	private String command;
	private final List<String> arguments = new ArrayList<>();
	
	// traditional getters & setters
	public String getCommand() {
		return this.command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public void addArgument(String argument) {
		this.arguments.add(argument);
	}
	public List<String> getArguments() {
		return this.arguments;
	}
	
	// clear
	public void clear() {
		this.command = "";
		this.arguments.clear();
	}
}
