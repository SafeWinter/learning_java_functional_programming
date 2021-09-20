package ch2.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Demo04_HOF {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Huey", "Duey", "Luey");
		
		list.parallelStream().forEach(s -> System.out.println(
				processString(t -> t.toLowerCase(), s)));
		
		System.out.println();
		
		list.forEach(s -> System.out.println(
				processString(String::toLowerCase, s)));
		
		System.out.println();
		
		list.forEach(s -> System.out.println(
				processString(String::toUpperCase, s)));
	}

	public static String processString(
			Function<String, String> operation, 
			String target
	) {
		return operation.apply(target);
	}
	
}
