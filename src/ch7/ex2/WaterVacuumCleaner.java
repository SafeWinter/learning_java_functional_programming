package ch7.ex2;

public class WaterVacuumCleaner implements VacuumCleaner {
	
	public WaterVacuumCleaner() {
		System.out.println("Creating water vacuum cleaner");
	}

	@Override
	public void vacuum() {
        System.out.println("Vacuuming water");
	}

	@Override
	public void clean() {
        System.out.println("Cleaning water vacuum cleaner");
	}
}
