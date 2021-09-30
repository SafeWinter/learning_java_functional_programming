package ch6.ex1;

import java.util.Optional;

public class Demo01_OptionalInstance {

	public static void main(String[] args) {
		String animal = "cat";
		Optional<String> opt;
		opt = Optional.of(animal);
		System.out.println(opt);
		
		animal = null;
		// opt = Optional.of(animal);  // Comment out this line will generate a NullPointerException exception
		opt = Optional.ofNullable(animal);
		System.out.println(opt);
	}
}
