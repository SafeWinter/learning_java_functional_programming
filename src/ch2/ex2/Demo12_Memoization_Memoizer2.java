package ch2.ex2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Demo12_Memoization_Memoizer2 {

	public static void main(String[] args) {
		Function<Integer, Integer> square = x -> {
			System.out.println("In function");
			return x * x;
		};
		
		Function<Integer, Integer> memoizeSquare = Memoizer1.memoize(square);
		System.out.println(memoizeSquare.apply(5));
		System.out.println(memoizeSquare.apply(5));
		System.out.println(memoizeSquare.apply(5));
		System.out.println(memoizeSquare.apply(5));
	}

	
}

class Memoizer1<T, R> {
	private final Map<T, R> cache = new ConcurrentHashMap<>();
	
	private Function<T, R> doMemoize(Function<T, R> function) {
		return input -> cache.computeIfAbsent(input, function::apply);
	}
	
	public static <T, R> Function<T, R> memoize(Function<T, R> function) {
		return new Memoizer1<T, R>().doMemoize(function);
	}
} 
