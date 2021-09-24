package ch4.ex1;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo03_InfiniteStream_iterate {

	public static void main(String[] args) {
		// Demo1: infinite stream
		Random random = new Random();
		int i = 0;
		while(i < 10) {
			int number = random.nextInt();
			// process number
			System.out.println(number);
			i++;
		}
		
		// Demo2: using iterate method
		IntStream.iterate(0, n -> n + 1)
			.limit(10)
			.forEach(System.out::println);
		
		
		// Demo3: another iterate example
		Stream.iterate("Going", m -> m + "...")
			.limit(10)
			.forEach(System.out::println);
		
		
		// Demo4: iterate + filter
		IntStream.iterate(0, n -> n + 1)
			.filter(n -> n > 10 && n < 100)
			.limit(10)
			.forEach(n -> System.out.print(n + " "));
		
		
//		// Exception demo1: forgot limit
//		IntStream.iterate(0, n -> n + 1)
//			.filter(n -> n > 10 && n < 100)
//			// .limit(10)
//			.forEach(n -> System.out.print(n + " "));
		
		
//		// Exception demo2: exchange the order of filter and limit
//		IntStream.iterate(0, n -> n + 1)
//			.limit(10)
//			.filter(n -> n > 10 && n < 100)
//			.forEach(n -> System.out.print(n + " "));
		
		
//		// Exception demo3: limit larger than the max value of a stream
//		IntStream.iterate(0, n -> (n+ 1) % 2)
//			.distinct()
//			.limit(10)
//			.forEach(n -> System.out.print(n + " "));
		
	}
}
