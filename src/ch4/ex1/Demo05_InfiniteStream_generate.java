package ch4.ex1;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo05_InfiniteStream_generate {

	private static int number = 0;
	
	public static int nextInt() {
		return number++;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// Demo1: generate several 0s
		Supplier<Integer> intSupplier = () -> 0;
		IntStream.generate(() -> 0)
			.limit(5)
			.forEach(System.out::println);


		// Demo2: generate numbers based on a seed
		Stream.generate(() -> nextInt())
			.limit(5)
			.forEach(System.out::println);
		
		
		// Error demonstration: 
		// Compilation error: Local variable number defined in an enclosing scope must be final or effectively final
//		int number = 0;
//	    Stream.generate(() -> number++)
//	            .limit(5)
//	            .forEach(System.out::println);
		
		
		// Demo3: use method reference to generate random numbers, without seed assignment
		Supplier<Double> randomSupplier = Math::random;
		Stream.generate(randomSupplier)
			.limit(4)
			.forEach(System.out::println);
	}
}
