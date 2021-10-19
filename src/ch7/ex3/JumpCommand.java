package ch7.ex3;

public class JumpCommand implements Command {
	
	private final Move move;
	
	public JumpCommand(Move move) {
		this.move = move;
	}

	@Override
	public boolean execute() {
		return move.jump();
	}

}
