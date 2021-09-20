package fp.ch2.ex1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Demo12_Memoization_Memoizer {
	
	public static void main(String[] args) {
		Function<Integer, Integer> dbl = x -> {
			System.out.println("In function");
			return x * x;
		};
		
		Function<Integer, Integer> memoizeDbl = Memoizer.memoize(dbl);
		System.out.println(memoizeDbl.apply(6));
		System.out.println(memoizeDbl.apply(6));
		System.out.println(memoizeDbl.apply(6));
		System.out.println(memoizeDbl.apply(6));
	}
}

class Memoizer<T, R> {
	
	private final Map<T, R> cache = new ConcurrentHashMap<>();
	
	private Function<T, R> doMemoize(Function<T, R> function) {
		return input -> cache.computeIfAbsent(input, function::apply);
	}
	
	public static <T, R> Function<T, R> memoize(Function<T, R> function) {
		return new Memoizer<T, R>().doMemoize(function);
	}
}