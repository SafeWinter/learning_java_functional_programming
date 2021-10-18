package ch6.ex3;

import java.util.Optional;
import java.util.function.Function;

public class Demo12_Monad_map {
	public static void main(String[] args) {
		Optional<Integer> one = Optional.of(1);
		Optional<Integer> add1 = one.map(x -> x + 1);
		System.out.println(add1.get());  // 2
		
		Function<? super Integer, ? super Integer> add1MapFunction = 
				n -> n + 1;
		Optional<? super Integer> map1 = one.map(add1MapFunction);
		System.out.println(map1.get());  // 2
		
		Optional<Integer> result = one.map(x -> x.intValue() + 1)
			.flatMap(x -> Optional.of(x + 1));
		System.out.println(result.get());  // 3
	}
}
