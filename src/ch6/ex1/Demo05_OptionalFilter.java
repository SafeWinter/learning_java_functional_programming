package ch6.ex1;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Demo05_OptionalFilter {

	public static void main(String[] args) {
		// max found
		OptionalInt result = IntStream.of(1, 5, 12, 7, 5, 24, 6)
				.filter(n -> n > 10)
				.max();
		result.ifPresent(o -> System.out.println(o));
		
		// not found
		IntStream.of(1, 5, 12, 7, 5, 24, 6)
			.filter(n -> n > 100)
			.max()
			.ifPresent(System.out::println);
	}
}
