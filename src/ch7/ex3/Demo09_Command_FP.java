package ch7.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Demo09_Command_FP {

	public static void main(String[] args) {
		Character character = new Character();

		FunctionalCommands fc = new FunctionalCommands();
        fc.addCommand(() -> character.walk());
        fc.addCommand(() -> character.run());
        fc.addCommand(() -> character.jump());
        
        fc.addCommand(character::walk);
        fc.addCommand(character::run);
        fc.addCommand(character::jump);
        
        fc.executeCommand();
    }
}

class FunctionalCommands {
	private final List<Supplier<Boolean>> commands = new ArrayList<>();
	
	public void addCommand(Supplier<Boolean> action) {
		commands.add(action);
	}
	
	public void executeCommand() {
		commands.forEach(Supplier::get);
	}
}