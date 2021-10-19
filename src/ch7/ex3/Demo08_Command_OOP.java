package ch7.ex3;

import java.util.ArrayList;
import java.util.List;

public class Demo08_Command_OOP {

	public static void main(String[] args) {
        Commands commands = new Commands();
        
        Character character = new Character();
        commands.addCommand(new WalkCommand(character));
        commands.addCommand(new RunCommand(character));
        commands.addCommand(new JumpCommand(character));
        
        commands.executeCommand();
    }
}

class Commands {
	private final List<Command> commands = new ArrayList<>();
	
	public void addCommand(Command command) {
		commands.add(command);
	}
	
	public void executeCommand() {
		commands.forEach(Command::execute);
	}
}