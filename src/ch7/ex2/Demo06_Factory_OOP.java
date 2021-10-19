package ch7.ex2;

public class Demo06_Factory_OOP {

	public static void main(String[] args) {
		// Conventional approach
		VacuumCleaner dvc = VacuumCleanerFactory.getInstance("Dirt");
		dvc.vacuum();
		dvc.clean();
		
		VacuumCleaner wvc = VacuumCleanerFactory.getInstance("Water");
		wvc.vacuum();
		wvc.clean();
	}
}
