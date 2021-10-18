package ch6.ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Demo14_Monad_Part_class {
	
	public static void main(String[] args) {
		
		Map<Integer, Part> parts = getParts();
		
		int id = 456;
		// int id = 111;
		Optional<Part> optPart = null;
		try {
			optPart = Optional.ofNullable(parts.get(id));
			System.out.println(
				optPart
					.flatMap(x -> x.outOfStock(true))
					.flatMap(x -> x.partName(x.getPartName() + "-Out-of-stock"))
					.flatMap(Part::replicatePartMonad)
					.orElseThrow(RuntimeException::new)
			);
			System.out.println(optPart);
		} catch (RuntimeException e) {
			System.out.println("Exception: " + optPart);
		}
	}

	private static Map<Integer, Part> getParts() {
		Map<Integer, Part> parts = new HashMap<>();
	    parts.put(123, new Part(123, "bolt"));
	    parts.put(456, new Part(456, "nail"));
	    parts.put(789, new Part(789, "wire"));
		return parts;
	}
}
