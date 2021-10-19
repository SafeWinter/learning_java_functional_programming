package ch7.ex2;

import java.util.function.Supplier;

public class Demo07_Factory_FP {

	public static void main(String[] args) {
		// Functional approach: using supplier interface
		Supplier<VacuumCleaner> dvcSupplier = DirtVacuumCleaner::new;
		VacuumCleaner dvc = dvcSupplier.get();
		dvc.vacuum();
		dvc.clean();
		
		Supplier<VacuumCleaner> wvcSupplier = WaterVacuumCleaner::new;
		VacuumCleaner wvc = wvcSupplier.get();
		wvc.vacuum();
		wvc.clean();
	}
}